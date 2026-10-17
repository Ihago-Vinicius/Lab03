import java.util.Scanner;

public class Main {
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
                for (int i = 0; i < app.mostrarFilmes().length; i++) {
                    System.out.println(app.mostrarFilmes()[i]);
                }
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
        }
    }
}
