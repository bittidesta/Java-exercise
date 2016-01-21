
/**
 * BreakingCipher
 * Decrypts text that is encrypted using one/two keys 
 * @author (Aida) 
 * @version (Jan,2016)
 */
import edu.duke.*;
public class BreakingCipher {
     public int[] countLetters(String message){
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
   public int maxIndex(int[] frqes){
        int maxInd = 0;
       for(int i=0; i < frqes.length; i++){
          
           if(frqes[i] > frqes[maxInd]){
               maxInd = i;
             }
        }
       return maxInd;
    }
   public String decrypt(String encrypted){
     CaesarCipher cc = new CaesarCipher();
     int[] freqs = countLetters(encrypted); 
     int maxInd = maxIndex(freqs);
     int dkey = maxInd - 4;
     if(maxInd < 4){
         dkey = 26 - (4-maxInd);
        }else{
          dkey = maxInd - 4;
        }
      return cc.encrypt(encrypted, 26-dkey);
     
    }
   public void testDecrypt(){
       FileResource fr = new FileResource();
       CaesarCipher ciph = new CaesarCipher();
       String encrypted = ciph.encrypt(fr.asString(), 15);
       String decrypted = decrypt(encrypted);
       System.out.println(decrypted);     
       
    }
   
   public String halfOfString(String message, int start){
       StringBuilder sb = new StringBuilder(message);
       String halfS = "";
       for(int i = start; i < sb.length(); i+=2){
           char curr = sb.charAt(i);           
                halfS = halfS + curr;
                  
        }      
      return halfS;
       
    }
   
   public int getKey(String s){
      int[] freq = countLetters(s);
      int maxI = maxIndex(freq);
      int dkey = maxI - 4;
      if(maxI < 4){
         dkey = 26 - (4-maxI);
        }
       return dkey;
    }
   
   public String decryptTwoKeys(String encrypted){
       CaesarCipher cc = new CaesarCipher();
       String one = halfOfString(encrypted,0);
       String two = halfOfString(encrypted,1);
       int key1 = getKey(one);
       int key2 = getKey(two);
       System.out.println("key1 = " + key1 + " key2 = " + key2);
       return cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    } 
    
   public void testDecryptTwoKeys(){
       FileResource fr = new FileResource();
       CaesarCipher ciph = new CaesarCipher();
       String encrypted =  fr.asString();//ciph.encryptTwoKeys(fr.asString(), 23, 2);
       String decrypted = decryptTwoKeys(encrypted);
       System.out.println(decrypted);     
       
    }
   
}
