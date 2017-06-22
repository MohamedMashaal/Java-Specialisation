import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyNames {
    private void totalBirths(CSVParser parser){
        int totalBirths = 0 , boysNum = 0 , girlsNum = 0 ;
        int totalNames = 0 , boysNames = 0 , girlsNames = 0 ;
        for(CSVRecord rec : parser){
            totalNames ++ ;
            int temp = Integer.parseInt(rec.get(2));
            totalBirths += temp;
            if(rec.get(1).equals("F")){
                girlsNames ++;
                girlsNum += temp ;
            }
            else{
                boysNames ++ ;
                boysNum += temp ;
            }
        }
        System.out.println("Total Number of names in the list : " + totalNames);
        System.out.println("Total Number of Births : " + totalBirths);
        System.out.println("Total Number of Boys names : " + boysNames);
        System.out.println("Total Number of Boys Births : " + boysNum);
        System.out.println("Total Number of Girls names : " + girlsNames);
        System.out.println("Total Number of Girls Births : " + girlsNum);
    }
    
    void testingTotalBirths(){
        FileResource x = new FileResource();
        totalBirths(x.getCSVParser(false));
    }
    
    int getRank(int year , String name , String gender){
        FileResource x = new FileResource("C:\\Users\\Mohamed Mashaal\\Desktop\\Java Specialisation\\Course II\\Week 4\\us_babynames\\us_babynames_by_year\\yob" + Integer.toString(year)+".csv");
        int rank = -1;
        int count = 0 ;
        for(CSVRecord rec : x.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                count ++ ;
                if(rec.get(0).equals(name)){
                    rank = count ;
                    return rank ;
                }
            }
        }
        return rank ;
    }
    
   // void testingGetRank() {
   //     System.out.println("the rank of the name Ahmed in 2014 is : " + getRank(1971 , "Frank" ,"M" ));
   // }
    
    String getName(int year , int rank , String gender){
        FileResource x = new FileResource("C:\\Users\\Mohamed Mashaal\\Desktop\\Java Specialisation\\Course II\\Week 4\\us_babynames\\us_babynames_by_year\\yob" + Integer.toString(year)+".csv");
        int count = 0 ;
        for(CSVRecord rec : x.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                count ++ ;
                if(count == rank){
                    return rec.get(0) ;
                }
            }
        }
        return "NO NAME" ;
    }
    
    //void testingGetName(){
    //    System.out.println(getName(2014 , 549 , "M" ));
    //}
    
    void whatIsNameInYear(String name , int year , int newYear , String gender){
        int rank = getRank(year , name , gender);
        String newName = getName(newYear , rank , gender);
        System.out.println("the name " + name +" will be : " + newName);
    }
    
//    void testingNewName(){
//      whatIsNameInYear("Ahmed", 2014, 1990, "M");
//   }
    
    String yearOfHighestRank(String name , String gender){
        DirectoryResource dr = new DirectoryResource();
        int highestYear = -1 ;
        String year = "-1" ;
        for(File f : dr.selectedFiles()){
            String temp = f.getName();
            temp = temp.substring(3,7);
            int currentRank = getRank(Integer.parseInt(temp) , name , gender);
            if(highestYear == -1 && currentRank != -1){
                highestYear = currentRank ;
                year = temp ;
            }
            else if( currentRank != -1 && currentRank < highestYear ){
                highestYear = currentRank ;
                year = temp ;
            }
        }
        return year ;
    }
    
    double getAverageRank(String name , String gender){
        DirectoryResource dr = new DirectoryResource();
        double average = -1 ;
        double res = 0 ;
        int count = 0 ;
        for(File f : dr.selectedFiles()){
            String temp = f.getName();
            temp = temp.substring(3,7);
            int currentRank = getRank(Integer.parseInt(temp) , name , gender);
            if(currentRank != -1){
                count ++ ;
                res += currentRank ;
            }
        }
        if(count == 0){
            return average ;
        }
        return res / count ;
    }
    
    int getTotalBirthsRankedHigher(int year , String name , String gender){
        FileResource x = new FileResource("C:\\Users\\Mohamed Mashaal\\Desktop\\Java Specialisation\\Course II\\Week 4\\us_babynames\\us_babynames_by_year\\yob" + Integer.toString(year)+".csv");
        int lastRank = getRank(year , name , gender);
        int countHigher = 0 ;
        int count = 0 ;
        for(CSVRecord rec : x.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
            count++ ;
            if(count < lastRank){
                countHigher += Integer.parseInt(rec.get(2));
            }
            else{
                break ;
            }}
        }
        return countHigher ;
    }
}
