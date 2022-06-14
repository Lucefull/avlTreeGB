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

    @Override
    public String toString() {
        return "Nó: " + this.data + " ; Esquerda: " + left.data + " ; Direita: " + right.data + "\n";
    }
}