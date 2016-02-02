
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUniqe(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }else{
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
            
        }
    }
    
    public int findIndexOfMax(){
        findUniqe();
        int maxFreq = 0;
        int maxIndx = 0;
        for(int i=0; i < myWords.size(); i++){
            if(maxFreq == 0){
                maxFreq = myFreqs.get(i);
                maxIndx = i;
            }else if(myFreqs.get(i) > maxFreq){
                maxFreq = myFreqs.get(i);
                maxIndx = i;
            }
                
        }
        return maxIndx;
    }
    
    public void tester(){
        findUniqe();
        int maxIndx = findIndexOfMax();
        System.out.println("# Uniqe words: " + myWords.size());
//         for(int i=0; i < myWords.size(); i++){
//             System.out.println(myFreqs.get(i)+"\t"+myWords.get(i));
//         }
        
        System.out.println("The word that occurs most often and its count are: "+myWords.get(maxIndx)+"\t"+myFreqs.get(maxIndx));
    }

}
