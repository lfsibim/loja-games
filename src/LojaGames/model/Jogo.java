package LojaGames.model;

public class Jogo extends Produto{

    private int classIndicativa;
    private String genero;

    public Jogo(int id, int tipo, String nome, String marca, float preco, int classIndicativa, String genero) {
        super(id, tipo, nome, marca, preco);
        this.classIndicativa = classIndicativa;
        this.genero = genero;
    }

    public int getClassIndicativa() {
        return classIndicativa;
    }

    public void setClassIndicativa(int classIndicativa) {
        this.classIndicativa = classIndicativa;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public void visualizar(){
        super.visualizar();
        System.out.printf("\nGênero: %s\nClassificação: +%d\nPreço: %.2f\n" +
                        "----------------------------",this.getGenero(),
                this.getClassIndicativa(), this.getPreco());
    }
}
