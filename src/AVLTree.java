import java.io.*;
import java.util.*;

public class AVLTree {
    public String answer = "";
    public static class Node {
        private Node left, right;
        private int height = 1;
        private int value;
        private Node (int val) {
            this.value = val;
        }
    }

    public int height (Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    public Node insertNode(Node node, int value) {
        if (node == null) {
            return(new Node(value));
        }
        if (value < node.value)
            node.left  = insertNode(node.left, value);
        else
            node.right = insertNode(node.right, value);
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return balancing(node);
    }

    private Node rightRotate(Node node) {
        Node newNode = node.left;
        Node temp = newNode.right;

        newNode.right = node;
        node.left = temp;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newNode.height = Math.max(height(newNode.left), height(newNode.right)) + 1;
        return newNode;
    }

    private Node leftRotate(Node node) {
        Node newNode = node.right;
        Node buffer = newNode.left;

        newNode.left = node;
        node.right = buffer;

        node.height = Math.max(height(node.left), height(node.right))+1;
        newNode.height = Math.max(height(newNode.left), height(newNode.right))+1;
        return newNode;
    }

    private int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    public void preOrder(Node root, AVLTree t) {
        if (root != null){
            preOrder(root.left, t);
            t.answer = t.answer + root.value + " ";
            preOrder(root.right, t);
        }
    }

    public Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public Node balancing(Node node) {
        int balance = getBalance(node);
        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public Node deleteNode(Node root, int value) {
        if (root == null)
            return null;

        if (value < root.value)
            root.left = deleteNode(root.left, value);
        else if(value > root.value)
            root.right = deleteNode(root.right, value);
        else {
            if ((root.left == null) && (root.right == null))
                return null;
            else if((root.left == null) || (root.right == null))
                root = (root.left != null) ? root.left : root.right;
            else {
                Node temp = minValueNode(root.right);
                root.value = temp.value;
                root.right = deleteNode(root.right, temp.value);
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return balancing(root);
    }

    public void print(Node root) {
        if(root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height, width = (int)Math.pow(2, height-1);
        List<Node> current = new ArrayList<Node>(1), next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder stringBuilder = new StringBuilder(maxHalfLength*width);
        for(int i = 0; i < maxHalfLength*width; i++)
            stringBuilder.append(' ');
        String textBuffer;

        for(int i = 0; i < height; i++) {
            stringBuilder.setLength(maxHalfLength * ((int)Math.pow(2, height - 1 - i) - 1));
            textBuffer = stringBuilder.toString();
            for(Node n : current) {
                System.out.print(textBuffer);
                if(n == null) {
                    System.out.print("        ");
                    next.add(null);
                    next.add(null);
                } else {
                    System.out.printf("(%6d)", n.value);
                    next.add(n.left);
                    next.add(n.right);
                }
                System.out.print(textBuffer);
            }

            System.out.println();
            if(i < height - 1) {
                for(Node n : current) {
                    System.out.print(textBuffer);
                    if(n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s", n.left == null ? " " : "/", n.right == null ? " " : "\\");
                    System.out.print(textBuffer);
                }
                System.out.println();
            }
            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);
        }
    }

    public static void main(String[] args) {
        String res = "";
        AVLTree t = new AVLTree();
        Node root = null;

        while (true) {
           // t.preOrder(root, res);
            System.out.println("(1) Insert");
            System.out.println("(2) Delete");


            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferRead.readLine();

                if (Integer.parseInt(s) == 1) {
                    System.out.print("Value to be inserted: ");
                    root = t.insertNode(root, Integer.parseInt(bufferRead.readLine()));
                }
                else if (Integer.parseInt(s) == 2) {
                    System.out.print("Value to be deleted: ");
                    root = t.deleteNode(root, Integer.parseInt(bufferRead.readLine()));
                }
                else {
                    System.out.println("Invalid choice, try again!");
                    continue;
                }

                t.print(root);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}