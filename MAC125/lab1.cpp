#include <iostream>
#include <string>

using namespace std;

struct Employee {
  string name;
  int id;
  float salary;
};

void updateSalary(Employee &emp, float percentage);
void displayEmployee(const Employee &emp);

int main(void){
  Employee emp1 = {"John Doe", 1001, 50000};
  Employee emp2 = {"Jane Smith", 1002, 60000};

  cout << "Before salary update: " << endl;
  displayEmployee(emp1);
  displayEmployee(emp2);

  updateSalary(emp1, 10); 
  updateSalary(emp2, 5);

  cout << "\nAfter Salary update: " << endl;
  displayEmployee(emp1);
  displayEmployee(emp2);

  return 0;
}
