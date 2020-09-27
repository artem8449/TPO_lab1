import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {


    @Test
    public void testaddsingleNode() {
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;
        root = tree.insert(root, 25);
        tree.preOrder(root, tree);
        assertEquals("Таки едиственный узел добавился не правильно", "25 ", tree.answ);
    }

    @Test
    public void testDeletsingleNode(){
       // String res = "";
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 25);
        root = tree.deleteNode(root, 25);
        tree.preOrder(root, tree);
        assertEquals("Таки едиственный узел удалился не правильно", "", tree.answ);
    }

    @Test
    public void testaddManyNode(){

        String result = "";

        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;


        for (int i = 0; i<100; i++) {
            root = tree.insert(root, i);
            result = result + Integer.toString(i) + " ";
        }

        tree.preOrder(root, tree);
        assertEquals("Таки куча элементов добавилась не правильно", result, tree.answ);
    }

    @Test
    public void testDeletallNode(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 60);
        root = tree.insert(root, 70);
        root = tree.insert(root, 80);
        root = tree.insert(root, 90);
        root = tree.deleteNode(root, 90);
        root = tree.deleteNode(root, 80);
        root = tree.deleteNode(root, 70);
        root = tree.deleteNode(root, 60);
        root = tree.deleteNode(root, 50);
        root = tree.deleteNode(root, 40);

        tree.preOrder(root, tree);
        assertEquals("Таки куча элементов удалилась не правильно", "", tree.answ);

    }

    @Test
    public void  testDeletsmallestNode(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 60);
        root = tree.insert(root, 35);


        root = tree.deleteNode(root, 20);

        tree.preOrder(root, tree);
        assertEquals("Наименьший элемнт удален не правильно", "30 35 40 50 60 ", tree.answ);

    }


    @Test
    public void  testDelethighestNode(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 60);
        root = tree.insert(root, 35);


        root = tree.deleteNode(root, 60);

        tree.preOrder(root, tree);
        assertEquals("Наибольший элемнт удален не правильно", "20 30 35 40 50 ", tree.answ);

    }

    @Test
    public void testDeletтщтшыNode(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 60);
        root = tree.insert(root, 35);


        root = tree.deleteNode(root, 200);

        tree.preOrder(root, tree);
        assertEquals("Несуществующий элемнт удален не правильно", "20 30 35 40 50 60 ", tree.answ);

    }

    @Test
    public void testLeftsmallRotate(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 60);


        assertEquals("При малом левом повороте неправильная балансировка", 2, tree.height(root));

    }

    @Test
    public void testRightsmallRotate(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 60);


        assertEquals("При малом правом повороте неправильная балансировка", 2, tree.height(root));
    }

    @Test
    public void testLeftBigRotate(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 60);
        root = tree.insert(root, 70);
        root = tree.insert(root, 80);
        root = tree.insert(root, 90);
        root = tree.insert(root, 100);
        root = tree.insert(root, 110);

        assertEquals("При большом левом повороте неправильная балансировка", 4, tree.height(root));
    }

    @Test
    public void testRightBihRotate(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 110);
        root = tree.insert(root, 100);
        root = tree.insert(root, 90);
        root = tree.insert(root, 80);
        root = tree.insert(root, 70);
        root = tree.insert(root, 60);
        root = tree.insert(root, 50);
        root = tree.insert(root, 40);
        root = tree.insert(root, 30);
        root = tree.insert(root, 20);
        root = tree.insert(root, 10);

        assertEquals("При большом правом повороте неправильная балансировка", 4, tree.height(root));
    }

    @Test
    public void testTreeHightnonNod(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        assertEquals("Высота дерева без вершин не верна", 0, tree.height(root));

    }

    @Test
    public void testTreeHightoneNod(){
        AVLTree tree = new AVLTree();
        AVLTree.Node root = null;

        root = tree.insert(root, 100);

        assertEquals("Высота дерева ч одним узлом не верна", 1, tree.height(root));

    }


}