#include <fstream>
#include <iostream>
#include <string>

using namespace std;

int main()
{
    int a = 'b';
}

void processGrade(double grades[10][10],int rows){
    
    for(int i=0;i<grades.length;i++){
        for(int j=0;j<10;j++){
            if(i%2 == 0) grades[i][j] = grades[i][j]*1.1;
            else grades[i][j] = grades[i][j] - 10;
        }
    }
}

point hexagon::getCenter(){
    double centerX = 0,centerY = 0;
    for(int i=0;i<6;i++){
        centerX = centerX+this.vertexes[i].getX();
        centerY = centerY+this.vertexes[i].getY();
    }
    return point(centerX/6,centerY/6)
}
char afterSpace(string str){
 for(int i=0;i<str.length();i++){
     if(str[i] ==' '&&i<str.length()-1) return str[i+1];
 }
 return ' ';
}