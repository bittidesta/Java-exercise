
/**
 * TestCaesarCipherTwokeys using oo concept. 
 * 
 * @author (Aida) 
 * @version (21.01.2016)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
   private String halfOfString(String message, int start){
       StringBuilder sb = new StringBuilder(message);
       String halfS = "";
       for(int i = start; i < sb.length(); i+=2){
           char curr = sb.charAt(i);           
                halfS = halfS + curr;
                  
        }      
      return halfS;
       
    }
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
   private int getKey(String s){
          int[] freq = countLetters(s);
          int maxI = maxIndex(freq);
          int dkey = maxI - 4;
          if(maxI < 4){
             dkey = 26 - (4-maxI);
            }
           return dkey;
    }
   public String breakCaesarCipherTwo(String input){       
       String one = halfOfString(input,0);
       String two = halfOfString(input,1);
       int key1 = getKey(one);
       int key2 = getKey(two);   
       System.out.println("key1= " + key1 + " key2= " + key2);
       CaesarCipherTwo ccT = new CaesarCipherTwo(26-key1, 26-key2);
       return ccT.encrypt(input);
   }
   public void simpleTest(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipherTwo ccT = new CaesarCipherTwo(17, 3);
        String encrypted = ccT.encrypt(message);
        System.out.println("Encrypted " + encrypted);
        String decrypted = ccT.decrypt(encrypted);
        System.out.println("Decrypted " + decrypted);
        String auto = breakCaesarCipherTwo(encrypted);
        System.out.println("Auto Decrypted: " + auto);
        
    }
}
