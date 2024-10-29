package data_structures;

import java.util.NoSuchElementException;

// Queue implemented with linked lists.
// This versions traverses through all the nodes to find the last one, for practice.
public class LQueue1<Type>{
  private node head;

  public LQueue1(){
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

  public node last(){
    if(isEmpty())
      throw new NoSuchElementException();

    node current = head;
    while(current.next != null){
      current = current.next;
    }
    // At this point, current = last node.
    return current;
  }

  public void enqueue(Type data) {
    node new_node = new node(data);

    // Add the first node;
    if(isEmpty()){
      head = new_node;
      return;
    }

    // find the last node.
    node last = last();
    last.next = new_node;
  }

  public Type dequeue(){
    if(isEmpty())
      throw new NoSuchElementException();

    // remove data from the first element in the queue.
    Type data = head.data;
    // update head to point to the next element;
    head = head.next;
    return data;
  }

  public Type peek(){
    if(isEmpty())
      throw new NoSuchElementException();
    return head.data;
  }


  public void display(){
    if(isEmpty())
      throw new NoSuchElementException();
    node current = head;

    System.out.println();
    // exhaust all the nodes;
    while(current != null){
      System.out.println(current.data);
      current = current.next;
    }
    System.out.println();
  }

}
