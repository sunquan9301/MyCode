#include "graph.h"
#include "heap.h"
#include "util.h"
#include <limits>

class DijkstraSp
{

public:
    DijkstraSp(int vNum)
    {
        num = vNum;
        edgeTo = new EdgeNode[vNum + 1];
        distTo = new double[vNum + 1];
        pq.init(vNum + 1);
        for (int v = 1; v <= vNum; v++)
        {
            distTo[v] = (numeric_limits<double>::max)();
        }
    }
    void init(Graph *G, int s);
    void relax(Graph *G, int v);
    double queryDistTo(int v)
    {
        return distTo[v];
    }
    bool hassPathTo(int v)
    {
        return distTo[v] < (numeric_limits<double>::max)();
    }
    void toPathString(int v)
    {
        cout << "PATH: ";
        if (v == source)
        {
            cout << v << endl;
        }
        else
        {
            EdgeNode e = edgeTo[v];
            if (e.v == source)
            {
                cout << e.v << ", " << e.w << endl;
            }
            else
            {
                string result = "";
                while (e.v != source)
                {
                    result = ", " + Util::itos(e.w) + result;
                    e = edgeTo[e.v];
                }
                cout << e.v << ", " << e.w << result << endl;
            }
        }
    }
    void toString()
    {
        for (int i = 1; i <= num; i++)
        {
            cout << distTo[i] << ",";
        }
        cout << endl;
    }
    ~DijkstraSp()
    {
        delete[] edgeTo;
        delete[] distTo;
    }

private:
    int source;
    int num;
    IndexMinPQ pq;
    EdgeNode *edgeTo;
    double *distTo;
};