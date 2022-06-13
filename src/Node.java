public class Node {
    Node left, right;
    int data;
    int height;

    public Node() {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }

    public Node(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }

    @Override
    public String toString() {
        return "Nó: " + this.data + " ; Esquerda: " + left.data + " ; Direita: " + right.data + "\n";
    }
}