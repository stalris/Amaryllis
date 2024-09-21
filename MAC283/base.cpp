#include <stdio.h>
#include <math.h>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;


// String handling was a B****. Used <string> to handle memory allocation/deallocation instead of doing it myself.
// Store converted numbers into strings, since native support only exists for base 2, 8, 10, and 16.
//
// TODO. I think I moved this within the class base_converter. Keeping it incase I needed it for something else.
string convert_to(int n, int b){
  int remainder;
  string num;
  for(int i = 0; n > 0; n = n / b){
    remainder = n % b;
    if(0 <= remainder && remainder <= 9){
      num += remainder + '0';
    }else if(10 <= remainder && remainder <= 16){
      num += remainder - 10 + 'A';
    }
  }
  reverse(num.begin(), num.end());
  return num;
}


class base_converter{
  private:
    string num;
    string base;
    int num_10;

  public:
    base_converter(){
      num = "0";
      base = "10";
      num_10 = 0;
    }

    base_converter(string n, string b){
      num = n;
      base = b;
      cout << "inside con, base: " + base <<endl;
      num_10 = stoi(n, std::stoi(b));
    }

    string change_base(string base){
      string sum = "";
      int b = std::stoi(base);
      int temp = num_10;
      for(int i = 0, remainder = 0; temp > 0; temp = temp / b){
        remainder = temp % b;
        if(0 <= remainder && remainder <= 9){
          sum += remainder + '0';
        }else if(10 <= remainder && remainder <= 16){
          sum += 'A' + remainder - 10;
        }else{
          printf("how did we get to this point?\n");
          return "";
        }
      }
      reverse(sum.begin(), sum.end());
      this->base = base;
      num = sum;
      return sum; 
    }

    int stoi(string s, int base){
      reverse(s.begin(), s.end());
      int sum = 0;
      for(int i = 0, n = 0; i < s.length(); i++){
        n = ctoi(s[i], base);
        if(n == -1){
          printf("invalid number: %c\n", n);
          return -1;
        }
        sum += n * pow(base, i); 
      }
      
      return sum;
    }

    // only supports numbers up to base 16
    int ctoi(char c, int base){

      int i;
      if('0' <= c && c <= '9')
        i = c - '0';
      else if('A' <= c && c <= 'F')
        // c-'A' returns 0, but 'A' represents the number 10.
        i = c - 'A' + 10;
      else if('a' <= c && c <= 'f')
        i = c - 'a' + 10;
      else{
        printf("can't handle numbers that are bigger than base 16");
        return -1;
      }
      if (i >= base){
        printf("yo gooby, what's going on?\nnumber: %d\nbase: %d\n", i, base);
        return -1;
      }else
        return i;
    }

    void display(){
      cout << "num: " + num << endl;
      cout << "base: " + base << endl;
      printf("num_10: %d\n", num_10);
    }
};

int main(int argc, char* argv[]){
  if(argc != 4){
    printf("Usage: base number init_base final_base\n");
    return -1;
  }
  base_converter num = base_converter(string(argv[1]), string(argv[2]));
  num.display();
  num.change_base(string(argv[3]));
  num.display();
}
