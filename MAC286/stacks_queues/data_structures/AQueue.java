package data_structures;
import java.util.EmptyStackException;

public class AQueue{
  private int head;
  private int tail;
  private int[] nums;

  AQueue(){
    this(10);
  }

  public AQueue(){
    this(10);
  }
  public AQueue(int n){
    // Similar logic to AStack. The queue is empty when head = tail = -1;
    head = -1;
    tail = -1;
    nums = new int[n];
  }

  // When dequeuing the last element, make sure to reset this state.
  public boolean isEmpty(){
    return (head == -1);
  }

  // The queue is full when the tail is one behind the head. 
  // For example, in the array [4,0,1,2,3]
  // the head is at i = 1 and tail at i = 0;
  // don't forget to include % nums.length to account for when the queue 'wraps' around the array.
  public boolean isFull(){
    return ((tail+1) % nums.length == head);
  }

  // Add element to the array.
  public void enqueue(int data){
    System.out.println("\n\ti: "+data);
    if(isEmpty()){
      head = 0;
      tail = 0;
      nums[tail] = data;
    }else if(isFull()){
      throw new StackOverflowError();
    }else{
      tail = (tail+1) % nums.length;
      nums[tail] = data;
    }
  }

  // [0, 1, null]
  // [null, 1, null]
  public int dequeue(){
    if(isEmpty()){
      throw new EmptyStackException();
    }else if(tail == head){ // This happens when the queue has only one element, reset the queue.
      int data = nums[head];
      head = -1;
      tail = -1;
      return data;
    }else{
      int data = nums[head];
      head = (head + 1) % nums.length;
      return data;
    }
  }

  public int peek(){
    if(isEmpty())
      throw new EmptyStackException();
    return nums[head];
  }

  public void display(){
    for(int i = 0; i < nums.length; i++){
      System.out.println(nums[(head + i)%nums.length]);
    }
  }
}
