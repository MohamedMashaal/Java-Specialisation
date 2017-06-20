
/**
 * Write a description of PartII here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartII {
    int howMany(String stringa , String stringb){
        int count = 0 ;
        int currentIndex = stringb.indexOf(stringa);
        while(currentIndex != -1){
            count ++ ;
            currentIndex = stringb.indexOf(stringa,currentIndex+stringa.length());
        }
        return count ;
    }
    
    void testing(){
        System.out.println(howMany("AA","ATAAAA"));
    }
}
