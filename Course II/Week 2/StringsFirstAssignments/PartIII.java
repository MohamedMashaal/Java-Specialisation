
/**
 * Write a description of PartIII here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartIII {
    boolean twoOccurrences(String stringa ,String stringb){
        int first = stringb.indexOf(stringa);
        if(first == -1)
            return false ;
        int second = stringb.indexOf(stringa , first+1);
        if(second == -1)
            return false ;
        return true;
    }
    
    void testing(){
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(lastPart("an", "banana"));
        
    }
    
    String lastPart(String stringa , String stringb){
        int start = stringb.indexOf(stringa);
        if(start == -1)
            return stringb;
        return stringb.substring(start+stringa.length());
        
    }
}
    