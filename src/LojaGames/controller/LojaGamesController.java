package LojaGames.controller;

import LojaGames.model.Produto;
import LojaGames.repository.LojaGamesRepository;

import java.util.ArrayList;

public class LojaGamesController implements LojaGamesRepository {

    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    int id = 0;

    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
    }

    @Override
    public void listarTodos() {
        for(var item:listaProdutos){
            item.visualizar();
        }
    }

    @Override
    public Produto buscarPorId(int id) {
        for(Produto item:listaProdutos){
            if(item.getId() == id){
                item.visualizar();
                return item;
            }
        }
        System.out.printf("\nO ID %d não foi encontrado.\n",id);
        return null;
    }

    @Override
    public Produto atualizar(int id, Produto produto) {
        for(Produto item:listaProdutos){
            if(item.getId() == id){
                return listaProdutos.set(listaProdutos.indexOf(item), produto);
            }
        }
        System.out.printf("\nO ID %d não foi encontrado.\n",id);
        return null;
    }

    @Override
    public void deletar(int id) {
        for(Produto item:listaProdutos){
            if(item.getId() == id){
                listaProdutos.remove(item);
                System.out.printf("\nO item %s foi removido com sucesso.",item.getNome());
                return;
            }
        }
        System.out.printf("\nO item de ID %d não foi encontrado.",id);
    }

    public int gerarId(){
        return ++ id;
    }
}
