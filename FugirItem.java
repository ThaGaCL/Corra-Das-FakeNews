import java.util.*;

public class FugirItem extends Item{
    
    private final int TAB_BORDA_MIN = 0;
    private final int TAB_BORDA_MAX = 8;

    public FugirItem(int tipo, String nome, Posicao posicao){
        super(tipo, nome, posicao);
    }

    @Override
    public void usar(Setor casa[][], LinkedList<FakeNews> FakeNewsList, Jogador jogador, Posicao pos, Scanner scan){
        int xNovo, yNovo;
        int x = pos.getX();
        int y = pos.getY();
        
        System.out.println("Para qual casa você deseja Fugir?");
        System.out.print("X: ");
        xNovo = scan.nextInt();

        System.out.print("Y: ");
        yNovo = scan.nextInt();

        Posicao posNova = new Posicao(xNovo, yNovo);
        if(!verificaCasa(casa, posNova)){
            casa[xNovo][yNovo].setJogador(jogador);
            jogador.setPosicao(posNova);
            casa[x][y].setJogador(null);
        }
        else{
            System.out.println("Esta casa já esta ocupada!");
            this.usar(casa, FakeNewsList, jogador, pos, scan);
        }
    }

    public boolean verificaCasa(Setor casa[][], Posicao concatPos){
        return (concatPos.getX() < TAB_BORDA_MIN || concatPos.getX() > TAB_BORDA_MAX 
        || concatPos.getY() < TAB_BORDA_MIN || concatPos.getY() > TAB_BORDA_MAX
        || (casa[concatPos.getX()][concatPos.getY()].getFakeNews() != null)
        || (casa[concatPos.getX()][concatPos.getY()].getJogador() != null)
        || (casa[concatPos.getX()][concatPos.getY()].isRestrito() != false)
        || (casa[concatPos.getX()][concatPos.getY()].getItem() != null));
    }
    
}
