package exam2;

public class Compute {
    public static void main(String[] args){
        int[] num = {100,-3,72,54,23,35,-1,12,43,11,-6};
        int ans = compute(num,0);
    }

    public static int compute(int[] num,int index){
        if(index == num.length - 1)
            return num[index]%3!=0?index:0;
        return (num[index]%3!=0?index:0)+compute(num,index+1);
    }
}
