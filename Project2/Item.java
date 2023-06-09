public abstract class Item {
    
    private Posicao posicao;

    public Item(Posicao posicao){
        this.setPosicao(posicao);
    }

    //Métodos get/set
    public Posicao getPosicao(){
        return this.posicao;
    }

    public void setPosicao(Posicao posicao){
        this.posicao = posicao;
    }

    public abstract void usar();

}
