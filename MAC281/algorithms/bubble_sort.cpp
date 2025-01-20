// Implementation of bubble sort.
#include <stdio.h>

void bubble_sort(int nums[], int length);

int main(void){
  printf("앙영 지에\n");
   int nums[] = {50, 40, 30, 20, 10, 0};
   int length = sizeof(nums) / sizeof(nums[0]);
   bubble_sort(nums, length);
   for(int i = 0; i < length; i++){
     printf("i: %d\nnums[%d}: %d\n", i, i, nums[i]);
   }
  return 0;
}

void bubble_sort(int nums[], int length){
  for(int i = 0; i < length; i++){
    // on each iteration, compare the element at index j with the next element at index j+1.
    for(int j = 0; j < length - i - 1; j++){
      // if the element at j is greater than at j+1, then swap.
      if(nums[j+1] < nums[j]){
        int temp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = temp;
      }
    }
  }
}
