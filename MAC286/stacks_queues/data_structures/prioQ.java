package data_structures;

public class prioQ{
  private int size;
  private int[] nums;

  public prioQ(){
    this(10);
  }

  public prioQ(int n){
    nums = new int[n];
    size = 0;
  }
}

