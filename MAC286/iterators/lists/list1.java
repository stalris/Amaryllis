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

  // Add a number at 'index' by shifting elements, starting the shifts at 'index'. 
  public void add(int n, int index){
    // reject attemps to access an invalid index. 
    // index == size is a valid index. It means insert at the end of the list.
    if(index < 0 || index > size)
      throw new IndexOutOfBoundsException();
    // Check if the array is full.
    if(size == nums.length)
      throw  new IllegalArgumentException();
    int temp;
    int nums_ahead = size - index; // the number of elements between index (inclusive) and the end of the list(exclusive).
    int swaps = nums_ahead + 1;  // If there are no elements ahead(index==size) then do at least one swap.

    // Swaps n and nums[index+i], the first swap happens at index+0 = index. The last swap access the new end of the list.
    for(int i = 0; i < swaps; i++){
      temp = nums[index+i];
      nums[index+i] = n;
      n = temp;
    }

    size++;
  }

  // remove and return the number at index. Shifts all subsequent elements to remove any dead space.
  // Starts from the end of the list.
  public int remove(int index){
    // Check for invalid indices.
    // Valid indices of a list are between [0, and size-1]
    // You can write this as index >= 0 && index < size
    // To indicate invalid indices, use demorgans to invert the expression.
    // !(index >= 0 && index < size) =
    // !(index >= 0) || !(index < size) = 
    // index < 0 || index >= size
    if(index < 0 || index >= size())
      throw new IndexOutOfBoundsException();
    int data = get(index);

    // Start from the last element of the list, size-1.
    int current_index = size - 1;
    for(int i = 0, temp = 0, prev = 0; i < size; i++){
      temp = nums[current_index-i]; // element at the current index.
      nums[current_index-i] = prev; // replace with the TODO
      prev = temp;
    }

    size--;
    return data;
  }
}
