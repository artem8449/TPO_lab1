import java.io.*;
import java.util.*;

public class AVLTree {
    public String answ = "";
    public class Node {
        private Node left, right;
        private int height = 1;
        private int value;


        private Node (int val) {
            this.value = val;
        }
    }

    //метод возвращает высоту поддерева для узла
    public  int height (Node N) {
        if (N == null)
            return 0;
        return N.height;
    }
    //метод рекурсивного прохода по дереву со вставкой элемнтой и балансировки
    public  Node insert(Node node, int value) {
        /* 1.  Создание обьекта нового узла  */
        if (node == null) {
            return(new Node(value));
        }

        if (value < node.value)
            node.left  = insert(node.left, value);
        else
            node.right = insert(node.right, value);

        /* 2. подситываем высоту для поддерева */
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        /* 3. Проверяем является ли узел сбалансированным*/
        int balance = getBalance(node);

        // Если произошел дисбаланс проводим балансировку в зависимости от условий

        // Left Left Case - малое правое вращение
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right Right Case - малое левое вращение
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left Right Case - большое правое вращение
        if (balance > 1 && value > node.left.value)
        {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case - большое левое вращение
        if (balance < -1 && value < node.right.value)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }
//перепривязываем  ссылки на объекты и пересчитываем высоту поддеревьев при правом повороте
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // перпривязка
        x.right = y;
        y.left = T2;

        // обновление высоты
        y.height = Math.max(height(y.left), height(y.right))+1;
        x.height = Math.max(height(x.left), height(x.right))+1;


        return x;
    }
//перепривязываем  ссылки на объекты и пересчитываем высоту поддеревьев при левом повороте
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // перепривязка
        y.left = x;
        x.right = T2;

        //  обновление длины
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;


        return y;
    }

    // проверяем и выводи сбанасированы ли поддеревья узла
    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }


    public  void preOrder(Node root, AVLTree t) {

        //StringBuilder builder = new StringBuilder();
       // t.answ = "";
        if (root != null) {
            preOrder(root.left, t);
           // System.out.printf("%d ", root.value);
           // res = res + Integer.toString(root.value) + " ";
           // builder.append(root.value).append(" ");
            t.answ = t.answ + Integer.toString(root.value) + " ";
            preOrder(root.right, t);
        }
       // String result = builder.toString();
       // System.out.printf(result);
       // return result;

    }


//метод врзвращающий минимальный узел
    public  Node minValueNode(Node node) {
        Node current = node;
        /* иттеративнно спускаемся по дерево к самому левому узлу */
        while (current.left != null)
            current = current.left;
        return current;
    }
//метод рекурсивно спускается по дереву, находит узел удоляет его и перестраивает дерево
    public  Node deleteNode(Node root, int value) {
        // STEP 1: находим и удаляем узел

        if (root == null)
            return root;

        // Если удаляемый узел (value) меньше рассматриваемого то левое поддерево,
        if ( value < root.value )
            root.left = deleteNode(root.left, value);

            // Если удаляемый узел (value) больше рассматриваемого то правое поддерево,
        else if( value > root.value )
            root.right = deleteNode(root.right, value);

            // Если значение найденного узла равно удаляемому, то удоляем
        else {
            // при условии что у узла 1 ребенок или нет детей
            if( (root.left == null) || (root.right == null) ) {

                Node temp;
                if (root.left != null)
                    temp = root.left;
                else
                    temp = root.right;

                // случай нет детей
                if(temp == null) {
                    temp = root;
                    root = null;
                }
                else // один ребенок
                    root = temp; // сохраняем содержание не пустого ребенка

                temp = null;
            }
            else {
                // узел с 2 детьми - берем минимальный в правом поддереве
                Node temp = minValueNode(root.right);

                // Сохраняем значение найденного узла
                root.value = temp.value;

                // Удаляем найденный узел
                root.right = deleteNode(root.right, temp.value);
            }
        }

        // если у дерева 1 узел возвращаем
        if (root == null)
            return root;

        // STEP 2: Обновляем высоту поддерева для выбранного узла
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: Проверяем кзел на сбалансированность и балансируем
        int balance = getBalance(root);

        // если произошел разбаланс, балансируем

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left =  leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
//вывод дерева в консоль
    public void print(Node root) {

        if(root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height,
                width = (int)Math.pow(2, height-1);

        // Подготавливаем обьекты для заполнения узлами
        List<Node> current = new ArrayList<Node>(1),
                next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength*width);
        for(int i = 0; i < maxHalfLength*width; i++)
            sb.append(' ');
        String textBuffer;

        // Подготовка строки для вывода
        for(int i = 0; i < height; i++) {

            sb.setLength(maxHalfLength * ((int)Math.pow(2, height-1-i) - 1));

            // приведение к строке.
            textBuffer = sb.toString();

            // вывод значения узла
            for(Node n : current) {

                System.out.print(textBuffer);

                if(n == null) {

                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {

                    System.out.printf("(%6d)", n.value);
                    next.add(n.left);
                    next.add(n.right);

                }

                System.out.print(textBuffer);

            }

            System.out.println();
            // вывод связей с узлами детьми
            if(i < height - 1) {

                for(Node n : current) {

                    System.out.print(textBuffer);

                    if(n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s",
                                n.left == null ? " " : "/", n.right == null ? " " : "\\");

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            // увеличиваем переменные для возможности вывода след. узла .
            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);

        }

    }

    public static void main(String args[]) {
        String res = "";
        AVLTree t = new AVLTree();
        Node root = null;

        while (true) {
           // t.preOrder(root, res);
            System.out.println("(1) Insert");
            System.out.println("(2) Delete");


            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferRead.readLine();

                if (Integer.parseInt(s) == 1) {
                    System.out.print("Value to be inserted: ");
                    root = t.insert(root, Integer.parseInt(bufferRead.readLine()));
                }
                else if (Integer.parseInt(s) == 2) {
                    System.out.print("Value to be deleted: ");
                    root = t.deleteNode(root, Integer.parseInt(bufferRead.readLine()));
                }
                else {
                    System.out.println("Invalid choice, try again!");
                    continue;
                }

                t.print(root);
            }
            catch(IOException e) {
                e.printStackTrace();
            }

        }
    }
}