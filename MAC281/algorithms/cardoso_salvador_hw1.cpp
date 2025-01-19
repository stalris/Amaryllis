// iterative version of binary search, per homework spec.
#include <stdio.h>

int binary_search(int x, int nums[], int i, int j);

int main(void){
  printf("앙영 지헤\n");
  int nums[] = {10};
  int n = sizeof(nums) / sizeof(nums[0]);
  int x = 20;
  int location = binary_search(x, nums, 0, n-1);
  printf("location of %d within nums[]: %d\n", x, location);

}

int binary_search(int x, int nums[], int i, int j){
  while (i < j){
    int m = (i + j) / 2;
    if(x > nums[m])
      i = m + 1;
    else
      j = m;
  }

  int location;
  if(x == nums[i])
    location = i;
  else
    location = -1;

  return location;
}
