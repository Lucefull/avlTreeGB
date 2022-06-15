public class AvlTreeDate {
    private Node root;

    public AvlTreeDate() {
        root = null;
    }

    public void insert(Pessoa data) {
        root = insertNode(root, data);        
    }

    private Node insertNode(Node node, Pessoa data) {
        if (node == null) {
            return new Node(data);
        } else if (node.data.getDataNascimento().before(data.getDataNascimento())) {
            node.left = insertNode(node.left, data);
        } else if (node.data.getDataNascimento().after(data.getDataNascimento())) {
            node.right = insertNode(node.right, data);
        }

        return rebalance(node);
    }
    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.left.left) > height(z.left.right))
                z = simpleRotationToRight(z);
            else {
                z.left = simpleRotationToLeft(z.left);
                z = simpleRotationToRight(z);
            }
        } else if (balance < -1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = simpleRotationToLeft(z);
            } else {
                z.right = simpleRotationToRight(z.right);
                z = simpleRotationToLeft(z);
            }
        }
        return z;
    }

    private int getBalance(Node n) {
        if (n == null)
            return 0;
        else
            return height(n.left) - height(n.right);
    }

    private Node simpleRotationToLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node simpleRotationToRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }
    private int height(Node n) {
        return n == null ? -1 : n.height;
    }
}
