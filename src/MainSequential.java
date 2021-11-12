/* By : Lindani khuzwayo
*  khzlino12
*  Assignment

*/
import java.util.concurrent.ForkJoinPool;
import java.util.*;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;


public class MainSequential{

public static  float array [];
 public static  int number;
 public static float[] temp;
  public static float[] result;
  public static float[] z;
  static long startTime = 0;
     
/*This method starts the timer by setting start timer to the current time of system
*/	
  private static void tick(){
		startTime = System.nanoTime();
	}
   
/*This method stops the timer and calculated the time length of excution
*/   
	private static float tock(){
		return (System.nanoTime() - startTime) / 1000000.0f;
    }


 //// main method drives the program/////
   public static void main(String[] args){
   try{
   File myObj = new File("q.txt");
   Scanner myReader = new Scanner(myObj);
   String arr =myReader.nextLine();
    number = Integer.parseInt(arr);
   
   array =new float[number];
   int i =0;
   
   while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      String [] str =data.split(" ",5);
      String newstr = str[1].replace(",",".");
      float f = Float.parseFloat(newstr);
      array[i]=f;
      i++;
      
      }
   myReader.close();
   }catch(FileNotFoundException e) {
    System.out.println("An error occurred.");
      e.printStackTrace();
    }//try load small task;  `now everything on board 
    
    //for (int s=0;s<1000;s++){
    /////////////////////////////////////////////////////////////////////
    //result = new float[100];
    
    temp = new float[array.length];
    int border = 3/ 2;
    
    tick();
    for (int i=0;i< array.length;i++){
      if (i - border < 0 || i + border >= array.length){
      temp[i] = array[i];
      }else {
      float[] p  = new float[3];
         for (int t = 0; t < 3; t++) {
                  p[t] = array[i+(t-border)];
              }
              Arrays.sort(p);
              temp[i] = p[(p.length / 2)];

       
      }
     }
     //return temp;
    
     float time = tock(); //ends timer
     System.out.println("Run took "+ time +" milliseconds");
    
    ///////////////////////////////////////////////////////////////////////
    //}
    
    
    
    
    
    
    
   }///main

}//class