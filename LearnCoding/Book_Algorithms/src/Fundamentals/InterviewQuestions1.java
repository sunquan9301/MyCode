package Fundamentals;


public class InterviewQuestions1 {
    private int[] ids;
    private int[] sizes;
    private int M;

    public InterviewQuestions1(int N, int M) {
        ids = new int[N];
        this.M = M;
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    public static void main(String[] args) {
        //1. init InterviewQuestions1, get the count of log file m timestamps -> M
        // 2. get each row data of log file -> (time, p,q), invoke union with p,q
        // 3. if the result is 1 return time; else return 2

        //space performance: O(N);   user id[] and size[]
        //time performance:  union: O(logN) ; all mlogN
    }

    public int union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return -1;

        if (sizes[pRoot] >= sizes[qRoot]) {
            ids[qRoot] = pRoot;
            sizes[pRoot] += sizes[qRoot];
            if (sizes[pRoot] == M) {
                return 1;
            }
        } else {
            ids[pRoot] = qRoot;
            sizes[qRoot] += sizes[pRoot];
            if (sizes[qRoot] == M) {
                return 1;
            }
        }
        return -1;

    }

    public int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }
}
