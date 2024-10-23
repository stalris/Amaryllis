import java.util.EmptyStackException;

public class test{
  public static void main(String[] args){
    AQueue q = new AQueue();
    try{
      q.dequeue();
    }catch(EmptyStackException empty){
      System.out.println("Stack is empty");
    }
    try{
      for(int i = 0; i < 10; i++){
        q.enqueue(i);
      }
      q.display();
    }catch(StackOverflowError full){
      System.out.println("Stack is full");
    }
  }
}
