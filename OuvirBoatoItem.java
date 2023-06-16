import java.util.*;

public class OuvirBoatoItem extends Item{
    
    public OuvirBoatoItem(int tipo, String nome, Posicao posicao){
        super(tipo, nome, posicao);
    }

    public void usar(Setor casa[][], LinkedList<FakeNews> FakeNewsList, Jogador jogador, Posicao pos, Scanner scan){
        GeradorAleatorio rand = new GeradorAleatorio();

        rand.setAleatorio(8);
        jogador.movimentar(1 + rand.getAleatorio());
    }
}
