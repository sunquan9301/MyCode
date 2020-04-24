package datastructure;

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    //On  如果count 到最后一次， 需要 O(n^2）的时间复杂度
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pId) id[i] = qId;
        count--;
    }


    //影响最坏情况复杂度
    public int find2(int p){
        while(p!=id[p]) p=id[p];
        return p;
    }

    public void union2(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
}
