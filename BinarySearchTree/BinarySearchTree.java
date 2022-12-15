public class BinarySearchTree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    };

    private Node root;

    public void insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            return;
        }

        var currentNode = root;
        while (true){
            if(currentNode.value < value) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = newNode;
                    break;
                }
                currentNode = currentNode.leftChild;
            }else {
                if(currentNode.rightChild == null){
                    currentNode.rightChild = newNode;
                    break;
                }
                currentNode = currentNode.rightChild;
            }
        }
    }

    public boolean find(int value){
        var currentNode = root;
        while (currentNode != null){
            if(currentNode.value < value)
                currentNode = currentNode.rightChild;
            else if(currentNode.value > value)
                currentNode = currentNode.leftChild;
            else
                return true;
        }
        return false;
    }

    public boolean equalityOfBinaryTree(BinarySearchTree other){
        if(other == null) return false;
        return equalityOfBinaryTree(root,other.root);
    }
    private boolean equalityOfBinaryTree(Node first,Node second){
        if(first==null && second==null) return true;
        if(first!=null && second!=null)
            return first.value == second.value &&
                    equalityOfBinaryTree(first.leftChild,second.leftChild) &&
                    equalityOfBinaryTree(first.rightChild,second.rightChild);
        return false;
    }

    public int minOfBinarySearchTree(){
        var currentNode = root;
        while (currentNode.leftChild != null) currentNode = currentNode.leftChild;
        return currentNode.value;
    }

    public int maxOfBinarySearchTree(){
        var currentNode = root;
        while (currentNode.rightChild != null) currentNode = currentNode.rightChild;
        return currentNode.value;
    }

    public int minOfBinaryTree(){
        return minOfBinaryTree(root);
    }
    private int minOfBinaryTree(Node root){
        if(root.leftChild==null && root.rightChild==null) return root.value;

        return Math.min(Math.min(minOfBinaryTree(root.leftChild),minOfBinaryTree(root.rightChild)),root.value);
    }

    public int maxOfBinaryTree(){
        return maxOfBinaryTree(root);
    }
    private int maxOfBinaryTree(Node root){
        if(root.leftChild==null && root.rightChild==null) return root.value;

        return Math.max(Math.max(maxOfBinaryTree(root.leftChild),maxOfBinaryTree(root.rightChild)),root.value);
    }

    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root == null) return -1;
        if(root.leftChild==null && root.rightChild==null) return 0;

        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root,int min,int max){
        if(root == null) return true;
        if(root.value<min || root.value>max) return false;

        return isBinarySearchTree(root.leftChild,min,max-1) &&
                isBinarySearchTree(root.rightChild,min+1,max);
    }

    public void printNodeAtDistance(int distance){
        printNodeAtDistance(root,distance);
        System.out.println();
    }
    private void printNodeAtDistance(Node root,int distance){
        if(root == null) return;
        if(distance == 0){
            System.out.print(root.value + " ");
            return;
        }
        printNodeAtDistance(root.rightChild,distance-1);
        printNodeAtDistance(root.leftChild,distance-1);
    }

    public void levelOrderTraversal(){
        int height = height();
        for(int i=0; i<=height; i++)
            printNodeAtDistance(i);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node root){
        if(root == null)
            return;
        inOrderTraversal(root.leftChild);
        System.out.println(root.value);
        inOrderTraversal(root.rightChild);
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node root){
        if(root == null)
            return;
        System.out.println(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node root){
        if(root == null)
            return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.value);
    }

}
