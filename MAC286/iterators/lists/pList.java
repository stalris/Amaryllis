package lists;

public class pList<Type>{
  public node head;
  public node tail;
  private int size;

  private class node {
    private node next;
    private node prev;
    private Type data;

    public node(Type data){
      next = null;
      prev = null;
      this.data = data;
    }
  }

  // Constructor
  public pList(){
    head = null;
    size = 0;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public int size(){
    return size;
  }

  public Type first(){
    if(isEmpty())
      throw new IndexOutOfBoundsException();

    return head.data;
  }

  public Type last(){
    if(isEmpty())
      throw new IndexOutOfBoundsException();
    return tail.data;
  }

  public void addFirst(Type data){

    // create a new node.
    node new_node = new node(data);

    if(isEmpty()){
      head = new_node;
      tail = new_node;
      size++;
      return;
    }

    // The node pointed by head becomes the new second node.
    node prev_first = head;

    // link the new node.
    new_node.next = head;

    // link the prev node.
    prev_first.prev = new_node;

    // update head node.
    head = new_node;

    size++;
  }

  public void addLast(Type data){
    if(isEmpty()){
      addFirst(data);
      return;
    }
    node new_node = new node(data);

    node prev_last = tail;
    
    // point the new node to the previous last node.
    new_node.prev = prev_last;

    // Update prev node to point to the new last node.
    prev_last.next = new_node;

    // update tail;
    tail = new_node;

    size++;
    
  }

  public node find(int index){
    if(isEmpty())
      throw new IndexOutOfBoundsException();
    int i = 1;
    node current = head;
    while(i < index){
      current = current.next;
      i++;
    }
    return current;
  }

  // Add an element before the specified index.
  public void addBefore(Type data, int index){
    // Do I want to add at index == size? 
    // Yes, equivalent to addLast.
    if(index < 0 || index > size){

    }
  }

  public void display(){
    if(isEmpty())
      return;
    node current = head;
    System.out.println("\nin display(): ");
    System.out.println("\n\tfirst: "+head.data);
    System.out.println("\n\tlast: "+tail.data);
    while(current != null){
      System.out.println("\n\n\t\tcurrent.data: "+current.data);
      current = current.next;
    }
  }
}
