#include <iostream>

using namespace std;

void insert(int x, int* &nums, int &length, int &capacity);
int* resize(int* nums, int &capacity);
void print_nums(int* nums, int length);

int main(void){
  // create arrays dynamically incase it needs to be resized (when resizing delete old array, but can't delete a static array)
  int length = 6;
  int capacity = length;
  int* nums = new int[length]{1, 2, 4, 6, 9, 10};
  int x = 11;

  print_nums(nums, length);
  insert(x, nums, length, capacity);
  print_nums(nums, length);
  delete[] nums;
  return 0;
}

int* resize(int* nums, int &capacity){
  // create a new array that is twice the size of the old one.
  int* new_array = new int[capacity*2];
  for(int i = 0; i < capacity; i++){
    new_array[i] = nums[i];
  }
  capacity *= 2;

  delete[] nums;
  return new_array;
}

void insert(int x, int* &nums, int &length, int &capacity){
  if(length == capacity)
    nums = resize(nums, capacity);

  for(int i = length-1; i >= 0; i--){
    if(nums[i] < x){
      nums[i+1] = x;
      break;
    }else{
      nums[i+1] = nums[i];
    }
  }

  length++;

}

void print_nums(int* nums, int length){
  for(int i = 0; i < length; i++){
    printf("nums[%d]: %d\n", i, nums[i]);
  }
  printf("\n");
}
