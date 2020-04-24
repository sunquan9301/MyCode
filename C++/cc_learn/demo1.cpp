#include <fstream>
#include <iostream>
#include <string>

using namespace std;

const int size = 7;
struct superhero
{
    char *name;
    int age;
};
void sortS(superhero a[]);
int main()
{
    superhero a[] = {{"Superman", 1000}, {"Batman", 40}, {"Pokemon", 5}, {"Mickey", 60}, {"Super Mario", 45}, {"Harry Potter", 17}, {"Ninja", 600}};
    sortS(a);
    return 0;
}

void sortS(superhero a[])
{
    int press = 1;
    cout << "Press 1 to sort by name or press 2 to sort by age:";
    cin >> press;
    int length = sizeof(a) / sizeof(a[0]);
    if (press == 1)
    {
        for (int i = 0; i < length; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < length; j++)
            {
                if (a[j].name < a[minIndex].name)
                    minIndex = j;
            }
            if (minIndex != i)
            {
                superhero change = {};
                change = a[i];
                a[i] = a[minIndex];
                a[minIndex] = change;
            }
        }
    }
    else if (press == 2)
    {
        for (int i = 0; i < length; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < length; j++)
            {
                if (a[j].age < a[minIndex].age)
                    minIndex = j;
            }
            if (minIndex != i)
            {
                superhero change = {};
                change = a[i];
                a[i] = a[minIndex];
                a[minIndex] = change;
            }
        }
    }
    else
    {
        cout << "Please input correct num";
    }
}
