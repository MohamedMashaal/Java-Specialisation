
/**
 * Write a description of PartII here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartII {
    float cgRatio(String dna){
        int count = 0;
        for(int i = 0 ; i < dna.length() ; i ++){
            if(dna.charAt(i) == 'C' ||dna.charAt(i) == 'G')
                count ++ ;
        }
        return (float)count/dna.length();
    }
    
    void testing(){
        System.out.println(cgRatio("ATGCCATAG"));
    }
}
