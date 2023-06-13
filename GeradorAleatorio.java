import java.util.Random;

public class GeradorAleatorio {
    
    //Atributos
    int aleatorio;

    //Construtor
    public GeradorAleatorio(){}
    
    //Métodos get/set
    public int getAleatorio(){
        return this.aleatorio;
    }
    
    public void setAleatorio(int num){
        Random random = new Random();
        this.aleatorio = random.nextInt(num);
    }

}
