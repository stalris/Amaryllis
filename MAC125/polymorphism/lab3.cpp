#include <iostream>
#include <string>
#include <cmath>

using namespace std;

class calculator{

  public:
    int calculate(int num, int num2){
      return num + num2;
    }

    double calculate(double num, double num2){
      return num * num2;
    }

    double calculate(int num, int num2, int num3){
      return (num + num2 + num3) / 3;
    }

};

class shape{

  public:
    virtual double area(){

    }
};

class circle : public shape{
  private:
    double radius;
  public:
    circle(double radius) : radius(radius){}
    double area() override {
      return M_PI * radius * radius;
    }
};

class rectangle : public shape{
  private:
    double length;
    double width;
  public:
    rectangle(double length, double width) : length(length), width(width){}
    double area() override{
      return length * width;
    }
};

int main(void){

  printf("안녕 하세요\n");
  calculator c;
  cout << "Adding 5 and 4: " << c.calculate(5,4) << endl;
  cout << "multiplying 5.5 and 4.9: " << c.calculate(5.5,4.9) << endl;
  cout << "average of 5,6, and 7: " << c.calculate(5,6,7) << endl;

  shape* shapeptr1;
  shape* shapeptr2;

  rectangle r(4,5);
  circle cir(10);

  shapeptr1 = &r;
  shapeptr2 = &cir;

  cout << "Area of rectangle: " << shapeptr1->area() << endl;
  cout << "Area of circle: " << shapeptr2->area() << endl;
  return 0;
}
