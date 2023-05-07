public class Tabuleiro
{

    int tamanho;

    public Tabuleiro(){
        this.tamanho = 9;
    }

    public void desenhaTabuleiro(){
        System.out.println(Cores.ANSI_WHITE + "+---+---+---+---+---+---+---+---+---+" + Cores.ANSI_RESET);

    }
}