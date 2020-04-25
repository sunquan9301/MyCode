#include "heap.h"

void IndexMinPQ::init(int maxN)
{
    n = 0;
    keys = new double[maxN + 1];
    pq = new int[maxN + 1];
    qp = new int[maxN + 1];
    for (int i = 0; i <= maxN; i++)
    {
        qp[i] = -1;
    }
}
void IndexMinPQ::exch(int i, int j)
{
    int swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
    qp[pq[i]] = i;
    qp[pq[j]] = j;
}

void IndexMinPQ::swim(int k)
{
    while (k > 1 && greaterOther(k / 2, k))
    {
        exch(k, k / 2);
        k = k / 2;
    }
}

void IndexMinPQ::sink(int k)
{
    while (2 * k <= n)
    {
        int j = 2 * k;
        if (j < n && greaterOther(j, j + 1))
            j++;
        if (!greaterOther(k, j))
            break;
        exch(k, j);
        k = j;
    }
}
void IndexMinPQ::insert(int i, double key)
{
    if (contains(i))
        return;
    n++;
    qp[i] = n;
    pq[n] = i;
    keys[i] = key;
    swim(n);
}
int IndexMinPQ::delMin()
{
    int min = pq[1];
    exch(1, n);
    n--;
    sink(1);
    qp[min] = -1;
    keys[min] = -1;
    pq[n + 1] = -1;
    return min;
}
void IndexMinPQ::changeKey(int i, double key)
{
    keys[i] = key;
    swim(qp[i]);
    sink(qp[i]);
}