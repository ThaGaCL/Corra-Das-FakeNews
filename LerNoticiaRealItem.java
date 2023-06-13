import java.util.*;

public class LerNoticiaRealItem extends Item{

    public LerNoticiaRealItem(int tipo, String nome, Posicao posicao){
        super(tipo, nome, posicao);
    }

    @Override
    public void usar(){
        System.out.println("Você usou o item 'Ler Notícia Real'!");
    }

    public void usar(Setor casa[][], Posicao posicao, ArrayList<FakeNews> fakeNewsList, FakeNews fakenews){
        casa[posicao.getX()][posicao.getY()].setFakeNews(null);
        fakeNewsList.remove(fakenews);
    }

}