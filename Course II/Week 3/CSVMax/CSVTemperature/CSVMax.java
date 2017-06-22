import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.File;
/**
 * Write a description of CSVMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSVMax {
    private CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldest = null ;
        for(CSVRecord record : parser){
            if(coldest == null){
                coldest = record ;
            }
            else{
                if(Double.parseDouble(record.get("TemperatureF")) != -9999)
                coldest = getLowest(coldest , record ,"TemperatureF") ;
            }
        }
        return coldest ;
    }
    
    private CSVRecord getLowest(CSVRecord r1 , CSVRecord r2 , String field){
        if(Double.parseDouble(r2.get(field))< Double.parseDouble(r1.get(field))){
                    return r2 ;
        }
        return r1 ;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("The Coldest Temperature " + coldest.get("TemperatureF") + "in Date " +coldest.get("DateUTC"));
    }
    
     private File getColdestOfTwoFiles(File coldest ,File f){
        if(coldest == null)
            return f ;
        else{
            FileResource fr = new FileResource(f);
            CSVParser parser1 = fr.getCSVParser();
            fr = new FileResource(coldest);
            CSVParser parser2 = fr.getCSVParser();
            if(Double.parseDouble(coldestHourInFile(parser1).get("TemperatureF"))< Double.parseDouble(coldestHourInFile(parser2).get("TemperatureF"))){
                return f ;
            }
            else{
                return coldest ;
            }
        }
    }
    
    public void fileWithColdestTemperature (){
        DirectoryResource dr = new DirectoryResource();
        File coldest = null ;
        for(File f : dr.selectedFiles()){
            coldest = getColdestOfTwoFiles(coldest , f );
        }
        System.out.println("Coldest day was in file " + coldest.getName());
        System.out.println("Coldest temperature on that day was " + coldestHourInFile(new FileResource(coldest).getCSVParser()).get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for(CSVRecord record : new FileResource(coldest).getCSVParser()){
            System.out.println(record.get("DateUTC")+ " " + record.get("TemperatureF"));
        }
    }
    
    private CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowest = null ;
        for(CSVRecord record : parser){
            if(lowest == null && !record.get("Humidity").equals("N/A")){
                lowest = record ;
            }
            else{
                if( ! record.get("Humidity").equals("N/A")){
                    lowest = getLowest(lowest , record , "Humidity");
                }
            }
        }
        return lowest ;
    }
    
    void testingHumidity(){
        FileResource fr = new FileResource();
        CSVRecord lowest = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("The Lowest Humidity is " + lowest.get("Humidity") + " in Date " +lowest.get("DateUTC"));
    }
    
    private CSVRecord lowestHumidityInManyFiles (){
        DirectoryResource dr = new DirectoryResource();
        File lowest = null ;
        for(File f : dr.selectedFiles()){
            lowest = getLowestOfTwoFiles(lowest , f );
        }
        
        return lowestHumidityInFile(new FileResource(lowest).getCSVParser());
        
    }
    
    void testingManyHumidity(){
        CSVRecord record = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity is " + record.get("Humidity") + " at" + record.get("DateUTC"));
    }
    
    private File getLowestOfTwoFiles(File lowest ,File f){
        if(lowest == null)
            return f ;
        else{
            FileResource fr = new FileResource(f);
            CSVParser parser1 = fr.getCSVParser();
            fr = new FileResource(lowest);
            CSVParser parser2 = fr.getCSVParser();
            if(Double.parseDouble(lowestHumidityInFile(parser1).get("Humidity"))< Double.parseDouble(lowestHumidityInFile(parser2).get("Humidity"))){
                return f ;
            }
            else{
                return lowest ;
            }
        }
    }
    
    private double averageTemperatureInFile(CSVParser parser){
        double count = 0 , res = 0;
        for(CSVRecord record : parser){
            count ++ ;
            res += Double.parseDouble(record.get("TemperatureF"));
        }
        return res/count ;
    }
    
    void testingFileAverage(){
        FileResource fr = new FileResource();
        System.out.println("The Average Temperature is "+ averageTemperatureInFile(fr.getCSVParser()));
    }
    
    private double averageTemperatureWithHighHumidityInFile(CSVParser parser , int  value){
        double res = 0 ;
        int count = 0 ;
        for(CSVRecord record : parser){
            if(Double.parseDouble(record.get("Humidity")) >= value){
                count ++ ;
                res+= Double.parseDouble(record.get("TemperatureF"));
            }
        }
        if(count == 0){
            return 0 ;}
        return res / count ;
    }
    
    void testingAverageWithHumidity(){
        FileResource fr = new FileResource();
        if(averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80) == 0){
            System.out.println("No Temperature with such humidity");
        }
        else{
            System.out.println("The Average Temperature is "+ averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80));
        }
        
    }   
    } 
    
    

