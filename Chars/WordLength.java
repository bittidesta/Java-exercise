
/**
 * Counts words by their length. 
 * @author  
 * @version (Jan, 2016)
 */
import edu.duke.*;
import java.util.*;
public class WordLength {
    public int numOfWord(FileResource resource){
          int indexs = 0;
          for(String s : resource.words()){
               indexs += 1;
            } 
            return indexs;
    }
    
    public void countWordLength(FileResource resource, int[] counts ){
         
        for(String word : resource.words()){
            int wordLength = 0;
            char Fch = word.charAt(0);
            char Lch = word.charAt(word.length()-1); 
            if(Character.isLetter(Fch) == false && Character.isLetter(Lch) == false){
                wordLength = word.length() - 2;
            }else if(Character.isLetter(Fch) == false || Character.isLetter(Lch) == false){
                wordLength = word.length() -1;
            }else{
                wordLength = word.length();
            }
            counts[wordLength] ++;
            
        }
    }
     
    public int maxIndex(int[] counted){
        int maxind = 0;
        for(int i=0; i< counted.length; i++){
            if(counted[i] > counted[maxind]){
                maxind = i;
            }
        }
        return maxind;
    }
    public void testCountWordLengths(){
        FileResource fr = new FileResource(); 
        int[] counts = new int[numOfWord(fr)];
        countWordLength(fr,counts);
        int max = maxIndex(counts);
        System.out.println(max);
        for(int i = 1; i <= numOfWord(fr) - 1 ; i++){
            
            if(counts[i] != 0){
               System.out.println(counts[i] + " words of lenght " + i);
           }
        }
    }
}
