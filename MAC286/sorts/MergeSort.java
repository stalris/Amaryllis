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
    System.out.println("Array["+lower+"]: "+array[lower]);
    System.out.println("Array["+upper+"]: "+array[upper]);
    if(lower == upper){
      // We found a subarray of size 1
      System.out.println(array[lower]);
      return;
    }else{

      // This array must be split into two equal subarrays.
      // The lower half is bounded by lower and the middle index
      // The upper half is bounded by the (middle index + 1) and upper
      int middle = (lower+upper) / 2;
      sort(lower, middle);
      sort(middle+1, upper);

      // Swap
      if(array[lower] > array[upper]){
        int greater = array[lower];
        array[lower] = array[upper];
        array[upper] = greater;
      }

      System.out.println("After swap");
      System.out.println("\tArray[lower]: "+array[lower]);
      System.out.println("\tArray[upper]: "+array[upper]);
      System.out.println();
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
