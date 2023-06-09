public abstract class Item {
    
    private String nome;
    private Posicao posicao;

    public Item(String nome, Posicao posicao){
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

    public void setPosicao(Posicao posicao){
        this.posicao = posicao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public abstract void usar();

}
