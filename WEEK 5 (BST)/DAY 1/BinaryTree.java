public class BinaryTree {
    Node root;

    public Node insert(Node node, Student data) {
        if (node == null) {
            node = new Node(data);
            if (root == null)
                root = node;
            return node;

        }
        if (node.left == null) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void traversal(Node node, Direction dir) {
        if (dir.equals(Direction.INORDER)) {
            if (node != null) {
                traversal(node.left, Direction.INORDER);
                System.out.println(node.student);
                traversal(node.right, Direction.INORDER);
            }
        }
        if (dir.equals(Direction.PREORDER)) {
            if (node != null) {
                System.out.println(node.student);
                traversal(node.left, Direction.PREORDER);
                traversal(node.right, Direction.PREORDER);
            }
        }
        if (dir.equals(Direction.POSTORDER)) {
            traversal(node.left, Direction.POSTORDER);
            traversal(node.right, Direction.POSTORDER);
            System.out.println(node.student);
        }
    }

}
