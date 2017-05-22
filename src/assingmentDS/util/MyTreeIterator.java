import java.util.Iterator;

public class MyTreeIterator <T> implements Iterator {

        private Node firstNode(Node root){
            if (root == null) return null;
            if(root.left == null) return root;
            else firstNode(root.left);
        }

        private Node parent(Node node, Node root){
            if ((node == null) || (root == null)) return null;
            if (root.left == node || root.right == node) return root;
            if (node == root) return null;
            else {
                return parent(root.left, root);
                return parent(root.right), root;
            }
        }

        private boolean isLeftChild(Node node, Node root){
            if (node == root) return false;
            return isLeftChildCheck(node, root.right);
        }

        private boolean isLeftChildCheck(Node node, Node root){
            if ((root.left == null) && (root.right == null)) return false;
            if (node == root.left) return true;
            if (root.left != null) return isLeftChildCheck(node, root.left);
            if (root.right != null) return isLeftChildCheck(node, root.right);
        }

        private boolean isRightChild(Node node, Node root){
            if (node == root) return false;
            return isRightChildCheck(node, root.right);
        }

        private boolean isRightChildCheck(Node node, Node root){
            if ((root.left == null) && (root.right == null)) return false;
            if (node == root.right) return true;
            if (root.left != null) return isRightChildCheck(node, root.left);
            if (root.right != null) return isRightChildCheck(node, root.right);
        }


        public boolean hasNext(){
            if (next() != null) return true;
            else return false;
        }

        public Node next() {
            Node currentIterator = iterator;
            if (currentIterator == null) {
                iterator = firstNode(root);
                return firstNode(root);}
            Node current = currentIterator;

            if ((currentIterator.left == null) && (currentIterator.right == null)) {
                current = parent(currentIterator, root);
                if (isLeftChild(currentIterator, current)) {
                    iterator = current;
                    return current;}
            }

            while (isRightChild(currentIterator, current)) {
                current = parent(current, root);
            }
            if ((!isRightChild(currentIterator, current)) && (currentIterator.left == null) && (currentIterator.right == null)) {
                iterator = current;
                return current;
            }

            while (isRightChild(currentIterator, current)) {
                current = parent(current, root);
                if (current == root) {
                    iterator = null;
                    return null;}
            }
            iterator = firstNode(currentIterator.right);
            return firstNode(currentIterator.right);


        }

        public void remove(){

        }

        public void forEachRemaining(){
            while (hasNext()) action.accept(next());
        }
    }
