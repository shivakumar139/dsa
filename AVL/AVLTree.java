package AVL;

public class AVLTree {
    class Node{
        private int data, height;
        private Node left, right;

        public Node(int val){
            data = val;
        }

    }
    private Node root;

    public int getHeight(){
        return height(root);
    }
    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.data);
        display(node.left, "Left child of " + node.data + " : ");
        display(node.right, "Right child of " + node.data + " : ");
    }

    public void insert(int val){
        root = insert(val, root);
    }
    private int getBalanced(Node node){
        if(node == null) return 0;

        return height(node.left) - height(node.right);
    }

    private Node insert(int val, Node node){
        if(node == null) return new Node(val);

        if(val < node.data){
            node.left = insert(val, node.left);
        } else if(val > node.data){
            node.right = insert(val, node.right);
        } else{
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;


        int balanced = getBalanced(node);

        // LL, balanced > 1 means left tree is greater, insert in right
        if(balanced > 1 && val < node.left.data){
            return rightRotate(node);
        }

        // RR, balanced < -1 means right tree is greater, insert in left
        if(balanced < -1 && val > node.right.data){
            return leftRotate(node);
        }

        //LR
        if(balanced > 1 && val > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL
        if(balanced < -1 && val < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }




    public Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }
    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    private int height(Node node){
        if(node == null) return 0;

        return node.height;
    }

}
