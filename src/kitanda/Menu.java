package kitanda;

import kitanda.controller.ProdutoController;
import kitanda.model.CestaFruta;
import kitanda.model.Produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoController produtos = new ProdutoController();

        //Produto produto = new Produto(1, 45.60f);
        //produto.visualizar();

        int opcao, numero;
        float preco;
        String frutas;

        while (true) {

            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                         KITANDA                     ");
            System.out.println("            Frutas frescas, saúde na sua mesa!       ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Cesta de Frutas                ");
            System.out.println("            2 - Listar Todas as Cestas               ");
            System.out.println("            3 - Buscar Cesta por Número              ");
            System.out.println("            4 - Atualizar da Cesta                   ");
            System.out.println("            5 - Apagar Cesta                         ");
            System.out.println("            6 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     ");

            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                sc.nextLine();
                opcao = 0;
            }

            if (opcao == 6) {
                System.out.println("\nKITANDA - Frutas frescas, saúde na sua mesa!");
                sobre();
                sc.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Monte sua cesta");
                    System.out.println("Digite o nome da fruta: ");
                    sc.skip("\\R?");
                    frutas = sc.nextLine();
                    System.out.println("Digite o número da Cesta: ");
                    numero = sc.nextInt();
                    System.out.println("Digite o Valor da Cesta: ");
                    preco = sc.nextFloat();

                    produtos.cadastrar(new CestaFruta(numero, preco, frutas));

                    keyPress();
                    break;
                case 2:
                    System.out.println("Listar todas as Cestas de Frutas\n");
                    produtos.listarTodos();

                    keyPress();
                    break;
                case 3:
                    System.out.println("Buscar dados da Cesta de Frutas - por número\n");
                    numero = sc.nextInt();
                    produtos.procurarPorNumero(numero);

                    keyPress();
                    break;
                case 4:
                    System.out.println("Atualizar dados da Conta\n");
                    System.out.println("Digite o número da Cesta de fruta: ");
                    numero = sc.nextInt();
                    var buscarProduto = produtos.buscarNaCollection(numero);
                    if (buscarProduto != null) {
                        System.out.println("Digite o nome das Frutas: ");
                        sc.skip("\\R?");
                        frutas = sc.nextLine();
                        System.out.println("Digite o preço da Cesta: ");
                        preco = sc.nextFloat();
                        produtos.atualizar(new CestaFruta(numero, preco, frutas));
                    } else {
                        System.out.println("Cesta não encontrada!");
                    }

                    keyPress();
                    break;
                case 5:
                    System.out.println("Apagar a Conta\n");
                    System.out.println("Digite o número da Cesta de Frutas: ");
                    numero = sc.nextInt();
                    produtos.excluir(numero);

                    keyPress();
                    break;
                default:
                    System.out.println("\nOpção inválida!\n");
                    keyPress();
                    break;

            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: ");
        System.out.println("Contato: blancasuarz@gmail.com");
        System.out.println("https://github.com/biancasuarz");
        System.out.println("https://github.com/mozartCuman");
        System.out.println("https://github.com/IJNavi");
        System.out.println("https://github.com/Ninaraquel");
        System.out.println("https://github.com/Martinelii");
        System.out.println("https://github.com/fany-santos8");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println("\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {

            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
