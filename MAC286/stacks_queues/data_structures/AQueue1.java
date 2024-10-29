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
    head = -1;
    tail = -1;
    nums = new int[n];
  }

  public boolean isEmpty(){
    return head == -1;
  }

  public boolean isFull(){
    return size() == nums.length;
  }

  public int size(){
    // If the tail index is ahead of the head.
    if(tail >= head){
      return tail - head + 1;
    }
    // tail wrapped around the array, and is now behind the head.
    return tail - (head - nums.length) + 1;
  }

  public void enqueue(int data){
    if(isFull()){
      throw new StackOverflowError();
    }
    // Intialize the head to 0, if the queue was previously empty.
    if(isEmpty()){
      head++;
    }
    tail = (tail+1) % nums.length;
    nums[tail] = data;
  }

  public int dequeue(){
    if(isEmpty())
      throw new EmptyStackException();
    int data = nums[head];
    // reset to default state, if this is the last element.
    if(size() == 1){
      head = -1;
      tail = -1;
    }else
      head = (head+1) % nums.length;
    return data;
  }

  public void display(){
    System.out.println();
    int h;
    for(int i = 0, j = size(); i < j; i++){
      h = (head+i) % nums.length;
      System.out.println("i: "+h+"\n\tnums["+i+"]: "+nums[h]);
    }
    System.out.println();
  }
}
