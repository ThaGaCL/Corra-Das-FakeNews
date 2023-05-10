import java.util.Random;
import java.util.Scanner;

public class Principal
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogador[] jogadores = new Jogador[4];
        jogadores[0] = new Jogador(0, 4, "J1");
        jogadores[1] = new Jogador(4, 8, "J2");
        jogadores[2] = new Jogador(8, 4, "J3");
        jogadores[3] = new Jogador(4, 0, "J4"); 

        Restrito[] restritos = new Restrito[4];

        // Cada restrito é inicializado com uma posição aleatória
        Random random = new Random();
        for(int i = 0; i < 4; i++){
            int linha = random.nextInt(9);
            int coluna = random.nextInt(9);

            while((linha == 0 && coluna == 4)||(linha == 4 && coluna == 8)||(linha == 8 && coluna == 4)||(linha == 4 && coluna == 0)){
                linha = random.nextInt(9);
                coluna = random.nextInt(9);
            }

            restritos[i] = new Restrito(linha, coluna);
        }

        Fake[] fakes = new Fake[6];
        for(int i = 0; i < 6; i++){
            int linha = random.nextInt(9);
            int coluna = random.nextInt(9);

            while((linha == 0 && coluna == 4)||(linha == 4 && coluna == 8)||(linha == 8 && coluna == 4)||(linha == 4 && coluna == 0)||(linha == restritos[0].linha && coluna == restritos[0].coluna)||(linha == restritos[1].linha && coluna == restritos[1].coluna)||(linha == restritos[2].linha && coluna == restritos[2].coluna)||(linha == restritos[3].linha && coluna == restritos[3].coluna)){
                linha = random.nextInt(9);
                coluna = random.nextInt(9);
            }

            fakes[i] = new Fake(linha, coluna);

            
        }

        fakes[0].setNome("E1");
        fakes[1].setNome("E2");
        fakes[2].setNome("E3");
        fakes[3].setNome("E1");
        fakes[4].setNome("E2");
        fakes[5].setNome("E3");

        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.inicializaJogadores(jogadores);
        tabuleiro.inicializaRestritos(restritos);
        tabuleiro.inicializaFakes(fakes);
        tabuleiro.desenhaTabuleiro();

        int jogadorAtual = 0;
        int rodadas = 0;

        while(rodadas < 20){
            if(jogadorAtual > 3)
                jogadorAtual = 0;
            
            System.out.println("Jogador atual: " + jogadores[jogadorAtual].nome);
            System.out.println("Digite 1 para mover para cima, 2 para mover para esquerda, 3 para mover para baixo e 4 para mover para direita");
            int opcao = scanner.nextInt();
            int linhaAnterior = jogadores[jogadorAtual].linha;
            int colunaAnterior = jogadores[jogadorAtual].coluna;


            switch(opcao){
                case 1:
                    jogadores[jogadorAtual].moveCima();
                    break;
                case 2:
                    jogadores[jogadorAtual].moveEsquerda();
                    break;
                case 3:
                    jogadores[jogadorAtual].moveBaixo();
                    break;
                case 4:
                    jogadores[jogadorAtual].moveDireita();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break; 

            }

            tabuleiro.atualizaJogador(jogadores[jogadorAtual], linhaAnterior, colunaAnterior);
            tabuleiro.desenhaTabuleiro();
            rodadas++;
            jogadorAtual++;
        }

        scanner.close();

    }
}