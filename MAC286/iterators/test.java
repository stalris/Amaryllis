import lists.list1;

public class test{
  public static void main(String[] args){
    System.out.println("내 고양이 귀엽다");
    list1 nums = new list1();
    nums.add(9, 0);
    nums.add(8, 0);
    for(int i = 0; i < nums.size(); i++){
      System.out.println("\n\tnums["+i+"]: "+nums.get(i));
    }
  }
}
