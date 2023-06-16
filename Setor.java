public class Setor {

    //Atributos
    private Posicao posicao;
    private boolean restrito;
    private Item item;
    private Jogador jogador;
    private FakeNews fakenews;

    //Construtor
    public Setor(Posicao posicao, boolean restrito){
        this.setPosicao(posicao);
        this.setItem(null);
        this.setFakeNews(null);
        this.setJogador(null);
        this.setRestrito(restrito);
    }

    //Métodos get/set
    public Posicao getPosicao(){
        return this.posicao;
    }

    public boolean isRestrito(){
        return this.restrito;
    }

    public Item getItem(){
        return this.item;
    }

    public Jogador getJogador(){
        return this.jogador;
    }

    public FakeNews getFakeNews(){
        return this.fakenews;
    }

    public void setPosicao(Posicao posicao){
        this.posicao = posicao;
    }
    
    public void setRestrito(boolean restrito){
        this.restrito = restrito;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public void setJogador(Jogador jogador){
        this.jogador = jogador;
    }

    public void setFakeNews(FakeNews fakenews){
        this.fakenews = fakenews;
    }
    
}
