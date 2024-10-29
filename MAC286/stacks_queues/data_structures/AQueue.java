package data_structures;
import java.util;

public class AQueue{
  private int head;
  private int tail;
  private int[] nums;

  AQueue(){
    this(10);
  }

  AQueue(int n){
    head = -1;
    tail = -1;
    nums = new int[n];
  }

  public void enqueue(int data){
    // Check if the queue is empty.
    if(head == tail){
      head++;
    }else if((tail+1) % nums.length == head){ // if the array is full then the tail will be one index behind the head. % accounts for the fact that the queue 'wraps' around.
      throw new StackOverflowError();
    }
    // Add the element to the next available slot, at the back of the queue.
    tail = (tail + 1) % nums.length;
    nums[tail] = data;
  }

  public int dequeue(){
    // check if the queue is empty.
    if(head == tail)
      throw new EmptyStackException();

    // 'Remove' the element from the head.
    int data = nums[head];
    head = (head + 1) % nums.length; 
    return data;
  }

  public int peek(){
    // Check if the queue is empty.
    if(isEmpty()){
      throw new EmptyStackException();
    }
    return nums[tail];
  }

  public boolean isEmpty(){
    return (head == tail);
  }
}
