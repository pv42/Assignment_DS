package assingmentDS.util;

import java.util.Iterator;

import assingmentDS.util.MyBinTree.Node;

public class MyTreeIterator<T> implements Iterator {

    private Node iterator, root;


    //gibt die am weitesten links liegende Node im subtree der übergebenen root zurück
    private Node firstNode(Node node) {
        if (node == null) return null;
        if (node.left == null) {
            return node;
        }else{
            return firstNode(node.left);
        }
    }

    //gibt den parent der übergebenen Node zurück
    private Node parent(Node node) {
        Node parent;
        if ((node == null) || (root == null)) return null;
        if (root.left == node || root.right == node) return root;
        if (node == root) {
            return null;
        }
        else{
            parent = leftParent(node, root.left);
            if (parent != null) return parent;
            parent = rightParent(node, root.right);
            return parent;
        }
    }

    //sucht den parent im linken subtree
    private Node leftParent(Node node, Node root) {
        Node parent;
        if ((node == null) || (root == null)) return null;
        if (root.left == node || root.right == node) return root;
        if (node == root) {
            return null;
        }else{
            parent = leftParent(node, root.left);
            if (parent != null) return parent;
            parent = rightParent(node, root.right);
            return parent;
        }
    }

    //sucht den parent im rechten subtree
    private Node rightParent(Node node, Node root) {
        Node parent;
        if ((node == null) || (root == null)) return null;
        if (root.left == node || root.right == node) return root;
        if (node == root) {
            return null;
        }
        else{
            parent = leftParent(node, root.left);
            if (parent != null) return parent;
            parent = rightParent(node, root.right);
            return parent;
        }
    }

    //gibt wahr zurück falls die übergebene Node im linken Subtree enthalten ist
    private boolean isLeftChild(Node node, Node root) {
        if (node == root) return false;
        return isLeftChildCheck(node, root.right);
    }

    //sucht beide subtrees nach der übergebenen Node ab
    private boolean isLeftChildCheck(Node node, Node root) {
        if ((root.left == null) && (root.right == null)) return false;
        if (node == root.left) return true;
        if (root.left != null) return isLeftChildCheck(node, root.left);
        return isLeftChildCheck(node, root.right);
    }

    //gibt wahr zurück falls die übergebene Node im rechten Subtree enthalten ist
    private boolean isRightChild(Node node, Node root) {
        if (node == root) return false;
        return isRightChildCheck(node, root.right);
    }

    //sucht beide subtrees nach der übergebenen Node ab
    private boolean isRightChildCheck(Node node, Node root) {
        if ((root.left == null) && (root.right == null)) return false;
        if (node == root.right) return true;
        if (root.left != null) return isRightChildCheck(node, root.left);
        return isRightChildCheck(node, root.right);
    }

    //next() Funktion, aber ohne überschreiben der globalen Variable 'iterator'
    public Node hasNextCheck() {
        Node currentIterator = iterator;
        //am Anfang der Iteration, wird die am weitesten links liegende Node zurück gegeben
        /*Es wird immer rechts gegangen, außer wenn es keine weiter rechts liegenden Nodes im subtree gibt. In dem
          Fall ist die root des nächst höheren subtrees die nächste Iteration, gefolgt von der linkesten
          Node des rechten pfades dieser root.
          Wiederholt bis die tatsächliche root des vorliegenden Baumes erreicht ist.
          Anliegend an de In-Order
        */

        //Suchen der anfangs Node
        if (currentIterator == null) {
            return firstNode(root);
        }
        Node current = currentIterator;

        //Current wird auf das parent eines Blattes gesetzt
        if ((currentIterator.left == null) && (currentIterator.right == null)) {
            current = parent(currentIterator);
            //falls das Blatt das linke child von current ist, wird es zur nächsten Iteration
            if (isLeftChild(currentIterator, current)) {
                return current;
            }
        }

        /*falls eine Lücke im Baum enthalten ist(ein nicht Blatt bestitzt kein rechtes child),
         *dann wird das parent dieser Node zur nächsten Iteration
         *falls es das rechteste element des Baumes ist, wird dieser Schritt übersprungen
         * */
        if ((currentIterator.left != null) && (currentIterator.right == null)){
            current = parent(currentIterator);
            if (isLeftChild(currentIterator, current)){
                return current;
            }
        }

        //Sprung zum nächst höheren Subtree
        while (isRightChild(currentIterator, current)) {
            current = parent(current);
        }
        /*falls die vorhergehende Iteration im linken subtree des nächst höheren subtree
        * enthalten war, wird die root dieses subtrees zur nächsten Iteration
        * */
        if ((!isRightChild(currentIterator, current)) && (currentIterator.left == null) && (currentIterator.right == null)) {
            return current;
        }

        //Prüft mit der root des Baumes ob das Ende der Iteration erreicht ist
        while (isRightChild(currentIterator, current)) {
            current = parent(current);
            if (current == root) {
                return null;
            }
        }

        //gibt die linkeste Node im rechten Subtree der derzeitigen Iteration zurück
        return firstNode(currentIterator.right);
    }


    //gibt wahr zurück falls eine nächste Node existiert
    public boolean hasNext() {
        if (hasNextCheck() != null) return true;
        else return false;
    }

    //gibt die nächste Node in der Iteration zurück
    public Node next() {
        Node currentIterator = iterator;
        //am Anfang der Iteration, wird die am weitesten links liegende Node zurück gegeben
        /*Es wird immer rechts gegangen, außer wenn es keine weiter rechts liegenden Nodes im subtree gibt. In dem
          Fall ist die root des nächst höheren subtrees die nächste Iteration, gefolgt von der linkesten
          Node des rechten pfades dieser root.
          Wiederholt bis die tatsächliche root des vorliegenden Baumes erreicht ist.
          Anliegend an de In-Order
        */

        //Suchen der anfangs Node
        if (currentIterator == null) {
            iterator = firstNode(root);
            return firstNode(root);
        }
        Node current = currentIterator;

        //Current wird auf das parent eines Blattes gesetzt
        if ((currentIterator.left == null) && (currentIterator.right == null)) {
            current = parent(currentIterator);
            //falls das Blatt das linke child von current ist, wird es zur nächsten Iteration
            if (isLeftChild(currentIterator, current)) {
                iterator = current;
                return current;
            }
        }

        /*falls eine Lücke im Baum enthalten ist(ein nicht Blatt bestitzt kein rechtes child),
         *dann wird das parent dieser Node zur nächsten Iteration
         *falls es das rechteste element des Baumes ist, wird dieser Schritt übersprungen
         * */
        if ((currentIterator.left != null) && (currentIterator.right == null)){
            current = parent(currentIterator);
            if (isLeftChild(currentIterator, current)){
                iterator = current;
                return iterator;
            }
        }

        //Sprung zum nächst höheren Subtree
        while (isRightChild(currentIterator, current)) {
            current = parent(current);
        }
        /*falls die vorhergehende Iteration im linken subtree des nächst höheren subtree
        * enthalten war, wird die root dieses subtrees zur nächsten Iteration
        * */
        if ((!isRightChild(currentIterator, current)) && (currentIterator.left == null) && (currentIterator.right == null)) {
            iterator = current;
            return current;
        }

        //Prüft mit der root des Baumes ob das Ende der Iteration erreicht ist
        while (isRightChild(currentIterator, current)) {
            current = parent(current);
            if (current == root) {
                iterator = null;
                return null;
            }
        }

        //gibt die linkeste Node im rechten Subtree der derzeitigen Iteration zurück
        iterator = firstNode(currentIterator.right);
        return firstNode(currentIterator.right);


    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}
