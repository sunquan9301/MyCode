#include <fstream>
#include <iostream>
#include <string>

using namespace std;

// void sumByValue(int x,int y){
//     cout<<"Pass by value: "<<(x+y)<<end;
// }
// void sumByReference(int &x,int &y, int &sum){
//     sum = x+y;
//     cout<<"Pass by reference: "<<sum<<endl;
// }
void sumByPointer(int *x, int *y, int *sum){
    *sum = *x+*y;
    cout<<"Pass by pointer: "<<sum<<endl;
}


int main()
{   
    int x = 5,y = 3,sum =0;
    sumByPointer(x,y,&sum);
}
