import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Jayme Rigiel Gomes Neto
 * @author Luan Roberto Steffens
 */

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AvlTree tree = new AvlTree();   
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");   
        String value = "14/06/2022";
        try{
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(value);
            System.out.println(formatter.format(date1));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         
        System.out.println("--- AVLTree Tree ---\n");
        String choice = "";

        while (true) {
            System.out.println("###########################################\n"
                    + "##          AVLTree Operations           ##\n"
                    + "###########################################\n"
                    + "## I  ## INSERIR                         ##\n"
                    + "## B  ## BUSCAR                          ##\n"
                    + "## R  ## REMOVER                         ##\n"
                    + "## S  ## SAIR                            ##\n"
                    + "###########################################\n");
            System.out.println("Digite a opção: ");
            choice = scan.next();
            switch (choice.toUpperCase()) {
                case "I":
                    System.out.println("Digite o elemento inteiro a ser inserido:");
                    //tree.insert(scan.nextInt());
                    break;
                case "B":
                    System.out.println("Digite o valor inteiro a ser buscado:");
                    //tree.search(scan.nextInt());
                    break;
                case "R":
                    System.out.println("Digite o valor a ser deletado:");
                    //tree.delete(scan.nextInt());
                    break;
                case "S":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção invalida!\nTente novamente\n");
                    break;
            }
            System.out.println("\n");
        }
    }
}
