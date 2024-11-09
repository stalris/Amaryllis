import lists.pList;

public class test{
  public static void main(String[] args){
    System.out.println("내 고양이 귀엽다");
    pList<Integer> nums = new pList<>();

    nums.addFirst(5);
    nums.addFirst(4);
    nums.addFirst(3);
    nums.addFirst(2);
    nums.addFirst(1);

    nums.display();

    nums.addLast(10);

    nums.display();

    nums.find(3);
  }
}
