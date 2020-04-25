#include "util.h"
#include <vector>
#include<iostream>
#include<string>
#include<sstream>
using namespace std;

bool Util::startWith(const string &str, const string &head)
{
    return str.compare(0, head.size(), head) == 0;
}

string Util::itos(int i)
{
    stringstream s;
    s << i;
    return s.str();
}
bool Util::endWith(const string &str, const string &tail)
{
    return str.compare(str.size() - tail.size(), tail.size(), tail) == 0;
}

void Util::split(const string &strtem, const char a, vector<string> &res)
{
    res.clear();
    string::size_type pos1, pos2;
    pos2 = strtem.find(a);
    pos1 = 0;
    while (string::npos != pos2)
    {
        res.push_back(strtem.substr(pos1, pos2 - pos1));
        pos1 = pos2 + 1;
        pos2 = strtem.find(a, pos1);
    }
    res.push_back(strtem.substr(pos1));
}