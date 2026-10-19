/**
 * Classe molde do objeto FilmNow, o programa responsável por realizar as operações internas.
 */
public class FilmNow {
    /** Array de filmes.*/
    private Filme[] filmes;
    /** Array de filmes com status hot.*/
    private Filme[] hotList;

    /**
     * Construtor da classe.
     * Por padrão inicializa o array de filmes com 100 vagas e a hotlist com 10 vagas.
     * As primeiras vagas de cada array, correspondente a posição 0, não são contabilizadas.
     */
    public FilmNow() {
        this.filmes = new Filme[101];
        this.hotList = new Filme[11];
    }

    /**
     * Método usado para adicionar um filme a lista de filmes.
     * @param posicao posição que o filme deve ser adicionado.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde pode assistir ao filme.
     * @return 'POSIÇÃO INVÁLIDA' se posição passada for fora do intervalo de 0 a 99, 'FILME JÁ ADICIONADO' se filme
     * passado já tiver sido adicionado e 'FILME INVÁLIDO' caso passe um local ou um nome vazio.
     */
    public String addFilme(int posicao, String nome, int ano, String local) {
        Filme novofilme = new Filme(nome, ano, local);
        if (posicao < 1 || posicao > 100) {
            return "POSIÇÃO INVÁLIDA";
        }
        for (Filme filme : filmes) {
            if (filme != null && filme.equals(novofilme)) {
                return "FILME JÁ ADICIONADO";
            }
        }
        if (local.isEmpty() || nome.isEmpty()) {
            return "FILME INVÁLIDO";
        }
        filmes[posicao] = novofilme;
        return "FILME ADICIONADO";
    }

    /**
     * Retorna uma _String_ contendo todos os filmes adicionados.
     * @return _String_ que contém todos os filmes adicionados.
     */
    public String mostrarFilmes() {
        String saida = "";
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                saida += i + " - " + filmes[i].getNome() + "\n";
            }
        }
        if (saida.isEmpty()) {
            return "LISTA DE FILMES VAZIA!";
        }
        return saida;
    }

    /**
     * Retorna a representação textual de um filme.
     * @param posicao posição do filme.
     * @return representação textual do filme. _Emoji_ adicionado aos detalhes se filme estiver em hotlist.
     */
    public String detalharFilme(int posicao) {
        if (filmes[posicao] == null) {
            return "POSIÇÃO INVÁLIDA";
        }
        for (int i = 0; i < 11; i++) {
            if (hotList[i] != null & filmes[posicao].equals(hotList[i])) {
                return "\uD83D\uDD25 " + filmes[posicao].toString();
            }
        }
        return filmes[posicao].toString();
    }

    /**
     * Retorna uma _String_ contendo todos os filmes que já foram adicionados a hotlist.
     * @return _String_ representado os filmes adicionados a hotlist caso haja pelo menos 1 filme, ou
     * "HOTLIST VAZIA!" caso não existam filmes na hotlist.
     */
    public String exibirHotList() {
        String saida = "";
        for (int i = 0; i < hotList.length; i++) {
            if (hotList[i] != null) {
                saida += i + " - " + hotList[i].getNome() + ", " + hotList[i].getAno() + "\n";
            }
        }
        if (saida.isEmpty()) {
            return "HOTLIST VAZIA!";
        }
        return saida;
    }

    /**
     * Adiciona um filme a HotList.
     * Não adiciona se esse filme já existir na hotlist.
     * @param posicaoFilme Posição do filme que se quer adicionar a HotList.
     * @param posicaoHotlist Posição da HotList que se deve adicionar o filme.
     * @return "FILME JÁ ESTÁ NA HOTLIST!" caso filme já tenha sido adicionado anteriormente,
     * ou "ADICIONADO À HOTLIST NA POSIÇÃO X!" caso posição seja válida, com X sendo a posição,
     * ou "POSIÇÃO INVÁLIDA" se não existir filme naquela posição.
     */
    public String atribuirHot(int posicaoFilme, int posicaoHotlist) {
        if (filmes[posicaoFilme] == null){
            return "POSIÇÃO INVÁLIDA";
        }
        for (int i = 0; i < hotList.length; i++) {
            if (hotList[i] != null && hotList[i].equals(hotList[posicaoFilme])) {
                return "FILME JÁ ESTÁ NA HOTLIST!";
            }
        }
        hotList[posicaoHotlist] = filmes[posicaoFilme];
        return "ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHotlist + "!";
    }

    /**
     * Remove um filme da HotList.
     * @param posicao Posição do filme na HotList.
     * @return "FILME NÃO EXISTEA" se a posição estiver vazia, ou "FILME NÃO ESTAVA NA HOTLIST",
     * ou "FILME REMOVIDO DA HOTLIST" caso a posição seja válida.
     */
    public String removerHot(int posicao) {
        if (filmes[posicao] == null) {
            return "FILME NÃO EXISTE!";
        }
        for (int i = 0; i < hotList.length; i++) {
            if (hotList[i] != null && hotList[i].equals(filmes[posicao])) {
                hotList[i] = null;
                return "FILME REMOVIDO DA HOTLIST";
            }
        }
        return "FILME NÃO ESTAVA NA HOTLIST";
    }
}