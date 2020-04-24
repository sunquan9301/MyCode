package Fundamentals;


public class InterviewQuestions2 {
    private int[] ids;
    private int[] heights;
    private int[] max;

    public InterviewQuestions2(int N, int M) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            max[i] = i;
            heights[i] = 1;

        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if (heights[pRoot] >= heights[qRoot]) {
            ids[qRoot] = pRoot;
            heights[pRoot] += 1;
            max[pRoot] = Math.max(max[qRoot], max[pRoot]);
        } else {
            ids[pRoot] = qRoot;
            heights[qRoot] += 1;
            max[qRoot] = Math.max(max[qRoot], max[pRoot]);
        }

    }

    public int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return max[p];
    }
}
