// DeliciousZongZi.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <bits/stdc++.h>
#define maxi(a,b) (a>b?a:b)
#define _OJ_
using namespace std;
class offer {
public:
    int bp = 0;
    int best = 0;
    offer() {

    }
    offer(int b, int be) :bp(b), best(be) {

    }
    bool operator<(offer other) {
        return best < (other.best);
    }
    bool operator>(offer other) {
        return best > (other.best);
    }
    offer operator=(offer other) {
        bp = other.bp;
        best = other.best;
        return *this;
    }
    bool operator==(offer other) {
        return (bp == other.bp) && (best == other.best);
    }
};
class node {
public:
    vector<node* >to;
    vector<node*>from;
    offer best;
    int price = 0;
    bool visit = false;
};
vector<node> nodes;
queue<node* > bfs;
int main()
{
    int n;
    int m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int pri;
        cin >> pri;
        node nod;
        nod.price = pri;
        nodes.push_back(nod);
    }
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        --u;
        --v;
        nodes[u].to.push_back(&(nodes[v]));//u can reach v.record it.
        nodes[v].from.push_back(&(nodes[u]));//v can be arrived from u.recode it sopra.
    }
    nodes[n - 1].best.bp = nodes[n - 1].price;
    bfs.push(&(nodes[n - 1]));
    while (!(bfs.empty())) {
        auto t = bfs.front();
        bfs.pop();
        t->visit = true;
        for (auto& i : (t->from))
        {
            offer temp;
            temp = i->best;
            offer donation(max(i->price,t->best.bp), max(t->best.bp - i->price,t->best.best));//Try to buy in i city instead.
            if (i->visit && i->best.bp >= donation.bp && i->best.best >= donation.best) { //Reentry the circuit and no new optimization.Don't time fly and explode in the circuit.Pass.
                continue; //Pass.
            }
            else { 
                i->best = donation; 
                bfs.push(i); 
            }
        }
    }
    cout << (nodes[0].best.best);
    return 0;
}