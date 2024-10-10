import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class InsertionSort{
  public static void main(String[] args){
    System.out.println("안녕");
    InsertSort num8 = new InsertSort("Num8.txt");
    InsertSort num16 = new InsertSort("Num16.txt");
    InsertSort num32 = new InsertSort("Num32.txt");
    InsertSort num64 = new InsertSort("Num64.txt");
    InsertSort num128 = new InsertSort("Num128.txt");
    InsertSort num256 = new InsertSort("Num256.txt");
    InsertSort num512 = new InsertSort("Num512.txt");
    InsertSort num1024 = new InsertSort("Num1024.txt");
    InsertSort num2048 = new InsertSort("Num2048.txt");
    InsertSort num4096 = new InsertSort("Num4096.txt");
    InsertSort num8192 = new InsertSort("Num8192.txt");
    InsertSort num16284 = new InsertSort("Num16284.txt");

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
    num8.write("answers_8.txt");
    num16.write("answers_16.txt");
    num32.write("answers_32.txt");
    num64.write("answers_64.txt");
    num128.write("answers_128.txt");
    num256.write("answers_256.txt");
    num512.write("answers_512.txt");
    num1024.write("answers_1024.txt");
    num2048.write("answers_2048.txt");
    num4096.write("answers_4096.txt");
    num8192.write("answers_8192.txt");
    num16284.write("answers_16284.txt");
  }
}

class InsertSort{
  private int[] array;
  private int count; // Used to indicate the cost of running insertion sort.
  private String file; 
  private String unsorted;
  private String sorted;

  InsertSort(int[] a){
    array = a;
    count = 0;
    file = "";
    unsorted = Arrays.toString(array);
  }

  InsertSort(int n){
    array = new int[n];
    count = 0;
    file = "";
    unsorted = Arrays.toString(array);
  }

  // Creates an int array from a file. Assumes it is populated with numbers.
  InsertSort(String file){

    // Read from the file, convert to numbers, and store them in nums.
    ArrayList<Integer> nums = new ArrayList<>();
    try{

      // Loop through each line in the file and convert them into numbers.
      BufferedReader b = new BufferedReader(new FileReader(file));
      String s;
      int i = 0;
      while((s = b.readLine()) != null){
        if(!s.isEmpty()){
          try{
            // try to convert s to an int, and add it to nums.
            nums.add(Integer.parseInt(s));
          }catch(NumberFormatException nufu){ 
            // s wasn't a valid number. Squash this error. Might change my mind later.
          }
        }
      }

      // Avoiding memory leaks.
      b.close();
    }catch(IOException ioexception){
      System.out.println("Could not read file");
      ioexception.printStackTrace();
      return;
    }catch(Exception e){
      System.out.println("No idea what could have caused this");
      e.printStackTrace();
      return;
    }

    // Copy the list into an array.
    int[] a = new int[nums.size()];
    for(int i = 0, n = nums.size(); i < n ; i++){
      a[i] = nums.get(i);
    }

    // Clean up.
    array = a;
    count = 0;
    this.file = file;
    unsorted = Arrays.toString(array);
  }

  // Populate the array with random numbers between [0,n)
  void rand(int n){
    Random random = new Random();
    for(int i = 0; i < array.length; i++){
      array[i] = random.nextInt(n);
    }
  }

  // Sorts an array in ascending order via insertion sort.
  void sort(){
    // Insertion sort operates by progressively building a sorted subarray from left to right.
    // It starts by considering the first element as sorted, and the rest of the elements as unsorted.
    // For each element in the unsorted subarray, it is compared with elements in the sorted subarray.
    // The element is placed in its correct position by shifting larger elements to the right, in the sorted subarray.
    // The process continues until all elements are sorted.
    // In total, there are length-1 iterations, as only length-1 elements need to be sorted.
    for(int i = 0; i < array.length-1; i++){

      // The inner loop will compare an element, array[j], with elements in the 'sorted' subarray.
      // The 'sorted' subarray is the part of array with indices less than j.
      for(int j = i+1; j > 0; j--){

        count++;
        // Compares the current element with the previous element.
        // If the current element is smaller than the previous one, swap.
        if(array[j-1] > array[j]){

          // Swap both elements.
          int max = array[j-1];
          array[j-1] = array[j];
          array[j] = max;
        }else{ // If no swaps have occured then the subarray is sorted. Break out of the inner loop.
          break;
        }
      }
    }
    // String representation of the sorted array.
    sorted = Arrays.toString(array);
  }

  // Prints out the contents of this array.
  void display(){
    System.out.println("File: "+file);
    System.out.println("\tLength: "+array.length);
    System.out.println("\tCount: "+count);
  }

  void displayUnsorted(){
    System.out.println(unsorted);
  }

  void displaySorted(){
    System.out.println(sorted);
  }

  void display100(){
    if(array.length >= 100){
      for(int i = 51; i <= 100; i++){
        System.out.println(array[i]);
      }
    }
  }

  void write(String file){
    try(FileWriter f = new FileWriter(file)){
      String s;
      if(array.length < 65){
        s = Arrays.toString(array);
        f.write(s);
        f.close();
      }else{
        // copyOfRange takes 3 arguments, (array, start, end)
        // copyOfRange will copy from array starting with and including the start index and ending with, but not including, the end index.
        // Spec says to print indices 51-100, I'm assuming its inclusive [51,100]. So use 51,101 as the range.
        int[] nums = Arrays.copyOfRange(array, 51, 101);
        s  = Arrays.toString(nums);
        f.write(s);
        f.close();
      }
    }catch(IOException iofu){
      System.out.println("ioexception hehe");
      iofu.printStackTrace();
    }
  }

}
