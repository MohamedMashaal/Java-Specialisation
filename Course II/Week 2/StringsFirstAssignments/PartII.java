
/**
 * Write a description of PartI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartII {
    String findSimpleGene(String dna , String start , String stop){
        dna = dna.toUpperCase();
        start = start.toUpperCase();
        stop = stop.toUpperCase();
        int startIndex = dna.indexOf(start);
        if(startIndex == -1){
            return "";
        }
        int endIndex = dna.indexOf(stop,startIndex+3);
        if(endIndex == -1){
            return "";
        }
        if(!((endIndex - startIndex)% 3 == 0)){
            return "";
        }
        endIndex += 3;
        
        return dna.substring(startIndex , endIndex);
    }
    
    void testSimpleGene(){
        String s1 = "tttaatgccccgctaataagg";
        System.out.println(findSimpleGene(s1 , "atg" , "taa"));
        String s2 = "TTTAACGCCCCGCTAATAAGG";
        System.out.println(findSimpleGene(s2,"Atg" , "tAA"));
    }
}
