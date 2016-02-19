import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    private  HashSet<String> words;
    
    public VigenereBreaker(){
        words = new HashSet<String>();
    }
    
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        message = message.toLowerCase();
        StringBuilder sb1 = new StringBuilder(message);
        StringBuilder Fsb = new StringBuilder();
        
        for(int i=whichSlice; i < sb1.length(); i+= totalSlices){
             char ch = sb1.charAt(i);
             Fsb.append(ch);
        }
        
        return Fsb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
       CaesarCracker br = new CaesarCracker();    
       int[] keys = new int[klength];
       for(int i=0; i < klength; i++){
               String s1 = sliceString(encrypted, i, klength);
               int k = br.getKey(s1);
               keys[i] = k;
        }
      return keys;
    }
    
    public HashSet readDictionary(FileResource fr){
        for(String line : fr.lines()){
          line = line.toLowerCase();
          words.add(line);
        }
        return words;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        
        int counted = 0;
        for(String word : message.split("\\W")){
            word = word.toLowerCase();
            if(dictionary.contains(word)){
                counted += 1;
            }
        }
        
       return counted;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){      
       HashMap<Character,Integer> count = new HashMap<Character, Integer>();
       for(String word : dictionary){
           for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(count.keySet().contains(ch)){ 
                int occurence = count.get(ch);
                 count.put(ch,occurence+1);
              }else{
                 count.put(ch,1);
               }
            }
        }
       int maxcount = 0;
       Character mostcommon = 'z';
       for(char c : count.keySet()){
             int occ = count.get(c);
             if(occ > maxcount){
                 maxcount = occ;
                 mostcommon = c;
                }
        }
       
       return mostcommon;
    }
    
    public void breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages){
        int max = 0;
        String lang = "";
        String decrypted = "";
        for(String l : languages.keySet()){
             HashSet<String> dictionary = languages.get(l);
             String message = breakForLanguage(encrypted, dictionary);
             int counted = countWords(message, dictionary);
             if(counted > max){
                max = counted;
                lang = l;
                decrypted = message;
                }
        }
    
        System.out.println("Language: " + lang);
        System.out.println(decrypted);
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int max = 0;
        int keylength = 0;
        String decrypted = "";
        for(int i = 1; i <= 100; i++){
         char comm = mostCommonCharIn(dictionary);
         int[] kth = tryKeyLength(encrypted, i, comm);
         VigenereCipher vc = new VigenereCipher(kth);
         String message = vc.decrypt(encrypted);
         int counted = countWords(message, dictionary);
         if(counted > max){
            max = counted;
            keylength = i;
            decrypted = message;
         }
        }
        System.out.println("Key length: "+ keylength);
        System.out.println("counted words:" + max);
        return decrypted;
    }
    
    
    public void breakVigenere () {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        words.clear();
        HashMap<String, HashSet<String>> langMap = new HashMap<String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
           String Fname = f.getName();
           FileResource Fdictionary = new FileResource(f);
           HashSet<String> dict = readDictionary(Fdictionary);
           if(!langMap.keySet().contains(Fname)){
               langMap.put(Fname, dict);
            }
           System.out.println(Fname); 
        }
        
        breakForAllLanguages(encrypted, langMap);
        
        
        /**HashSet<String> dict = readDictionary(dictionary);
        char common = mostCommonCharIn(dict);
        System.out.println(common);
        String decrypted = breakForLanguage(encrypted, dict);      
        System.out.println(decrypted);
        
        int[] klength = tryKeyLength(encrypted, 38, 'e');
        VigenereCipher vc = new VigenereCipher(klength);
        String message = vc.decrypt(encrypted);
        int counted = countWords(message, dict);
        System.out.println("counted: " + counted); **/
    }
    
}
