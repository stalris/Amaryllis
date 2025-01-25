#include <iostream>
#include <string>

using namespace std;

int fibonacci(int n);
int fibonacci_recursive(int n);

int main(void){
  printf("하나 둘 셋 넷\n");
  int n = 7;
  cout << "Fibonacci of " << n << " : " << fibonacci(n)<<endl;
  cout << "Recursive Fibonacci of " << n << " : " << fibonacci_recursive(n) << endl;
}

// iterative version of fibonacci.
int fibonacci(int n){
  if (n == 0)
    return 0;
  if (n == 1)
    return 1;

  // f(n) = f(n-1) + f(n-2)
  // f is used to represent f(n-1) within the expression
  // and the sum is stored back into f
  //
  // f = f + f_2
  // 
  // represents the fibonacci of n, provided that f_2 is updated correctly.
  int f_2 = 0;
  int f = 1; 
  int temp; // 
  for(int i = 2; i <= n; i++){
    temp = f;
    f = f + f_2;
    f_2 = temp;
  }
  return f;
}

// recursive version
int fibonacci_recursive(int n){
  if (n == 0)
    return 0;
  if (n == 1)
    return 1;
  return fibonacci(n-1) + fibonacci(n-2);
}
