package data_structures;

// Implement a Stack using two queues.
// The Queues are composed of linked list, where the head of the list = the head of the queue.
//
// The strategy is to realize that the head of the list = the head of the queue = bottom of the stack.
// In other words, the end of the list = the tail of the queue = the top of the stack.
// enqueue() happens on the tail of the queue while push() happens at the top of the stack.
// Therefore enqueue() and push() happen at the same part of the list, and thus doing one is the same as doing the other.
// However, pop() occurs at the end of the list while dequeue() happens at the head of the list.
// The solution is to dequeue all but the last element into a second queue.
public class QStack<Type>{
  LQueue<Type> active;
  LQueue<Type> empty;
  Type last; // Keeping a tab on the last element pushed to the stack.

  // Initialize two queues to in order to implement the stack.
  public QStack(){
    active = new LQueue<>();
    empty = new LQueue<>();
    last = null;
  }

  // The end of the linked list serves is where both enqueue() and push() happen. Doing one is the same as doing the other.
  public void push(Type data){
    last = data;
    active.enqueue(data);
  }

  // The top of the stack is on the tail of the active queue. 
  // Move all, but the last element, from the active queue to the other queue. Return the last element.
  public Type pop(){
    if(active.isEmpty())
      return null;

    // Go through all elements in the active queue and store the last element in tail.
    Type tail = null; 
    while(!active.isEmpty()){
      tail = active.dequeue();
      // if active isn't empty then push the element into the other queue.
      if(!active.isEmpty())
        empty.enqueue(tail);
    }
    // After the loop tail will contain the last element from the active queue and will now be empty.
    // Reverse the references of active and empty queue.
    LQueue<Type> temp = active;
    active = empty;
    empty = temp;
    return tail;
    
  }

  // If I didn't define last I would have to do the entire queue transfer just to find this element.
  public Type top(){
    return last;
  }

  public boolean isEmpty(){
    return active.isEmpty();
  }

  public void display(){
    active.display();
  }
}
