package tree;

public class BST {
  private node root;
  private int size;

  public BST(){
    root = null;
    size = 0;
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

  public void add(int n){
    node new_node = new node(n);

    if(isEmpty()){
      root = new_node;
      size++;
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
          return;
        }
        // Travel down the left branch.
        current = current.left;
      }else{
        // If the node has no right child, then append the new node as its right child.
        if(current.right == null){
          current.right = new_node;
          size++;
          return;
        }
        // Travel down the right branch.
        current = current.right;
      }
    }
  }

  // inorder traversel.
  // left, root, right.
  public void inorder(){
    if(isEmpty())
      throw new IllegalStateException();
    inorder(root);
  }

  public void inorder(node n){
    // Travel through the left branch.
    if(n.left != null)
      inorder(n.left);
    // Pring the root, after traveling through the left branch.
    System.out.println(n.data);
    if(n.right != null)
      inorder(n.right);
  }

  // preorder traversal.
  // root, left, right;
  public void preorder(){
    if(isEmpty())
      throw new IllegalStateException();
    preorder(root);
  }

  public void preorder(node n){
    // Pring the root data.
    System.out.println(n.data);
    // Travel down the left branch.
    if(n.left != null)
      preorder(n.left);
    if(n.right != null)
      preorder(n.right);
  }
}
