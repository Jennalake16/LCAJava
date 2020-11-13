package LCAJava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LCAJavaTest {
    @Test
    public void test(){
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

        assertEquals(3, binaryTree.LCA(6, 10));
        assertEquals(5, binaryTree.LCA(8, 9));
        assertEquals(7, binaryTree.LCA(7, 11));
        assertEquals(1, binaryTree.LCA(12, 3));
    }
}