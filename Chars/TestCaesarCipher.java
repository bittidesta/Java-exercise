
/**
 * Ecrypts and Decrypts text using OO concept
 * 
 * @author (Aida) 
 * @version (Jan, 2016)
 */
import edu.duke.*;
public class TestCaesarCipher {
     private int[] countLetters(String message){
         String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         int[] counts = new int[26];
         for(int i=0; i < message.length(); i++){
             char ch = Character.toUpperCase(message.charAt(i));
             int index = alph.indexOf(ch);
                if(index != -1){
                    counts[index] +=1;
                }
            } 
       
         return counts;
    }
    
    private int maxIndex(int[] frqes){
        int maxInd = 0;
       for(int i=0; i < frqes.length; i++){
          
           if(frqes[i] > frqes[maxInd]){
               maxInd = i;
             }
        }
       return maxInd;
    }   
       
     public String breakCaesarCipher(String input){
         int[] freqs = countLetters(input); 
         int maxInd = maxIndex(freqs);
         int dkey = maxInd - 4;
         if(maxInd < 4){
             dkey = 26 - (4-maxInd);
            }else{
              dkey = maxInd - 4;
            }
          CaesarCipherO ccO = new CaesarCipherO(26-dkey);
          return ccO.encrypt(input);
         
    }
    
    public void simpleTests(){
         FileResource fr = new FileResource();
         String message = fr.asString();
         CaesarCipherO cco = new CaesarCipherO(18);
         String encrypted = cco.encrypt(message);
         System.out.println("Encrypted " + encrypted);
         String decrypted = cco.decrypt(encrypted);
         System.out.println("Decrypted " + decrypted);
         String auto = breakCaesarCipher(encrypted);
         System.out.println("Auto Decrypted " + auto);
    }
}
