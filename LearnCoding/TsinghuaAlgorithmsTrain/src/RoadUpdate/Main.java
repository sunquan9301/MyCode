package RoadUpdate;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] uf = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            uf[i] = i;
            size[i] = 1;
        }
        int m = cin.nextInt();
        int[] roadMark = new int[m + 1];
        MaxPQ maxPQ = new MaxPQ(m);
        for (int i = 0; i < m; i++) {
            maxPQ.insert(new Edge(i + 1, cin.nextInt(), cin.nextInt()));
        }
        int count = 0;
        while (!maxPQ.isEmpty() && count < n - 1) {
            Edge e = maxPQ.delMax();
            int rootP = find(uf, e.v);
            int rootQ = find(uf, e.w);
            if (rootP != rootQ) {
                union(uf, size, rootP, rootQ);
                roadMark[e.id] = 1;
            }
        }
        System.out.println(n - 1);
        for (int i = 1; i <= m; i++) {
            if (roadMark[i] == 1) System.out.println(i);
        }
    }

    public static int find(int[] uf, int p) {
        int temp = p;
        while (p != uf[p]) {
            p = uf[p];
        }
        while (temp != p) {
            int temp1 = uf[temp];
            uf[temp] = p;
            temp = temp1;
        }
        return p;
    }

    //return isConn
    public static void union(int[] uf, int[] size, int rootP, int rootQ) {
        if (size[rootP] < size[rootQ]) {
            uf[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            uf[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
}

class Edge {
    int id;
    int v;
    int w;

    public Edge(int id, int v, int w) {
        this.id = id;
        this.v = v;
        this.w = w;
    }
}

class MaxPQ {
    Edge[] key;
    int n;

    public boolean isEmpty() {
        return n == 0;
    }

    public MaxPQ(int capacity) {
        key = new Edge[capacity + 1];
        this.n = 0;
    }

    public void insert(Edge e) {
        key[++n] = e;
        swim(n);
    }

    public int size() {
        return n;
    }

    public Edge delMax() {
        Edge max = key[1];
        exch(1, n--);
        sink(1);
        key[n + 1] = null;
        return max;
    }

    public void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && small(j, j + 1)) j++;
            if (!small(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void swim(int k) {
        while (k > 1 && !small(k, k / 2)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void exch(int i, int j) {
        Edge temp = key[i];
        key[i] = key[j];
        key[j] = temp;
    }

    public boolean small(int i, int j) {
        return key[i].id < key[j].id;
    }
}
