#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

using namespace std;

class base_converter{
  private: 
    // Store the number's value in base 10
    int num_10;
    int base;
    // number of digits in num_10. Also length of num
    int d;
    // Store the number as a string
    char* num;

  public:
    base_converter(){
      // default values
      num_10 = 0;
      base = 10;
      d = 1;
      num = (char*)malloc(d+1);
    }

    // number 12345, base 7
    base_converter(int n, int b){
      base = b;
      d = digits(n);
      num = (char*)malloc(d+1);
      snprintf(num, d+1, "%d", n);
      num_10 = (int) strtol(num, NULL, base);
    }

    base_converter(char* n, char* b){
      base = find_base(b);
      num_10 = (int) strtol(n, NULL, base);
    }

    // This only checks for bases between 0 and 16. 
    int find_base(char* base){
      // Empty string
      if(strlen(base) == 0){
        printf("Empty string, try again\n");
        return -1;
      }
      // Can only handle bases up to 16. i.e max length of str can only be 2.
      if(strlen(base) > 2){
        printf("invalid base. Not programmed to handle anything bigger than hex.");
        return -1;
      }else if(strlen(base) == 2){ // Assume that the string is in decimal
        int b = (int) strtol(base, NULL, 10);
        if(b >= 0 && b <= 16)
          return b;
        else{
          printf("cannot handle bases bigger than 16\n");
          return -1;
        }
      // string of length 1. Can only handle strings that have 0-9 or a-f or A-F  
      }else{
        if(base[0] >= '0' && base[0] <= '9'){
          return base[0] - '0';
        }else if(base[0] >= 'A' && base[0] <= 'F'){
          return base[0] - 'A' + 10;
        }else if(base[0] >= 'a' && base[0] <= 'f'){
          return base[0] - 'a' + 10;
        }else{
          printf("something went wrong. Cannot handle bases that aren't between 0-9 or A-F\n");
          return -1;
        }
      }
    }
    int digits(int num){

      // There are two ways to find the number of digits in an int. The first is to use snprintf()
      // per the documentation at https://cplusplus.com/reference/cstdio/snprintf/
      // snprintf() takes four arguments
      // * s
      //        A pointer to a buffer where the resulting c-string is stored.
      //        The buffer should have a size of at least n characters.
      // * n
      //        Max number of bytes to be used in the buffer. The generated string has a 
      //        length of at most n-1, leaving space for the additional terminating null
      //        character.
      // * format
      //        The format string. Similar to the first argument of printf()
      // 
      //
      // Return Value:
      //        The number of characters that would have been printed if n had been sufficiently
      //        large enough, not counting the terminating null character. If an encoding error
      //        occurs, a negative number is returned.
      //
      // If you pass NULL as the first argument then the results are not stored in any buffer.
      // If you pass 0 as the second argument then no charcters will be written to the first argument.
      // Passing these two arguments together allows use to ignore the primary function of 
      // snprintf() to just find the number of characters in an int via the return value.
      return snprintf(NULL, 0, "%d", num);

      // The second way to find the number of digits is to use logarithms.
      // To determine the number of digits in an integer using logarithms, we can use log10().
      // For example, consider log10(123) = 2.089. The whole part of this result is 2 and 
      // corresponds to the largest exponent of the positional value of the most significant
      // digit in the number. For 123, the most significant digit 1 is in the hundreds place,
      // representing 1*10^2
      // 
      // Since the number of digits is one more than this exponent, the formula to find the 
      // number of digits in a number is:
      //
      // number of digits = floor(log10(num)) + 1
      //
      // return floor(log190(num)) + 1;
    }

    // Should take an int of unknown base.
    void int_to_str(int n, int d, char* num){
      snprintf(num, d+1, "%d", n);
    }

    void display(){
      printf("Display():\n\tnum: %s\n", num);
    }
};
int main(int argc, char** argv){
  base_converter num1 = base_converter(12345, 7);
  base_converter m = base_converter(argv[1], argv[2]);
}
