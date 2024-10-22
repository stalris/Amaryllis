package data_structures;

// Thrown when attempting to access an empty array.
import java.util.EmptyStackException;

// An array based stack.

// I don't understand the intricacies of why delcaring an array using generic parameteter doesn't work, so I'm not going to use it for now.
// syntax in question: 
//      new Type[n]
// The correct syntax:
//     (Type[]) new Object[n] 

// A stack of integers.
public class AStack{
  private int[] stack; // A declaration for a reference to an int array.
  private int max; // Index of the last element in the array. Used to indicate a full array.
  private int top; // Index of the element that serves as the top of the stack.
  
  // Default to creating a stack of size 10.
  public AStack(){
    // An example on constructor chaining. 
    // Within one constructor, call another.
    this(10);
  } 

  // Default values for a new stack.
  public AStack(int n){
    stack = new int[n]; // instantiate a new int array of size n, and store it in stack.
    max = n-1; // The index of the last element in the array is always n-1. For example, in an array of size 5, indices are 0,1,2,3,4.
    top = -1; // When the first element is added to the node it will be stored in index 0.
  }

  // Push a new element to the top of the stack.
  public void push(int data){
    // throw the StackOverflowError exception that is apparently part of the java.lang package
    // Also, java.lang package is automatically imported by default in every java program.
    // Who knew? KEKW
    if(isFull()){
      throw new StackOverflowError("Stack is full");
    }
    // Store the element in the next available slot.
    top++;
    stack[top] = data;
  } 

  public int pop(){
    // Throw the EmpStackException defined in java.util package.
    if(isEmpty()){
      // EmptyStackException takes no arguments, so print out a message instead.
      System.out.println("Stack is empty");
      throw new EmptyStackException();
    }
    // I don't need to reset the values, but I want to.
    int data = stack[top];
    stack[top] = 0;
    top--;
    return data;
  }

  // return the top element of the stack, or throw an exception if empty.
  public int top(){
    if(isEmpty())
      throw new EmptyStackException();
    return stack[top];
  } 

  // When top >= 0 then the array is not empty, otherwise empty.
  public boolean isEmpty(){
    return top == -1;
  }

  // When the index is on the last element of the array then the array is full.
  public boolean isFull(){
    return top == max;
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
    if(isEmpty()){
      System.out.print("Nothing to print, Stack is empty");
      return;
    }
    System.out.println("\nPrinting out, but not removing, elements from the stack");
    for(int i = size()-1; i >= 0; i--){
      System.out.println("\t"+stack[i]);
    }
  }
}
