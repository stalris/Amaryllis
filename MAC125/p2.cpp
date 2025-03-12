#include <iostream>
#include <string>
#include <vector>
#include <exception>

using namespace std;

struct Product{
  string name;
  double price;
  bool inStock;

  Product(string name, double price, bool inStock) : name(name), price(price), inStock(inStock){}

  public:
    void display(){
      cout << "Product information:" << endl;
      cout << "name: " << name << endl;
      cout << "price: " << price << endl;
      cout << "inStock: " << ((inStock) ? "True" : "False") << endl;
    }
};

class ShoppingCart {
  private:
    string owner;
    vector<Product*> v;
  public:
    ShoppingCart(string owner) :  owner(owner), v(vector<Product*> {}){}
    const string& get_owner(){
      return owner;
    }
    void set_owner(string owner){
      this->owner = owner;
    }
    void addProduct(Product* p){
      v.push_back(p);
    }
};

int main(void){
  return 0;
}
