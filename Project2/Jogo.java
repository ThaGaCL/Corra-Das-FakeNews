import java.util.*;

public class Jogo {
    // Constantes
    private final int TAM_TAB = 9;
    private final int TAB_BORDA_MIN = 0;
    private final int TAB_BORDA_MAX = 8;
    private final int NUM_INIT_FAKE_NEWS = 6;
    private final int NUM_INIT_SETOR_PRIVADO = 4;
    private final int NUM_INIT_ITEM = 10;
    private final int DELAY = 000;

    // Atributos
    private List<Jogador> jogadoresList;
    private List<FakeNews> fakeNewsList;
    private List<Item> itemList;
    private Posicao[] posicoes;

    // Construtor
    public Jogo() {
        jogadoresList = new ArrayList<>();
        fakeNewsList = new ArrayList<>();
        itemList = new ArrayList<>();
        posicoes = new Posicao[4];
    }

    // Métodos get/set
    public Jogador getJogador(int ind) {
        return jogadoresList.get(ind);
    }

    public void setJogador(Jogador jogador, int ind) {
        jogadoresList.set(ind, jogador);
    }

    public void inicializaJogador(InterfaceTerminal terminal, Setor[][] casa) {
        posicoes[0] = new Posicao(4, 0);
        posicoes[1] = new Posicao(8, 4);
        posicoes[2] = new Posicao(4, 8);
        posicoes[3] = new Posicao(0, 4);

        int numjogadores = terminal.getNumJogadores();
        for (int i = 0; i < numjogadores; i++) {
            Jogador jogador = new Jogador(posicoes[i], "J" + (i + 1));
            jogadoresList.add(jogador);
            casa[posicoes[i].getX()][posicoes[i].getY()].setJogador(jogador);
        }
    }

    public void inicializaFakeNews(Setor[][] casa) {
        GeradorAleatorio randPosX = new GeradorAleatorio();
        GeradorAleatorio randPosY = new GeradorAleatorio();
        Posicao concatPos;

        for (int i = 0; i < NUM_INIT_FAKE_NEWS; i++) {
            randPosX.setAleatorio(7);
            randPosY.setAleatorio(7);

            int linha = randPosX.getAleatorio();
            int coluna = randPosY.getAleatorio();

            concatPos = new Posicao(linha + 1, coluna + 1);

            // Verificar se a posição já está ocupada por um jogador ou fakenews
            while (verificaCasa(casa, concatPos)) {
                randPosX.setAleatorio(7);
                randPosY.setAleatorio(7);
                linha = randPosX.getAleatorio();
                coluna = randPosY.getAleatorio();
                concatPos = new Posicao(linha + 1, coluna + 1);
            }

            int tipo = i % 3 + 1;
            FakeNews fakeNews = new FakeNews(concatPos, "F" + tipo);
            fakeNewsList.add(fakeNews);

            casa[fakeNews.getPosicao().getX()][fakeNews.getPosicao().getY()].setFakeNews(fakeNews);
        }
    }

    public void inicializaSetor(Setor[][] casa) {
        GeradorAleatorio randPosX = new GeradorAleatorio();
        GeradorAleatorio randPosY = new GeradorAleatorio();
        Posicao concatPos;

        for (int i = 0; i < NUM_INIT_SETOR_PRIVADO; i++) {
            randPosX.setAleatorio(TAM_TAB);
            randPosY.setAleatorio(TAM_TAB);

            int linha = randPosX.getAleatorio();
            int coluna = randPosY.getAleatorio();

            concatPos = new Posicao(linha, coluna);

            // Verificar se a posição já está ocupada por um jogador, fake news ou é restrita
            while (verificaCasa(casa, concatPos)) {
                randPosX.setAleatorio(TAM_TAB);
                randPosY.setAleatorio(TAM_TAB);
                linha = randPosX.getAleatorio();
                coluna = randPosY.getAleatorio();
                concatPos = new Posicao(linha, coluna);
            }

            casa[concatPos.getX()][concatPos.getY()].setRestrito(true);
        }
    }

    public void inicializaItem(Setor[][] casa) {
        GeradorAleatorio randPosX = new GeradorAleatorio();
        GeradorAleatorio randPosY = new GeradorAleatorio();
        GeradorAleatorio randTipo = new GeradorAleatorio();
        Posicao concatPos;

        for (int i = 0; i < NUM_INIT_ITEM; i++) {
            randPosX.setAleatorio(TAM_TAB);
            randPosY.setAleatorio(TAM_TAB);
            randTipo.setAleatorio(4);

            int linha = randPosX.getAleatorio();
            int coluna = randPosY.getAleatorio();

            concatPos = new Posicao(linha, coluna);

            // Verificar se a posição já está ocupada por um jogador, fake news, é restrita ou possui item
            while (verificaCasa(casa, concatPos)) {
                randPosX.setAleatorio(TAM_TAB);
                randPosY.setAleatorio(TAM_TAB);
                linha = randPosX.getAleatorio();
                coluna = randPosY.getAleatorio();
                concatPos = new Posicao(linha, coluna);
            }

            switch (randTipo.getAleatorio()) {
                case 0:
                    itemList.add(new DenunciarFakeNewsItem("Denunciar Fake News", concatPos));
                    break;
                case 1:
                    itemList.add(new FugirItem("Fugir", concatPos));
                    break;
                case 2:
                    itemList.add(new LerNoticiaRealItem("Ler Notícia Real", concatPos));
                    break;
                case 3:
                    itemList.add(new OuvirBoatoItem("Ouvir Boato", concatPos));
                    break;
                default:
                    break;
            }
            casa[concatPos.getX()][concatPos.getY()].setItem(itemList.get(i));
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
    
    public void atualizaFakeNews(Tabuleiro tabuleiro, Setor[][] casa) {
        ArrayList<FakeNews> fakeNewsListAux = new ArrayList<FakeNews>();
        Iterator<FakeNews> iterator = fakeNewsList.iterator();
        GeradorAleatorio rand = new GeradorAleatorio();
        
        while (iterator.hasNext()) {
            FakeNews fakeNews = iterator.next();

            Posicao antigaPosicao = fakeNews.getPosicao();
            rand.setAleatorio(4);
            fakeNews.movimentar(rand.getAleatorio());
            Posicao novaPosicao = fakeNews.getPosicao();

            // impede movimento sem deslocamento de casa
            while (antigaPosicao.getY() == novaPosicao.getY() && antigaPosicao.getX() == novaPosicao.getX()) {
                antigaPosicao = fakeNews.getPosicao();
                rand.setAleatorio(4);
                fakeNews.movimentar(rand.getAleatorio());
                novaPosicao = fakeNews.getPosicao();
            }

            // Informa o movimento de cada FakeNews
            System.out.print("\n\n");
            System.out.println(fakeNews.getNome() + ": " + "(" + antigaPosicao.getX() + ", " + antigaPosicao.getY() + ")" + " ---> " + "(" + novaPosicao.getX() + ", " + novaPosicao.getY() + ")");

            //Eliminação de fakenews por sair do tabuleiro
            if ((novaPosicao.getX() > TAB_BORDA_MAX || novaPosicao.getX() < TAB_BORDA_MIN) || (novaPosicao.getY() > TAB_BORDA_MAX || novaPosicao.getY() < TAB_BORDA_MIN)){
                eliminaFakeNews(casa, iterator, antigaPosicao);
                
                System.out.println("A Fake News " + fakeNews.getNome() + " foi eliminada por sair do tabuleiro!");
            }

            //Eliminação de fakenews por entrar em setor privado
            else if (casa[novaPosicao.getX()][novaPosicao.getY()].getRestrito() != false) {
                eliminaFakeNews(casa, iterator, novaPosicao);
                
                System.out.println("A Fake News " + fakeNews.getNome() + " foi eliminada por entrar em setor privado!");
            }

            //Eliminiação de fakenews por colisão
            else if (casa[novaPosicao.getX()][novaPosicao.getY()].getFakeNews() != null) {
                eliminaFakeNews(casa, iterator, antigaPosicao);
                
                System.out.println("A Fake News " + fakeNews.getNome() + " foi eliminada por colidir com outra FakeNews!");
            }

            //Duplicação de fakenews por pegar item
            else if (casa[novaPosicao.getX()][novaPosicao.getY()].getItem() != null) {
                GeradorAleatorio posAdjX = new GeradorAleatorio();
                GeradorAleatorio posAdjY = new GeradorAleatorio();
                Item itemNome = casa[novaPosicao.getX()][novaPosicao.getY()].getItem();
                FakeNews fakeNewsDup;
                
                casa[novaPosicao.getX()][novaPosicao.getY()].setItem(null);
                itemList.remove(itemNome);
            
                casa[novaPosicao.getX()][novaPosicao.getY()].setFakeNews(fakeNews);
            
                posAdjX.setAleatorio(3);
                posAdjY.setAleatorio(3);
            
                int offsetX = posAdjX.getAleatorio() - 1;
                int offsetY = posAdjY.getAleatorio() - 1;
                Posicao posDup = new Posicao(novaPosicao.getX() + offsetX, novaPosicao.getY() + offsetY);

                while(posDup.equals(novaPosicao) || verificaCasa(casa, posDup)){
                    posAdjX.setAleatorio(3);
                    posAdjY.setAleatorio(3);

                    offsetX = posAdjX.getAleatorio() - 1;
                    offsetY = posAdjY.getAleatorio() - 1;
                    posDup = new Posicao(novaPosicao.getX() + offsetX, novaPosicao.getY() + offsetY);
                }
                fakeNewsDup = new FakeNews(posDup, fakeNews.getNome());
                casa[posDup.getX()][posDup.getY()].setFakeNews(fakeNewsDup);
                fakeNewsListAux.add(fakeNewsDup);
                
                System.out.println("A Fake News " + fakeNewsDup.getNome() + " foi duplicada em " + "(" + fakeNewsDup.getPosicao().getX() + "," + fakeNewsDup.getPosicao().getY() + ")" + " por pegar um item!");
            }
            
            
            //Eliminação de jogador pela fakenews
            else if (casa[novaPosicao.getX()][novaPosicao.getY()].getJogador() != null) {
                Jogador jogadorNome = casa[novaPosicao.getX()][novaPosicao.getY()].getJogador();
                eliminaJogador(casa, novaPosicao, jogadorNome);
                casa[novaPosicao.getX()][novaPosicao.getY()].setFakeNews(fakeNews);
                System.out.println("O Jogador " + jogadorNome.getNome() + " foi eliminado pela FakeNews " + fakeNews.getNome() + "!");
            }
            
            //Movimenta a fakenews realocando sua posição e apagando a antiga
            else {
                casa[novaPosicao.getX()][novaPosicao.getY()].setFakeNews(fakeNews);
            }
            casa[antigaPosicao.getX()][antigaPosicao.getY()].setFakeNews(null);
            
            // Intervalo de 2 segundos entre cada movimentação de FakeNews
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            tabuleiro.desenhaTabuleiro(casa);
        }
        fakeNewsList.addAll(fakeNewsListAux);
        for (FakeNews fakeNews : new ArrayList<>(fakeNewsList)) {
            if (fakeNewsList.contains(fakeNews)) {
                System.out.println(fakeNews.getNome() + " (" + fakeNews.getPosicao().getX() + "," + fakeNews.getPosicao().getY() + ")");
            }
        }
    }

    public void eliminaFakeNews(Setor casa[][], Iterator<FakeNews> iterator, Posicao posicao){
        casa[posicao.getX()][posicao.getY()].setFakeNews(null);
        iterator.remove();
    }

    public void eliminaJogador(Setor casa[][], Posicao posicao, Jogador jogadorNome){
        casa[posicao.getX()][posicao.getY()].setJogador(null);
        jogadoresList.remove(jogadorNome);
    }
    
    public void atualizarJogadores(Tabuleiro tabuleiro, Setor[][] casa, InterfaceTerminal terminal){
        Iterator<Jogador> iterator = jogadoresList.iterator();
        Scanner input = new Scanner(System.in);
        while (iterator.hasNext()) {
            int move;
            Jogador jogador = iterator.next();

            System.out.print(Cores.ANSI_WHITE + "É a vez de: " + jogador.getNome() + "\n\n" + Cores.ANSI_RESET);
            terminal.caixaSelecao();
            move = input.nextInt();

            if(move == 1){
                Posicao posAntiga, posNova;
                int direcao;

                terminal.caixaMovimento();
                direcao = input.nextInt();

                posAntiga = jogador.getPosicao();
                jogador.movimentar(direcao);
                posNova = jogador.getPosicao();

                while(casa[posNova.getX()][posNova.getY()].getJogador() != null) {
                    System.out.println("Esta casa ja está ocupada por outro jogador, escolha outra!");
                    terminal.caixaMovimento();
                    direcao = input.nextInt();
    
                    posAntiga = jogador.getPosicao();
                    jogador.movimentar(direcao);
                    posNova = jogador.getPosicao();
                }


                System.out.print("\n\n");
                System.out.println(jogador.getNome() + ": " + "(" + posAntiga.getX() + ", " + posAntiga.getY() + ")" + " ---> " + "(" + posNova.getX() + ", " + posNova.getY() + ")");

                if((posNova.getX() > TAB_BORDA_MAX || posNova.getX() < TAB_BORDA_MIN) || (posNova.getY() > TAB_BORDA_MAX || posNova.getY() < TAB_BORDA_MIN)){
                    casa[posAntiga.getX()][posAntiga.getY()].setJogador(null);
                    iterator.remove();

                    System.out.println("O jogador " + jogador.getNome() + " foi eliminado por se desviar de sua jornada!");
                }
                else if (casa[posNova.getX()][posNova.getY()].getRestrito() != false){
                    casa[posNova.getX()][posNova.getY()].setJogador(null);
                    iterator.remove();

                    System.out.println("O jogador " + jogador.getNome() + " foi eliminado por andar em setor privado!");
                }
                else if (casa[posNova.getX()][posNova.getY()].getFakeNews() != null) {
                    casa[posNova.getX()][posNova.getY()].setJogador(null);
                    iterator.remove();

                    System.out.println("O jogador " + jogador.getNome() + " foi eliminado por confiar em FakeNews!");
                }
                else if (casa[posNova.getX()][posNova.getY()].getItem() != null) {
                    Item itemNome = casa[posNova.getX()][posNova.getY()].getItem();
                    casa[posNova.getX()][posNova.getY()].setItem(null);
                    itemList.remove(itemNome);

                    casa[posNova.getX()][posNova.getY()].setJogador(jogador);

                    jogador.adicionarItem(itemNome);
                    if(itemNome.getNome().equals("Ouvir Boato"))
                        System.out.println("Oh não! O jogador ouviu um boato, seu próximo movimento será aleatório!");
                    else
                        System.out.println("O jogador recebeu o direito de " + itemNome.getNome());

                    

                }
                else{
                    casa[posNova.getX()][posNova.getY()].setJogador(jogador);
                }
                casa[posAntiga.getX()][posAntiga.getY()].setJogador(null);

            }
            else{
                int acao;
                terminal.caixaAcao();
                acao = input.nextInt();
            }

            tabuleiro.desenhaTabuleiro(casa);
        }
        input.close();
    }
}
