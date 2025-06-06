
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreesB {
    // this is class of Node
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // this is code of building binary tree  

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            // if node is equal to -1 means there is no any nodes
            if(nodes[idx] == -1) {
                return null;
            }
            // if node is not equal to -1 then we need to create a new node
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode; 
        }

        // preorder traversing in tree
        public static void preorder(Node root){
            if(root == null){
                // System.out.print(-1+ " ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        // Inorder traversing in tree
        public static void inorder(Node root) {
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        // postorder traversing in tree
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        // levelorder traversal in tree
        public static void levelorder (Node root){
            if(root == null){
                return;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while(!queue.isEmpty()){
                Node currNode = queue.remove();
                if(currNode == null){
                  System.out.println();
                  if(queue.isEmpty()){
                    break;
                  }else{
                    queue.add(null);
                  }
                }else{
                    System.out.print(currNode.data+ " ");
                    if(currNode.left != null){
                        queue.add(currNode.left);
                    }
                    if(currNode.right != null){
                        queue.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        // calling preorder traversing
        System.out.println("Preorder traversing in tree");
       tree.preorder(root);
       System.out.println();

       // calling inorder traversing
       System.out.println("Preorder traversing in tree");
       tree.inorder(root);
       System.out.println();

       // calling postorder teaversing
       System.out.println("Preorder traversing in tree");
       tree.postorder(root);
       System.out.println();

       // calling level tracersing function in tree
       System.out.println("Preorder traversing in tree");
        tree.levelorder(root);
    }
}
