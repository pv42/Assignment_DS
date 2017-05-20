package assingmentDS.util;

/**
 * Created by pv42 on 20.05.2017.
 */

public class MyBinTree<T> {
    private class Node {

        //Knotenpunkte für BinBaum
        T enclosure;
        Node left, right;
        Node (T nenclosure)
        {
            this.enclosure = nenclosure;
            this.left = null;
            this.right = null;
        }

    }


    Node root = null;

    private void rekInsert(Node ast, T nenclosure)
    {
        if (nenclosure < ast.enclosure)
        {
            //left einfügen
            if (ast.left == null)
            {
                ast.left = new Node(nenclosure);
            }
            else rekInsert(ast.left, nenclosure);
        }
        else
        {
            //right einfügen
            if (ast.right == null)
            {
                ast.right = new Node(nenclosure);
            }
            else rekInsert(ast.right, nenclosure);
        }
    }

    public void insert(T nenclosure)
    {
        if (root == null)
        {
            root = new Node(nenclosure);
        }
        else rekInsert(root, nenclosure);
    }

    //Ausgeben

    private void rekRunThrough(Node ast)
    {
        if (ast != null)
        {
            rekRunThrough(ast.left);
            System.out.print(ast.enclosure); System.out.println();
            rekRunThrough(ast.right);
        }
    }

    public void runThrough()
    {
        if (root != null)
        {
            rekRunThrough(root.left);
            System.out.print(root.enclosure); System.out.println();
            rekRunThrough(root.right);
        }
    }
}