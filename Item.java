public abstract class Item {
    
    private int tipo;
    private String nome;
    private Posicao posicao;

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

    public abstract void usar();

}
