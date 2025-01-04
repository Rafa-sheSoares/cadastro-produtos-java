package telas;

import cadastro.Produto;
import listagem.ListaProduto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaLista extends JFrame {
    private final ListaProduto repository;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public TelaLista(ListaProduto repository) {
        this.repository = repository;
        configurarTela();
    }

    private void configurarTela() {
        setTitle("Listagem de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        String[] colunas = {"Nome", "Valor"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JButton btnNovo = new JButton("Novo Produto");
        btnNovo.addActionListener(e -> abrirTelaCadastro());
        add(btnNovo, BorderLayout.SOUTH);

        atualizarTabela();
        setLocationRelativeTo(null);
    }

    public void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (Produto p : repository.listarTodos()) {
            modeloTabela.addRow(new Object[]{
                    p.getNome(),
                    String.format("R$ %.2f", p.getValor())
            });
        }
    }

    private void abrirTelaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro(repository);
        telaCadastro.setTelaListagem(this);
        telaCadastro.setVisible(true);
        this.setVisible(false);
    }
}
