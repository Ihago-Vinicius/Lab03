import java.util.ArrayList;
import java.util.List;

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
     * Retorna um Array de Strings contendo todos os filmes adicionados.
     * @return Array de Strings que contém todos os filmes adicionados
     */
    public String[] mostrarFilmes() {
        List<String> listaDeFilmesAdicionados = new ArrayList<>();
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                listaDeFilmesAdicionados.add(i + " - " + filmes[i].getNome());
            }
        }
        return listaDeFilmesAdicionados.toArray(new String[0]);
    }

    /**
     * Retorna a representação textual de um filme.
     * @param posicao posição do filme.
     * @return representação textual do filme. Emoji adicionado se filme estiver em hotlist.
     */
    public String detalharFilme(int posicao) {
        for (int i = 0; i < 11; i++) {
            if (hotList[i] != null) {
                if (filmes[posicao].equals(hotList[i])) {
                    return "\uD83D\uDD25 " + filmes[posicao].toString();
                }
            }
        }
        if (filmes[posicao] != null) {
            return filmes[posicao].toString();
        }
        else{
            return "FILME NÃO EXISTE!";
        }
    }

    /**
     * Retorna um Array de Strings contendo todos os filmes que já foram adicionados a hotlist.
     * @return Array de Strings dos filmes adicionados a hotlist.
     */
    public String[] exibirHotList() {
    List<String> filmesAdicionadosAHotList = new ArrayList<>();
    for (int i = 0; i < hotList.length; i ++) {
        if (hotList[i] != null) {
                filmesAdicionadosAHotList.add(i + " - " + hotList[i].getNome());
        }
    }
    if (filmesAdicionadosAHotList.isEmpty()) {
        filmesAdicionadosAHotList.add("HOTLIST VAZIA!");
    }
    return filmesAdicionadosAHotList.toArray(new String[0]);
    }

    /**
     * Adiciona um filme a HotList.
     * Não adiciona se esse filme já existir na hotlist.
     * @param posicaoFilme Posição do filme que se quer adicionar a HotList.
     * @param posicaoHotlist Posição da HotList que se deve adicionar o filme.
     * @return "FILME JÁ ESTÁ NA HOTLIST!" caso filme já tenha sido adicionado anteriormente,
     * ou "ADICIONADO À HOTLIST NA POSIÇÃO X!" caso posição seja válida, com X sendo a posição.
     */
    public String atribuirHot(int posicaoFilme, int posicaoHotlist) {
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
     * @return "POSIÇÃO INVÁLIDA" se a posição estiver vazia ou não corresponder a uma posição existente na hotlist,
     * ou "FILME REMOVIDO DA HOTLIST" caso a posição seja válida.
     */
    public String removerHot(int posicao) {
        if (posicao < 1 || posicao > 10 || hotList[posicao] == null) {
            return "POSIÇÃO INVÁLIDA";
        }
        else {
            hotList[posicao] = null;
            return "FILME REMOVIDO DA HOTLIST";
        }
    }
}