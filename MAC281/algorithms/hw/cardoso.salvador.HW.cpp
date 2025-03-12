#include <iostream>
#include <string>
#include <chrono>

using namespace std;
using namespace std::chrono;

int fibonacci(int n);
int fibonacci_recursive(int n);

int main(void){
  printf("하나 둘 셋 넷\n");
  int n = 42;
  time_point<high_resolution_clock> start;
  time_point<high_resolution_clock> end;
  duration<double> d;

  // Time the iterative version of fibonacci.
  start = high_resolution_clock::now();
  cout << "\nFibonacci of " << n << " : " << fibonacci(n) << endl;
  end= high_resolution_clock::now();
  d = end - start;
  cout << "Time to run iterative Fibonacci: " << d.count() << " seconds\n\n";

  // Time to run recursive fibonacci with different n.
  for(int n = 39; n <= 42; n++){
    start = high_resolution_clock::now();
    cout << "\nrecursive Fibonacci of " << n << " : " << fibonacci_recursive(n) << endl;
    end= high_resolution_clock::now();
    d = end - start;
    cout << "Time to run recursive Fibonacci: " << d.count() << " seconds\n\n";
  }
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
  return fibonacci_recursive(n-1) + fibonacci_recursive(n-2);
}
