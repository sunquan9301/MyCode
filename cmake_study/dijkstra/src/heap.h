#include <iostream>
using namespace std;
class IndexMinPQ
{
public:
    void init(int maxN);
    bool isEmpty() { return n == 0; }
    bool contains(int i) { return qp[i] != -1; }
    int size() { return n; }
    bool greaterOther(int i, int j) { return keys[pq[i]] > keys[pq[j]]; }
    void exch(int i, int j);
    void swim(int k);
    void sink(int k);
    void insert(int i, double key);
    int minIndex()
    {
        return pq[1];
    }
    double minKey()
    {
        return keys[pq[1]];
    }
    int delMin();
   
    void changeKey(int i, double key);

    ~IndexMinPQ(){
        delete[] pq;
        delete[] qp;
        delete[] keys;
    }

private:
    int n;
    int *pq;
    int *qp;
    double *keys;
};