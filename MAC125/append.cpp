#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main(void){
  fstream f("ditto.txt", ios::app);
  if(f.is_open()){
    f << "기다렸지 all this time" << endl;
    f.close();
  }else
    cerr << "errors" << endl;
  return 0;
}
