package algorithm.algorithm;

public class BinaryTreeSearch {


    static void preOrder(Node node) {
        if ( node != null ) {
            System.out.print(node.data + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }
    static void inOrder(Node node) {
        if ( node != null ) {
            inOrder(node.leftChild);
            System.out.print(node.data + " ");
            inOrder(node.rightChild);
        }
    }
    static void postOrder(Node node) {
        if ( node != null ) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Node[] node = new Node[16];
        for (int i = 0; i < node.length; i++) {
            node[i] = new Node();
            node[i].data = i;
            node[i].leftChild = null;
            node[i].rightChild = null;
        }

        for (int i = 1; i < node.length; i++) {
            if ( i%2 == 0 ){
                node[i / 2].leftChild = node[i];
            }else {
                node[i / 2].rightChild = node[i];
            }
        }

        preOrder(node[1]);
        inOrder(node[1]);
        postOrder(node[1]);

    }

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;
    }

}
