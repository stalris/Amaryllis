import java.util.Random;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.nio.charset.StandardCharsets;

public class InsertionSort{
  public static void main(String[] args){
    System.out.println("안녕");
    InsertSort num8 = new InsertSort("Num8.txt");
    System.out.println("Before sorting");
    num8.display();
    num8.sort();
    System.out.println("After sorting");
    num8.display();
  }
}

class InsertSort{
  private int[] array;
  public int count; // Used to indicate the cost of running insertion sort.

  InsertSort(int[] a){
    array = a;
    count = 0;
  }

  InsertSort(int n){
    array = new int[n];
    count = 0;
  }

  // Creates an int array from a file. Assumes it is populated with numbers.
  InsertSort(String file){
    FileReader f;
    char[] b = new char[10000];
    String w;
    String[] words;
    ArrayList<Integer> nums = new ArrayList<>();
    try{

      // Read the file
      f = new FileReader(file);
      f.read(b);

      // Split the file along its newlines.
      w = new String(b);
      words = w.split("\n");
      f.close();

    }catch(IOException ioexception){
      System.out.println("Could not read file");
      ioexception.printStackTrace();
      return;
    }catch(Exception e){
      System.out.println("No idea what could have caused this");
      e.printStackTrace();
      return;
    }
    // Parse numbers.
    String s = "";
    for(int i = 0; i < words.length; i++){
      try{
        s = words[i].trim();
        if(!s.isEmpty()){
          nums.add(Integer.parseInt(s));
        }
      }catch (NumberFormatException n){
        // A non-number word was found. Ignore it. Might change my mind later.
      }catch(Exception e){
        System.out.println("Wonder what happened here?");
      }
    }

    // Copy the list into an array.
    int[] a = new int[nums.size()];
    for(int i = 0, n = nums.size(); i < n ; i++){
      a[i] = nums.get(i);
    }

    // Clean up.
    array = a;
    count = 0;
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
  }

  // Prints out the contents of this array.
  void display(){
    for(int i = 0; i < array.length; i++){
      System.out.println("array["+i+"]: "+array[i]);
    }
    System.out.println("Length of array: "+array.length);
    System.out.println("Count: "+count);
    System.out.println();
  }

}
