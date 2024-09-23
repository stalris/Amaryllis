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
  // Takes advantage of the fact that floating points are truncated in ints. i.e 6.5 = 6.
  // Use the algorithm for converting a number n in base 10 to another base b by 
  // taking the remainders of n / b, and using the quotient for subsequent divisions. Stops until there is a 0 for a quotient, so to speak.
  for(int i = 0; n > 0; n = n / b){
    // the modulus operator grabs the remainder of the division n / b.
    remainder = n % b;
    // if the remainder is between 0-9 convert to the equivalent ascii character.
    if(0 <= remainder && remainder <= 9){
      num += remainder + '0';
    }else if(10 <= remainder && remainder <= 16){
      num += remainder - 10 + 'A';
    }
  }
  // The remainders form the new number in base b by reversing their order.
  reverse(num.begin(), num.end());
  return num;
}


class base_converter{
  private:
    string num;
    string base;
    int num_10;

  // Default to 0 in base 10  
  public:
    base_converter(){
      num = "0";
      base = "10";
      num_10 = 0;
    }

    // Store given numbers and their base as strings.
    base_converter(string n, string b){
      num = n;
      base = b;
      // Used std::stoi within the <string> library to convert base b into a decimal.
      // Named a method in this class stoi that converts a number n in base b into its decimal equivalent.
      num_10 = stoi(n, std::stoi(b));
    }

    // Converts the number stored in this object into the given base.
    // Store the result back into num and also return it.
    string change_base(string base){
      string sum = "";
      int b = std::stoi(base); // base is a string because it is passed as a command-line argument.
      int temp = num_10; // copy num_10, otherwise it will be permanently modified in the loop.
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
      // reverse the string to get the final number.
      reverse(sum.begin(), sum.end());
      // update the base and num in this object.
      this->base = base;
      num = sum;
      return sum; 
    }

    // Converts a string 's' in base 'base' to its base 10 equivalent.
    int stoi(string s, int base){
      // parse the string in reverse order.
      reverse(s.begin(), s.end());
      int sum = 0;
      // Parse each char in s.
      for(int i = 0, n = 0; i < s.length(); i++){
        n = ctoi(s[i], base);
        // error popped up in ctoi
        if(n == -1){
          printf("invalid number: %c\n", n);
          return -1;
        }
        sum += n * pow(base, i); 
      }
      
      return sum;
    }

    // only supports numbers up to base 16
    // Converts a given char into its int equivalent
    int ctoi(char c, int base){

      int i;
      if('0' <= c && c <= '9')
        i = c - '0';
      else if('A' <= c && c <= 'F')
        // c-'A' returns 0 if c = 'A', but 'A' represents the number 10. Add 10 to get the correct result.
        i = c - 'A' + 10;
      else if('a' <= c && c <= 'f')
        i = c - 'a' + 10;
      else{
        printf("can't handle numbers that are bigger than base 16");
        return -1;
      }
      // I forgot why I included this if the final else should catch anything between 0-9 and a-f. Oh well.
      // oh. I remember now. The 'number' 'A' can only be represented in base 11-16 (in this program). If the user
      // gives a 'number' that includes 'A', 'B', 'C', etc but those numbers don't exist in the given base then it is caught here.
      // For example, the 'number' 'A' doesn't exist in base 2, only 0 and 1.
      if (i >= base){
        printf("yo gooby, what's going on?\nnumber: %d\nbase: %d\n", i, base);
        return -1;
      }else
        return i;
    }

    void display(){
      cout << "num: " + num << endl;
      cout << "\tbase: " + base << endl;
      printf("\tnumber in base 10: %d\n\n", num_10);
    }
};


// Take command line arguments for converting numbers into different bases.
// There is barely any error-checking and can only handle bases up to 16.
int main(int argc, char* argv[]){
  if(argc != 4){
    printf("Usage: base number_in_base_init_base init_base final_base\n");
    return -1;
  }
  base_converter num = base_converter(string(argv[1]), string(argv[2]));
  num.display();
  printf("Converting to base: %s\n\n", argv[3]);
  num.change_base(string(argv[3]));
  num.display();
}
