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
public class TestPicture17
{
    Picture apic = new Picture("images\\seaTurtle.jpg");
     Picture acanvas = new Picture("images\\canvas.jpg");
    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /*
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();*/

     //opens a picture using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //Know it, Love it, Live it ON TEST----------------------
     //relative path                dir/folder/file
     
     //Picture apic = new Picture("images\\seaTurtle.jpg");
     Picture acanvas = new Picture("images\\canvas.jpg");
     
     Picture apic1 = new Picture("images\\temple.jpg");
     
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture moto = new Picture("images/redMotorcycle.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");

     //mirrorVertical(apic);
     //apic.explore(); //DISPLAYS THE PICTURE ------------------------
     copytoCanvas(apic1,acanvas);
      mirrorTemple(apic1);
     acanvas.explore();
     //ferris1.explore();
     //moto.explore();
     
     //makes an array of pixels ----have to do for every picture
     //Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
    // pixels = ferris1.getPixels();
     
     Pixel[] mpixels;
     mpixels = moto.getPixels();
   
     //how many pixels or how large array ------- not tested on arrays
    //System.out.println("This is a large array"+pixels.length  );


    /**/
        //access each index
    //System.out.println(pixels[17]);
    //access each pixel
   
    //setting colors with pixel documentation
    /*Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(433,283);
    Pixel ferr17 = pixels[17];
   
    ferr17.setGreen(160);
    ferr17.setBlue(200);
    ferr17.setRed(240);//MUST explore again to see it
   
    Color newColor = new Color(250,128,114);//salmon
    spot.setColor(newColor);
    spot2.setColor(Color.blue);
   
   
    ferris1.explore();
   
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
   
    for (int i = 0; i < 10000; i++){
        Pixel yuck = ferris1.getPixel((int)(Math.random()*600), (int)(Math.random()*600));
        yuck.setColor(Color.green);
    }
    ferris1.explore();
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/**/
   // FOR EACH loop to access indexes of array or collection----------------------
    int red;
    int blue,green;
    //for each loop spot  is a ?
    for (Pixel spot1 : mpixels) {
        //System.out.println( spot1 );
        red = spot1.getRed();
        red = (int)(red*.25);
        spot1.setRed(red);
    }
    //moto.explore();
    for (Pixel spot1 : mpixels) {
        blue = spot1.getBlue();
        blue = (int)(blue*Math.random());
        spot1.setBlue(blue);
       
        green = spot1.getGreen();
        green = (int)(green*Math.random());
        spot1.setGreen(green);
    }
   
    //moto.explore();
   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
   
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
       
        //set the red value of the current pixel to the new value
       

    }
    // use new picture when changing or it will make changes to
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/
    //write/save a picture as a file
    //ferris1.write("images/ferris11.jpg");

    /**/
  }//main
  /**
   * Method to mirror on a vertical line in the middle of the picture
   * based on the width
   */
  public static void mirrorVertical(Picture source){
        int width = source.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        //loop through all the rows 
        for(int y = 0; y<source.getHeight();y++){
            // loop from 0 to the middle (mirror point)
            for(int x = 0; x<mirrorPoint;x++){
                leftPixel = source.getPixel(x,y);
                rightPixel = source.getPixel(width -1-x,y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        
      
    }//mirrorVertical
    
    public void mirrorTemple(Picture source){
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
