#include <iostream>
#include <string>

using namespace std;

int fibonacci(int n);

int main(void){

  int n = 5;
  return 0;
}

int fibonacci(int n){
  if (n == 0)
    return 0;
  if (n == 1)
    return 1;

  int a = 0;
  int b = 1; 
  int result;

  for(int i = 2; i <= n; i++){
    result = a+b;
  }

}
