#include <iostream>
#include <string>
#include <fstream>
#include <sys/stat.h>

using namespace std;
bool check_file(const fstream& f);
long fSize(const string& f);
void create_f(string name);

int main(void){
  string name = "test.txt";
  fstream f(name);
  if(check_file(f))
    cout << "Does the file exist?: " << ((check_file(f)) ? "Yes" : "No" ) << endl;
  else
    create_f(name);
  cout << "Size of file: " << fSize(name) << endl;


  return 0;
}

bool check_file(const fstream& f){
  return f.good();
}

long fSize(const string& f){
  struct stat fstat;
  if(stat(f.c_str(), &fstat) == 0)
    return fstat.st_size;
  return -1;
}

void create_f(string name){
  fstream f(name);
  if(f.is_open()){
    cout << "File exists" << endl;
    f.close();
    return; 
  }else{
    ofstream f2(name);
    if(f2.is_open())
      cout << "created file in create_f()" << endl;
    else
      cerr << "cerr: couldn't create file in create_f()" << endl;
  }
  f.close();
}
