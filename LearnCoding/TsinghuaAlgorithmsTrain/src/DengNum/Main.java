package DengNum;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        int n = cin.nextInt();
        byte k = cin.nextByte();
        if (k == 1) {
            int[] mark = new int[n + 1];
            for (int i = 2; i <= n; ++i) {
                if (mark[i] == 2) continue;
                for (int j = 2 * i; j <= n; j += i) {
                    if (mark[i] == 0) mark[j] = 1;
                    else mark[j] = 2;
                }
            }
            for (int i = 2; i <= n; i++)
                if (mark[i] == 1) out.println(i);
        } else {
            Bitmap bitmap = new Bitmap(n);
            bitmap.set(0);
            bitmap.set(1);
            for (int i = 2; i <= n; i++)
                if (!bitmap.test(i))
                    for (int j = 2 * i; j <= n; j += i) bitmap.set(j);
            for (int i = 2; i <= n; i++)
                if (!bitmap.test(i)) out.println(i);
        }
        out.close();

    }

    static class Bitmap {
        byte[] bitAtt;

        public Bitmap(int n) {
            bitAtt = new byte[(n / 8 + 1)];
        }

        public void set(int k) {
            bitAtt[k >> 3] |= (0x80 >> (k & 0x07));
        }

        public void clear(int k) {
            bitAtt[k >> 3] &= ~(0x80 >> (k & 0x07));
        }

        public boolean test(int k) {
            return (bitAtt[k >> 3] & (0x80 >> (k & 0x07))) > 0;
        }
    }
}
