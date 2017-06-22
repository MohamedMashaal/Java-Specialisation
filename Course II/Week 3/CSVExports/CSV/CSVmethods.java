import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of CSVmethods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSVmethods {
    String countryInfo(CSVParser parser , String country){
        String result ;
        for(CSVRecord record : parser){
            String current = record.get("Country");
            if(current.contains(country)){
                result = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
                return result ;
            }
        }
        result = "NOT FOUND";
        return result ;
    } 
    
    void listExportersTwoProducts(CSVParser parser , String exportItem1 , String exportItem2 ){
        for(CSVRecord record : parser){
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    int numberOfExporters(CSVParser parser , String exportItem ){
        int count = 0 ;
        for(CSVRecord record : parser){
            if(record.get("Exports").contains(exportItem)){
                count ++ ;
            }
        }
        return count ;
    }
    
    void bigExporters(CSVParser parser , String amount){
        for(CSVRecord record : parser){
            if(record.get("Value (dollars)").length() > amount.length()){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    void testing(){
        FileResource x = new FileResource();
        CSVParser z = x.getCSVParser();
        String result = countryInfo(z , "Nauru");
        System.out.println(result);
        z = x.getCSVParser();
        listExportersTwoProducts(z , "cotton" , "flowers");
        z = x.getCSVParser();
        System.out.println(numberOfExporters(z,"cocoa"));
        z = x.getCSVParser();
        bigExporters(z , "$999,999,999,999");
    }
    
}
