package data_structures;

// If you plan to import the LStack class from another package or file, it must be declared public.
// If this file contains the main() method, then that class must be public instead.
// In this case, LStack can omit the access modifier (making it package-private).
// This means that LStack will only be accessible within the same package.
//
// The syntax for declaring a generic class with a generic parameter is:
// class ClassName<T> {...}
public class LStack<Type>{
  // reference to the top of the stack (The first node in the list).
  // The identifier for the generic parameter can be used in the class as follows:
  private Node head; 
  private int size; // Keeps track of the number of elements in the list. Useless for now, might use it later.

  // Constructor to instantiate a new LStack.
  public LStack(){
    head = null;
    size = 0;
  }

  // node class nested within LStack for better organization.
  class Node{
    Type data; // The element/data of each node.
    Node next; // reference to the next node in the list.
    
    Node(Type data){
      this.data = data;
      this.next = null; // All newly created nodes will initially point to null(nothing).
    }
  }

  // Add a new element onto the stack.
  public void push(Type d){
    // Create a new node. This will act as the new head of the stack.
    Node newNode = new Node(d);

    // Check for the general case, where at least one node exists in the list.
    if(!isEmpty()){
      //The new node will become the head node. Point the new node to the previous head.
      newNode.next = head;
    }
    // In either the base case or general case, the reference to the top of the stack always points to the new node.
    head = newNode;
    size++; // Update counter for number of nodes in the list.
  }

  // Remove an element from the stack.
  public Type pop(){
    // Check for the base case, where the list is empty.
    if(isEmpty()){
      return null;
    }
    // The general case, where at least one element is in the list.
    Type data = head.data;
    head = head.next;
    return data;
  }

  // Grab element from the stack without removing it from the list.
  public Type top(){
    // Check for the base case, where the list is empty.
    if(isEmpty()){
      return null;
    }
    // General case, return data from the top of the stack.
    return head.data;
  }

  // Check if the stack is empty.
  public boolean isEmpty(){
    return (head == null);
  }
}
