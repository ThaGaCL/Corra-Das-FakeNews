import java.util.*;

public class Jogador implements Movimento{

    //Atributos
    private String nome;
    private Posicao posicao;
    private List<Item> itens;

    //Construtor
    public Jogador(Posicao pos, String nome){
        this.setNome(nome);
        this.setPosicao(pos);
        this.setItens(new ArrayList<Item>());
    }

    //Métodos get/set
    public Posicao getPosicao(){
        return this.posicao;
    }

    public Collection<Item> getItens(){
        return this.itens;
    }

    public String getNome(){
        return this.nome;
    }

    public void setPosicao(Posicao pos){
        this.posicao = pos;
    }

    public void setItens(List<Item> itens){
        this.itens = itens;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    //Outros métodos
    public void adicionarItem(Item item){
        itens.add(item);
    }

    public int quantItem(int indice){
        return itens.size();
    }

    public Item buscarItem(int indice){
        return itens.get(indice);
    }

    public void removerItem(Item item){
        itens.remove(item);
    }

    public void movimentar(){
        
    }
}