package AVL;

public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        for(int i=1; i<=1000; i++){
            avlTree.insert(i);
        }



        System.out.println(avlTree.getHeight());
//        avlTree.display();
    }
}
