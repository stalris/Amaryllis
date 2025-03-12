#include <iostream>
#include <string>
#include <thread>

using namespace std;

void thread1();
void thread2();

int main(void){
  thread t1(thread1);
  thread t2(thread2);

  t1.join();
  t2.join();
  return 0;
}

void thread1(){
  cout << "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" << endl;
}

void thread2(){
  cout << "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ" << endl;
}
