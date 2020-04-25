#include "dijkstraSp.h"

void DijkstraSp::init(Graph *G, int s)
{
    distTo[s] = 0.0;
    pq.insert(s, 0.0);
    while (!pq.isEmpty())
    {
        int index = pq.delMin();
        relax(G, index);
    }
}

void DijkstraSp::relax(Graph *G, int v)
{
    EdgeNode *p = G->adj[v].firstedge;
    while (p != nullptr)
    {

        int w = p->w;
        if (distTo[w] > distTo[v] + p->weight)
        {
            distTo[w] = distTo[v] + p->weight;
            edgeTo[w] = *p;
            if (pq.contains(w))
                pq.changeKey(w, distTo[w]);
            else
                pq.insert(w, distTo[w]);
        }
        p = p->next;
    }
}
