/* By : Lindani khuzwayo
*  khzlino12
*  Assignment

*/

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.*;

/*This class used the RecursiveTask method to implent the parallel programming alogorithm
*/
class Median extends RecursiveTask< float[] > {
  static int SEQUENTIAL_THRESHOLD = 4; //instance variables
  int lo;  
  int hi;    
  float[] arr; //input array
  int filterSize;
  int borderSize;
  float[] result;//result me
  float[] temp;// store temp
 
 /*This constructor intialise the Medain class
@param A input array of type float
@param the size of the filter
@param low value of type int for the lowest element in the array
@param high value of type int for the size of he array
*/ 
  Median(float[] arr , int lo , int hi ,int filterSize) {
    this.lo=lo;
    this.hi=hi;
    this.arr = arr;
    this.filterSize = filterSize;
     //this.s=SEQUENTIAL_THRESHOLD;
   // this.borderSize = filterSize/2;
   }
   
 /*The compute method overides the computer() function
@return an array of type float 
*/
  public float[] compute() { //overide
 
    if ((hi-lo) < SEQUENTIAL_THRESHOLD) {  //if input is less or equal to sequential, hence run the algoritm runs sequentual
        //////////////////    
        temp = new float[arr.length];
    int border = filterSize/ 2;
    //////////////////////
              
          //result = new float[hi];
          temp = new float[arr.length];
           border = filterSize/ 2;
          
          for (int i=0;i< arr.length;i++){
            if (i - border < 0 || i + border >= arr.length){
            temp[i]= arr[i];
           
            }else {
                float[] p  = new float[3];
                for (int t = 0; t < 3; t++) {
                  p[t] = arr[i+(t-border)];
              }
              Arrays.sort(p);
              temp[i] = p[(p.length / 2)];
            
            
            }
            
            }////inner loop
          ///sort this small array than get median 
           //Arrays.sort(temp);
           //Arrays.toString(temp);
           
         // result[iz]=temp[1];
         // System.out.println(result[iz]);
         
         
          ///outer loop
           
        return temp;
        
 
     }else{  //Thisxzz     Median left = new Median(arr,lo,(hi+lo)/2,filterSize);
     
     Median left = new Median(arr,lo,(hi+lo)/2,filterSize);
     Median right = new Median(arr,(hi+lo)/2,hi,filterSize);  //divide-and-conquer algorithm

     left.fork();  //Allows left threads to be excuted simulatenously 
     right.fork();
     float[] rightAns = right.compute(); //allows the right thread to compute simulatemnously as well
     float[] leftAns = left.join(); //waits for the left threads to compile
     
     int length1 = rightAns.length;  //determines length of firstArray  
     int length2 = leftAns.length; //determines length of secondArray 
     float[] join = new float[length1 + length2];  //resultant array of size first array and second array  
     System.arraycopy(rightAns, 0, join, 0, length1);  
     System.arraycopy(leftAns, 0, join, length1, length2); //combines left and right joins
       
     return join;  //return results
     
  }
 
 
 
 
 
} 
  
}
