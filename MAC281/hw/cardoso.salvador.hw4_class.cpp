#include <iostream>
#include <string>
#include <vector>

using namespace std;

// tests Reflexivity, Symmetry, and antiSymmetry as methods.
class matrices{
  private:
    // turtles all the way down. (A vector of matrices).
    vector<vector<vector<int>>> m;
  public:
    void push_back(vector<vector<int>> m){
      this->m.push_back(m);
    } 

    // displays the i-th matrix.
    void displayMatrix(int i){
      vector<vector<int>> matrix = m[i];
  
      cout << "Matrix " << i + 1 << ": " << endl << endl;
      for(int i = 0, rows = matrix.size(); i < rows; i++){
  
        cout <<"\t";
        for(int j = 0, cols = matrix[i].size(); j < cols; j++){
          cout << matrix[i][j] << " " ;
        }
        cout << endl;
      }
      cout << endl;
    }

    // diagonals must all exist.
    bool isReflexive(vector<vector<int>> a){
      for(int i = 0, rows = a.size(); i < rows; i++){
        if(a[i][i] != 1)
          return false;
      }
      return true;
    }

    // [i][j] must equal [j][i] for any i != j (diagonal isn't taken into account)
    bool isSymmetric(vector<vector<int>> a){
      for(int i = 0, rows = a.size(); i < rows; i++){
        for(int j = 0, cols = a[i].size(); j < cols; j++){
          if(a[i][j] != a[j][i] && i != j)
            return false;
        }
      }
      return true;
    }

    // forces [i][j] & [j][i] to either both be 0 or at most one is equal to 1. (diagonal isn't taken into account)
    bool isAntiSymmetric(vector<vector<int>> a){
      for(int i = 0, rows = a.size(); i < rows; i++){
        for(int j = 0, cols = a[i].size(); j < cols; j++){
          if(a[i][j] == 1 && a[j][i] == 1 && i != j)
            return false;
        }
      }
      return true;
    }

    // Display the properties of all stored matrices.
    void test_all(){
      cout << "Testing all matrices for reflexivity, symmetry, and antisymmetry\n\n" ;
      for(int i = 0; i < m.size(); i++){
        displayMatrix(i);
        string b = isReflexive(m[i]) ? "True" : "False";
        cout << "\tReflexive?: " << b << endl;
        b = isSymmetric(m[i]) ? "True" : "False";
        cout << "\tSymmetric?: " << b << endl;
        b = isAntiSymmetric(m[i]) ? "True" : "False";
        cout << "\tAntiSymmetric?: " << b << endl << endl;
      }
      cout << endl;
    }
};

int main(void){
  printf("훌쩍 커버렸어\n");

  // Bunch of matrices. The output is makes it a bit easier to tell what properties they have.
  matrices m;
  m.push_back({ {1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1} }); // Reflexive, Symmetric, and antiSymmetric
  m.push_back({ {0, 1, 0, 0}, {1, 0, 1, 0}, {0, 1, 0, 1}, {0, 0, 1, 0} }); // Symmetric
  m.push_back({ {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 0} }); // AntiSymmetric
  m.push_back({ {1, 1, 0, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1} }); // Reflexive
  m.push_back({ {0, 1, 0, 0}, {1, 0, 1, 1}, {0, 1, 0, 0}, {1, 0, 1, 0} }); // None
  m.test_all();

  printf("상상만 으로난\n");
}
