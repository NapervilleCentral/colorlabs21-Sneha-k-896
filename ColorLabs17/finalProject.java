/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*; //imports color class in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class finalProject
{
    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
     
     Picture apic = new Picture("images\\seaTurtle.jpg");
     Picture acanvas = new Picture("images\\canvas.jpg");
     Picture small = scale(0.5,apic);
     small.explore();
     mirrorHorizontal(apic);
     apic.explore(); //DISPLAYS THE PICTURE ------------------------
     //mirrorTemple(apic1);
     copytoCanvas(apic,acanvas);
     //apic1.explore();

  }//main
  
  public static void mirrorHorizontal(Picture source){
        int height = source.getHeight();
        int mirrorPoint = height/2;
        Pixel topPixel, bottomPixel;
        
        for(int y =0;y<mirrorPoint; y++){
            for(int x = 0; x<source.getWidth(); x++){
                topPixel = source.getPixel(x,y);
                bottomPixel = source.getPixel(x,height-1-y);
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    
    }//original
    
    public static Picture scale(double factor,Picture source){
        int newW = (int)(source.getWidth()*factor);
        int newH = (int)(source.getHeight()*factor);
        Picture result = new Picture(newW,newH);
        for(int y =0; y<newH;y++){
            for(int x = 0; x<newW; x++){
                int oldX = (int)(x/factor);
                int oldY = (int)(y/factor);
                Pixel oldPixel = source.getPixel(oldX,oldY);
                Pixel newPixel = result.getPixel(x,y);
                newPixel.setColor(oldPixel.getColor());
            }
        }
        return result;
    }
  
  /**
   * Method to mirror on a vertical line in the middle of the picture
   * based on the width
   */
  public static void mirrorVertical(Picture source){
        int width = source.getWidth();
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        //loop through all the rows 
        for(int y = 27; y<97;y++){
            // loop from 0 to the middle (mirror point)
            for(int x = 13; x<mirrorPoint;x++){
                leftPixel = source.getPixel(x,y);
                rightPixel = source.getPixel(mirrorPoint+(mirrorPoint-x),y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        
      
    }//mirrorVertical
    
    public static void mirrorTemple(Picture source){
        int width = source.getWidth();
        int height = source.getHeight();
        int mirrorPoint = width/2;
        Pixel leftPixel, rightPixel;
        for(int y = 0;y<height/4;y++){
            for (int x = 0; x<mirrorPoint; x++){
                leftPixel = source.getPixel(x,y);
                int reflectedX = mirrorPoint + (mirrorPoint-x);
                if(reflectedX<width){
                    rightPixel = source.getPixel(reflectedX,y);
                    rightPixel.setColor(leftPixel.getColor());
                }
            }
        }
        
        
    }
    
    
  /**
   * copy one picture to another picture/canvas
   * add two ints to params to place you want picture on the target
   */
  public static void copytoCanvas(Picture source,Picture target){
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        //loop through columns (targetX is the starting point on the canvas)
        for(int sourceX =0,targetX = 0; sourceX<source.getWidth();sourceX++,targetX++){
            //loops throug the rows
            for(int sourceY =0,targetY = 0; sourceY<source.getHeight();sourceY++,targetY++){
                sourcePix = source.getPixel(sourceX,sourceY);
                targetPix = target.getPixel(targetX,targetY);
                targetPix.setColor(sourcePix.getColor());
        }
    }
}
//class
}
