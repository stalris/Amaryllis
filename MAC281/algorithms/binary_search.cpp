#include <stdio.h>

int binary_search(int nums[], int left, int right, int target);

int main(void){
  printf("앙영 지헤\n");
  int nums[] = {10,11};
  int length = sizeof(nums) / sizeof(nums[0]);
  int index = binary_search(nums, 0, length-1, 12);
  printf("index: %d\n", index);
  return 0;
}

int binary_search(int nums[], int left, int right, int target){
  printf("하나\n");
  int middle = (left + right) / 2;
  printf("\tleft: %d\n", left);
  printf("\tright: %d\n", right);
  printf("\tmiddle: %d\n", middle);
  printf("\ttarget: %d\n", target);
  printf("\tnums[%d]: %d\n", middle, nums[middle]);
  if(target == nums[middle])
    return middle;
  // if the boundaries are the same and the number isn't found, then it doesn't exist in the array.
  else if(left == right){
    return -1;
  }
  // target is in the right subarray.
  else if(nums[middle] < target){
    printf("old left: %d\n", left);
    left = middle + 1;
    printf("new left: %d\n", left);
    return binary_search(nums, left, right, target);
  }
  // target is in left subarray.
  else{
    printf("old right: %d\n", right);
    right = middle - 1;
    printf("new right: %d\n", right);
    return binary_search(nums, left, right, target);
  }
  
}
