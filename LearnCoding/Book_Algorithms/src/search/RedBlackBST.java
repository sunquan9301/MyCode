package search;

public class RedBlackBST<K extends Comparable<K>, V>  extends BST<K,V> {

    public boolean isRed(BSTNode node){
        if(node == null) return false;
        return node.isRedColor;
    }

    public void flipColor(BSTNode node){
        node.left.isRedColor = false;
        node.right.isRedColor = false;
        node.isRedColor = true;
    }

    public BSTNode rotateLeft(BSTNode node){
        BSTNode x = node.right;
        node.right = x.left;
        x.left = node;
        x.isRedColor = node.isRedColor;
        node.isRedColor = true;
        x.N = node.N;
        node.N = size(node.left)+size(node.right)+1;
        return x;
    }

    public BSTNode rotateRight(BSTNode node){
        BSTNode x = node.left;
        node.left = x.right;
        x.right = node;
        x.isRedColor = node.isRedColor;
        node.isRedColor = true;
        x.N = node.N;
        node.N = size(node.left)+size(node.right)+1;
        return x;
        synchronized ()
    }


    @Override
    public BSTNode put(BSTNode node, K key, V val) {
        if(node == null) return new BSTNode(key,val,1,true);
        if(key.compareTo(node.key)<0) node.left = put(node.left,key,val);
        else if(key.compareTo(node.key)>0) node.right = put(node.right,key,val);
        else node.value = val;
        if(isRed(node.right)&&!isRed(node.left)) node = rotateLeft(node);
        if(isRed(node.left)&&isRed(node.left.left)) node = rotateRight(node);
        if(isRed(node.left)&&isRed(node.right)) flipColor(node);
        node.N = size(node.left)+size(node.right)+1;
        return node;
    }
}
