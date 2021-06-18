package Sort;

public class MaxPQ {
    private int[] pq;
    private int N = 0;

    public MaxPQ(int n) {
        pq = new int[n + 1];
    }

    public void insert(int v) {
        pq[++N] = v;
        swim(N);
    }

    public int delMax() {
        int max = pq[1];
        exch(1, N--);
        pq[N + 1] = -1;
        sink(1);
        return max;
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while(k>1&&pq[k/2]<pq[k]){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k<=N){
            int j=2*k;
            if(j<N && pq[j]<pq[j+1]) j++;
            if(pq[k]>pq[j]) break;
            exch(k,j);
            k = j;
        }
    }
}
