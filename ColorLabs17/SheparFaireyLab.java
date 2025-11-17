
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List


public class SheparFaireyLab
{
    public static void main(String[] args)
    {
        
         //opens selfie picture 
          /**/
         /*String fileName = FileChooser.pickAFile();
         Picture pictObj = new Picture(fileName);
         pictObj.explore();*/
         
         //relative path
         Picture apic = new Picture("images\\sneha.jpg");
         //Picture apic = new Picture("images\beach.jpg");
         //change with selfie picture
         Picture me = new Picture("images/sneha.jpg");
         Picture me1 = new Picture("images/sneha.jpg");
         Picture me2 = new Picture("images/sneha.jpg");
         
         //creates 4 sections rgb
         int sec1 = 255/4;
         int sec2 = 255/2;
         int sec3 = 255 * 3/4;
         
         Pixel pixels [];
         pixels = apic.getPixels();
         apic.explore();
         
         Pixel pixels1 [];
         pixels1 = me.getPixels();
         
         /**
          * method 1 change
          * Makes everything greyscale and roughly divides sections and colors
          */
         for (Pixel spot: pixels1){
            int average = (spot.getRed() + spot.getBlue() + spot.getGreen())/3;
            spot.setRed(average);
            spot.setBlue(average);
            spot.setGreen(average);
            
            }         
         Color dark = new Color(131,80,159); // dark amymnest
         Color light = new Color(250,217,201); // peach glow
         Color coral = new Color(240,128,128); // light coral
         Color berry = new Color (153,15,75); // vintage berry
         for (Pixel spot:pixels1){
            if (spot.getRed()<sec1){
                spot.setColor(dark);
            }
            else if(spot.getRed()>=sec1 && spot.getRed() < sec2){
                spot.setColor(light);
            }
            else{
                spot.setColor(berry);
            }
            }
         me.explore();
         
         Pixel pixels2[];
         pixels2 = me1.getPixels();
         // method 2 change - makes grayscale and makes 4 sections based off of highest and lowest rbg values
         for(Pixel spot:pixels2){
            int average = (spot.getRed() + spot.getBlue()+spot.getGreen())/3;
            spot.setRed(average);
            spot.setBlue(average);
            spot.setGreen(average);
            }
         int largest = 1;
         int lowest = -1;
         for (Pixel spot:pixels2){
            int nextRed = spot.getRed();
            if (largest ==1 && lowest == -1){
                largest = nextRed;
                lowest = nextRed;
            }
            else{
                if(nextRed>largest){
                    largest=nextRed;
                }
                else{
                    lowest = nextRed;
                }
            }
            }
         int value = largest-lowest;
         int one = value/4;
         int two=value/2;
         int three = value*3/4;
         
         for (Pixel spot:pixels2){
            if(spot.getRed()<=one){
                spot.setColor(dark);
            }
            else if(spot.getRed()>one && spot.getRed()<two){
                spot.setColor(light);
            }
            else if(spot.getRed()>=two &&spot.getRed()<three){
                spot.setColor(coral);
            }
            else{
                spot.setColor(berry);
            }
            }
            me1.explore();
         
         //method 3
         Pixel pixels3[];
         pixels3 = me2.getPixels();
         int sc1 = 255/6;
         int sc2 = 255/3;
         int sc3 = 255/2;
         int sc4 = 255 * 2/3;
         int sc5 = 255*5/6;
         for (Pixel spot: pixels3){
            int average = (spot.getRed() + spot.getBlue()+spot.getGreen())/3;
            spot.setRed(average);
            spot.setBlue(average);
            spot.setGreen(average);
            }
         Color p1 = new Color(222,182,133);
         Color p2 = new Color(10,10,10);
         Color p3 = new Color(144,93,93);
         Color p4 = new Color(255,183,197);
         Color p5 = new Color(255,190,152);
         Color p6 = new Color(255,92,157);
         for (Pixel spot:pixels3){
             if(spot.getRed()<sc1){
                 spot.setColor(p1);}
             else if (spot.getRed()>=sc1 && spot.getRed()<sc2){
                spot.setColor(p2);
                }
             else if (spot.getRed()>=sc2 && spot.getRed()<sc3){
                spot.setColor(p3);
                }
             else if(spot.getRed()>=sc3 && spot.getRed()<sc4){
                spot.setColor(p4);
                }
             else if(spot.getRed()>=sc4 && spot.getRed()<sc5){
                spot.setColor(p5);
                }
             else{
                spot.setColor(p6);
                }
            }
         me2.explore();
         me2.write("images/SFtryfinal.jpg");
    }//main       
}//class
