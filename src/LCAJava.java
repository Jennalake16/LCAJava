
import java.util.ArrayList;
public class LCAJava {

    public static void main(String[] args) {
        //create tree and tests here
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);
        binaryTree.root.left.right.left = new Node(8);
        binaryTree.root.left.right.right = new Node(9);
        binaryTree.root.right.right.left = new Node(10);
        binaryTree.root.right.right.right = new Node(11);
        binaryTree.root.left.right.right.left = new Node(12);
        binaryTree.root.left.right.right.right = new Node(13);

        System.out.println("LCA of nodes with values 6 and 10 is " + binaryTree.LCA(6, 10)); //should be 3
        System.out.println("LCA of nodes with values 8 and 9 is " + binaryTree.LCA(8, 9)); //should be 5
        System.out.println("LCA of nodes with values 7 and 11 is " + binaryTree.LCA(7, 11)); //should be 7
        System.out.println("LCA of nodes with values 12 and 3 is " + binaryTree.LCA(12, 3)); //should be 1

    }
}

//node class
class Node{
    int value;
    Node left, right;

    Node(int num){
        value = num;
        left = null;
        right = null;
    }
}

//binary tree class
class BinaryTree{
    Node root;
    ArrayList<Integer> path1 = new ArrayList<>();
    ArrayList<Integer> path2 = new ArrayList<>();

    int LCA(int node1, int node2){
        path1.clear();
        path2.clear();
        return getLCA(root, node1, node2);
    }

    int getLCA(Node root, int node1, int node2){
        if(getPath(root, node1, path1) && getPath(root, node2, path2)){
            int i;
            for(i = 0; i < path1.size() && i < path2.size(); i++){
                int index1 = path1.get(i);
                int index2 = path2.get(i);
                if (index1 != index2) {
                    break;
                }
            }
            int lca = path1.get(i-1);
            return lca;
        } else {
            System.out.println("Nodes are not present in tree");
            return -1;
        }
    }

    boolean getPath(Node root, int endNode, ArrayList<Integer> path){
        if (root == null) {
            return false;
        }

        path.add(root.value);

        if (root.value == endNode) {
            return true;
        }

        if (root.left != null && getPath(root.left, endNode, path)) {
            return true;
        }

        if (root.right != null && getPath(root.right, endNode, path)) {
            return true;
        }

        path.remove(path.size()-1);

        return false;

    }
}






















    /*public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        System.out.println("LCA(10, 14): " + tree.findLCA(10,14));
        System.out.println("LCA(14, 8): " + tree.findLCA(14,8));
        System.out.println("LCA(10, 22): " + tree.findLCA(10,22));

    }

    // A Binary Tree node
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    public static class BinaryTree
    {

        Node root;
        private List<Integer> path1 = new ArrayList<>();
        private List<Integer> path2 = new ArrayList<>();

        // Finds the path from root node to given root of the tree.
        int findLCA(int n1, int n2) {
            path1.clear();
            path2.clear();
            return findLCAInternal(root, n1, n2);
        }

        private int findLCAInternal(Node root, int n1, int n2) {

            if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
                System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
                System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
                return -1;
            }

            int i;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {

                // System.out.println(path1.get(i) + " " + path2.get(i));
                if (!path1.get(i).equals(path2.get(i)))
                    break;
            }

            return path1.get(i-1);
        }

        // Finds the path from root node to given root of the tree, Stores the
        // path in a vector path[], returns true if path exists otherwise false
        private boolean findPath(Node root, int n, List<Integer> path)
        {
            // base case
            if (root == null) {
                return false;
            }

            // Store this node . The node will be removed if
            // not in path from root to n.
            path.add(root.data);

            if (root.data == n) {
                return true;
            }

            if (root.left != null && findPath(root.left, n, path)) {
                return true;
            }

            if (root.right != null && findPath(root.right, n, path)) {
                return true;
            }

            // If not present in subtree rooted with root, remove root from
            // path[] and return false
            path.remove(path.size()-1);

            return false;
        }

        // Driver code

    }
// This code is contributed by Sreenivasulu Rayanki.
}*/
