import tree.BST;

public class test{
  public static void main(String[] args){
     System.out.println("하나 둘 셋 넷 다섯 여섯 일곱 여덟 아홉 열");

     BST nums = new BST();

     System.out.println("\tEmpty?: "+nums.isEmpty());
     nums.add(10);
     nums.add(5);
     nums.add(12);
     nums.add(2);
     nums.add(11);
     nums.add(15);

     nums.inorder();
     System.out.println("\tEmpty?: "+nums.isEmpty());
     nums.preorder();
  }
}
