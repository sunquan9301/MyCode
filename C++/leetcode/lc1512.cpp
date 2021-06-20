#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    int numIdenticalPairs(vector<int> &nums)
    {
        int a[101] = {0};
        for (int i = 0; i < nums.size(); i++)
            a[nums[i]]++;
        int result = 0;
        for (int i = 1; i <= 100; i++)
            if (a[i] > 0)
                result += (a[i] * a[i] - 1) / 2;
        return result;
    }
};
int numIdenticalPairs(vector<int> &nums)
{
    int a[101] = {0};
    for (int i = 0; i < nums.size(); i++)
        a[nums[i]]++;
    int result = 0;
    for (int i = 1; i <= 100; i++)
        if (a[i] > 0)
            result += (a[i] * (a[i] - 1)) / 2;
    return result;
}

// int main()
// {   
//     vector<int> a;
//     a.push_back
//     cout<<numIdenticalPairs(a);
// }x]