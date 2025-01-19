#include <iostream>
using namespace std;

int main(void){
  int nums[] = {1,2,3,4,5};
  int* ptr = nums;
  printf("%d\n", *(ptr + 1));
}
