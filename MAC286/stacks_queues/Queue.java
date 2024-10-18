//import data_structures.list_stack.LStack;
import data_structures.LStack;

public class Queue{
  public static void main(String[] args){
    System.out.println("말해줘");
    LStack<Integer> stack = new LStack<>();
    LStack<String> stack2 = new LStack<>();
    stack.pop();
    stack.push(42);
    stack.pop();
    System.out.println(stack.size());
  }
}
