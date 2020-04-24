#include <stdio.h>
#include <fstream>
#include <iostream>
using namespace std;
class Util
{
public:
    static void closeStream();
    static bool endWith(const string &str, const string &tail);
    static bool startWith(const string &str, const string &head);
    static void split(const string &strtem, const char a, vector<string> &res);
};
