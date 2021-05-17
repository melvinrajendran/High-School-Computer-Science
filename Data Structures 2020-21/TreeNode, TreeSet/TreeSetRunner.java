public class TreeSetRunner {
    public TreeSetRunner() {
        int count = 0;

        TreeSet<Character> tree = new TreeSet<Character>();
        while (tree.size() < 26) {
            int value = (int)(Math.random() * 26) + 65;
            System.out.print((char)value);
            tree.add((char)value);
        }
        System.out.println();

        String s = tree.preOrder();
        s = s.substring(1, s.length() - 1);
        String[] preOrderCopy = s.split(", ");
        TreeSet<Character> preOrderSet = new TreeSet<>();
        for (String str : preOrderCopy)
            preOrderSet.add(str.charAt(0));

        s = tree.inOrder();
        s = s.substring(1, s.length() - 1);
        String[] inOrderCopy = s.split(", ");
        TreeSet<Character> inOrderSet = new TreeSet<>();
        for (String str : inOrderCopy)
            inOrderSet.add(str.charAt(0));

        s = tree.postOrder();
        s = s.substring(1, s.length() - 1);
        String[] postOrderCopy = s.split(", ");
        TreeSet<Character> postOrderSet = new TreeSet<>();
        for (String str : postOrderCopy) {
            postOrderSet.add(str.charAt(0));
            count += (int)(str.charAt(0));
        }

        System.out.println("Average ASCII Value - " + (count / 30));
        System.out.println("Average Character - " + (char)(count / 30));
        System.out.println("Size - " + tree.size() + "\n");
        
        System.out.println("Original Set - Preorder: " + tree.preOrder());
        System.out.println("Original Set - Inorder: " + tree.inOrder());
        System.out.println("Original Set - Postorder: " + tree.postOrder() + "\n");

        System.out.println("PreOrder Copy - Preorder: " + preOrderSet.preOrder());
        System.out.println("PreOrder Copy - Inorder: " + preOrderSet.inOrder());
        System.out.println("PreOrder Copy - Postorder: " + preOrderSet.postOrder() + "\n");

        System.out.println("InOrder Copy - Preorder: " + inOrderSet.preOrder());
        System.out.println("InOrder Copy - Inorder: " + inOrderSet.inOrder());
        System.out.println("InOrder Copy - Postorder: " + inOrderSet.postOrder() + "\n");

        System.out.println("PostOrder Copy - Preorder: " + postOrderSet.preOrder());
        System.out.println("PostOrder Copy - Inorder: " + postOrderSet.inOrder());
        System.out.println("PostOrder Copy - Postorder: " + postOrderSet.postOrder() + "\n");

        System.out.println("Right Rotation 1");
        tree.rotateRight();
        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder() + "\n");

        System.out.println("Right Rotation 2");
        tree.rotateRight();
        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder() + "\n");

        System.out.println("Right Rotation 3");
        tree.rotateRight();
        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder() + "\n");

        System.out.println("Left Rotation 1");
        tree.rotateLeft();
        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder() + "\n");

        System.out.println("Left Rotation 2");
        tree.rotateLeft();
        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder() + "\n");

        System.out.println("Left Rotation 3");
        tree.rotateLeft();
        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder());
    }
    public static void main(String[] args) {
        new TreeSetRunner();
    }
}