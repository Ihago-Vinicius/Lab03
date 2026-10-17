import java.util.Objects;

public class Filme {
    /** Nome do filme.*/
    private String nome;
    /** Ano de lançamento do filme.*/
    private int ano;
    /** Local que o filme está disponível para assistir.*/
    private String local;

    /**
     * Construtora de Filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento.
     * @param local Local onde está disponível para assistir.
     */
    public Filme(String nome, int ano, String local) {
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    /**
     * Retorna o nome do filme.
     * @return Nome do filme.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o ano que o filme foi lançado.
     * @return Ano de lançamento.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Representação textual da classe.
     * @return Representação em String.
     */
    public String toString() {
        return nome + ", " + ano + "\n" + local;
    }

    /**
     * Override de equals para se filmes são iguais.
     * @param obj   the reference object with which to compare.
     * @return True se fore, iguais, false se forem diferentes
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() ) {
            return false;
        }
        Filme outrofilme = (Filme) obj;
        return Objects.equals(this.nome, outrofilme.getNome()) && this.ano == outrofilme.getAno();
    }

    /**
     * Override de hashCode para apontar para cada filme de acordo com os seus identificadores.
     * @return inteiro correspondente.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, ano);
    }

}