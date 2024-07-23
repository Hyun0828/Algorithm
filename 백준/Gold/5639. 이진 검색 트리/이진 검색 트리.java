import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BinarySearchTree tree = new BinarySearchTree(null);
        String input = null;
        while ((input = reader.readLine()) != null)
            tree.insert(Integer.parseInt(input));
        tree.preOrder(tree.root);
    }
}

class Node {
    int data;
    Node left_child;
    Node right_child;

    public Node(int data) {
        this.data = data;
        left_child = null;
        right_child = null;
    }
}

class BinarySearchTree {

    Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public void insert(int data) {

        Node newNode = new Node(data);

        if (root == null)
            root = newNode;
        else
            root = insertNode(root, newNode);
    }

    private Node insertNode(Node node, Node newNode) {

        if (node == null)
            return newNode;
        else if (node.data > newNode.data)
            node.left_child = insertNode(node.left_child, newNode);
        else if (node.data < newNode.data)
            node.right_child = insertNode(node.right_child, newNode);

        return node;
    }

    public void preOrder(Node node) {
        if (node == null)
            return;

        preOrder(node.left_child);
        preOrder(node.right_child);
        System.out.println(node.data);
    }
}
