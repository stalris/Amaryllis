package data_structures;

// Implements a queue using two stacks.
//
// The strategy is to realize the top of a stack is always the tail of a queue.
// Conversely, the bottom of a stack is always the head of a queue.
public class SQueue<Type>{
  private LStack<Type> active;
  private LStack<Type> empty;
  private Type head; // peek() requires access to the bottom of the stack. Declaring this saves time.
  
  // Initialize a new Queue composed of two Stacks.
  public SQueue(){
    active = new LStack<>();
    empty = new LStack<>();
    // Do I need to hold the value of the last element on the list?
    // Yes, otherwise I need to, basically, do dequeue() just to find the head of SQueue.
    head = null; 
  }

  // push() and enqueue() are the same operation.
  public void enqueue(Type data){
    // The first element in LStack is always the head of the queue.
    if(active.isEmpty()){
      head = data;
    }
    active.push(data);
  }
  
  // TODO
  public Type dequeue(){
    // No elements in the active queue.
    if(active.isEmpty())
      return null;
    // I can move all the elements from the active stack into the empty stack.
    while(!active.isEmpty()){
      // pop() from active, and push() that into empty.
      empty.push(active.pop());
    }
    // This effectively reverses the order of the linked list.
    // The top of the stack now holds the head of the queue.
    Type data = empty.pop();
    // Reverse the linked list in order to preserve the logic for dequeue().
    while(!empty.isEmpty()){
      active.push(empty.pop());
    }
    // Finally, return the value we were looking for.
    return data;
  }
  
  // TODO
  public boolean isEmpty(){
    return active.isEmpty();
  }

  // TODO
  public Type peek(){
    return head;
  }

  // Prints the contents of the active LStack
  public void display(){
    while(!active.isEmpty()){
      System.out.println(active.top());
    }
  }
}
