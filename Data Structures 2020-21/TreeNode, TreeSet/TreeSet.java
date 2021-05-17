public class TreeSet<E extends Comparable<E>> {
    private TreeNode<E> root;
    private String str;
    private int size;

    public TreeSet() {
        root = null;
        size = 0;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public int size() {
        return size;
    }

    public void add(E value) {
        if (root == null) {
            root = new TreeNode<E>(value);
            size++;
        } else {
            add(root, value);
        }
    }

    public void add(TreeNode<E> node, E value) {
        if (value == node.getValue()) {
            return;
        } else if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode<E>(value));
                size++;
                return;
            } else {
                add(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new TreeNode<E>(value));
                size++;
                return;
            } else {
                add(node.getRight(), value);
            }
        }
    }

    public boolean contains(TreeNode<E> node, E value) {
        if (node == null)
            return false;

        if (node.getValue().equals(value))
            return true;
        else if (value.compareTo(node.getValue()) < 0)
            return contains(node.getLeft(), value);
        else
            return contains(node.getRight(), value);
    }

    public E minValue(TreeNode<E> node) {
        if (node.getLeft() == null)
            return node.getValue();
        else
            return minValue(node.getLeft());
    }

    public void remove(E value) {
        if (root == null)
            return;
        if (contains(root, value)) {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                size = 0;
                return;
            } else {
                size--;
                root = remove(root, value);
            }
        }
    }

    public TreeNode<E> remove(TreeNode<E> node, E value) {
        if (node == null)
            return null;
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(remove(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(remove(node.getRight(), value));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                E minValue = minValue(node.getRight());
                node.value = minValue;
                node.setRight(remove(node.getRight(), minValue));
            }
        }
        return node;
    }

    public String inOrder() {
        if (size == 0) {
            return "[]";
        } else {
            str = "[" + inOrder(root).substring(2) + "]";
            return str;
        }
    }

    public String inOrder(TreeNode<E> node) {
        String s = "";
        if (node != null)
            s += inOrder(node.getLeft()) + ", " + node + inOrder(node.getRight());
        return s;
    }

    public String preOrder() {
        if (size == 0) {
            return "[]";
        } else {
            str = "[" + preOrder(root);
            str = str.substring(0, str.length() - 2) + "]";
            return str;
        }
    }

    public String preOrder(TreeNode<E> node) {
        String s = "";
        if (node != null)
            s += node + ", " + preOrder(node.getLeft()) + preOrder(node.getRight());
        return s;
    }

    public String postOrder() {
        if (size == 0) {
            return "[]";
        } else {
            str = "[" + postOrder(root);
            str = str.substring(0, str.length() - 2) + "]";
            return str;
        }
    }

    public String postOrder(TreeNode<E> node) {
        String s = "";
        if (node != null)
            s += postOrder(node.getLeft()) + postOrder(node.getRight()) + node + ", ";
        return s;
    }

    public void rotateLeft() {
        rotateLeft(root);
    }

    public void rotateLeft(TreeNode<E> node) {
        if (node == null || node.getRight() == null)
            return;
            
        TreeNode<E> temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        root = temp;
    }

    public void rotateRight() {
        rotateRight(root);
    }

    public void rotateRight(TreeNode<E> node) {
        if (node == null || node.getLeft() == null)
            return;

        TreeNode<E> temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        root = temp;
    }
    
    public class TreeNode<E extends Comparable<E>> {
        private E value;
        private TreeNode<E> left, right;

        public TreeNode(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public E getValue() {
            return value;
        }

        public TreeNode<E> getLeft() {
            return left;
        }

        public TreeNode<E> getRight() {
            return right;
        }

        public void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        public void setRight(TreeNode<E> right) {
            this.right = right;
        }

        public String toString() {
            return value + "";
        }
    }
}