// Modifying the program to accept generic parameters.
public class ll_2{
  public static void main(String [] args){
    node<Integer> head = new node<>(10);
    head.add(11);
    head.add(12);
    head.add(13);
    head.traverse();

    node<String> sHead = new node<>("뉴진스");
    sHead.add("sal");
    sHead.add("Doge");
    sHead.add("Moises");
    sHead.add("Medha");
    sHead.traverse();
  }
}

class node<Type>{

  // Avoiding keeping references to the head and tail nodes in this version.
  public node<Type> next;
  public Type data;

  node(){
    next = null;
    data = null;
  }
  
  node(Type n){
    next = null;
    data = n;
  }

  // Iterative method for find the last node
  public void add(Type n){
    node<Type> new_node = new node<>(n);
    node<Type> last = this;
    while(last.next != null){
      last = last.next;
    }
    last.next = new_node;
  }

  // Recursive method for finding the last node.
  public node<Type> traverse(){
    System.out.println("Data in this node: " + this.data);
    if(this.next ==  null){
      return this;
    }else{
      return this.next.traverse();
    }
  }
}
