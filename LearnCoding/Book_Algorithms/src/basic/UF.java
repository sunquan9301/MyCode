package basic;

public class UF {
    private int[] values;
    private int count;

    public UF(int n) {
        this.count = n;
        values = new int[count];
        for (int i = 0; i < count; i++) {
            values[i] = i;
        }
    }

    public int find(int p) {
        while (p != values[p]) p = values[p];
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        values[rootP] = rootQ;
        count--;
    }
}
