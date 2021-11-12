/* By : Lindani khuzwayo
*  khzlino12
*  Assignment

*/


import java.util.concurrent.ForkJoinPool;
import java.util.*;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

/*This class is the main class of excution for the median filter
*/
public class Main{

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
    
 /*This method invokes the fork/join framework and ensure it is correctly implemnented.
*/
   static float[] Median(float[] arr,int FilterSize){
     return ForkJoinPool.commonPool().invoke(new Median(arr,0,arr.length,FilterSize)); 
    }

 public static void main(String[] args)
  /*Main program which runs the main texfile and prints appropriate commands if neccessary*/
   {
   //reads input
  
   try {
     File textfile = new File(args[0]); //Reads texfile and store data to an array
     Scanner scan  = new Scanner(textfile);
     String line1 = scan.nextLine();
     int size = Integer.parseInt(line1);
     float [] arr = new float[size];
   
     for ( int i=0;i<size;i++)
      {
       String data = scan.nextLine();
       data =  data.replace(",",".");
      String[] input  = data.split(" ",2);
      arr[i] = Float.parseFloat(input[1]);  
      }
    
     scan.close();
   // for (int i=0;i<1000;i++){
    System.gc();
    float[] ans = new float[arr.length];
    //float[] time1 = new float[100];
      tick();  //starts timer
      ans =  Median(arr,Integer.parseInt(args[1]));
     float time = tock(); //ends timer
     //float x=time ;
    //System.out.println("Run took "+ time +" milliseconds");
    
    tick(); //repeats timer
    ans =  Median(arr,Integer.parseInt(args[1]));
     time = tock();
    //x=(x+time)/2;
    System.out.println("Second Run took "+ time +" milliseconds"); //stores final results in textfile
    //System.out.println("avg"+ x +" milliseconds");
    //time1[i]=x;
    
    
   // }///for loop for the repeating runs 
   
   /////////////////////////////////////////////////////////////
   	try {
				  File myObj = new File(args[2]);
				  myObj.createNewFile();
			      FileWriter myWriter = new FileWriter("filename.txt");
			      
			      for(int i = 0; i < size; i++) {
			    	  String data = String.valueOf(ans[i]).replace(".", ",");
			    	  String output = i + " " + data + "\n";
			    	  myWriter.write(output);
			      }
			      myWriter.close();
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			
   
   
    
    }//first try///////////////////////
   
  catch (IOException e)
   {
    System.out.println("Textfile not found");
    }

   }
} 
