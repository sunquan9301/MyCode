#include "graph.h"

void Graph::addEdge(int v, int w, double weight)
{
    EdgeNode *node = new EdgeNode;
    node->v = v;
    node->w = w;
    node->weight = weight;
    node->next = adj[v].firstedge;
    adj[v].firstedge = node;
}

void Graph::toString()
{
    cout << V() << " " << E() << endl;
    for (int i = 1; i <= v; i++)
    {
        cout << i << " : ";
        EdgeNode *p = adj[i].firstedge;
        while (p != nullptr)
        {
            if (p->next == nullptr)
            {
                cout << "(" << p->w << ", " << p->weight << ")";
            }else{
                cout << "(" << p->w << ", " << p->weight << ");";
            }
            p = p->next;
        }
        cout << endl;
    }
}