public class FakeNews implements Movimento{
    
    //Atributos
    private String nome;
    private Posicao posicao;

    //Construtor
    public FakeNews(Posicao posicao, String nome){
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

    //Outros métodos
    public void movimentar(int movimento){
        if(getNome().equals("F1")){
            switch(movimento){
                case 0:
                    movimentarNorte();
                    break;
                case 1:
                    movimentarSul();
                    break;
                case 2:
                    movimentarLeste();
                    break;
                case 3:
                    movimentarOeste();
                    break;
            }
        }
        else if(getNome().equals("F2")){
            switch(movimento){
                case 0:
                    movimentarNorte();
                    movimentarNorte();
                    break;
                case 1:
                    movimentarSul();
                    movimentarSul();
                    break;
                case 2:
                    movimentarLeste();
                    movimentarLeste();
                    break;
                case 3:
                    movimentarOeste();
                    movimentarOeste();
                    break;
            }
        }
        else if(getNome().equals("F3")){
            switch(movimento){
                case 0:
                    movimentarNoroeste();
                    break;
                case 1:
                    movimentarNordeste();
                    break;
                case 2:
                    movimentarSudoeste();
                    break;
                case 3:
                    movimentarSudeste();
                    break;
            }
        }
    }

    public void movimentarNorte() {
        Posicao novaPosicao = new Posicao(getPosicao().getX(), getPosicao().getY() - 1);
        setPosicao(novaPosicao);
    }

    public void movimentarSul(){
        Posicao novaPosicao = new Posicao(getPosicao().getX(), getPosicao().getY() + 1);
        setPosicao(novaPosicao);
    }

    public void movimentarLeste(){
        Posicao novaPosicao = new Posicao(getPosicao().getX() + 1, getPosicao().getY());
        setPosicao(novaPosicao);
    }

    public void movimentarOeste(){
        Posicao novaPosicao = new Posicao(getPosicao().getX() - 1, getPosicao().getY());
        setPosicao(novaPosicao);
    }

    public void movimentarNoroeste(){
        Posicao novaPosicao = new Posicao(getPosicao().getX() - 1, getPosicao().getY() - 1);
        setPosicao(novaPosicao);
    }

    public void movimentarNordeste(){
        Posicao novaPosicao = new Posicao(getPosicao().getX() + 1, getPosicao().getY() - 1);
        setPosicao(novaPosicao);
    }

    public void movimentarSudoeste(){
        Posicao novaPosicao = new Posicao(getPosicao().getX() - 1, getPosicao().getY() + 1);
        setPosicao(novaPosicao);
    }

    public void movimentarSudeste(){
        Posicao novaPosicao = new Posicao(getPosicao().getX() + 1, getPosicao().getY() + 1);
        setPosicao(novaPosicao);
    }
}
