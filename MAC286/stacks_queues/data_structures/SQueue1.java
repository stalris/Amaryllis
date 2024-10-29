package data_structures;
import java.util.NoSuchElementException;

public class SQueue1<Type>{
  private LStack1<Type> active;
  private LStack1<Type> empty;
  private Type head_data;

  public SQueue1(){
    active = new LStack1<>();
    empty = new LStack1<>();
  }

  public boolean isEmpty(){
    return active.isEmpty();
  }

  // Is enqueue() also equivalent to push in this mirror(?) implementation?
  public void enqueue(Type data){
    // For easier top() operations.
    if(isEmpty())
      head_data = data;
    active.push(data);
  }

  // I need to remove the bottom of the stack, to simulate a dequeue().
  public Type dequeue(){
    if(isEmpty())
      throw new NoSuchElementException();
    // pop() will reverse the order if pushing into a second stack.
    // pop() from this second stack to simulate dequeue()
    // transfer elements back to the active stack to undo the reversion of order.
    while(!active.isEmpty()){
      empty.push(active.pop());
    }
    // empty.pop() now simulates dequeue()
    Type data = empty.pop();
    // Update head_data to look at the new 'head' of the queue / bottom of the stack.
    // but only if empty still has elements.
    if(!empty.isEmpty())
      head_data = empty.top();

    // return to form.
    while(!empty.isEmpty()){
      active.push(empty.pop());
    }

    return data;
  }

  public Type peek(){
    if(isEmpty())
      throw new NoSuchElementException();
    return head_data;
  }

  // Just displaying the elements according to the stack.
  public void display(){
    active.display();
  }


}
