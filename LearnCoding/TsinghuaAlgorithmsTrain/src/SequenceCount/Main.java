package SequenceCount;

import java.util.Scanner;

public class Main {

    final static int N = 300005;
    static int n,d;
    static int[] max_value = new int[N];
    static int[] min_value = new int[N];
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        d = cin.nextInt();
        int[] value = new int[n];
        for(int i=0;i<value.length;i++){
            value[i] = cin.nextInt();
        }
        System.out.println(solve(0,n-1,value));
    }

    public static long solve(int l,int r,int[] value){
        if(l == r) return 0;
        int mid = (l+r)/2;
        long ans = solve(l,mid,value)+solve(mid+1,r,value);
        for(int i=mid+1;i<=r;++i){
            min_value[i] =(i==mid+1)?value[i]:Math.min(min_value[i-1],value[i]);
            max_value[i] =(i==mid+1)?value[i]:Math.max(max_value[i-1],value[i]);
        }
        int mn=0,mx=0,pos = r;
        for(int i=mid;i>=l&&pos>mid;--i){
            mn =(i==mid)?value[i]:Math.min(mn,value[i]);
            mx =(i==mid)?value[i]:Math.max(mx,value[i]);
            for(;pos>mid&&Math.max(mx,max_value[pos])-Math.min(mn,min_value[pos])>d;--pos);
            ans+=pos-mid;
        }
        return ans;
    }

}
