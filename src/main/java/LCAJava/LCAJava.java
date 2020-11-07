package LCAJava;

import java.util.ArrayList;
public class LCAJava {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
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
