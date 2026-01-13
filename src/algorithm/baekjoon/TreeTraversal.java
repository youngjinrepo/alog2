import java.util.Scanner;

public class TreeTraversal {

    static class Node{
        char left;
        char right;
        Node (char left, char right) {
            this.left=left;
            this.right=right;
        }
    }

    static Node[] tree = new Node[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            char root = line.charAt(0);
            char left = line.charAt(2);
            char right = line.charAt(4);
            tree[root-'A'] = new Node(left, right);
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
        System.out.println();

        sc.close();
    }

    private static void postOrder(char root) {
        if (root=='.' || tree[root-'A'] == null) return;
        postOrder(tree[root - 'A'].left);
        postOrder(tree[root - 'A'].right);
        System.out.print(root);
    }

    private static void inOrder(char root) {
        if (root=='.' || tree[root-'A'] == null) return;
        inOrder(tree[root - 'A'].left);
        System.out.print(root);
        inOrder(tree[root - 'A'].right);
    }

    private static void preOrder(char root) {
        if (root=='.' || tree[root-'A'] == null) return;
        System.out.print(root);
        preOrder(tree[root - 'A'].left);
        preOrder(tree[root - 'A'].right);
    }
 }