package tree;

public class BST {
  private node root;
  private int size;
  private int height;

  public BST(){
    root = null;
    size = 0;
    height = 0;
  }

  private class node{
    private node left;
    private node right;
    private int data;

    private node(int n){
      left = null;
      right = null;
      data = n;
    }
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public int size(){
    return size;
  }

  public int height(){
    return height;
  }

  public void add(int n){
    node new_node = new node(n);
    int node_height = 0;

    if(isEmpty()){
      root = new_node;
      size++;
      return;
    }
    // compares n with the current node, goes left if less than node and right if greater.
    // Loop returns after adding the node.
    
    node current = root;
    // Forbid duplicates, immediately return if found.
    while(true){
      if(current.data == n)
        return;
      if(n <  current.data){
        // if current has no left child, then append the new node as its left child.
        if(current.left == null){
          current.left = new_node;
          size++;
          node_height++;
          height = (node_height > height) ? node_height : height;
          return;
        }
        // Travel down the left branch.
        node_height++;
        current = current.left;
      }else{
        // If the node has no right child, then append the new node as its right child.
        if(current.right == null){
          current.right = new_node;
          size++;
          node_height++;
          height = (node_height > height) ? node_height : height;
          return;
        }
        // Travel down the right branch.
        node_height++;
        current = current.right;
      }
    }
  }

  // inorder traversel.
  // left, root, right.
  public void inorder(){
    if(isEmpty())
      throw new IllegalStateException();
    System.out.println("\nPrinting nodes using inorder traversal:");
    inorder(root);
    System.out.println("\nEnd of traversel\n");
  }

  public void inorder(node n){
    // Travel through the left branch.
    if(n.left != null)
      inorder(n.left);
    // Pring the root, after traveling through the left branch.
    System.out.println("\n\t"+n.data);
    if(n.right != null)
      inorder(n.right);
  }

  // preorder traversal.
  // root, left, right;
  public void preorder(){
    if(isEmpty())
      throw new IllegalStateException();
    System.out.println("\nPrinting nodes using preorder traversal:");
    preorder(root);
    System.out.println("\nEnd of traversel\n");
  }

  public void preorder(node n){
    // Pring the root data.
    System.out.println("\n\t"+n.data);
    // Travel down the left branch.
    if(n.left != null)
      preorder(n.left);
    if(n.right != null)
      preorder(n.right);
  }

  // left-right-root
  public void postorder(){
    if(isEmpty())
      throw new IllegalStateException();
    System.out.println("Printing nodes using postorder traversal:");
    postorder(root);
    System.out.println("\nEnd of traversal\n");
  }

  public void postorder(node n){
    if(n.left != null)
      postorder(n.left);
    if(n.right != null)
      postorder(n.right);
    System.out.println("\n\t"+n.data);
  }
}
