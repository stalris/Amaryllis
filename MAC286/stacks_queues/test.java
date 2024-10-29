import data_structures.SQueue1;
import data_structures.QStack1;
import java.util.NoSuchElementException;

public class test{
  public static void main(String[] args){
    System.out.println("말해줘");
    // Defaults to a size of 10, if no argument is passed.
    SQueue1<Integer> nums = new SQueue1<>();

    int k = 0;
    System.out.println("\nChecking if the queue is empty and adding an element, 3 times.\n");
    for(int i = 0; i < 3; i++){
      if(!nums.isEmpty())
        System.out.println("\tHead of queue(peek): "+nums.peek());
      System.out.println("\tempty?: "+nums.isEmpty());
      System.out.println("\tenqueueing: "+k);
      nums.enqueue(k++);
    }

    System.out.println("\nRemoving elements and checking if empty, twice.\n");

    for(int i = 0; i < 2; i++){
      if(!nums.isEmpty())
        System.out.println("\tHead of queue(peek): "+nums.peek());
      System.out.println("\tempty?: "+nums.isEmpty());
      System.out.println("\tdequeueing: "+nums.dequeue());
    }

    System.out.println("\nAdding 3 more elements\n");
    for(int i = 0; i < 4; i++){
      if(!nums.isEmpty())
        System.out.println("\tHead of queue(peek): "+nums.peek());
      System.out.println("\tempty?: "+nums.isEmpty());
      System.out.println("\tenqueueing: "+k);
      nums.enqueue(k++);
    }
    System.out.println("\nRemove all elements from the queue\n");
    // dequeue all the elements from nums.
    while(!nums.isEmpty()){
      if(!nums.isEmpty())
        System.out.println("\tHead of queue(peek): "+nums.peek());
      System.out.println("\tempty?: "+nums.isEmpty());
      System.out.println("\tdequeueing: "+nums.dequeue());
    }
    System.out.println("\n\tempty?: "+nums.isEmpty());
    System.out.println("\n\n\nTesting QStack now\n\n\n");

    QStack1<Integer> stack = new QStack1<>();

    System.out.println("\nAdding 4 elements to the stack\n");
    for(int i = 0; i < 4; i++){
      if(!stack.isEmpty())
        System.out.println("\ttop of stack: "+stack.top());
      System.out.println("\tempty?: "+stack.isEmpty());
      System.out.println("\tpushing: "+k);
      stack.push(k++);
    }
    System.out.println("\nRemove 3 elements\n");

    for(int i = 0; i < 3; i++){
      if(!stack.isEmpty())
        System.out.println("\ttop of stack: "+stack.top());
      System.out.println("\tempty?: "+stack.isEmpty());
      System.out.println("\tpopping: "+stack.pop());
    }
    System.out.println("\nAdding 3 more elements\n");

    for(int i = 0; i < 4; i++){
      if(!stack.isEmpty())
        System.out.println("\ttop of stack: "+stack.top());
      System.out.println("\tempty?: "+stack.isEmpty());
      System.out.println("\tpushing: "+k);
      stack.push(k++);
    }
    System.out.println("\nRemove all elements\n");

    // remove all elements from stack.
    while(!stack.isEmpty()){
      if(!stack.isEmpty())
        System.out.println("\ttop: "+stack.top());
      System.out.println("\tempty?: "+stack.isEmpty());
      System.out.println("\tpopping: "+stack.pop());
    }
  }
}
