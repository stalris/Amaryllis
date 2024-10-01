import java.util.Random;

public class InsertionSort{
  public static void main(String[] args){
    System.out.println("안녕");

    // create an array of 10 elements.
    InsertSort s_array = new InsertSort(10);
    // populate this array with random numbers between [0,100)
    s_array.rand(100);
    s_array.display();
    s_array.sort();
    s_array.display();
  }
}

class InsertSort{
  private int[] array;

  InsertSort(int[] a){
    array = a;
  }

  InsertSort(int n){
    array = new int[n];
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
    // Iterate length-1 times in the outer loop.
    for(int i = 0; i < array.length-1; i++){

      // The inner loop will compare an element with elements in the 'sorted' subarray.
      // The 'sorted' subarray is the part of array with indices less than j.
      for(int j = i+1; j > 0; j--){

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
    System.out.println();
  }

}
