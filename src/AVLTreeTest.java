import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {
    AVLTree tree;
    AVLTree.Node root;

    @Before
    public void createTree() {
        tree = new AVLTree();
        root = null;
    }

    @Test
    public void testAddSingleNode() {
        root = tree.insertNode(root, 25);
        tree.preOrder(root, tree);
        assertEquals("Таки едиственный узел добавился неправильно", "25 ", tree.answer);
    }

    @Test
    public void testDeleteSingleNode() {
        root = tree.insertNode(root, 25);
        root = tree.deleteNode(root, 25);
        tree.preOrder(root, tree);
        assertEquals("Таки едиственный узел удалился не правильно", "", tree.answer);
    }

    @Test
    public void testAddManyNodes() {
        String result = "";

        for (int i = 0; i < 100; i++) {
            root = tree.insertNode(root, i);
            result = result + i + " ";
        }

        tree.preOrder(root, tree);
        assertEquals("Таки куча элементов добавилась не правильно", result, tree.answer);
    }

    @Test
    public void testDeleteAllNodes() {
        for (int i = 40; i <= 90; i += 10)
            root = tree.insertNode(root, i);

        for (int i = 90; i >= 40; i -= 10)
            root = tree.deleteNode(root, i);

        tree.preOrder(root, tree);
        assertEquals("Таки куча элементов удалилась не правильно", "", tree.answer);
    }

    @Test
    public void testDeleteSmallestNode() {
        for (int i = 20; i <= 60; i += 10)
            root = tree.insertNode(root, i);

        root = tree.deleteNode(root, 20);
        tree.preOrder(root, tree);
        assertEquals("Наименьший элемнт удален не правильно", "30 40 50 60 ", tree.answer);

    }

    @Test
    public void testDeleteHighestNode() {
        for (int i = 20; i <= 60; i += 10)
            root = tree.insertNode(root, i);

        root = tree.deleteNode(root, 60);
        tree.preOrder(root, tree);
        assertEquals("Наибольший элемнт удален не правильно", "20 30 40 50 ", tree.answer);

    }

    @Test
    public void testDeleteMissingNode() {
        for (int i = 20; i <= 60; i += 10)
            root = tree.insertNode(root, i);

        root = tree.deleteNode(root, 200);
        tree.preOrder(root, tree);
        assertEquals("Несуществующий элемнт удален не правильно", "20 30 40 50 60 ", tree.answer);

    }

    @Test
    public void testLeftSmallRotate() {
        for (int i = 40; i <= 60; i += 10)
            root = tree.insertNode(root, i);

        assertEquals("При малом левом повороте неправильная балансировка", 2, tree.height(root));
    }

    @Test
    public void testRightSmallRotate() {
        for (int i = 40; i <= 60; i += 10)
            root = tree.insertNode(root, i);

        assertEquals("При малом правом повороте неправильная балансировка", 2, tree.height(root));
    }

    @Test
    public void testLeftBigRotate() {
        for (int i = 10; i <= 110; i += 10)
            root = tree.insertNode(root, i);

        assertEquals("При большом левом повороте неправильная балансировка", 4, tree.height(root));
    }

    @Test
    public void testRightBihRotate() {
        for (int i = 110; i >= 10; i -= 10)
            root = tree.insertNode(root, i);

        assertEquals("При большом правом повороте неправильная балансировка", 4, tree.height(root));
    }

    @Test
    public void testTreeHeightNonNode() {
        assertEquals("Высота дерева без вершин не верна", 0, tree.height(root));
    }

    @Test
    public void testTreeHeightOneNode() {
        root = tree.insertNode(root, 100);

        assertEquals("Высота дерева ч одним узлом не верна", 1, tree.height(root));
    }
}