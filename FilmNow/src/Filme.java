public class Filme {

    private String nome;

    private int ano;

    private String local;

    public Filme(String nome, int ano, String local) {
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome + ", " + ano + "\n" + local;
    }

    public boolean equals(Object o) {

    }

    public int hashCode() {

    }

}