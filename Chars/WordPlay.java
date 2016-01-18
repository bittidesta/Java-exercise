
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
   public Boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        String vouls = "aeiou";
        Boolean B = false;
       for(int i=0; i<vouls.length(); i++){
           char currV = vouls.charAt(i);
           if(currV == ch){
              B = true;
            }
        }
        return B;
   }
   public void VoulTest(){
        
        if(isVowel('F') == true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    
   public String replaceVowels(String phrase, char ch){
       //phrase = phrase.toLowerCase();
       StringBuilder sb = new StringBuilder(phrase);
       //ch = Character.toLowerCase(ch);
       for(int i=0; i< sb.length(); i++){
           char curr = sb.charAt(i);
           if(isVowel(curr) == true){
               sb.setCharAt(i, ch);
            }
        }
       return sb.toString();
    }
   public void testReplaceVowel(){
       String phrase = "Hello World";
       char ch = '*';
       String modif = replaceVowels(phrase,ch);
       System.out.println(modif);
    }
   
   public String emphasize(String phrase, char ch){
       phrase = phrase.toLowerCase();
       ch = Character.toLowerCase(ch);
       StringBuilder sb = new StringBuilder(phrase);
       for(int i=0; i<sb.length(); i++){
           char curr = sb.charAt(i);
           if((i % 2) == 0 && curr == ch ){
               sb.setCharAt(i, '*');
            }else if((i % 2) != 0 && curr == ch){
                sb.setCharAt(i, '+');
            }

        }
       return sb.toString();
    }
   public void testEmphesize(){
       String changed = emphasize("Mary Bella Abracadabra", 'a');
       System.out.println(changed);
    }
}
