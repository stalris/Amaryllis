package data_structures;

// A queue implements first-in, first-out.
public class LQueue<Type>{
  private node<Type> head;
  private node<Type> last;
  private int size;

  // Not sure if node needs methods besides its constructors. Think LQueue will implement everything else.
  public class node<Type>{
    private node<Type> next;
    private node<Type> prev;
    private Type data;

    // In order to call another constructor from within a constructor (AKA constructor chaining) you must use 'this' keyword.
    node(){
      this(null);
    }

    node(Type d){
      next = null;
      prev = null;
      data = d;
    }
  }

  // LQueue needs to be public in order to be called from outside the package. 
  // In other words, if you import this class and try to instantiate a new LQueue<>(), it will fail if it doesn't have the public access modifier.
  public LQueue(){
    // An empty queue with no nodes.
    head = null;
    last = null;
    size = 0;
  }

  // Methods that queue needs to implement, push(), pop(), top(), isEmpty()
  public void push(Type d){
    // Check if the Queue is empty.
    node<Type> new_node = new node<>(d);
    if(isEmpty()){
      head = new_node;
    }else{
      // Push new elements to the end of the list, The queue will pop() from the head of the list.
      last.next = new_node;
      new_node.prev = last;
    }
    last = new_node;
    size++;
  }

  public boolean isEmpty(){
    return size==0;
  }

  // Return the element that would be popped.
  public Type top(){
    if(isEmpty())
      return null;
    return head.data;
  }

  // This queue will pop from the beginning of the list, since it pushes to the end of the list.
  public Type pop(){
    if(isEmpty){
      return null;
    }
    node<Type> popped = head;
    // update head. Will be null if the popped element was the last element.
    head = popped.next;
    // TODO
    // if 
    if(head != null)
      head.prev = null;
  }
}
