
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CharactersInPlay {
    private ArrayList<String> characterName;
    private ArrayList<Integer> characterFreqs;
    
    public CharactersInPlay(){
        characterName = new ArrayList<String>();
        characterFreqs = new ArrayList<Integer>();
        
    }
    
    public void update(String person){
        
        int indx = characterName.indexOf(person);
        if(indx == -1){
            characterName.add(person);
            characterFreqs.add(1);
        }else{
            int value = characterFreqs.get(indx);
            characterFreqs.set(indx, value+1);
        }
        
    }

    public void findAllCharacters(){
        FileResource fr = new FileResource();
        for(String l : fr.lines()){
            
            if(l.contains(".")){
                int end = l.indexOf(".");
                String P = l.substring(0,end);
                
                update(P);
            }
        }
    }
    
    public void testr(){
        findAllCharacters();
        for(int i=0; i< characterName.size(); i++){
            if(characterFreqs.get(i) >= 60 &&characterFreqs.get(i) <=600){
               System.out.println(characterName.get(i)+" "+ characterFreqs.get(i));
           }
         }
    }
}
