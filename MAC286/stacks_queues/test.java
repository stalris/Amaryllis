import data_structures.AQueue1;

public class test{
  public static void main(String[] args){
    System.out.println("안녕");
    AQueue1 nums = new AQueue1();

    int k = 0;
    for(int i = 0; i < 10; i++){
      nums.enqueue(k++);
      System.out.println(nums.isFull());
    }

    nums.display();

    for(int i = 0, j = nums.size()-1; i < j; i++){
      System.out.println(nums.dequeue());
    }

    for(int i = 0, j = 10 - nums.size(); i < j; i++){
      nums.enqueue(k++);
      System.out.println(nums.isFull());
    }

    nums.display();
  }
}
