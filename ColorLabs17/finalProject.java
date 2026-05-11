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
     
     Picture apic = new Picture("images\\seaTurtle.jpg");//original
     Picture acanvas = new Picture("images\\canvas.jpg");
     Picture apic2 = new Picture("images\\seaTurtle.jpg");//gray
     Picture small = scale(0.5,apic);
     
     Picture gray = new Picture("images\\seaTurtle.jpg");//edgedetection
     Picture turtle = new Picture("images\\seaTurtle.jpg");//vertical
     
     Picture recurse = new Picture("images\\seaTurtle.jpg");//recursion

     
     Picture recurseI = recursiveImage(recurse,acanvas,0,0,0.5);
     Picture gray2 = grayScale(apic2); //makes gray
     Picture vertical = mirrorVertical(turtle);//makes vertical
     Picture endDetect = edgeDetection(gray);//edge detection
     
     Picture newSmall4 = scale(0.5,recurseI); //recurse pic 
     Picture newSmall3 = scale(0.5,vertical); //vertical pic 
     Picture newSmall2 = scale(0.5,endDetect);//endetect
     Picture newSmall = scale(0.5,gray2); //makes pic gray

     copytoCanvas(small,acanvas,0,0);
     copytoCanvas(newSmall,acanvas,500,0);
     copytoCanvas(newSmall2,acanvas,1000,0);
     copytoCanvas(newSmall3,acanvas,1000,661);
     copytoCanvas(newSmall4,acanvas,500,661);
     acanvas.explore();
    
    

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
    
   //makes it smaller
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
  public static Picture mirrorVertical(Picture source){ 
        int width = source.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel, rightPixel;
      /*
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;*/
        
        //loop through all the rows 
        for(int y = 0; y<source.getHeight();y++){
            // loop from 0 to the middle (mirror point)
            for(int x = 0; x<mirrorPoint;x++){
                leftPixel = source.getPixel(x,y);
                rightPixel = source.getPixel(width-1-x,y);
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
        return source;
    }//mirrorVertical

    public static Picture grayScale(Picture source){
        Pixel p;
        int r,g,b,average;
        for(int y=0; y<source.getHeight();y++){
            for(int x=0;x<source.getWidth();x++){
                p=source.getPixel(x,y);
                average=(int)(p.getRed() + p.getGreen() + p.getBlue())/3;
                
                p.setRed(average);
                p.setGreen(average);
                p.setBlue(average);
            }
        }
        return source;
    }
    
    //uses edge detection
    public static Picture edgeDetection(Picture source){
        Pixel leftPixel, rightPixel;
        Color rightColor;
        int colorDistance;
        for(int y = 0; y<source.getHeight();y++){
            for(int x = 0; x<source.getWidth()-1; x++){
                leftPixel = source.getPixel(x,y);
                rightPixel = source.getPixel(x+1,y);
                rightColor = rightPixel.getColor();
                int differnce = Math.abs(leftPixel.getRed()-rightPixel.getRed())+
                Math.abs(leftPixel.getGreen()-rightPixel.getGreen())+Math.abs(leftPixel.getBlue()-rightPixel.getBlue());
                if(differnce>20){
                    leftPixel.setColor(Color.BLACK);
                }
                else{
                    leftPixel.setColor(Color.WHITE);
                }
    
            }
        }
        return source;
    }
    
    public static Picture recursiveImage(Picture source,Picture canvas, int x, int y, double factor){
        if(source.getWidth()<5 || <source.getHeight()<5){
            return canvas;
        }
        copytoCanvas(source,canvas,x,y);
        Picture smaller = scale(factor,source);
        recursiveImage(smaller,canvas,x+50,y+50,factor);
        return source;
    }
    
    
    
    
  /**
   * copy one picture to another picture/canvas
   * add two ints to params to place you want picture on the target
   */
  public static void copytoCanvas(Picture source, Picture target, int startX, int startY){
        Pixel sourcePix, targetPix;
        
        //loop through columns (targetX is the starting point on the canvas)
        for(int sourceX =0; sourceX<source.getWidth();sourceX++){
            for(int sourceY =0; sourceY<source.getHeight();sourceY++){
                
                if(sourceX+startX<target.getWidth() && sourceY+startY<target.getHeight()){
                    sourcePix = source.getPixel(sourceX,sourceY);
                    targetPix = target.getPixel(sourceX+startX, sourceY+startY);
                    targetPix.setColor(sourcePix.getColor());
                    
                }
        }
    }
}
//class
}
