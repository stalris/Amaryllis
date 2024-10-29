package data_structures;
import java.util.NoSuchElementException;

// This version will traverse the entire linked list, just because.
// I lied, forgot this was the linked list stack. All operations occur at the head of the list.
public class LStack1<Type>{
  private node head;

  public LStack1(){
    head = null;
  }

  private class node{
    private node next;
    private Type data;

    private node(Type data){
      this.next = null;
      this.data = data;
    }
  }

  public boolean isEmpty(){
    return head == null;
  }

  public void push(Type data){
    node new_node = new node(data);

    // Head points to the current top of the stack.
    if(!isEmpty())
      // point new_node to the current top of the stack.
      new_node.next = head;
    // Make new_node the new top of the stack;
    head = new_node;
  }

  public Type pop(){
    if(isEmpty())
      throw new NoSuchElementException();

    // Grab data from current top of the stack.
    Type data = head.data;
    // Point head to the next node in the list. If no such node exists then head = null;
    head = head.next;

    return data;
  }

  public Type top(){
    if(isEmpty())
      throw new NoSuchElementException();
    return head.data;
  }

  public void display(){
    if(isEmpty())
      throw new NoSuchElementException();
    node current = head;

    System.out.println();

    while(current != null){
      System.out.println(current.data);
      current = current.next;
    }

    System.out.println();
  }


}
