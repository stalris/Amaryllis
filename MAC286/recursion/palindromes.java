public class palindromes{
  public static void main(String[] args){
    System.out.println("yo");
    palindrome water = new palindrome("water");
    palindrome deified = new palindrome("deified");
    water.is_palindrome();
    deified.is_palindrome();
  }
}

class palindrome{
  String word;

  palindrome(String s){
    word = s;
  }

  void is_palindrome(){
    // To check whether a word is a palindrome you first need to know whether the size of the word is odd or even.
    boolean is = is_palindrome(word);
    if(is)
      System.out.println("is a palindrome");
    else
      System.out.println("is not a palindrome");
  }

  boolean is_palindrome(String word){
    char first = word.charAt(0);
    char last = word.charAt(word.length()-1);
    if(word.length() <= 1){
      return true;
    }
    if(first == last){
      return is_palindrome(word.substring(1, word.length()-1));
    }else{
      return false;
    }
  }
}
