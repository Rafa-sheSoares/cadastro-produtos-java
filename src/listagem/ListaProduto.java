package listagem;

import cadastro.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaProduto {
        private static final ArrayList<Produto> produtos = new ArrayList<>();

        public void adicionar(Produto produto) {
            produtos.add(produto);
        }

        public List<Produto> listarTodos() {
            Collections.sort(produtos);
            return new ArrayList<>(produtos);
        }
    }

