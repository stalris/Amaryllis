// An array based stack.

public class AStack<Type>{
  private Type[] stack;
  private int max; // Maximum number of elements the stack can hold.
  private int top; // Index to the element that serves as the top of the stack.
  
  // Default to creating a stack of size 10.
  public AStack(){
    // An example on constructor chaining. 
    // Within one constructor, call another.
    this(10);
  } 

  // Default values for a new stack.
  public AStack(int n){
    stack = new int[n];
    max = n;
    top = 0;
  }

  //
  public void push(Type data){
    if(isFull()){
      System.out.println("Array is full");
      return;
    }
    // Store the element and update index for the top of the stack.
    stack[top] = data;
    top++;
  } 

  public Type pop(){
    if(isEmpty()){
      System.out.println("Array is empty");
      return null;
    }
    // I don't need to 
    Type data = stack[top];
    stack[top] = null;
    top--;
    return data;
  }

  public Type top(){

  } 

  public boolean isEmpty(){

  }

  public boolean isFull(){

  }

  public int size(){

  }
}
