#include <iostream>
#include <string>
#include <thread>
#include <fstream>
#include <sstream>
#include <vector>
#include <exception>
#include <unordered_map>

using namespace std;

// exceptions
class invalidInputException : public exception{
  private:
    string e;

  public:
    invalidInputException(string e) : e(e){}

    const char* what() const noexcept override {
      return e.c_str();
    }

};

class FileIOException : public exception{
  private:
    string e;
  public:
    FileIOException(string e) : e(e){}
    const char* what() const noexcept override{
      return e.c_str();
    }
};


// Structure to hold employee details.
struct employeeData {
  int employeeID;
  string employeeName;
  string employeePosition;
  double employeeSalary;
  string employeeDepartment;

  // constructor for an individual employee.
  employeeData(int employeeID, string employeeName, string employeePosition, double employeeSalary, string employeeDepartment) : 
    employeeID(employeeID), employeeName(employeeName), employeePosition(employeePosition), employeeSalary(employeeSalary), employeeDepartment(employeeDepartment){}

  // Conver this data into json.
  string toJSON();
};
// Convert each employee's information into JSON.
string employeeData::toJSON(){
  string s = "\t{\n";
  s += "\t\t\"employeeID\": " + to_string(this->employeeID) + ",\n";
  s += "\t\t\"employeeName\": \"" + this->employeeName + "\",\n";
  s += "\t\t\"employeePosition\": \"" + this->employeePosition + "\",\n";
  s += "\t\t\"employeeSalary\": " + to_string(this->employeeSalary) + ",\n";
  s += "\t\t\"employeeDepartment\": \"" + this->employeeDepartment + "\"\n";
  s += "\t}";
  return s;
}

// Base class for employee management.
class Employee{
  protected:
    // Employee's information.
    int employeeID;
    string employeeName;
    string employeePosition;
    double employeeSalary;
    string employeeDepartment;

    // container for employees. Shared among all employees.
    static vector<employeeData*> employeeList;
    // Keeps track of how many employees are made, so the destructor is only called after the last is destroyed.
    static int employeeCount;

  public:

    // Constructors.
    Employee();
    Employee(int employeeID, string employeeName, string employeePosition, double employeeSalary, string employeeDepartment);
    ~Employee();

    // function prototypes / declarations.
    bool empty(); // check if there is at least one employee.
    void addEmployee(int employeeID, string employeeName, string employeePosition, double employeeSalary, string employeeDepartment);
    void updateEmployee(int id, string attribute, string newValue);
    void deleteEmployee(int id); // remove an employee from the vector and free its resources.
    vector<employeeData*>::iterator getEmployeeByID(int id); // Grab an employee's details, if they exist.
    void displayAllEmployees();
    virtual void displayDetails();
    void saveToFile(string& f);
    void loadFromFile(string& f);
    void validateInput(string attribute, string input);
    string toJSON();
    friend void printEmployeeThread(Employee* e, int id); // Used to print a single employee's information in a thread.
};

// Method definitions for Employee

vector<employeeData*> Employee::employeeList = {};
int Employee::employeeCount = 0;

// default constructor.
Employee::Employee(){}
// Constructor. Store this person's information in this object and also push it onto the employeeList.
Employee::Employee(int employeeID, string employeeName, string employeePosition, double employeeSalary, string employeeDepartment) : 
employeeID(employeeID), employeeName(employeeName), employeePosition(employeePosition), employeeSalary(employeeSalary), employeeDepartment(employeeDepartment){
  employeeData* e = new employeeData(employeeID, employeeName, employeePosition, employeeSalary, employeeDepartment);
  employeeList.push_back(e);
  employeeCount++;
}
// destructor.
Employee::~Employee(){
  --employeeCount;

  // Free all resources once the last employee is deleted.
  if(employeeCount == 0){
    for(auto head = employeeList.begin(), tail = employeeList.end(); head != tail; ++head){
      delete (*head);
    }
    employeeList.clear();
  }
}
// check if the vector is empty.
bool Employee::empty(){
  return employeeList.empty();
}

// Add a new employee to the employeeList vector.
void Employee::addEmployee(int employeeID, string employeeName, string employeePosition, double employeeSalary, string employeeDepartment){
  // create a new employeeData object on the heap and add it to employeeList.
  employeeData* e = new employeeData(employeeID, employeeName, employeePosition, employeeSalary, employeeDepartment);
  employeeList.push_back(e);
}

// update an employee's details. Propogates exceptions.
void Employee::updateEmployee(int id, string attribute, string input){
  vector<employeeData*>::iterator i = Employee::getEmployeeByID(id);

  // some basic error checking.
  if(i == employeeList.end()){
    string s = "Employee with id: " + to_string(id) + " does not exist.";
    throw invalidInputException(s);
  }

  // check if attribute or input are valid. Propogates any errors.
  validateInput(attribute, input);   

  // assign new value to attribute.
  if(attribute == "employeeID"){ // new id
    int newID = stoi(input);
    (*i)->employeeID = newID;
  }else if(attribute == "employeeName") // new name
    (*i)->employeeName = input;
  else if(attribute == "employeePosition") // new position
    (*i)->employeePosition = input;
  else if(attribute == "employeeSalary"){ // new salary
    double newSalary = stod(input);
    (*i)->employeeSalary = newSalary;
  }else if(attribute == "employeeDepartment") // new department
    (*i)->employeeDepartment = input;
  else // attribute doesn't exist.
    throw invalidInputException("Invalid input. Attribute does not exist: " + input);
}

// remove an employee using their id.
void Employee::deleteEmployee(int id){
  vector<employeeData*>::iterator i = Employee::getEmployeeByID(id);
  // check if the iterator is exhausted.
  if(i != employeeList.end()){
    // free the object since it was initially allocated on the heap.
    delete(*i);
    employeeList.erase(i);
  }
}

// grab the employee with the given id, returns the iterator that starts at said employee or NULL if dne.
vector<employeeData*>::iterator Employee::getEmployeeByID(int id){
  // loop through the employeeList vector using an iterator.
  for(auto head = employeeList.begin(), tail = employeeList.end(); head != tail; ++head){
    // head is an iterator (pointer) to employeeData. Dereference it in order to access its attributes.
    if( (*head)->employeeID == id)
      return head;
  }
  return employeeList.end();
}

// print all employee details.
void Employee::displayAllEmployees(){

  cout << "Printing all employee details" << endl << endl;
  // no Employees.
  if(Employee::empty()){
    cout << "No employees in the system." << endl;
    return;
  }

  // use an iterator to loop through the employeeList vector.
  for(auto head = employeeList.begin(), tail = employeeList.end(); head != tail; ++head){
    cout << "Employee's name: " << (*head)->employeeName << endl;
    cout << "\tid: " << (*head)->employeeID << endl;
    cout << "\tPosition: " << (*head)->employeePosition<< endl;
    cout << "\tSalary: " << (*head)->employeeSalary<< endl;
    cout << "\tDepartment: " << (*head)->employeeDepartment << endl;
  }
  cout << "All employeeList have been printed" << endl << endl;
}

// print the employee's information.
void Employee::displayDetails(){

  // print their information.
  cout << "\nName: " << this->employeeName << endl;
  cout << "\tId: " << this->employeeID << endl;
  cout << "\tPosition: " << this->employeePosition << endl;
  cout << "\tSalary: " << this->employeeSalary << endl;
  cout << "\tDepartment: " << this->employeeDepartment << endl << endl;
}

// save Employees to a JSON file.
void Employee::saveToFile(string& f){
  fstream file(f, ios::out);
  if(file.is_open()){
    // build the json string.
    string s = "[\n";
    // write all objects as json.
    for(auto head = employeeList.begin(), tail = employeeList.end(); head != tail; ++head){
      s += (*head)->toJSON();
      s += ",\n";
    }
    // remove the trailing comma.
    int trailingComma = s.rfind(',');
    s = s.substr(0,trailingComma);
    s += "\n]";
    file << s;
    file.close();
  }else{
    string s = "Error: Could not open file: " + f;
    cerr << s << endl;
    throw FileIOException(s);
  }
}

// Read from a JSON file.
void Employee::loadFromFile(string& f){

  // Check if the file is open.
  fstream file(f, ios::in);
  if(!file.is_open())
    throw FileIOException("Error: Could not open file: " + f);

  // Validate JSON extension.
  int dotposition = f.rfind('.');
  // If '.' was found then extract the extension, otherwise assign an empty string.
  string extension = (dotposition != string::npos) ? f.substr(dotposition) : "";
  // check if the extension matches a json file.
  if(extension != ".json")
    throw FileIOException("Error: Not a JSON file: " + f);

  // Read entire json file into a string.
  ostringstream sstream;
  sstream << file.rdbuf();
  // Dump the string stream into the buffer string.
  string buffer = sstream.str();
  unordered_map<string, string> employee;

  string key = "";
  string value = "";
  bool key_ = false;
  bool value_ = false;
  // loop over buffer and extract each json object.
  for(int i = 0, j = buffer.length(); i < j; ++i){
    if(buffer[i] == '{') // beginning of an employee Object.
      employee.clear();
    else if(buffer[i] == '}'){ // finally found the end of the employee object.
      addEmployee(stoi(employee["employeeID"]), employee["employeeName"], employee["employeePosition"], stod(employee["employeeSalary"]), employee["employeeDepartment"]);
      // Check for the start of a key and if the key is empty.
      // Commas don't necessarily indicate a key, could also be a value of type string.
    }else if(buffer[i] == '\"' && key.empty()){
      key_ = true;
    }else if(buffer[i] == '\"' && key_){
      key_ = false;
    }else if(key_)
      key += buffer[i];
    else if(value.empty() && buffer[i] == ':') // start of a value
      value_ = true;
    else if(value_ && (buffer[i] == ',' || buffer[i] == '}' || buffer[i] == '\n')){ // end of the value.
      value_ = false;
      // add to map.
      employee[key] = value;
      // reset buffers;
      key = "";
      value = "";
    }else if(value_ && buffer[i] != ' ' && buffer[i] != '\"')
      value += buffer[i];
  }
}

// do some error-checking.
void Employee::validateInput(string attribute, string input){
  if(attribute == "")
    throw invalidInputException("Invalid input: Empty string provided for attribute");

  if(attribute == "employeeID"){
    // try/catch incase input can't be converted to int.
    try{
      int id = stoi(input);
      if(id < 0)
        throw invalidInputException("Invalid input: Negative id was provided. Only positive integer ids are accepted");
    }catch(invalid_argument& e){ // input was not a valid integer.
      string s = "Invalid input: Not a valid integer.";
      cerr << e.what() << endl;
      throw invalidInputException(s);
    }catch(out_of_range& e){ // input was too big to fit into an integer.
      string s = "Invalid input: Integer is out of range.";
      cerr << e.what() << endl;
      throw invalidInputException(s);
    }
  }
  // check if input is a valid salary.
  if(attribute == "employeeSalary"){
    try{
      double salary = stod(input);
      if(salary < 0)
        throw invalidInputException("Invalid input: Negative salary was provided. Only positive-number salaries are accepted");
    }catch(invalid_argument& e){
      string s = "Invalid input: Not a valid double.";
      cerr << e.what() << endl;
      throw invalidInputException(s);
    }catch(out_of_range& e){
      string s = "Invalid input: Double is out of range.";
      cerr << e.what() << endl;
      throw invalidInputException(s);
    }
  }
}


// Derived class for managers, inherits from Employee.
class Manager : public Employee{
  private:
    int teamSize; // Number of team members under a manager.
    string projectName; // Name of the project managed by this manager.

  public:
    // Method prototypes/declarations.
    Manager();
    Manager(int employeeID, string employeeName, string employeePosition, double employeeSalary, string employeeDepartment, int teamSize, string projectName);
    void displayDetails() override; // print details of this manager.
};

// Constructors.
Manager::Manager() : Employee() {}
Manager::Manager(int employeeID, string employeeName, string employeePosition, double employeeSalary, string employeeDepartment, int teamSize, string projectName) : 
  Employee(employeeID, employeeName, employeePosition, employeeSalary, employeeDepartment), teamSize(teamSize), projectName(projectName){};

// overrides employee's displayDetails().
void Manager::displayDetails(){
  // print the manager's information.
  cout << "Manager's Name: " << this->employeeName << endl;
  cout << "\tid: " << this->employeeID << endl;
  cout << "\tName: " << this->employeeName<< endl;
  cout << "\tPosition: " << this->employeePosition<< endl;
  cout << "\tSalary: " << this->employeeSalary<< endl;
  cout << "\tDepartment: " << this->employeeDepartment<< endl;
  cout << "\tteam size: " << this->teamSize << endl;
  cout << "\tProject Name: " << this->projectName << endl;
}

// threads
void addEmployeeThread(Employee* e, int employeeID, string employeeName, string employeePosition, double employeeSalary, string employeeDepartment){
  e->addEmployee(employeeID, employeeName, employeePosition, employeeSalary, employeeDepartment);   
}

void updateEmployeeThread(Employee* e, int id, string attribute, string input){
  e->updateEmployee(id, attribute, input);
}

void deleteEmployeeThread(Employee* e, int id){
  e->deleteEmployee(id);
}

void printEmployeeThread(Employee*e, int id){
  vector<employeeData*>::iterator i = e->getEmployeeByID(id);
  if(i == e->employeeList.end()){
    cerr << "Error: Employee with id: " << id << " does not exist" << endl;
    return;
  }
  cout << "Name: " << (*i)->employeeName << endl;
  cout << "ID: " << (*i)->employeeID << endl;
  cout << "Position: " << (*i)->employeePosition << endl;
  cout << "Salary: " << (*i)->employeeSalary << endl;
  cout << "Department: " << (*i)->employeeDepartment << endl;
}

int main(void){

  printf("훌쩍커버렸어\n");
  // create a new manager to either load from a file or start manually adding employees.
  Manager 지혀{};
  Employee* e = &지혀;
  bool isRunning = true;
  // exits when the quit option is entered.
  while(isRunning){

    // Program runs until you enter 0.
    int inputChoice;
    cout << "Options: " << endl;
    cout << "\t1: Load from file" << endl;
    cout << "\t2: save to a file" << endl;
    cout << "\t3: Display all employees" << endl;
    cout << "\t4: Add employee" << endl;
    cout << "\t5: Update employee information" << endl;
    cout << "\t6: Delete employee" << endl;
    cout << "\t7: Print employee information" << endl;
    cout << "\t0: quit" << endl;
    cin >> inputChoice;
    if(cin.fail()){
      cout << "invalid option: Not a number" << endl;
      cin.clear();
      cin.ignore(10000, '\n');
      continue;
    }
    try{
      switch(inputChoice){
        case 1:{ // load from a file
          string f;
          cout << "Loading from a file. Enter name of file: ";
          cin >> f;
          cout << "Loading from: " << f << endl;
          e->loadFromFile(f);
          break;
        }case 2:{ // save to a file
          string f;
          cout << "Saving from a file. Enter name of file: ";
          cin >> f;
          cout << "Saving to: " << f << endl;
          e->saveToFile(f);
          break;
        }case 3:{ // show all employees.
          e->displayAllEmployees();
          break;
        }case 4:{ // add a new employee.
          string employeeID, employeeName, employeePosition, employeeSalary, employeeDepartment;
          cout << "Adding new employee to the system" << endl;
          cout << "\tName: ";
          cin >> employeeName;
          e->validateInput("employeeName", employeeName);
          cout << "\tID: ";
          cin >> employeeID;
          e->validateInput("employeeID", employeeID);
          cout << "\tPosition: ";
          cin >> employeePosition;
          e->validateInput("employeePosition", employeePosition);
          cout << "\tSalary: ";
          cin >> employeeSalary;
          e->validateInput("employeeSalary", employeeSalary);
          cout << "\tDepartment: ";
          cin >> employeeDepartment;
          e->validateInput("employeeDepartment", employeeDepartment);
          // finally add the employee via the thread.
          thread t(addEmployeeThread, e, stoi(employeeID), employeeName, employeePosition, stod(employeeSalary), employeeDepartment);
          t.detach();
          break;
        }case 5:{ // update an employee's information.
          string employeeID, attribute, newValue;
          cout << "Updating employee information." << endl;
          cout << "Enter id of employee: ";
          cin >> employeeID;
          e->validateInput("employeeID", employeeID);
          cout << "Which field to update?: ";
          cin >> attribute;
          cout << "New value: ";
          cin >> newValue;
          thread t(updateEmployeeThread, e, stoi(employeeID), attribute, newValue);
          t.detach();
          break;
        }case 6:{ // delete an employee
          string employeeID;
          cout << "Removing employee from system. Employee id?: ";
          cin >> employeeID;
          e->validateInput("employeeID", employeeID);
          thread t(deleteEmployeeThread, e, stoi(employeeID));
          t.detach();
          break;
        }case 7:{ // print a single employee's information.
          string employeeID;
          cout << "Printing employee information. Employee id?: ";
          cin >> employeeID;
          e->validateInput("employeeID", employeeID);
          thread t(printEmployeeThread, e, stoi(employeeID));
          t.detach();
          break;
        }case 0:{
          isRunning = false;
          break;
        }
      }
    }catch(invalidInputException e){
      cerr << "Error: " << e.what() << endl;
    }catch(FileIOException e){
      cerr << "Error: " << e.what() << endl;
    }
  }
  // should have returned 0 in the loop.
  return 1;
}
