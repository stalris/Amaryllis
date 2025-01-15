#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

string base_converter(int num, int base, int new_base);

int main(void){
  printf("감사합니다\n");
  cout << base_converter(161, 10, 11) << endl;
}

string base_converter(int num, int base, int new_base){
  string digits = "0123456789ABCDEF";
  if(new_base < 2 || new_base > 16)
    return "Invalid new_base: " + to_string(new_base) + "\nChoose a base between 2-16\n";
  int q = num;
  int k = 0;
  string new_num = "";

  while (q != 0){
    new_num += digits[q % new_base];
    q = q / new_base;
  }
  reverse(new_num.begin(), new_num.end());
  return new_num;
} 
