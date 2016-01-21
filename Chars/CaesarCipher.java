
/**
 * Ecrypts text from a file using one/two keys
 * 
 * @author (Aida) 
 * @version (Jan, 2016)
 */
import edu.duke.*;
public class CaesarCipher {
    
    public String encrypt(String input, int key){
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String shifted = alphabet.substring(key)+ alphabet.substring(0,key);
       StringBuilder sb = new StringBuilder(input);
       
       for(int i=0; i < sb.length(); i++){
           char ch = sb.charAt(i);
           if(Character.isUpperCase(ch) != true){
               ch = Character.toUpperCase(ch);
               int idx = alphabet.indexOf(ch);
               if(idx != -1){
                   char Nch = shifted.charAt(idx);
                   Nch = Character.toLowerCase(Nch);
                   sb.setCharAt(i, Nch);
                }
            }else if(Character.isUpperCase(ch) == true){
                int idx = alphabet.indexOf(ch);
                if(idx != -1){
                   char Nch = shifted.charAt(idx);
                   sb.setCharAt(i, Nch);
                }
            }
            
       }
       return sb.toString();
    }
    public void testCaesar(){
      FileResource fr = new FileResource();
      String encrypted = encrypt(fr.asString(), 15);
     // String encrypted = encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15);
      System.out.println(encrypted);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        String shifted2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
        StringBuilder sb = new StringBuilder(input);
        
        for(int i=0; i < sb.length(); i++){
           char curr = sb.charAt(i);
           if(Character.isUpperCase(curr) != true){
               curr = Character.toUpperCase(curr);
               int idx = alphabet.indexOf(curr);
               if(idx != -1 && (i % 2) == 0){
                   char Nch = shifted1.charAt(idx);
                   Nch = Character.toLowerCase(Nch);
                   sb.setCharAt(i, Nch);
                }else if(idx != -1 && (i % 2) != 0){
                   char Nch = shifted2.charAt(idx);
                   Nch = Character.toLowerCase(Nch);
                   sb.setCharAt(i, Nch);
                }
            }else if(Character.isUpperCase(curr) == true){
                int idx = alphabet.indexOf(curr);
                if(idx != -1 && (i % 2) == 0){
                   char Nch = shifted1.charAt(idx);
                   sb.setCharAt(i, Nch);
                }else if(idx != -1 && (i % 2) != 0){
                   char Nch = shifted2.charAt(idx);
                   sb.setCharAt(i, Nch);
                }
            }
            
       }
       return sb.toString();
    }
    public void testCaesarTwoKeys(){
       FileResource fr = new FileResource();
       String encrypted = encryptTwoKeys(fr.asString(),23,2);
    // String encrypted = encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 8);
       System.out.println(encrypted);
    }

}
