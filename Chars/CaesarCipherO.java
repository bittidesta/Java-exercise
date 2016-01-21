
/**
 * CaesarCipherO class encrypts a message with one key
 * and also decrypts the same message. Implements OO concept.
 * 
 * @author (Aida) 
 * @version (Jan, 2016)
 */
public class CaesarCipherO {
    
    private String alphabet;
    private String shifted;
    private int mainKey;
    public CaesarCipherO(int key){
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shifted = alphabet.substring(mainKey)+ alphabet.substring(0,mainKey);
     }
 
   public String encrypt(String input){
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
    
    public String decrypt(String input){
      CaesarCipherO cc = new CaesarCipherO(26-mainKey);
      return cc.encrypt(input);
     
   }

}
