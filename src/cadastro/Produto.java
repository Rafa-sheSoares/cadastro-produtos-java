package cadastro;

public class Produto implements Comparable<Produto> {
    private String nome;
    private String descricao;
    private double valor;
    private boolean disponivel;

    public Produto(String nome, String descricao, double valor, boolean disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public boolean isDisponivel() { return disponivel; }

    @Override
    public int compareTo(Produto outro) {
        return Double.compare(this.valor, outro.valor);
    }
}

