#include <iostream>
#include <string>
#include <fstream>



using namespace std;

int main(void){
  printf("고양이\n");
  ofstream f("ditto.txt");

  if(f.is_open()){
    printf("Opened file\n");
   f << endl;
    f << "Stay in the middle" << endl;
    f << "Like you a little" << endl;
    f << "Don't want no riddle" << endl;
    f << "말해줘, say it back" << endl;
    f << "Oh say it ditto" << endl;
    f << "I want you so, want you so say it ditto" << endl;
    f << "훌쩍 커버렸어" << endl;
    f << "함께한 기억 철엄" << endl;
    f << "널보는 내 마음은" << endl;
    f << "은느새 여름 지나 가을" << endl;
    f << "기다 렸지 all this time..." << endl;
    f << endl;
    f.close();
    cout << "고영이" << endl;
  }else
    cerr << "errors" << endl;
  return 0;
}
