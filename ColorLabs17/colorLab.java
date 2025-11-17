import java.awt.*;
import java.util.*;
import java.util.List; 
/**
 * Write a description of class colorLab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class colorLab
{
    public static void main(String[] args){
        Picture p1 = new Picture("images\\caterpillar.jpg");
        Picture p2 = new Picture("images\\caterpillar.jpg");
        Picture p3 = new Picture("images\\caterpillar.jpg");
        Picture p4 = new Picture("images\\caterpillar.jpg");
        Picture p5 = new Picture("images\\caterpillar.jpg");
        Picture p6 = new Picture("images\\caterpillar.jpg");
        int total = 0;
        
        Pixel[] pixels1;
        pixels1 = p1.getPixels();
        p1.explore();
        
        for(Pixel spot:pixels1){
            spot.setRed((int)(spot.getRed()*0.5));
        
        }
        p1.explore();
        
        Pixel[] pixels2 = p2.getPixels();
        for (Pixel spot: pixels2){
            spot.setRed(255-spot.getRed());
            spot.setBlue(255-spot.getBlue());
            spot.setGreen(255-spot.getGreen());
        }
        p2.explore();
        
        Pixel[] pixels3;
        pixels3 = p3.getPixels();
        
        for (Pixel spot:pixels3){
            total = (spot.getRed()+spot.getBlue()+spot.getGreen())/3;
            spot.setRed(total);
            spot.setBlue(total);
            spot.setGreen(total);
        
        }
        p3.explore();
        
        Pixel[] pixels4;
        pixels4 = p4.getPixels();
        
        for(Pixel spot:pixels4){
            int red = spot.getRed() *2;
            spot.setRed(red);
            int blue = spot.getBlue()*2;
            spot.setBlue(blue);
            int green = spot.getGreen()*2;
            spot.setGreen(green);
        
        }
        p4.explore();
        Pixel[] pixels5;
        pixels5 = p5.getPixels();
        for(Pixel spot:pixels5){
            int red = spot.getRed();
            int blue = spot.getBlue() - spot.getRed();
            int green = spot.getGreen()-spot.getRed();
            spot.setRed(0);
            spot.setBlue(blue);
            spot.setGreen(green);
        
        }
        p5.explore();
        Pixel[] pixels6;
        pixels6 = p6.getPixels();
        
        Color bl = new Color(0,0,225);
        for(Pixel spot1:pixels6){
            if (spot1.getRed() > 250 && spot1.getGreen() < 5 && spot1.getBlue() < 5){
                spot1.setColor(bl);
            }
        }
        p6.explore();
    }
}
