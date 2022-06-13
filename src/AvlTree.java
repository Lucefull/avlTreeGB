public class AvlTree {
    private Node root;

    public AvlTree() {
        root = null;
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    public void insert(int data) {
        root = insertNode(root, data);
        inorder();
        preorder();
        postorder();
    }

    private Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else if (node.data > data) {
            node.left = insertNode(node.left, data);
        } else if (node.data < data) {
            node.right = insertNode(node.right, data);
        }

        return rebalance(node);
    }

    public void delete(int data) {
        Node nodoToDelete = deleteNode(root, data);
        inorder();
        preorder();
        postorder();
    }

    private Node deleteNode(Node node, int data) {
        if (node == null) {
            return node;
        } else if (node.data > data) {
            node.left = deleteNode(node.left, data);
        } else if (node.data < data) {
            node.right = deleteNode(node.right, data);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = getMostLeftChild(node.right);
                node.data = mostLeftChild.data;
                node.right = deleteNode(node.right, node.data);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    public void search(int data) {
        searchNode(root, data);
    }

    private Node searchNode(Node node, int data) {
        Node current = node;
        while (current != null) {
            System.out.println(current.data);
            if (current.data == data) {
                System.out.println("encounter!");
                break;
            } else if (current.data < data) {
                current = current.right;
                System.out.println("right");
            } else {
                current = current.left;
                System.out.println("left");
            }
        }
        if (current == null) {
            System.out.println("not encounter");
        }
        return current;
    }

    private int getBalance(Node n) {
        if (n == null)
            return 0;
        else
            return height(n.left) - height(n.right);
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

    public void inorder() {
        System.out.println("Em ordem: \n");
        inorder(root);
        System.out.println("\n");
    }

    private void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);           
        }
    }

    public void preorder() {
        System.out.println("Pré-ordem:\n ");
        preorder(root);
        System.out.println("\n");
    }

    private void preorder(Node r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preorder(r.left);
            preorder(r.right);
            
        }
    }

    public void postorder() {
        System.out.println("Pós-ordem:\n ");
        postorder(root);
        System.out.println("\n");
    }

    private void postorder(Node r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data + " ");
            
        }
    }

    private Node getMostLeftChild(Node n) {
        Node current = n;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

}