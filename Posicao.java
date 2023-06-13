public class Posicao {
    
    //Atributos
    private int x;
    private int y;

    //Construtor
    public Posicao(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    //Métodos get/set
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
