package data_structures;
import java.util.NoSuchElementException;


// implements a Stack via linked list queues.
public class QStack1<Type>{
  private LQueue1<Type> active;
  private LQueue1<Type> empty;
  private Type last;

  public QStack1(){
    active = new LQueue1<>();
    empty = new LQueue1<>();
  }

  public boolean isEmpty(){
    return active.isEmpty();
  }

  // The queues' tail act as a stack. When new elements are added to the tail of the queue, they are effectively added to the top of the stack.
  // TLDR: push() == enqueue()
  public void push(Type data){
    active.enqueue(data);
    last = data;
  }

  // pop() must happen at the tail of the queue. We need to find the last element and return it.
  public Type pop(){
    if(isEmpty())
      throw new NoSuchElementException();
    Type data = null;
    while(!isEmpty()){
      last = data;
      data = active.dequeue();
      if(!isEmpty())
        empty.enqueue(data);
    }
    // Empty now has elements, label it correctly.
    LQueue1<Type> temp = active;
    active = empty;
    empty = temp;

    return data;
  }

  public Type top(){
    return last;
  }

  // the queues start counting from the "bottom" of the stack, but we need to start at the top. What do?
  public void display(){
    // ngl I'm running out of time. Could probably do it with a doubly linked list, 
    // but not with a single linked one unless I declare a third queue to store a copy of active and then progressively pop() all elements from active.
    // just print out the elements as a queue.
    active.display();
  }
}
