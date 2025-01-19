#include <iostream>
#include <string>

using namespace std;

struct Employee {
  string name;
  int id;
  float salary;
  string department;
  int yearsOfExperience;
};

void updateSalary(Employee* emp, float percentage);
void displayEmployee(const Employee* emp);
float calculateBonus(const Employee* emp);

int main(void){
  // Employee emp1 = {"John Doe", 1001, 50000, "Computer Science", 10};
  //Employee emp2 = {"Jane Smith", 1002, 60000, "Accounting", 9};
  
  Employee* emp1 = new Employee{"Salvador Cardoso", 1003, 50000, "Computer Science", 1};
  Employee* emp2 = new Employee{"지혜 정", 1004, 60000, "Computer Science", 2};
  Employee* emp3 = new Employee{"Alana", 1005, 60000, "Computer Science", 1};
  
  cout << "Before Salary update: " << endl <<endl;
  displayEmployee(emp1);
  cout << endl;
  displayEmployee(emp2);
  cout << endl;
  displayEmployee(emp3);
  cout << endl;

  updateSalary(emp1, 10);
  updateSalary(emp2, 5);
  updateSalary(emp3, 20);

  cout << "\n\nAfter Salary update: " << endl << endl;
  displayEmployee(emp1);
  cout << endl;
  displayEmployee(emp2);
  cout << endl;
  displayEmployee(emp3);
  cout << endl;

  // Prints bonuses for employees at 5% of their salary * their years of experience.
  cout << "\nBonus for: " << (*emp1).name << "\n\tbonus: " << calculateBonus(emp1) << endl;
  cout << "\nBonus for: " << (*emp2).name << "\n\tbonus: " << calculateBonus(emp2) << endl;
  cout << "\nBonus for: " << (*emp3).name << "\n\tbonus: " << calculateBonus(emp3) << endl;

  delete(emp1);
  delete(emp2);
  delete(emp3);
  
  return 0;
}

void updateSalary (Employee* emp, float percentage){
  (*emp).salary += (*emp).salary * (percentage / 100);
}

void displayEmployee (const Employee* emp){
  cout << "Employee ID: " << (*emp).id << endl;
  cout << "Name: " << (*emp).name << endl;
  cout << "Salary: $" << (*emp).salary << endl;
  cout << "Department: " << (*emp).department <<endl;;
  cout << "Years of Experience: " << (*emp).yearsOfExperience <<endl;
}

float calculateBonus(const Employee* emp){
  return (*emp).yearsOfExperience * (*emp).salary * .05;
}


