
/**
 * Write a description of ImageToGray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
public class ImageToGray {
    private ImageResource toGray(ImageResource image){
        ImageResource outOne = new ImageResource(image.getWidth() ,image.getHeight());
        for(Pixel pixel : image.pixels()){
            int aver = (pixel.getRed() +pixel.getBlue() +pixel.getGreen()) / 3 ;
            Pixel tempo = outOne.getPixel(pixel.getX(),pixel.getY());
            tempo.setRed(aver);
            tempo.setGreen(aver);
            tempo.setBlue(aver);
        }
        return outOne;
    }
    
    public void pickAndChange(){
        DirectoryResource dr = new DirectoryResource();
        ImageResource tempo , newImage ;
        for(File f : dr.selectedFiles()){
        tempo = new ImageResource(f);
        String fileName = tempo.getFileName();
        fileName = "inverted-" + fileName ;
        newImage = toNegative(tempo);
        newImage.setFileName(fileName);
        newImage.save();
        }
    }
    
    private ImageResource toNegative(ImageResource image){
        ImageResource outOne = new ImageResource(image.getWidth() ,image.getHeight());
        for(Pixel pixel : image.pixels()){
            Pixel tempo = outOne.getPixel(pixel.getX(),pixel.getY());
            tempo.setRed(255-pixel.getRed());
            tempo.setGreen(255-pixel.getGreen());
            tempo.setBlue(255-pixel.getBlue());
        }
        return outOne;
    }
    
}
