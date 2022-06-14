public class Node {
    Node left, right;
    Pessoa data;
    int height;

    public Node() {
        left = null;
        right = null;
        data = new Pessoa();
        height = 0;
    }

    public Node(Pessoa n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Pessoa getData() {
        return data;
    }

    public void setData(Pessoa data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Nó: " + this.data + " ; Esquerda: " + left.data + " ; Direita: " + right.data + "\n";
    }
}