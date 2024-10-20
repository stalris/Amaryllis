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

  // How should this queue via two stacks work?
  // A queue operates on First in, first out.
  // A stack operates on Last in, first out.
  // Therefore, When pushing into stacks, the first element pushed needs to be eventually retrieved for queue.pop().
  // Do I need to push all elements, except the first, into the second stack? Let's try it.
  // Actually, given the stack [5,4,3,2,1] where 5 is the top of the stack, pushing all elements into another, empty, stack would result in
  // [1,2,3,4,5]. From the second stack, you can pop() to retrieve queue.pop(). You can keep using stack.pop() = queue.pop().
  // It is only when I need to queue.push() that I cannot insert into the head of Stack B. 
  //
  //
  // Strategy: Stack A can easily serve for queue.push(). The Top of Stack A serves as the Tail for the Queue. 
  // The Bottom of Stack A serves as the head of the Queue. In order to queue.pop() we need to access the Bottom of Stack A.
  // This can be done by popping all elements from Stack A into another Stack B. This operations reverses the order of the Elements in the stacks.
  // Stack B's Top now contains the Tail
  //
}
