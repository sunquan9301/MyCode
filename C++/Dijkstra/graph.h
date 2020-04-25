#include <iostream>
using namespace std;
#pragma once
typedef struct EdgeNode
{
    int v;
    int w;
    double weight;
    struct EdgeNode *next;
} EdgeNode;

typedef struct
{
    EdgeNode *firstedge;
} AdjList;

class Graph
{

public:
    Graph()
    {
    }
    void init(int mV, int mM)
    {
        v = mV;
        m = mM;
        adj = new AdjList[v+1];
        for (int i = 1; i <= v; i++)
        {
            adj[i].firstedge = nullptr;
        }
    }
    AdjList *adj;

    int V() { return v; }
    int E() { return m; }
    void addEdge(int v, int m, double weight);
    void toString();
    ~Graph()
    {
        delete[] adj;
    }

private:
    int v, m;
};