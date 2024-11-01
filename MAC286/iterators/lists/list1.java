package lists;

public class list1{
  private int[] nums;
  private int size;

  public list1(){
    this(10);
  }

  public list1(int n){
    if(n <= -1)
      throw new IllegalArgumentException();
    nums = new int[n];
    size = 0;
  }

  public int size(){
    return size;
  }

  public int get(int index){
    return nums[index];
  }

  public int set(int n, int index){
    int temp = nums[index];
    nums[index] = n;
    return temp;
  }

  // Add a number at index 'index' by shifting elements, starting the shifts at index. 
  public void add(int n, int index){
    // reject attemps to access an invalid index.
    if(index <= -1 || index >= nums.length)
      throw new IndexOutOfBoundsException();
    // Check if the array is full.
    if(size == nums.length)
      throw  new IllegalArgumentException();
    // The end of the list is at index = size-1;
    int temp;
    while(index <= size-1){
      // swap n and nums[index]
      temp = nums[index];
      nums[index] = n;
      n = temp;
    
      // Carry over the last value of n into the next iteration. 
      // This effectively becomes a bunch of element swaps, starting with the element at nums[index].
      index++;
    } 
    size++;
  }
}
