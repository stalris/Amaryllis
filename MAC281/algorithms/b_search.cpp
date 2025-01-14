#include <iostream>

using namespace std;

int binary_search(int target, int nums[], int length);

int main(void){
  int nums[] = {0,10,20,30,40,60};
  cout << "안녕 지혜" << endl;
  int length = sizeof(nums) / sizeof(nums[0]);
  int target = 60;
  int index = binary_search(target, nums, length);
  cout << "index of " << target << ": " << index << endl;
}

int binary_search(int target, int nums[], int length){
  int i = 0;
  int j = length - 1;
  int middle;
  while(i < j){
    middle = (i + j) / 2;
    if(target > nums[middle])
      i = middle + 1;
    else
      j = middle;
  }
  if(target == nums[i])
    return i;
  else
    return -1;
}
