import edu.duke.*;
/**
 * Write a description of PartIV here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartIV {
    void findLink(String link){
        URLResource x = new URLResource(link);
        for(String word : x.words()){
            word = word.toLowerCase();
            int pos = word.indexOf("youtube.com");
            if(pos != -1){
                int start = word.lastIndexOf("\"" , pos);
                int end = word.indexOf("\"",pos);
                System.out.println(word.substring(start,end+1));
            }
        }       
    }
    
    void testing(){
        findLink("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
}
