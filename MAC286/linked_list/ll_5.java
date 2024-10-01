// creating a circular list and a method within node to detect circular lists.
public class ll_5{
  public static void main(String [] args){

    node<String> sHead = new node<>("뉴진스");
    sHead.add("sal");
    sHead.add("Doge");
    sHead.add("Moises");
    sHead.add("Medha");
    sHead = sHead.new_head("도끼들");
    sHead = sHead.new_head("두려움 없는");
  
    System.out.println("안녕");
    System.out.println("hello");
    System.out.println("안녕");

    node<Integer> circular_list = node.circular_list();
    circular_list.display();
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

  // replaces the head of the linked list.
  public node<Type> new_head(Type n){
    node<Type> new_node_head = new node<>(n);
    new_node_head.next = this;
    return new_node_head;
  }

  // Print out the contents of the linked list.
  public void display(){
    System.out.println("Displaying contents of the linked list:");
    display(1, this);
    System.out.println();
  }
  
  // Encountered a problem with creating a static size field.
  // Using this method to display a linked list in the meantime.
  public void display(int n, node<Type> head){
    node<Type> current = this;
    while(current != null){
      System.out.println("Node "+n+"\n\tAddress: "+current+"\n\tElement in this node: "+current.data);
      if(head == current && n > 1){
        System.out.println("Encountered the head node again. This is a circular list");
        return;
      }
      current = current.next;
      n++;
    }
  }

  // Recursive method for finding the last node.
  public node<Type> traverse(){
    if(this.next ==  null){
      return this;
    }else{
      return this.next.traverse();
    }
  }

  // Careful iterating through this.
  public static node<Integer> circular_list(){
    node<Integer> head = new node<>(1);
    head.add(2);
    head.add(3);
    head.add(4);
    head.add(5);
    head.add(6);
    head.add(7);
    head.add(8);
    head.add(9);

    node<Integer> last = head.traverse();
    node<Integer> ten = new node<>(10);
    last.next = ten;
    ten.next = head;

    return head;
  }
}

