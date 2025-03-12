// 2 types of polymorphism
// compile-time poly:
//  function overloading
//  operator overloading
// run-time poly
//  virtual function
//  inheritance

#include <iostream>
#include <string>

using namespace std;

class number_wrapper{
  private:
    int num;

  public:

    number_wrapper(int n){
      num = n;
    }

    int operator+(number_wrapper num){
      return num.num + this->num;
    }

    string operator-(number_wrapper num){
      return "thought you'd be subtracting numbers, didn't you?";
    }
};

class parent_class{
  public:
    parent_class() {}

    // can be overriden.
    virtual void sayHello(){
      printf("안녕\n");
    }

    void sayGoodbye(){
      printf("안녕히 가네요\n");
    }
};

class child_class : public parent_class{
  public:
    child_class() = default;

    void sayHello() override {
      cout << "Say hello\n";
    }

    void sayGoodbye(){
      cout << "Say goodbye\n";
  }

};

int main(void){
  number_wrapper n1(5);
  number_wrapper n2(6);
  cout << n1 + n2 << endl;
  cout << n1 - n2 << endl;
  
  parent_class* p = new parent_class();
  child_class c;
  child_class* c2 = new child_class();

  p->sayHello();
  c.sayHello();
  c2->sayHello();

  p->sayGoodbye();
  c.sayGoodbye();
  c2->sayGoodbye();

  delete p;
  return 0;
}
