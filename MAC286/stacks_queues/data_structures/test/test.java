import java.util.EmptyStackException;

// An array based stack, holds integers.
public class test{
  public static void main(String[] args){
    AStack stack = new AStack();
    for(int i = 0; i < 10; i++){
      stack.push(i);
    }
    stack.display();
  }
}

class AStack{
  private int[] nums; // A declaration for a reference to an int array.
  private int top; // Index of the element that serves as the top of the stack.
  
  // Default to creating a stack of size 10.
  public AStack(){
    // An example on constructor chaining. 
    // Within one constructor, call another.
    this(10);
  } 

  // Default values for a new stack.
  public AStack(int n){
    nums = new int[n]; // instantiate a new int array of size n, and store it in stack.
    top = -1; // Index of the top of the stack, -1 when empty. When the first element is added to the node it will be stored in index 0.
  }


  // Push a new element to the top of the stack.
  public void push(int data){
    // Arrays have a length property that return its capacity.
    if(top == nums.length-1){
      throw new StackOverflowError("Stack is full");
    }
    // Store the element in the next available slot.
    top++;
    nums[top] = data;
}
public int pop(){
    // Throw the EmpStackException defined in java.util package.
    if(Empty()){
      throw new EmptyStackException();
    }
    int data = nums[top];
    top--;
    return data;
}

 // return the top element of the stack, or throw an exception if empty.
  public int top(){
    if(Empty())
      throw new EmptyStackException();
    return nums[top];
  }

  // When top >= 0 then the array is not empty, otherwise empty.
  public boolean Empty(){
    return top == -1;
  }

  // The index of the stack is always 1 less than the number of elements in the stack.
  // in other words:
  //    the size of the stack - 1 = top
  // so:
  //    top + 1 = size of stack;
  public int size(){
    return top+1;
  }

  // Step through the array and print out all its elements in the order that pop() would have done so.
  public void display(){
  if(Empty()){
    System.out.println("Stack is empty, nothing to print");
    return;
  }
    System.out.println("\nPrinting out, but not removing, elements from the stack");
    for(int i = top; i >= 0; i--){
      System.out.println("\t"+nums[i]);
    }
  }
}

