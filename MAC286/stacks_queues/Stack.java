import data_structures.QStack;

// Implement a stack using two queues.
// The strategy is to recognize that, assuming the head of the queue is the head of the list, then dequeue() and pop() share the same operation.
// However, enqueue happens on the opposite end, the tail of the queue.
// You can dequeue almost every element from queue_1 into queueu_2. The last element in queue_1 will be the element that needs to be returned for the stack operation pop().
public class Stack{
  public static void main(String[] args){
    System.out.println("어느새 여름 지나 가을");
    QStack<Integer> stack = new QStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.display();
    System.out.println();
    System.out.println(stack.top());
    System.out.println();
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    stack.display();
  }
}
