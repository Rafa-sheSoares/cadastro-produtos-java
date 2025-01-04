package telas;
import cadastro.Produto;
import listagem.ListaProduto;
import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private final ListaProduto repository;
    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtValor;
    private JComboBox<String> cbDisponivel;
    private TelaLista telaListagem;

    public TelaCadastro(ListaProduto repository) {
        this.repository = repository;
        configurarTela();
    }

    private void configurarTela() {
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        add(txtDescricao);

        add(new JLabel("Valor:"));
        txtValor = new JTextField();
        add(txtValor);

        add(new JLabel("Disponível:"));
        cbDisponivel = new JComboBox<>(new String[]{"Sim", "Não"});
        add(cbDisponivel);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarProduto());
        add(btnSalvar);

        setLocationRelativeTo(null);
    }

    private void salvarProduto() {
        try {
            String nome = txtNome.getText();
            String descricao = txtDescricao.getText();
            double valor = Double.parseDouble(txtValor.getText());
            boolean disponivel = cbDisponivel.getSelectedItem().equals("Sim");

            Produto novoProduto = new Produto(nome, descricao, valor, disponivel);
            repository.adicionar(novoProduto);

            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
            dispose();

            if (telaListagem != null) {
                telaListagem.atualizarTabela();
                telaListagem.setVisible(true);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setTelaListagem(TelaLista telaListagem) {
        this.telaListagem = telaListagem;
    }
}
