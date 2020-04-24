package JavaSpecification;

import java.util.ArrayList;
import java.util.List;

public class ArrayObject {
    public static void main(String[] args) {
        int[] a = new int[3];
        System.out.println(a instanceof Object);
        List l = new ArrayList<Number>();
        List<Long> ls = l;  // Unchecked warning
        ArrayObject ao = new ArrayObject();

    }

    public int getLength(ListNode head) {
        ListNode l = head;
        int count = 0;
        while (l != null) {
            count++;
            l = l.next;
        }
        return count;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
