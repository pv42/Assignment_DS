package assingmentDS.util;

/**
 * Created on 20.05.2017.
 */

/* TODO
* -die attribute von Node private, dafür getter und setter verwenden
* -die runThrough Methode währe besser, wenn sie eine toString() Methode whre, die statt sachen auszugeben, einen String
*  zurückgibt, den man dann auch zb in eine Datei schreiben könnte
* -der Baum muss nicht sortiert sein sondern nur balanciert d.h du musst nichts mit < vergleichen sondern nur beachten,
*  das beide Seiten gleich gewichtet sind
* */


public class MyBinTree<T> {
    private class Node {

        //Knotenpunkte für BinBaum
        T data;
        Node left, right;
        Node (T data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    Node root = null; // todo make it private (IntelliJ hätte dir das gesagt)
    // btw die  = null zuweisung ist nicht erforderlich, da das im automatischen Kontruktor enthalten ist

    private void rekInsert(Node ast, T nenclosure) { //todo this whole methode
        if (nenclosure < ast.data) {
            //left einfügen
            if (ast.left == null) {
                ast.left = new Node(nenclosure);
            } else {
                rekInsert(ast.left, nenclosure);
            }
        } else {
            //right einfügen
            if (ast.right == null) {
                ast.right = new Node(nenclosure);
            } else {
                rekInsert(ast.right, nenclosure);
            }
        }
    }

    public void insert(T nenclosure) {
        if (root == null) {
            root = new Node(nenclosure);
        } else {
            rekInsert(root, nenclosure);
        }
    }

    //Ausgeben

    private void rekRunThrough(Node ast) {
        if (ast != null) {
            rekRunThrough(ast.left);
            System.out.print(ast.data); System.out.println();
            rekRunThrough(ast.right);
        }
    }

    public void runThrough() {
        if (root != null) {
            rekRunThrough(root.left);
            System.out.print(root.data); System.out.println();
            rekRunThrough(root.right);
        }
    }
}