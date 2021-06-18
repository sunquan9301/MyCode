package search;

import java.util.Scanner;

public class BinarySeach {

    public void main(String[] args) {
        Scanner cin = new Scanner(System.in);
    }

    public int binarySearch(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (key < arr[mid]) r = mid - 1;
            if (key > arr[mid]) l = mid + 1;
            return mid;
        }
        return -1;
    }
}
