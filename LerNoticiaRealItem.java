import java.util.*;

public class LerNoticiaRealItem extends Item{

    public LerNoticiaRealItem(int tipo, String nome, Posicao posicao){
        super(tipo, nome, posicao);
    }

    @Override
    public void usar(Setor casa[][], LinkedList<FakeNews> FakeNewsList, Jogador jogador, Posicao pos, Scanner scan){
        int x, y;
        FakeNews fNAux;
        System.out.println("Qual a posição da FakeNews que você deseja eliminar?");
        System.out.print("X: ");
        x = scan.nextInt();

        System.out.print("Y: ");
        y = scan.nextInt();

        if((fNAux = casa[x][y].getFakeNews()) != null){
            casa[x][y].setFakeNews(null);
            FakeNewsList.remove(fNAux);
        }
        else{
            System.out.println("Não há nenhuma FakeNews nesta posição, escolha outra!");
            this.usar(casa, FakeNewsList, jogador, pos, scan);
        }
    }

}