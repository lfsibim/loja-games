package LojaGames;

import LojaGames.controller.LojaGamesController;
import LojaGames.model.Console;
import LojaGames.model.Jogo;
import java.util.Scanner;

public class LojaGamesMain {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int op, id, tipo, capacidade, classIndicativa;
        String nome, marca, modelo, genero;
        float preco;
        LojaGamesController produto = new LojaGamesController();

        do{
            System.out.println("\n*****************************************************");
            System.out.println("*                                                   *");
            System.out.println("*                  GameStation                      *");
            System.out.println("*              Sua loja de games!!!                 *");
            System.out.println("*                                                   *");
            System.out.println("*****************************************************");
            System.out.println("*                                                   *");
            System.out.println("*            1 - Cadastrar Produto                  *");
            System.out.println("*            2 - Listar todos os Produtos           *");
            System.out.println("*            3 - Buscar Produto por ID              *");
            System.out.println("*            4 - Atualizar Dados do Produto         *");
            System.out.println("*            5 - Apagar Produto                     *");
            System.out.println("*            0 - Sair                               *");
            System.out.println("*                                                   *");
            System.out.println("*****************************************************");
            System.out.println("\nEntre com a opção desejada:                          ");
            System.out.println("                                                     ");
            op = input.nextInt();
            input.nextLine();

            switch (op){
                case 1 -> {
                    System.out.println("Cadastrar Produto\n");
                    System.out.println("Qual o tipo do Produto que irá cadastrar?\n");
                    System.out.println("Digite (1) para Console ou (2) para Jogo: ");
                    tipo = input.nextInt();
                    input.nextLine();
                    switch(tipo){
                        case 1 -> {
                            System.out.println("\nDigite o nome do Console: ");
                            nome = input.nextLine();
                            System.out.println("\nDigite a marca do Console: ");
                            marca = input.nextLine();
                            System.out.println("\nDigite o modelo do Console: ");
                            modelo = input.nextLine();
                            System.out.println("\nDigite a capacidade do console em gigabytes: ");
                            capacidade = input.nextInt();
                            System.out.println("\nDigite o preço do Console: ");
                            preco = input.nextFloat();
                            produto.cadastrar(new Console(produto.gerarId(), tipo, nome, marca, preco, modelo,
                                    capacidade));
                            System.out.println("\nConsole cadastrado com sucesso!");
                        }
                        case 2 -> {
                            System.out.println("\nDigite o nome do Jogo: ");
                            nome = input.nextLine();
                            System.out.println("\nDigite a marca do Jogo: ");
                            marca = input.nextLine();
                            System.out.println("\nDigite o gênero do Jogo: ");
                            genero = input.nextLine();
                            System.out.println("\nDigite classificação indicativa do Jogo: ");
                            classIndicativa = input.nextInt();
                            System.out.println("\nDigite o preço do Jogo: ");
                            preco = input.nextFloat();
                            produto.cadastrar(new Jogo(produto.gerarId(), tipo, nome, marca, preco, classIndicativa,
                                    genero));
                            System.out.println("\nJogo cadastrado com sucesso!");
                        }
                    }
                }
                case 2 -> {
                    produto.listarTodos();
                }
                case 3 -> {
                    System.out.println("\nDigite o ID do Produto que deseja buscar: ");
                    id = input.nextInt();
                    produto.buscarPorId(id);
                }
                case 4 -> {
                    System.out.println("\nAtualizar Produtos!");
                    System.out.println("\nDigite o ID do Produto que deseja atualizar: ");
                    id = input.nextInt();
                    System.out.println("\nDados do produto que será atualizado: ");
                    var buscarId = produto.buscarPorId(id);
                    if(buscarId != null){
                        System.out.println("\nDigite (1) para Console ou (2) para Jogo: ");
                        tipo = input.nextInt();
                        input.nextLine();
                        switch(tipo){
                            case 1 -> {
                                System.out.println("\nDigite o nome do Console: ");
                                nome = input.nextLine();
                                System.out.println("\nDigite a marca do Console: ");
                                marca = input.nextLine();
                                System.out.println("\nDigite o modelo do Console: ");
                                modelo = input.nextLine();
                                System.out.println("\nDigite a capacidade do console em gigabytes: ");
                                capacidade = input.nextInt();
                                System.out.println("\nDigite o preço do Console: ");
                                preco = input.nextFloat();
                                produto.atualizar(id, new Console(id, tipo, nome, marca, preco, modelo,
                                        capacidade));
                                System.out.println("\nConsole cadastrado com sucesso!");
                            }
                            case 2 -> {
                                System.out.println("\nDigite o nome do Jogo: ");
                                nome = input.nextLine();
                                input.nextLine();
                                System.out.println("\nDigite a marca do Jogo: ");
                                marca = input.nextLine();
                                System.out.println("\nDigite o gênero do Jogo: ");
                                genero = input.nextLine();
                                System.out.println("\nDigite classificação indicativa do Jogo: ");
                                classIndicativa = input.nextInt();
                                System.out.println("\nDigite o preço do Jogo: ");
                                preco = input.nextFloat();
                                produto.atualizar(id, new Jogo(id, tipo, nome, marca, preco,
                                        classIndicativa,
                                        genero));
                                System.out.println("\nJogo atualizado com sucesso!");
                            }
                        }
                    }
                }
                case 5 -> {
                    System.out.println("\nDigite o ID do produto que deseja excluir: ");
                    id = input.nextInt();
                    produto.deletar(id);
                    System.out.println("\nProduto excluído com sucesso!");
                }
                case 0 -> {
                    System.out.println("Encerrando programa. Obrigado por utilizar!");
                    sobre();
                }
                default -> {
                    System.out.println("Opção inválida!");
                }
            }
        }while(op != 0);
    }
    public static void sobre() {
        System.out.println("\n*************************************************");
        System.out.println("* Projeto Desenvolvido por: Luis Felipe Sibim   *");
        System.out.println("*************************************************");
    }
}
