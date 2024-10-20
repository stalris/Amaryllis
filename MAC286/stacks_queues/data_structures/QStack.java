package data_structures;

// Implement a Stack using two queues.
public class QStack<Type>{
  LQueue<Type> q1;
  LQueue<Type> q2;

  // Initialize two queues to in order to implement the stack.
  public QStack(){
    q1 = new LQueue<>();
    q2 = new LQueue<>();
  }

  // Doesn't matter where push happens as it is abstracted away from the user.
  // Just keep track of which queue you are using.
  public void push(Type data){
    LQueue queue = queue();
    :
  }

  // return the non-empty queue.
  private LQueue<Type> queue(){
    if(q1 == null)
      return q2;
    return q1;
  }

}
