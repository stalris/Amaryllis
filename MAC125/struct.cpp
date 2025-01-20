#include <iostream>
#include <string>

using namespace std;

class class_1{
  public:
    int num;
    string name;

    class_1(int n, string s){
      num = n;
      name = s;
    }
};


int main(void){
  printf("안녕 지혜\n");
  class_1 c1(5, "hello");
  class_1* c2 = new class_1(5, "hello");
}

