package data_structures;

public class array_stack{
  public static void main(String[] args){
    Stack nums = new Stack(100);
    nums.push(42);
    System.out.println(nums.pop());
    nums.pop();
  }
}

class Stack{
  private int[] nums;
  private int index; // Index of the most recent element pushed.
  private int size; // Size of the array.
  
  // If no size is specified, make a default size of 10.
  Stack(){
    this(10);
  }

  Stack(int n){
    nums = new int[n];
    index = -1;
    size = n;
  }

  public void push(int n){
    if(isFull()){
      System.out.println("Stack is full");
      return;
    }else{
      // Move the index to the top of the stack.
      index++;
      nums[index] = n;
    }
  }

  public boolean isFull(){
    return (index == size-1);
  }

  public boolean isEmpty(){
    return (index == -1);
  }

  public int top(){
    if(isEmpty()){
      System.out.println("Stack is empty");
      return -1;
    }
    return nums[index];
  }

  public int pop(){
    if(isEmpty()){
      System.out.println("Stack is empty");
      return -1;
    }
    int j = nums[index];
    index--;
    return j;
  }


}
