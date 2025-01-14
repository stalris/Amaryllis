#include <stdio.h>

void insertion_sort(int nums[], int length);
int main(void){
  printf("안녕 지헤\n");
  int nums[] = {40, 30, 20, 10, 0};
  int length = sizeof(nums) / sizeof(nums[0]);
  insertion_sort(nums, length);
}

void insertion_sort(int nums[], int length){
  for(int i = 1; i < length; i++){
    printf("i: %d\n", i);
    for(int j = i-1; j >= 0; j--){
      printf("\tj: %d\n", nums[j]);
    }
    printf("\n");
  }
}
