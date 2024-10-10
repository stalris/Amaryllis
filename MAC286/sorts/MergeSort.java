import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Integer;
import java.lang.NumberFormatException;
import java.lang.StringBuilder;

public class MergeSort{
  public static void main(String[] args){
    System.out.println("안녕");
    mSort num8 = new mSort("Num8.txt");
    mSort num16 = new mSort("Num16.txt");
    mSort num32 = new mSort("Num32.txt");
    mSort num64 = new mSort("Num64.txt");
    mSort num128 = new mSort("Num128.txt");
    mSort num256 = new mSort("Num256.txt");
    mSort num512 = new mSort("Num512.txt");
    mSort num1024 = new mSort("Num1024.txt");
    mSort num2048 = new mSort("Num2048.txt");
    mSort num4096 = new mSort("Num4096.txt");
    mSort num8192 = new mSort("Num8192.txt");
    mSort num16284 = new mSort("Num16284.txt");

    num8.sort();
    num16.sort();
    num32.sort();
    num64.sort();
    num128.sort();
    num256.sort();
    num512.sort();
    num1024.sort();
    num2048.sort();
    num4096.sort();
    num8192.sort();
    num16284.sort();

    num8.display();
    num16.display();
    num32.display();
    num64.display();
    num128.display();
    num256.display();
    num512.display();
    num1024.display();
    num2048.display();
    num4096.display();
    num8192.display();
    num16284.display();

    num8.write("merge_sort_8.txt");
    num16.write("merge_sort_16.txt");
    num32.write("merge_sort_32.txt");
    num64.write("merge_sort_64.txt");
    num128.write("merge_sort_128.txt");
    num256.write("merge_sort_256.txt");
    num512.write("merge_sort_512.txt");
    num1024.write("merge_sort_1024.txt");
    num2048.write("merge_sort_2048.txt");
    num4096.write("merge_sort_4096.txt");
    num8192.write("merge_sort_8192.txt");
    num16284.write("merge_sort_16284.txt");
  }
}

class mSort{
  private int[] array;
  private int count;
  private String file;
  private String unsorted;
  private String sorted;
  
  mSort(){
    array = new int[10];
    count = 0;
    file = "";
    unsorted = Arrays.toString(array);
  }

  mSort(int n){
    array = new int[n];
    count = 0;
    file = "";
    unsorted = Arrays.toString(array);
  }

  mSort(int[] a){
    array = a;
    count = 0;
    unsorted = Arrays.toString(array);
  }

  // Read a file with numbers.
  mSort(String file){
    // Read the file, convert each line into numbers(if possible), and store them in nums. 
    ArrayList<Integer> nums = new ArrayList<>();
    try(BufferedReader b = new BufferedReader(new FileReader(file))){
      String s;
      while((s = b.readLine())!= null){
        try{
          nums.add(Integer.parseInt(s));
        }catch(NumberFormatException nufu){
          // The line wasn't a valid number. Squash this error for now.
        }
      }
    }catch(FileNotFoundException fu){
      System.out.println("Couldn't find the file in this directory: "+file);
      fu.printStackTrace();
      return;
    }catch(IOException iofu){
      System.out.println("IOException. IDK what happened.");
      iofu.printStackTrace();
      return;
    }
    
    // Add the numbers to an int array.
    array = new int[nums.size()];
    for(int i = 0; i < nums.size(); i++){
      array[i] = nums.get(i);
    }

    // clean up.
    count = 0;
    this.file = file;
    unsorted = Arrays.toString(array);
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

    System.out.println("File: "+file);
    System.out.println("\tlength: "+array.length);
    System.out.println("\tCount: "+count);
    System.out.println();
  }

  // Store the values of the int array into a file.
  void write(String file){
    try(FileWriter f = new FileWriter(file)){
      String s;
      if(array.length < 65){
        s = Arrays.toString(array);
        f.write(s);
      }else if(array.length >= 100){
        s = Arrays.toString(Arrays.copyOfRange(array, 51, 101));
        f.write(s);
      }
    }catch(IOException iofu){
      System.out.println("404: File not found.");
      iofu.printStackTrace();
    }
  }
}
