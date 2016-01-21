
/**
 * CaesarCipherTwo class encrypts a message with two keys
 * and also decrypts the same message. Implements OO concept.
 * @author (aida) 
 * @version (21.01.2016)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shifted1;
    private String shifted2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2){
        mainKey1 = key1;
        mainKey2 = key2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shifted1 = alphabet.substring(mainKey1)+ alphabet.substring(0,mainKey1);
        shifted2 = alphabet.substring(mainKey2)+ alphabet.substring(0,mainKey2);
     } 
    
    public String encrypt(String input){        
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

    public String decrypt(String input){
        CaesarCipherTwo ccT = new CaesarCipherTwo(26-mainKey1, 26-mainKey2);
        return ccT.encrypt(input);
    }
}
