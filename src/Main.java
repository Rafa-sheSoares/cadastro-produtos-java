import listagem.ListaProduto;
import telas.TelaLista;

public class Main {
    public static void main(String[] args) {
        ListaProduto repository = new ListaProduto();
        TelaLista telaListagem = new TelaLista(repository);
        telaListagem.setVisible(true);
    }
}
