import java.util.Random;

public class MergeSort{
  public static void main(String[] args){
    System.out.println("안녕");
    mSort array = new mSort(10);
    array.rand(100);
    array.display();
    array.sort();
    array.display();
  }
}

class mSort{
  private int[] array;
  
  mSort(){
    array = new int[10];
  }

  mSort(int n){
    array = new int[n];
  }

  mSort(int[] a){
    array = a;
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
    for(int i = 0; i < array.length;i++){
      System.out.println("array["+i+"]: "+array[i]);
    }
    System.out.println();
  }
}
