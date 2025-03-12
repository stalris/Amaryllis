#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main(void){
  fstream f("ditto.txt");
  if(f.is_open()){
    cout << "Open" << endl;
    string s;
    while(getline(f, s)){
      cout << s << endl;
    }
    f.close();
  }else
    cerr << "errors" << endl;
  return 0;
}

