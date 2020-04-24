package search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private BSTNode root;

    public int size() {
        return size(root);
    }

    public int size(BSTNode n) {
        if (n == null) return 0;
        return n.N;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    public BSTNode put(BSTNode node, K key, V val) {
        
        if (node == null) return new BSTNode(key, val, 1);
        if (key.compareTo(node.key) < 0) return node.left = put(node.left, key, val);
        else if (key.compareTo(node.key) > 0) return node.right = put(node.right, key, val);
        node.value = val;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(BSTNode node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) return get(node.left, key);
        else if (key.compareTo(node.key) > 0) return get(node.right, key);
        return node.value;

    }

    public BSTNode min() {
        return min(root);
    }

    public BSTNode min(BSTNode note) {
        if (note == null) return null;
        if (note.left == null) return note;
        return min(note.left);
    }


    public BSTNode floor(K key) {
        return floor(root, key);
    }

    public BSTNode floor(BSTNode node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) return floor(node.left, key);
        else if (key.compareTo(node.key) == 0) return node;
        else {
            BSTNode t = floor(node.right, key);
            if (t != null) return t;
            return node;
        }
    }

    //排名第k
    public BSTNode select(int k) {
        return select(root, k);
    }

    public BSTNode select(BSTNode n, int k) {
        if (n == null) return null;
        int t = size(n.left);
        if (k < t) return select(n.left, k);
        else if (k == n.N) return n;
        else return select(n.right, k - t - 1);
    }

    public int rank(BSTNode n, K key) {
        if (n == null) return 0;
        if (key.compareTo(n.key) == 0) return size(n.left);
        if (key.compareTo(n.key) < 0) return rank(n.left, key);
        return size(n.left) + 1 + rank(n.right, key);
    }

    public int rank(K key) {
        return rank(root, key);
    }

    public void deleteMin() {

    }

    public BSTNode deleteMin(BSTNode n) {
        return null;
    }

    public void delete(K key) {

    }

    public BSTNode delect(BSTNode n, K key) {
        return null;
    }

    class BSTNode {
        BSTNode left;
        BSTNode right;
        K key;
        V value;
        int N;
        boolean isRedColor;

        public BSTNode(K key, V value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        public BSTNode(K key, V value, int n, boolean isRedColor) {
            this.key = key;
            this.value = value;
            N = n;
            this.isRedColor = isRedColor;
        }
    }

}

