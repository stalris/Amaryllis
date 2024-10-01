public class ll_1{
  public static void main(String [] args){
    node head = new node(10);
    head.add(11);
    head.add(12);
    head.add(13);
    head.traverse();
  }
}

class node{

  // Avoiding keeping references to the head and tail nodes in this version.
  public node next;
  public int data;

  node(){
    next = null;
    data = 0;
  }
  
  node(int n){
    next = null;
    data = n;
  }

  // Iterative method for find the last node
  public void add(int n){
    node new_node = new node(n);
    node last = this;
    while(last.next != null){
      last = last.next;
    }
    last.next = new_node;
  }

  // Recursive method for finding the last node.
  public node traverse(){
    System.out.println("Data in this node: " + this.data);
    if(this.next ==  null){
      return this;
    }else{
      return this.next.traverse();
    }
  }
}
