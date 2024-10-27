// Needs to do push(), pop(), top(), and empty(), isfull() would be great too.
// Fields, array[] for nums, index of top.

package data_structures;
import java.util.EmptyStackException;

public class AStack1{
  private int[] nums;
  private int top;

  public AStack1(){
    this(10);
  }

  public AStack1(int n){
    nums = new int[n];
    top = -1;
  }

  public boolean isEmpty(){
    return top == -1;
  }

  public boolean isFull(){
    return size() == nums.length;
  }

  public int size(){
    return top+1;
  }

  public void push(int data){
    if(isFull())
      throw new StackOverflowError();
    // move pointer to the next available element.
    top++;
    nums[top] = data;
  }

  public int pop(){
    if(isEmpty())
      throw new EmptyStackException();
    int data = nums[top];
    top--;
    return data;
  }

  public int top(){
    return nums[top];
  }

  public void display(){
    if(isEmpty())
      throw new EmptyStackException();
    for(int t = top; t >= 0; t--){
      System.out.println("nums["+t+"]: "+nums[t]);
    }
  }
}
