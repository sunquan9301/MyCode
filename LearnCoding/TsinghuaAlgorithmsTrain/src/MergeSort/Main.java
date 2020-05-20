package MergeSort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args){
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i=0;i<n;i++){
            data[i] = in.nextInt();
        }
        mergeSort(data);
        for(int i=0;i<data.length;i++){
            out.print(data[i]+" ");
        }
        out.close();

    }

    public static void mergeSort(int[] data){
        int[] temp = new int[data.length];
        int gap = 1,N = temp.length;
        for(gap =1;gap<N;gap+=gap){
            for(int i=0;i<N-gap;i = i+2*gap){
                merge(i,i+gap-1,Math.min(N-1,i+2*gap-1),data,temp);
            }
        }
//        System.out.println(Arrays.toString(data));
    }

    public static void merge(int lo,int mid,int hi,int[] data,int[]temp){
        for(int i=lo;i<=hi;i++){
            temp[i] = data[i];
        }
        int p = lo,q = mid+1;
        for(int i=lo;i<=hi;i++){
            if(p>mid) data[i] = temp[q++];
            else if(q>hi) data[i] = temp[p++];
            else data[i] = temp[p]<=temp[q]?temp[p++]:temp[q++];
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        private InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        private short nextShort() {
            return Short.parseShort(next());
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private float nextFloat() {
            return Float.parseFloat(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
