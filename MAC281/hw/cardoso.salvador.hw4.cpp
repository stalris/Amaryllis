#include <iostream>
using namespace std;
bool isReflexive(int a[][4]);
bool isSymmetric(int a[][4]);
bool isAntiSymmetric(int a[][4]);
int main()
{
int myArray[4][4] = {{1, 0, 0, 1},
 {1, 1, 0, 1},
 {0, 1, 1, 0},
 {1, 0, 0, 1}};
cout << "The given matrix is: " << endl;
if(isReflexive(myArray)) cout << "reflexive" << endl;
else cout << "not reflexive" << endl;
if(isSymmetric(myArray)) cout << "symmetric" << endl;
else cout << "not symmetric" << endl;
if(isAntiSymmetric(myArray)) cout << "antisymmetric" << endl;
else cout << "not antisymmetric" << endl;
return 0;
} // end main
bool isReflexive(int a[][4])
{
	for(int i = 0; i < 4; i++){
    if(a[i][i] != 1)
      return false;
	}
  return true;
}
bool isSymmetric(int a[][4])
{
  for(int i = 0; i < 4; i++){
    for(int j = 0; j < 4; j++){
      if(a[i][j] != a[j][i] && i != j)
        return false;
    }
  }
  return true;
}
bool isAntiSymmetric(int a[][4])
{
  for(int i = 0; i < 4; i++){
    for(int j = 0; j < 4; j++){
      if(a[i][j] == 1 && a[j][i] == 1 && i != j)
        return false;
    }
  }
  return true;
}

