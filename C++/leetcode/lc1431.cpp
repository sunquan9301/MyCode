#include <iostream>
#include <vector>
using namespace std;
class Solution
{
public:
    vector<bool> kidsWithCandies(vector<int> &candies, int extraCandies)
    {
        vector<bool> result;
        int maxValue = candies[0];
        for (int i = 1; i < candies.size(); i++)
            maxValue = maxValue > candies[i] ? maxValue : candies[i];
        for (int i = 0; i < candies.size(); i++)
            result.push_back(candies[i] + extraCandies >= maxValue);
        return result;
    }
};