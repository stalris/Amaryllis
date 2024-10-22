import data_structures.SQueue;

// The strategy is the realize that the top of a stack always the tail of a queue.
// Conversely, the bottom of a stack is the head of a queue.
//
// Thus, if you need to implement a queue using stacks, then stack.push() and queue.enqueue() are the same operation.
public class Queue{
  public static void main(String[] args){
    System.out.println("말해줘");
    SQueue<Integer> q = new SQueue<>();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    System.out.println(q.peek());
    System.out.println();
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
  }
}
