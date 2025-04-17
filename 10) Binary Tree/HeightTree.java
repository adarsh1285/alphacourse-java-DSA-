public class HeightTree {
    // create a node 
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
    // calculate the height of the tree
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }
    // calculate the total number of nodes in the tree
    public static int numberOfNode(Node root){
        if (root == null){
            return 0;
        }
        int leftCount = numberOfNode(root.left);
        int rightCount = numberOfNode(root.right);
        int totalNode = leftCount + rightCount + 1;
        return totalNode;
    }
    // calculate sum of the node in tree
    public static int sumOfNode(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);
        int totalSum = leftSum + rightSum + root.data;
        return totalSum;
    }
    // calculate the diameter of the tree O(n^2)
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int leftDiam = diameter(root.left);
        int leftHeight = heightOfTree(root.left);
        int rightDiam = diameter(root.right);
        int rightHeight = heightOfTree(root.right);

        int selfDiam = leftHeight + rightHeight + 1;
        return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
    }
    // calculate the diameter of the tree optimize solution O(n)
    static class Info {
        int diam;
        int ht;

        public Info(int diam , int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter2 (Node root){
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam , rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    // subtree of another tree
    public static boolean isIdentical(Node node , Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root , Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root , subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // print all the nodes of K level
    public static void KLevel (Node root, int level , int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data+ " ");
            return;
        }
        KLevel(root.left, level + 1, k);
        KLevel(root.right, level + 1, k);
    }


    public static void main (String args[]){
        /*
              1
             / \
            2   3
           / \ / \
          4  5 6  7
                   

        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // root.right.right.right = new Node(8);
        
        /*
            2
           / \
          4   5
         */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // this calling for the calculate height
        System.out.println("Height of the tree is : "+heightOfTree(root));

        // this calling for the calculate number of node in tree
        System.out.println("Total Number of nodes in the tree : "+numberOfNode(root));

        // this calling for the calculating sum of the nodes
        System.out.println("Sum of the nodes is : "+ sumOfNode(root));

        // this calling for the calculating diameter of a tree O(n^2)
        System.out.println("Diameter of the tree is : "+ diameter(root));

        //this calling for the calculating the diameter of the a tree O(n)
        System.out.println("Diameter of the tree is : " + diameter2(root).diam);

        // this calling for the checking subtree in another tree
        System.out.println(isSubtree(root, subRoot));

        // print all the nodes of the k level 
        int k = 3;
        int level = 1;
        KLevel(root, level, k);

    }
}
