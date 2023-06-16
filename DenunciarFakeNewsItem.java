import java.util.*;

public class DenunciarFakeNewsItem extends Item{

    public DenunciarFakeNewsItem(int tipo, String nome, Posicao posicao){
        super(tipo, nome, posicao);
    }

    @Override
    public void usar(Setor casa[][], LinkedList<FakeNews> FakeNewsList, Jogador jogador, Posicao pos, Scanner scan) {
        int x = jogador.getPosicao().getX();
        int y = jogador.getPosicao().getY();
        FakeNews fnAux;
    
        //Verifica cada posição adjacente
        if (x + 1 < 8 && (fnAux = casa[x + 1][y].getFakeNews()) != null) {
            casa[x + 1][y].setFakeNews(null);
            FakeNewsList.remove(fnAux);
        }
        if (x + 1 < 8 && y + 1 < 8 && (fnAux = casa[x + 1][y + 1].getFakeNews()) != null) {
            casa[x + 1][y + 1].setFakeNews(null);
            FakeNewsList.remove(fnAux);
        }
        if (x + 1 < 8 && y - 1 >= 0 && (fnAux = casa[x + 1][y - 1].getFakeNews()) != null) {
            casa[x + 1][y - 1].setFakeNews(null);
            FakeNewsList.remove(fnAux);
        }
        if (y + 1 < 8 && (fnAux = casa[x][y + 1].getFakeNews()) != null) {
            casa[x][y + 1].setFakeNews(null);
            FakeNewsList.remove(fnAux);
        }
        if (y - 1 >= 0 && (fnAux = casa[x][y - 1].getFakeNews()) != null) {
            casa[x][y - 1].setFakeNews(null);
            FakeNewsList.remove(fnAux);
        }
        if (x - 1 >= 0 && (fnAux = casa[x - 1][y].getFakeNews()) != null) {
            casa[x - 1][y].setFakeNews(null);
            FakeNewsList.remove(fnAux);
        }
        if (x - 1 >= 0 && y + 1 < 8 && (fnAux = casa[x - 1][y + 1].getFakeNews()) != null) {
            casa[x - 1][y + 1].setFakeNews(null);
            FakeNewsList.remove(fnAux);
        }
        if (x - 1 >= 0 && y - 1 >= 0 && (fnAux = casa[x - 1][y - 1].getFakeNews()) != null) {
            casa[x - 1][y - 1].setFakeNews(null);
            FakeNewsList.remove(fnAux);
        }
    }    
}
