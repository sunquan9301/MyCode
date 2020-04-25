#include "graph.h"
#include "heap.h"
#include <limits>

class DijkstraSp
{

public:
    DijkstraSp(int vNum)
    {
        num = vNum;
        edgeTo = new EdgeNode[vNum+1];
        distTo = new double[vNum+1];
        pq.init(vNum+1);
        for (int v = 1; v <= vNum; v++)
        {
            distTo[v] = (numeric_limits<double>::max)();
        }
    }
    void init(Graph* G, int s);
    void relax(Graph* G,int v);
    double queryDistTo(int v)
    {
        return distTo[v];
    }
    bool hassPathTo(int v)
    {
        return distTo[v] < (numeric_limits<double>::max)();
    }
    void toString()
    {
        for (int i = 1; i <= num; i++)
        {
            cout << distTo[i] << ",";
        }
        cout<<endl;
    }
    ~DijkstraSp()
    {
        delete[] edgeTo;
        delete[] distTo;
    }

private:
    int num;
    IndexMinPQ pq;
    EdgeNode *edgeTo;
    double *distTo;
};