import java.util.Random;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Integer;
import java.lang.NumberFormatException;
import java.lang.StringBuilder;

public class MergeSort{
  public static void main(String[] args){
    System.out.println("안녕");
    mSort num8 = new mSort("Num8.txt");
    num8.display();
    num8.sort();
    num8.display();
  }
}

class mSort{
  private int[] array;
  private int count;
  
  mSort(){
    array = new int[10];
    count = 0;
  }

  mSort(int n){
    array = new int[n];
    count = 0;
  }

  mSort(int[] a){
    array = a;
    count = 0;
  }

  // Read a file with numbers.
  mSort(String file){
    FileReader f;
    char[] b = new char[100000];
    int b_size;
    // Read the file and store it in a buffer.
    try{
      f = new FileReader(file);
      b_size = f.read(b);
      f.close();
    }catch(FileNotFoundException fu){
      System.out.println("Couldn't find the file in this directory: "+file);
      fu.printStackTrace();
      return;
    }catch(IOException iofu){
      System.out.println("IOException. IDK what happened.");
      iofu.printStackTrace();
      return;
    }
    
    // Convert the char buffer into a string
    String temp_s = new String(b, 0, b_size);
    // Separate words in a file along their newlines.
    String[] words = temp_s.split("\n");

    // Convert valid words into their numeric counterparts.
    String s;
    ArrayList<Integer> nums = new ArrayList<>();
    for(int i = 0; i < words.length; i++){
      s = words[i].trim();
      // Make sure there is a word to read.
      if(!s.isEmpty()){
        try{
          nums.add(Integer.parseInt(s));
        }catch(NumberFormatException nfu){
          // String didn't represent a valid number. Ignore this warning for now.
        }
      }
    }

    // Add the numbers to an int array.
    array = new int[nums.size()];
    for(int i = 0; i < nums.size(); i++){
      array[i] = nums.get(i);
    }

    // clean up.
    count = 0;
  }

  // Randomize elements in the array.
  void rand(int n){
    Random r = new Random();
    for(int i = 0; i < array.length; i++){
      array[i] = r.nextInt(n);
    }
  }

  void sort(){

    // The lower and upper bound of the array.
    int lower = 0;
    int upper = array.length-1;
    sort(lower, upper);
    return;
  }

  void sort(int lower, int upper){
    // When the 'bounds' of an array/subarray are the same, the array has a size of 1.
    // These arrays are considered sorted and the finding them is the first step in merge sort.
    if(lower == upper){
      return;
    }else{

      // If the boundaries of the array do not equal each other then we must divide them in half and sort each half.
      // Sort the left and right subarrays
      int middle = (lower+upper) / 2;
      // Sort both sub arrays
      sort(lower, middle);
      sort(middle+1, upper);
      
      // Combine the sorted subarrays by first copying into a temporary array.
      int[] temp = new int[upper-lower+1];
      int lower_left = lower;
      int lower_right = middle+1;
      for(int i = 0; i < temp.length; i++){
        // Used to indicate the running time of merge sort.
        count++;
        // Left subarray is exhausted
        if(lower_left > middle){
          temp[i] = array[lower_right];
          lower_right++;
        }
        // right subarray is exhausted
        else if(lower_right > upper){
          temp[i] = array[lower_left];
          lower_left++;
        }
        // Compare smallest elements from both subarrays
        else{
          if(array[lower_left] < array[lower_right]){
            temp[i] = array[lower_left];
            lower_left++;
          }else{
            temp[i] = array[lower_right];
            lower_right++;
          }
        }
      }
      // Copy the temp array
      for(int i = 0; i < temp.length; i++){
        array[lower+i] = temp[i];
      }
    }
    return;
  }

  void display(){

    // Pring out the values of the array.
    for(int i = 0; i < array.length;i++){
      System.out.println("array["+i+"]: "+array[i]);
    }
    System.out.println("length: "+array.length);
    System.out.println("Count: "+count);
    System.out.println();
  }

  // Store the values of the int array into a file.
  void writeTo(String file){
      try(FileWriter f = new FileWriter(file)){
      StringBuilder s = new StringBuilder();
      for(int i = 0; i < array.length; i++){
        
      }
    }
  }
}
