package data_structures;

public class LQueue<Type>{
  private node head; // reference to the beginning of the list, which serves as the head of the queue.
  private node tail; // reference to the end of the list, which serves as the tail of the queue.
  private int size; // Not using it for anything so far, might change later.
  
  // Initialize an empty queue with 0 nodes.
  public LQueue(){
    head = null;
    tail = null;
    size = 0;
  }

  public class node{
    private node next; // reference to the next node on the list.
    private Type data; 

    node(Type data){
      this.next = null;
      this.data = data;
    }
  }

  // Add nodes to the queue.
  public void enqueue(Type data){
    // Create a new node.
    node new_node = new node(data);
    // Check if the list is empty.
    if(isEmpty()){
      // The only time the head node is updated during enqueue() is when the list is empty.
      head = new_node;
    }else{
      // The list has at least one node. Point that node to the new tail (new_node).
      tail.next = new_node;
    }

    tail = new_node;
    size++;
  }

  // Remove nodes from the queue.
  public Type dequeue(){
    // Empty list, do nothing.
    if(isEmpty())
      return null;
    // Grab the data before losing the reference to the former head of the queue.
    Type data = head.data;
    head = head.next;
    // If we just removed the last node then head now equals null.
    if(head == null)
      tail = null;
    size--;
    return data;
  }

  // List is empty when the head has no reference to a node.
  public boolean isEmpty(){
    return head == null;
  }

  // Print out the contents of the list starting from the head of the queue.
  public void display(){
    node current = head;
    while(current != null){
      System.out.println(current.data);
      current = current.next;
    }
  }
}
