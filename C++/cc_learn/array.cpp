#include <iostream>
using namespace std;

int* reverse(const int* list, int size){
    int*p = new int(size);
    for(int i=0;i<size;i++){
        *(p+i) = *(list+size-i);
    }
    return p;
}
int main()
{
    int* p1,p2,p3;
    int arr[11] = {0,1,2,3,4,5,6,7,8,9};
    int * q = reverse(arr,11);
    for(int i=0;i<11;i++){
        cout<<*(q+i);
    }
}

