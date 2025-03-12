#include <iostream>
#include <string>
#include <vector>
#include <stdexcept>

using namespace std;

template <typename t>
class max_heap{
  private:
    vector<t> heap;

  public:
    int get_parent_index(int index){
      return (index-1) / 2;
    }
    int get_left_child_index(int index){
      return 2*index + 1;
    }
    int get_right_child_index(int index){
      return 2*index + 2;
    }
    bool is_valid_index(int index){
      return index < heap.size();
    }

    bool is_Empty(){
      return heap.empty();
    }
    int size(){
      return heap.size();
    }

    t top(){
      if(heap.empty())
        throw out_of_range("Heap is empty");
      return heap[0];
    }

    void push(t element){
      // add element to the end of the heap/vector.
      heap.push_back(element);
      // ensure new element respects heap properties.
      // pass the index of the new element.
      heapify_up(heap.size() - 1);
    }

    void heapify_up(int child_index){
      int parent_index = get_parent_index(child_index);
      t temp;
      while(child_index > 0){
        // is heap property violated?
        if(heap[child_index] > heap[parent_index]){
          // swap
          temp = heap[child_index];
          heap[child_index] = heap[parent_index];
          heap[parent_index] = temp;
        }else
          return; // property is not violated within the three.

        // adjust indices.
        child_index = parent_index;
        parent_index = get_parent_index(parent_index);
      }
    }

    // ensure heap property is not violated.
    void heapify_down(){
      if(heap.empty())
        return;
      // buncha stuff I need.
      int parent_index = 0;
      int left_child_index; 
      int right_child_index;
      int greatest_child_index;
      bool left_child_exists; 
      bool right_child_exists;
      t temp; // used for swapping.

      // Loop will return once the heap property is not violated.
      while(true){
        left_child_index = get_left_child_index(parent_index);
        right_child_index = get_right_child_index(parent_index);
        left_child_exists = is_valid_index(left_child_index);
        right_child_exists = is_valid_index(right_child_index);

        // if the parent has no children then no violation can occur.
        if(!left_child_exists && !right_child_exists)
          return;
        // if at least one child exists, check which one is the biggest.
        if(left_child_exists && right_child_exists)
          greatest_child_index = ( heap[left_child_index] > heap[right_child_index]) ? left_child_index : right_child_index;
        else if(left_child_exists)
          greatest_child_index = left_child_index;
        else
          greatest_child_index = right_child_index;
        // compare parent with child.
        if(heap[parent_index] < heap[greatest_child_index]){
          // swap if heap property is violated.
          temp = heap[parent_index];
          heap[parent_index] = heap[greatest_child_index];
          heap[greatest_child_index] = temp;
        }else
          return; // if parent/child relationship doesn't violate heap then return.
        // update parent index for the next loop.
        parent_index = greatest_child_index;                 
      }
    }

    t pop(){
      if(heap.empty())
        throw out_of_range("Heap is empty\n");
      // grab the largest element. 
      t top = heap[0];

      // swap root with last element.
      int last_index = heap.size() - 1;
      t temp = heap[last_index];
      heap[last_index] = heap[0];
      heap[0] = temp;
      // remove the previous root.
      heap.pop_back();

      // ensure the root does not violate the heap property
      heapify_down();
      // return original root.
      return top;
    }
};

int main(void){

  max_heap<int> h;
  h.push(50);
  h.push(30);
  h.push(40);
  h.push(10);
  h.push(20);
  h.push(35);
  h.push(37);

  h.pop(); cout << h.top() << endl;
  h.pop(); cout << h.top() << endl;
  return 0;
}
