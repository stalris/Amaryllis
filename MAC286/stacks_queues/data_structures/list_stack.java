package data_structures;

public class list_stack{
  public static void main(String[] args){
    System.out.println("내 고양이는 소비아");
    LStack stack = new LStack();
  }
}

// A stack implemented as a linked list.
class LStack <Type>{
  private node<Type> head; // Holds the head of the Linked list.
  private int size;
  
  // Nodes for the linked list stack.
  public class node<Type>{
    private node<Type> next;
    private Type data;
    
    // default node.
    node(){
      this(null);
    }

    // new Node with a generic parameter 'Type' 
    node(Type d){
      next = null;
      data = d;
    }
  }

  // Methods for the linked list.

  // Create a new linkedList.
  LStack(){

  }
}
