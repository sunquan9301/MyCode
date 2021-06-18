//package graph;
//
//import edu.princeton.cs.algs4.Graph;
//import edu.princeton.cs.algs4.In;
//
//public class Cycle {
//    private boolean[] marked;
//    private boolean hasCycle;
//
//    public Cycle(MyGraph G) {
//        marked = new boolean[G.V()];
//        for (int s = 0; s < G.V(); s++) {
//            if (!marked[s]) dfs(G, s, s);
//        }
//    }
//
//    public void dfs(MyGraph G, int v, int u) {
//        marked[v] = true;
//        for (int w : G.adj(v)) {
//            if (!marked[w])
//                dfs(G, w, v);
//            else if (w != u) hasCycle = true;
//        }
//    }
//
//    public boolean hasCycle() {
//        return hasCycle;
//    }
//
//    public static void main(String[] args) {
//        MyGraph myGraph = new MyGraph(new In("tinyG.txt"));
//        Cycle cycle = new Cycle(myGraph);
//        System.out.println(cycle.hasCycle);
//    }
//}
