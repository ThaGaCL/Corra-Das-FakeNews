import java.util.*;

public class DenunciarFakeNewsItem extends Item{

    public DenunciarFakeNewsItem(int tipo, String nome, Posicao posicao){
        super(tipo, nome, posicao);
    }

    @Override
    public void usar(){
        System.out.println("Você usou o item 'Denuciar Fake News'!");
    }

    public void usar(ArrayList<FakeNews> fakeNewsList){
        
    }
}
