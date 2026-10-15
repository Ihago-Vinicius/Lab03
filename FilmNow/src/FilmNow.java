public class FilmNow {

    private Filme[] filmes;

    private Filme[] hotList;

    public FilmNow() {
        this.filmes = new Filme[100];
        this.hotList = new Filme[10];
    }

    public String addFilme(int posicao, String nome, int ano, String local) {
        this.filmes[posicao] = new Filme(nome, ano, local);
    }

    public String mostrarFilmes() {

    }

    public String detalharFilme(int posicao) {

    }

    public String exibirHotList() {

    }

    public void atribuirHot(int posicao) {

    }

    public void removerHot(int posicao) {

    }

}