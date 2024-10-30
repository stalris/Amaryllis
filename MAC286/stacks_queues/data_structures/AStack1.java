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
    return top == nums.length-1;
  }

  public int size(){
    return top+1;
  }

  public void push(int data){
    if(isFull()){
      throw new StackOverflowError();
    }
    top++;
    nums[top] = data;
  }

  public int pop(){
    if(isEmpty()){
      throw new EmptyStackException();
    }
    int data = nums[top];
    top--;
    return data;
  }

  public int top(){
    if(isEmpty())
      throw new EmptyStackException();
    return nums[top];
  }

  public void display(){
    System.out.println();
    for(int i = top;i >= 0; i--){
      System.out.println(nums[i]);
    }
    System.out.println();
  }
}
