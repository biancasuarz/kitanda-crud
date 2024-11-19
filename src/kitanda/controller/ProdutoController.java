package kitanda.controller;

import kitanda.model.Produto;
import kitanda.repository.ProdutoInterface;

import java.util.ArrayList;

public class ProdutoController implements ProdutoInterface {

    private ArrayList<Produto> listaProdutos = new ArrayList<>();

    public Produto buscarNaCollection(int numero) {
        for (var produto : listaProdutos) {
            if (produto.getNumero() == numero) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void procurarPorNumero(int numero) {
        var produto = buscarNaCollection(numero);
        if (produto != null) {
            produto.visualizar();
        } else {
            System.out.println("O produto número: " + numero + " não foi encontrado");
        }
    }

    @Override
    public void listarTodos() {
        for (var produto : listaProdutos) {
            produto.visualizar();
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("\nProduto " + produto.getNumero() + " Cadastrado com sucesso!");
    }

    @Override
    public void atualizar(Produto produto) {
        var procurar = buscarNaCollection(produto.getNumero());
        if (procurar != null) {
            listaProdutos.set(listaProdutos.indexOf(procurar), produto);
            System.out.println("\nProduto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    @Override
    public void excluir(int numero) {
        var produto = buscarNaCollection(numero);
        if (produto != null) {
            if (listaProdutos.remove(produto) == true) {
                System.out.println("Cesta: " + numero + " excluída com sucesso!");
            }
        } else {
            System.out.println("A cesta: " + numero + " não foi encontrada.");
        }
    }
}
