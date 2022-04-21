import java.util.Scanner;

public class AvlTreeTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AvlTree avlt = new AvlTree();

        // System.out.println("AVLTree Tree Test\n");
        String choice;

        do {
            System.out.println("\nAVLTree Operations\n");
            System.out.println("I. INSERIR ");
            System.out.println("B. BUSCAR");
            System.out.println("R. REMOVER");
            System.out.println("S. SAIR");

            choice = scan.next();
            switch (choice.toUpperCase()) {
                case "I":
                    System.out.println("Digite o elemento inteiro a ser inserido:");
                    avlt.insert(scan.nextInt());
                    break;
                case "B":
                    System.out.println("Digite o valor inteiro a ser buscado:");
                    System.out.println("Resultado Busca : " + avlt.search(scan.nextInt()));
                    break;
                case "R":

                    break;
                default:
                    System.out.println("Opção invalida!\nTente novamente\n");
                    break;
            }

            System.out.print("\nPós-Ordem : ");
            avlt.postorder();
            System.out.print("\nPré-Ordem : ");
            avlt.preorder();
            System.out.print("\nEm-Ordem : ");
            avlt.inorder();

        } while (choice != "S");
    }
}
