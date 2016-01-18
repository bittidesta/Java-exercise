
/**
 * Write a description of characterD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class characterD {
    public void digitTest(){
      String test = "ABCabc0123456789';#!";
       for(int i = 0; i < test.length(); i++){
           char ch = test.charAt(i);
           if(Character.isDigit(ch)){
               System.out.println(ch + " is a digit");
            }
           if(Character.isAlphabetic(ch)){
               System.out.println(ch + " is an alphabet");
            }
           if(ch == '#'){
               System.out.println(ch+" hashtag");
            }
          
       }
   }
   public String Encrypt(String mess, int key){
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String shifted = alphabet.substring(key)+ alphabet.substring(0,key);
       StringBuilder sb = new StringBuilder(mess);
       
       for(int i=0; i < mess.length(); i++){
           char ch = sb.charAt(i);
           int idx = alphabet.indexOf(ch);
           if(idx != -1){
               char Nch = shifted.charAt(idx);
               sb.setCharAt(i, Nch);
            }
        
       }
       return sb.toString();
    }
   public void EnTest(){
       String m = "A BAT";
       int k = 19;
       String encriptedmess = Encrypt(m,k);
       System.out.println(encriptedmess);
    }
}
