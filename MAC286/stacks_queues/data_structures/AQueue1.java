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
<<<<<<< HEAD
    head = -1;
    tail = -1;
    nums = new int[n];
=======
    nums = new int[n];
    head = -1;
    tail = -1;
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
  }

  public boolean isEmpty(){
    return head == -1;
  }

  public boolean isFull(){
<<<<<<< HEAD
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
=======
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
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
    tail = (tail+1) % nums.length;
    nums[tail] = data;
  }

  public int dequeue(){
    if(isEmpty())
      throw new EmptyStackException();
    int data = nums[head];
<<<<<<< HEAD
    // reset to default state, if this is the last element.
    if(size() == 1){
      head = -1;
      tail = -1;
    }else
      head = (head+1) % nums.length;
    return data;
=======
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
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
  }

  public void display(){
    System.out.println();
<<<<<<< HEAD
    int h;
    for(int i = 0, j = size(); i < j; i++){
      h = (head+i) % nums.length;
      System.out.println("i: "+h+"\n\tnums["+i+"]: "+nums[h]);
=======
    System.out.println("size: "+size());
    for(int i = 0, j = size(), k = 0; i < j; i++){
      k = (head+i) % nums.length;
      System.out.println("nums["+k+"]: "+nums[k]);
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
    }
    System.out.println();
  }
}
