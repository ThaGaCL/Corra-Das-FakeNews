import java.util.*;

public abstract class Item {
    
    protected int tipo;
    protected String nome;
    protected Posicao posicao;

    public Item(int tipo, String nome, Posicao posicao){
        this.setTipo(tipo);
        this.setNome(nome);
        this.setPosicao(posicao);
    }

    //Métodos get/set
    public Posicao getPosicao(){
        return this.posicao;
    }

    public String getNome(){
        return this.nome;
    }

    public int getTipo(){
        return this.tipo;
    }

    public void setPosicao(Posicao posicao){
        this.posicao = posicao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public abstract void usar(Setor casa[][], LinkedList<FakeNews> FakeNewsList, Jogador jogador, Posicao pos, Scanner scan);

}
