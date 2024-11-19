package kitanda.repository;

import kitanda.model.Produto;

public interface ProdutoInterface {

    public void procurarPorNumero(int numero);

    public void listarTodos();

    public void cadastrar(Produto produto);

    public void atualizar(Produto produto);

    public void excluir(int numero);

}
