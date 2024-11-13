import tree.BST;

public class test{
  public static void main(String[] args){
     System.out.println("하나 둘 셋 넷 다섯 여섯 일곱 여덟 아홉 열");

     BST nums = new BST();

     System.out.println("\tEmpty?: "+nums.isEmpty());
     System.out.println();
     System.out.println("Inserting: "+ 10);
     nums.add(10);
     System.out.println("Inserting: "+ 5);
     nums.add(5);
     System.out.println("Inserting: "+ 12);
     nums.add(12);
     System.out.println("Inserting: "+ 2);
     nums.add(2);
     System.out.println("Inserting: "+ 11);
     nums.add(11);
     System.out.println("Inserting: "+ 15);
     nums.add(15);
     System.out.println("Height: "+nums.height());
     System.out.println();

     System.out.println("\nTree should look like this:");
     System.out.println("    10   ");
     System.out.println("   /  \\");
     System.out.println("  5    12");
     System.out.println(" /    / \\");
     System.out.println("2    11  15");
     System.out.println("\nsize: "+nums.size());

     nums.inorder();
     nums.preorder();
     nums.postorder();
  }
}
