package data_structures;

// A stack implemented as a linked list.
public class LStack <Type>{
  private node<Type> head; 
  private node<Type> last;                         
  private int size;
  
  // Nodes for the linked list stack. 
  public class node<Type>{

    // The presence of prev means this is a doubly-linked list.
    private node<Type> next;
    private node<Type> prev;
    private Type data;
    
    // default node.
    node(){
      this(null);
    }

    // new Node with a generic parameter 'Type' 
    node(Type d){
      next = null;
      prev = null;
      data = d;
    }
  }

  // Methods for the linked list.

  // Create a new linkedList.
  public LStack(){
    head = null;
    size = 0;
  }

  // Add the node to the end of the list.
  public void push(Type d){
    // create a new node to store this element.
    node<Type> new_node = new node<>(d);

    // create the first element.
    if(size == 0){
      head = new_node;
    }else{
      // Have the newely created node point backwards to the previous last node. Must be done first, otherwise have to find prev node again.
      new_node.prev = last;
      // update the prev node to point to newly created node.
      last.next = new_node;
    }
    // update the reference to the last node.
    last = new_node;
    size++;
  }

  // Remove the last node from the stack and return its data.
  public Type pop(){
    
    if(isEmpty()){
      System.out.println("Nothing to remove. Stack is empty\n");
      return null;
    }
    // A reference to the node we're going to remove.
    node<Type> popped = last;
    // update the reference to the last node.
    last = popped.prev;
    // last will be null when popped was the only node in the stack. 
    // That is, since there is only one node in LStack (popped) then last = popped.prev = null ;
    if(last != null)
      last.next = null;
    else{
      // No more nodes in LStack if last == null.
      head = null;
    }
    size--;

    return popped.data;
  }

  public Type top(){
    if(isEmpty()){
      return null;
    }
    return last.data;
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size==0;
  }

  // Print out the contents of the stack.
  public void display(){
    if(isEmpty()){
      System.out.println("Noything to show. Stack is empty\n");
      return;
    }

    System.out.println("Showing all contentds of the list");
    node<Type> current = head;
    while(current != null){
      System.out.println(current.data);
      current = current.next;
    }
  }

}
