
/**
 * Write a description of Codon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.*;
public class Codon {
        private HashMap<String, Integer> DnaCodon;
        
        public Codon(){
            DnaCodon = new HashMap<String, Integer>();
        }
        
        public HashMap buildCodonMap(int start, String dna){
            DnaCodon.clear();
            String d = dna.trim().toLowerCase();
            int dLength = 0;
            if(start == 0){
                dLength = d.length();
            }else if(start == 1){
                dLength = d.length()-1;
            }else{
                dLength= d.length()-2;
            }
            while(true){
                
                if(start >= dLength-1 || start >= dLength-2){
                   break;
                }
                String codon = d.substring(start,start+3);
                
                if(DnaCodon.keySet().contains(codon)){
                    DnaCodon.put(codon,DnaCodon.get(codon)+1);
                    start += 3;
                }
                 else{
                    DnaCodon.put(codon,1);
                    start+= 3;
                }
                
            }
            return DnaCodon;
        }
        
        public String getMostCommonCodon(){
           int maxO = 0;
           String frqCod = "";
            for(String s : DnaCodon.keySet()){
             int occurence = DnaCodon.get(s);
             if(occurence > maxO){
                 maxO = occurence;
                 frqCod = s;
                }
            }
            return frqCod;
        }
        
        public void printCodonCounts(int start, int end){
            for(String s: DnaCodon.keySet()){
                int occrence = DnaCodon.get(s);
                if(occrence >= start || occrence <= end){
                    System.out.println(s+" "+ occrence);
                }
            }
        
        }
        
        public void testCodon(){
            FileResource fr = new FileResource();
            String dna = fr.asString();
            buildCodonMap(0,dna);
            System.out.println("codon starting at 0 " + DnaCodon.size());
            System.out.println("Most common codon is " + getMostCommonCodon());
            printCodonCounts(1,5);
            
        }
}
