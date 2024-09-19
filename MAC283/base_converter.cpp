#include <stdio.h>
//#include <iostream>
class base_converter{
  private :
    // the number, its base, and its value in base 10.
    int base;
    int num;
    int num_10;

  public :

      // defaults to 0 in base 10
      base_converter(){
        this->base = 10;
        this->num = 0;
      };
  
      base_converter(int num, int base){
        this->num = num;
        this->base = base;
        convert_to(10);
      }

      // Convert num into base 'base'
      void convert_to(int base){
        int num = this->num_10;
        int positional_value = 0;
        for(int i = 0, temp = 0; num > 0; num = num / 10){
          if(num > 0 && i = 0){
            temp = 1;
          }else{
            for(int j = 0; j < i; j++){
              positional_value *= positional_value;
            }
            temp += (num % 10) * positional_value;
          }
          temp = num % base;
        }
      }

      void display(){
        printf("Number: %d\nBase: %d\n",this->num,this->base);
      }
};

int main(void){
  printf("안녕\n");
  //std::cout << "hello" << std::endl;
  base_converter num(5, 10);
  num.display();
  num.convert_to(5);
  num.display();
  return 0;
}
