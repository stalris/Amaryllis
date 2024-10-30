<<<<<<< HEAD
=======
// Needs to do push(), pop(), top(), and empty(), isfull() would be great too.
// Fields, array[] for nums, index of top.

>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
package data_structures;
import java.util.EmptyStackException;

public class AStack1{
  private int[] nums;
  private int top;

  public AStack1(){
    this(10);
  }
<<<<<<< HEAD
=======

>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
  public AStack1(int n){
    nums = new int[n];
    top = -1;
  }

  public boolean isEmpty(){
    return top == -1;
  }

  public boolean isFull(){
<<<<<<< HEAD
    return top == nums.length-1;
=======
    return size() == nums.length;
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
  }

  public int size(){
    return top+1;
  }

  public void push(int data){
<<<<<<< HEAD
    if(isFull()){
      throw new StackOverflowError();
    }
=======
    if(isFull())
      throw new StackOverflowError();
    // move pointer to the next available element.
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
    top++;
    nums[top] = data;
  }

  public int pop(){
<<<<<<< HEAD
    if(isEmpty()){
      throw new EmptyStackException();
    }
=======
    if(isEmpty())
      throw new EmptyStackException();
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
    int data = nums[top];
    top--;
    return data;
  }

  public int top(){
<<<<<<< HEAD
    if(isEmpty())
      throw new EmptyStackException();
=======
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
    return nums[top];
  }

  public void display(){
<<<<<<< HEAD
    System.out.println();
    for(int i = top;i >= 0; i--){
      System.out.println(nums[i]);
    }
    System.out.println();
=======
    if(isEmpty())
      throw new EmptyStackException();
    for(int t = top; t >= 0; t--){
      System.out.println("nums["+t+"]: "+nums[t]);
    }
>>>>>>> 077e85bab98f740477b6040e59ddf12b5ffb5121
  }
}
