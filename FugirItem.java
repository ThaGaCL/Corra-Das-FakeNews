import java.util.*;

public class FugirItem extends Item{
    
    private final int TAB_BORDA_MIN = 0;
    private final int TAB_BORDA_MAX = 8;

    public FugirItem(int tipo, String nome, Posicao posicao){
        super(tipo, nome, posicao);
    }

    public void usar(Setor casa[][], ArrayList<FakeNews> FakeNewsList, Jogador jogador, Posicao pos){
        Scanner input = new Scanner(System.in);
        int xNovo, yNovo;
        int x = jogador.getPosicao().getX();
        int y = jogador.getPosicao().getY();
        
        System.out.println("Para qual casa você deseja Fugir?");
        System.out.print("X: ");
        xNovo = input.nextInt();
        System.out.print("Y: ");
        yNovo = input.nextInt();
        Posicao posNova = new Posicao(xNovo, yNovo);

        if(!verificaCasa(casa, posNova)){
            casa[x][y].setJogador(null);
            casa[xNovo][yNovo].setJogador(jogador);
        }
        else{
            System.out.println("Esta casa já esta ocupada!");
            this.usar(casa, FakeNewsList, jogador, pos);
        }
    }

    public boolean verificaCasa(Setor casa[][], Posicao concatPos){
        return (concatPos.getX() < TAB_BORDA_MIN || concatPos.getX() > TAB_BORDA_MAX 
        || concatPos.getY() < TAB_BORDA_MIN || concatPos.getY() > TAB_BORDA_MAX
        || (casa[concatPos.getX()][concatPos.getY()].getFakeNews() != null)
        || (casa[concatPos.getX()][concatPos.getY()].getJogador() != null)
        || (casa[concatPos.getX()][concatPos.getY()].getRestrito() != false)
        || (casa[concatPos.getX()][concatPos.getY()].getItem() != null));
    }
    
}
