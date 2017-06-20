
/**
 * Write a description of PartI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartI {
    String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int endIndex = dna.indexOf("TAA",startIndex+3);
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
        String s1 = "TTTAATGCCCCGCTAATAAGG";
        System.out.println(findSimpleGene(s1));
        String s2 = "TTTAACGCCCCGCTAATAAGG";
        System.out.println(findSimpleGene(s2));
    }
}
