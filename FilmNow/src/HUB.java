import java.util.Scanner;

/**
 * Hub visual do programa.
 */
public class HUB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmNow app = new FilmNow();
        while (true) {
            System.out.println("(A)Adicionar filme");
            System.out.println("(M)Mostrar todos");
            System.out.println("(D)Detalhar filme");
            System.out.println("(E)Exibir HotList");
            System.out.println("(H)Atribuir Hot");
            System.out.println("(R)Remover Hot");
            System.out.println("(S)Sair\n");

            System.out.print("Opção> ");
            String opcao = sc.nextLine();
            System.out.println();

            if (opcao.equals("S")) {
                break;
            }
            else if (opcao.equals("A")) {
                System.out.print("Posição> ");
                int posicao = sc.nextInt();
                sc.nextLine();
                System.out.print(("Nome> "));
                String nome = sc.nextLine();
                System.out.print("Ano> ");
                int ano = sc.nextInt();
                sc.nextLine();
                System.out.print("Local> ");
                String local = sc.nextLine();

                System.out.println(app.addFilme(posicao, nome, ano, local));
                System.out.println();
            }
            else if (opcao.equals("M")) {
                System.out.println(app.mostrarFilmes());
                System.out.println();
            }
            else if (opcao.equals("D")) {
                System.out.print("Posição> ");
                int posicao = sc.nextInt();
                sc.nextLine();
                System.out.println();
                System.out.println(app.detalharFilme(posicao));
                System.out.println();
            }
            else if (opcao.equals("H")) {
                System.out.print("Filme> ");
                int filme = sc.nextInt();
                sc.nextLine();
                System.out.print("Posição> ");
                int poscicao = sc.nextInt();
                sc.nextLine();
                System.out.println(app.atribuirHot(filme, poscicao));
                System.out.println();
            }
            else if (opcao.equals("R")) {
                System.out.print("Posição> ");
                int posicao = sc.nextInt();
                sc.nextLine();
                System.out.println(app.removerHot(posicao));
                System.out.println();
            }
            else if (opcao.equals("E")) {
                System.out.println(app.exibirHotList());
                System.out.println();
            }
            else {
                System.out.println("INVÁLIDA");
                System.out.println();
            }
        }
    }
}
