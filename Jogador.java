public class Jogador extends Peca {
    public String nome;

    public Jogador(int linha, int coluna, String nome){
        this.linha = linha;
        this.coluna = coluna;
        this.nome = nome;
    }

    public void inicializaJogadores(Jogador[] jogadores){
        jogadores[0] = new Jogador(0, 4, "J1");
        jogadores[1] = new Jogador(4, 8, "J2");
        jogadores[2] = new Jogador(8, 4, "J3");
        jogadores[3] = new Jogador(4, 0, "J4"); 

    }

    public void moveCima(){
        if(this.linha > 0)
            this.linha--;
    }

    public void moveEsquerda(){
        if(this.coluna > 0)
            this.coluna--;
    }

    public void moveBaixo(){
        if(this.linha < 8)
            this.linha++;
    }

    public void moveDireita(){
        if(this.coluna < 8)
            this.coluna++;
    }

}
