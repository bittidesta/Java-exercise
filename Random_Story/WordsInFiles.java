
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.*;
public class WordsInFiles {
    private HashMap<String,ArrayList<String>> words;
    
    public WordsInFiles(){
        words = new HashMap<String,ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
       for(String w : fr.words()){
           ArrayList<String> fNames = new ArrayList<String>();
           
           if(words.keySet().contains(w)){
               fNames = words.get(w);
               int indx = fNames.indexOf(f.getName());
               
               if(indx == -1){       
                  fNames.add(f.getName());
                 // words.put(w,fNames);
                }
            }else{
               fNames.add(f.getName());
               words.put(w,fNames);
                
                
            }
        }
    }
    
    public HashMap buildWordFileMap(){
        words.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
             addWordsFromFile(f);
        }
        return words;
    }
    
    public int maxNumber(){
        int maxNumberOfFiles = 0;
        //String commonWord = "";
        for(String w : words.keySet()){
            int numOfFiles = (words.get(w)).size();
            if(numOfFiles > maxNumberOfFiles){
                maxNumberOfFiles = numOfFiles;
            }
        }
        
        return maxNumberOfFiles;
    }
    
    public ArrayList wordsInNumFiles(int number){
        ArrayList<String> commonWord = new ArrayList<String>();
       // buildWordFileMap();
        for(String w : words.keySet()){
           int numOfFiles = (words.get(w)).size();
           if(numOfFiles == number){
              commonWord.add(w) ;
           }
          // System.out.println(w + " "+ words.get(w));
         
        }
        return commonWord;
        
    }
    
    public void printFilesIn(String word){
        // buildWordFileMap();
         if(words.keySet().contains(word)){
             ArrayList<String> fNames = new ArrayList<String>();
             fNames = words.get(word);
             for(String name : fNames){
                  System.out.println("\n"+name);
                
                }
         
            }else{
                System.out.println(word + " is not in the selected files.");
            }
    }
    
    public void tester(){
       ArrayList<String> commWords = new ArrayList<String>();
       buildWordFileMap();
       int max = maxNumber(); 
      // commWords = wordsInNumFiles(max);
       
     // for(String w : commWords){
           //System.out.println(w);
          // printFilesIn(w);
      //  }
       int size = wordsInNumFiles(4).size();
       System.out.print("Total num of words: "+size);
      printFilesIn("tree");
    }
}
