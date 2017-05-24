package assignmentDS.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import assignmentDS.util.MyBinTree.Node;

public class MyTreeIterator<T> implements Iterator {

    private Node current, root;


    MyTreeIterator(Node root) {
        this.root = root;
    }

    //gibt die am weitesten links liegende Node im subtree der übergebenen node zurück
    private Node firstNode(Node node) {
        if (node == null) return null;
        if (node.getLeft() == null) {
            return node;
        } else {
            return firstNode(node.getLeft());
        }
    }

    //gibt den parent der übergebenen Node zurück
    private Node parent(Node node) {
        return parent(node, root);
    }

    private Node parent(Node node, Node root) {
        if ((node == null) || (root == null)) return null;
        if (root.getLeft() == node || root.getRight() == node) return root;
        if (node == root) return null;
        Node parent;
        parent = parent(node, root.getLeft());
        if (parent != null) return parent;
        parent = parent(node, root.getRight());
        return parent; // may be null
    }

    //gibt wahr zurück falls die übergebene Node im linken Subtree enthalten ist
    private boolean isLeftChild(Node node, Node parent) {
        if (node == parent) return false;
        return isLeftChildCheck(node, parent);
    }

    //sucht beide subtrees nach der übergebenen Node ab
    private boolean isLeftChildCheck(Node node, Node parent) {
        if ((parent.getLeft() == null) && (parent.getRight() == null)) return false;
        if (node == parent.getLeft()) return true;
        return isChildNode(node, parent.getLeft());
    }

    // überprüft ob eine Node der andern untergeordnet oist
    private boolean isChildNode(Node node, Node parent) {
        if (parent == null || node == null) return false;
        if (node == parent.getLeft() || node == parent.getRight()) return true;
        return isChildNode(node, parent.getLeft()) || isChildNode(node, parent.getRight());
    }

    //gibt wahr zurück falls eine nächste Node existiert
    public boolean hasNext() {
        if (current == null) {
            return root != null;
        }
        if (current.getRight() != null) return true;
        Node currentParent = parent(current);
        if(currentParent == null) return false;
        while (!isLeftChild(current, currentParent)) {
            Node localcurrent = currentParent;
            currentParent = parent(localcurrent);
            if(currentParent == null) return false;
        }
        return true;
    }

    //gibt die nächste Node in der Iteration zurück
    public T next() {
        if(root == null) throw new IllegalStateException("Root can not be null");
        if (current == null) {
            current = firstNode(root);
            return (T) current.getData();
        }
        if (current.getRight() != null) {
            current = firstNode(current.getRight());
            return (T) current.getData();
        }
        Node currentParent = parent(current);
        if(currentParent == null) throw new NoSuchElementException("No Elements left");
        while (!isLeftChild(current, currentParent)) {
            current = currentParent;
            currentParent = parent(current);
            if(currentParent == null) throw new NoSuchElementException("No Elements left");
        }
        current = currentParent;
        return (T) current.getData();
    }
}
