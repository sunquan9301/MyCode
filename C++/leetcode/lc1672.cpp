#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int maximumWealth(vector< vector<int> > &accounts)
    {
        int max =0;
        int length = accounts[0].size();
        for (int i = 0; i < accounts.size(); i++)
        {
            int temp = accounts[i][0];
            for (int j = 1; j < length; j++)
                temp += accounts[i][j];
            max = max > temp ? max : temp;
        }
        return max;
    }
};