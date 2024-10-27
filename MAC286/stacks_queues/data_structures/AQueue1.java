package data_structures;
import java.util.EmptyStackException;

public class AQueue1{
  private int head;
  private int tail;
  private int[] nums;

  public AQueue1(){
    this(10);
  }

  public AQueue1(int n){
    nums = new int[n];
    head = -1;
    tail = -1;
  }

  public boolean isEmpty(){
    return head == -1;
  }

  public boolean isFull(){
      return (tail+1) % nums.length == head;
  }

  public int size(){
    // if tail is ahead of head. If they are equal then the size == 1;
    if(tail >= head)
      return tail - head + 1;
    return tail - (head-nums.length) + 1;
  }

  public void enqueue(int data){
    if(isFull())
      throw new StackOverflowError();
    // new queue.
    if(isEmpty())
      head++;
    tail = (tail+1) % nums.length;
    nums[tail] = data;
  }

  public int dequeue(){
    if(isEmpty())
      throw new EmptyStackException();
    int data = nums[head];
    if(size() == 1){
      head = -1;
      tail = -1;
      System.out.println("Empty now");
    }else{
      head = (head+1) % nums.length;
    }
    return data;

  }

  public int peek(){
    if(isEmpty()){
      throw new EmptyStackException();
    }

    return nums[head];
  }

  public void display(){
    System.out.println();
    System.out.println("size: "+size());
    for(int i = 0, j = size(), k = 0; i < j; i++){
      k = (head+i) % nums.length;
      System.out.println("nums["+k+"]: "+nums[k]);
    }
    System.out.println();
  }
}
