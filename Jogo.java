import java.util.*;

public class Jogo {
    // Constantes
    private final int TAM_TAB = 9;
    private final int TAB_BORDA_MIN = 0;
    private final int TAB_BORDA_MAX = 8;
    private final int NUM_INIT_FAKE_NEWS = 6;
    private final int NUM_INIT_SETOR_PRIVADO = 4;
    private final int NUM_INIT_ITEM = 2;
    private final int DELAY = 2000;

    // Atributos
    private LinkedList<Jogador> jogadoresList;
    private LinkedList<FakeNews> fakeNewsList;
    private ArrayList<Item> itemList;
    private Posicao[] posicoes;
    private Scanner input;

    // Construtor
    public Jogo() {
        jogadoresList = new LinkedList<>();
        fakeNewsList = new LinkedList<>();
        itemList = new ArrayList<>();
        posicoes = new Posicao[4];
        input = new Scanner(System.in);
    }

    // Getters e Setters
    public LinkedList<Jogador> getJogadoresList() {
        return jogadoresList;
    }

    public void setJogadoresList(LinkedList<Jogador> jogadoresList) {
        this.jogadoresList = jogadoresList;
    }

    public LinkedList<FakeNews> getFakeNewsList() {
        return fakeNewsList;
    }

    public void setFakeNewsList(LinkedList<FakeNews> fakeNewsList) {
        this.fakeNewsList = fakeNewsList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public Posicao[] getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(Posicao[] posicoes) {
        this.posicoes = posicoes;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
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
        int linha, coluna;

        for (int i = 0; i < NUM_INIT_FAKE_NEWS; i++) {

            // Verificar se a posição já está ocupada por um jogador ou fakenews
            do{
                randPosX.setAleatorio(7);
                randPosY.setAleatorio(7);
                linha = randPosX.getAleatorio();
                coluna = randPosY.getAleatorio();
                concatPos = new Posicao(linha + 1, coluna + 1);
            }while (verificaCasa(casa, concatPos));

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
        int linha, coluna;

        for (int i = 0; i < NUM_INIT_SETOR_PRIVADO; i++) {

            // Verificar se a posição já está ocupada por um jogador, fake news ou é restrita
            do{
                randPosX.setAleatorio(TAM_TAB);
                randPosY.setAleatorio(TAM_TAB);
                linha = randPosX.getAleatorio();
                coluna = randPosY.getAleatorio();
                concatPos = new Posicao(linha, coluna);
            }while(verificaCasa(casa, concatPos));

            casa[concatPos.getX()][concatPos.getY()].setRestrito(true);
        }
    }

    public void inicializaItem(Setor[][] casa, boolean itemColetado) {
        GeradorAleatorio randPosX = new GeradorAleatorio();
        GeradorAleatorio randPosY = new GeradorAleatorio();
        GeradorAleatorio randTipo = new GeradorAleatorio();
        int linha, coluna, quantItemInit;
        Posicao concatPos;

        randTipo.setAleatorio(4);

        //Diferencia inicialização de item de invocação de item
        if(itemColetado == true)
            quantItemInit = 1;
        else
            quantItemInit = NUM_INIT_ITEM;


        for (int i = 0; i < quantItemInit; i++) {

            // Verificar se a posição já está ocupada por um jogador, fake news, é restrita ou possui item
            do{
                randPosX.setAleatorio(TAM_TAB);
                randPosY.setAleatorio(TAM_TAB);
                linha = randPosX.getAleatorio();
                coluna = randPosY.getAleatorio();
                concatPos = new Posicao(linha, coluna);
            }while (verificaCasa(casa, concatPos));

            //Cria um tipo de item aleatório
            switch (randTipo.getAleatorio()) {
                case 0:
                    itemList.add(new DenunciarFakeNewsItem(1, "Denunciar FakeNews",concatPos));
                    break;
                case 1:
                    itemList.add(new FugirItem(2, "Fugir", concatPos));
                    break;
                case 2:
                    itemList.add(new LerNoticiaRealItem(3, "Ler Notícia Real", concatPos));
                    break;
                case 3:
                    itemList.add(new OuvirBoatoItem(4, "Ouvir Boato", concatPos));
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
        || (casa[concatPos.getX()][concatPos.getY()].isRestrito() != false)
        || (casa[concatPos.getX()][concatPos.getY()].getItem() != null));
    }
    
    public void atualizarFakeNews(Tabuleiro tabuleiro, Setor[][] casa, InterfaceTerminal terminal) {
        LinkedList<FakeNews> fakeNewsListAux = new LinkedList<FakeNews>();
        Iterator<FakeNews> iterator = fakeNewsList.iterator();
        GeradorAleatorio rand = new GeradorAleatorio();
        
        if(fakeNewsList.isEmpty() == true){
            String msgVitoria = "Os Jogadores eliminaram todas as FakeNews, Parabéns!";
            terminal.limpaTerminal();
            terminal.vitoria(msgVitoria);
            System.exit(0);
        }

        while (iterator.hasNext()) {
            FakeNews fakeNews = iterator.next();
            Posicao antigaPosicao; 
            Posicao novaPosicao;

            // Impede movimento sem deslocamento de casa
            do{
                antigaPosicao = fakeNews.getPosicao();
                rand.setAleatorio(4);
                fakeNews.movimentar(rand.getAleatorio());
                novaPosicao = fakeNews.getPosicao();
            }while(antigaPosicao.getY() == novaPosicao.getY() && antigaPosicao.getX() == novaPosicao.getX());

            // Informa o movimento de cada FakeNews
            System.out.print("\n\n");
            System.out.println(fakeNews.getNome() + ": " + "(" + antigaPosicao.getX() + ", " + antigaPosicao.getY() + ")" + " ---> " + "(" + novaPosicao.getX() + ", " + novaPosicao.getY() + ")");

            //Eliminação de fakenews por sair do tabuleiro
            if ((novaPosicao.getX() > TAB_BORDA_MAX || novaPosicao.getX() < TAB_BORDA_MIN) || (novaPosicao.getY() > TAB_BORDA_MAX || novaPosicao.getY() < TAB_BORDA_MIN)){
                eliminaFakeNews(casa, iterator, antigaPosicao);
                
                System.out.println("A Fake News " + fakeNews.getNome() + " foi eliminada por sair do tabuleiro!");
            }

            //Eliminação de fakenews por entrar em setor privado
            else if (casa[novaPosicao.getX()][novaPosicao.getY()].isRestrito() != false) {
                eliminaFakeNews(casa, iterator, novaPosicao);
                
                System.out.println("A Fake News " + fakeNews.getNome() + " foi eliminada por entrar em setor privado!");
            }

            //Eliminação de fakenews por colisão
            else if (casa[novaPosicao.getX()][novaPosicao.getY()].getFakeNews() != null) {
                eliminaFakeNews(casa, iterator, antigaPosicao);
                
                System.out.println("A Fake News " + fakeNews.getNome() + " foi eliminada por colidir com outra FakeNews!");
            }

            //Duplicação de fakenews por pegar item
            else if (casa[novaPosicao.getX()][novaPosicao.getY()].getItem() != null) {
                Posicao posDup;
                GeradorAleatorio posAdjX = new GeradorAleatorio();
                GeradorAleatorio posAdjY = new GeradorAleatorio();
                Item itemNome = casa[novaPosicao.getX()][novaPosicao.getY()].getItem();
                FakeNews fakeNewsDup;
                
                //Remove item do tabuleiro
                casa[novaPosicao.getX()][novaPosicao.getY()].setItem(null);
                itemList.remove(itemNome);
            
                casa[novaPosicao.getX()][novaPosicao.getY()].setFakeNews(fakeNews);
            
                posAdjX.setAleatorio(3);
                posAdjY.setAleatorio(3);

                do{
                    posAdjX.setAleatorio(3);
                    posAdjY.setAleatorio(3);

                    int offsetX = posAdjX.getAleatorio() - 1;
                    int offsetY = posAdjY.getAleatorio() - 1;
                    posDup = new Posicao(novaPosicao.getX() + offsetX, novaPosicao.getY() + offsetY);
                }while(posDup.equals(novaPosicao) || verificaCasa(casa, posDup));
                
                //Cria uma lista auxiliar para fakenews duplicadas e concatena na principal
                fakeNewsDup = new FakeNews(posDup, fakeNews.getNome());
                casa[posDup.getX()][posDup.getY()].setFakeNews(fakeNewsDup);
                fakeNewsListAux.addAll(fakeNewsListAux);

                this.inicializaItem(casa, true);
                
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
            
            terminal.limpaTerminal();
            tabuleiro.desenhaTabuleiro(casa);
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

        if(jogadoresList.isEmpty() == true){
            String msgDerrota = "Todos os jogadores foram eliminados!";
            terminal.limpaTerminal();
            terminal.derrota(msgDerrota);
            System.exit(0);
        }
        
        while (iterator.hasNext()) {
            int move;
            Jogador jogador;
            
            jogador = iterator.next();

            move = this.desenhaCaixas(terminal, jogador);
            
            if(move == 1){
                Posicao posAntiga, posNova;
                int direcao;
                
                do{
                    terminal.caixaMovimento();
                    direcao = input.nextInt();
                }while(direcao > 5);

                // Movimentação comum do jogador
                if(jogador.getItens().isEmpty() || jogador.getItens().getFirst().getTipo() != 4){
                    posAntiga = jogador.getPosicao();
                    jogador.movimentar(direcao);
                    posNova = jogador.getPosicao();
                }

                // Movimentação em caso de Ouvir Boato
                else{
                    Item item = jogador.getItens().getFirst();
                    OuvirBoatoItem oB = (OuvirBoatoItem) item;
                    System.out.print("O movimento escolhido pelo Jogador " + jogador.getNome() + " não foi respeitado e foi aleatorizado!");
                    posAntiga = jogador.getPosicao();
                    oB.usar(casa, fakeNewsList, jogador, jogador.getPosicao(), input);
                    posNova = jogador.getPosicao();
                    jogador.removerItem(oB);
                }
                
                //Caso jogador saia do tabuleiro
                if((posNova.getX() > TAB_BORDA_MAX || posNova.getX() < TAB_BORDA_MIN) || (posNova.getY() > TAB_BORDA_MAX || posNova.getY() < TAB_BORDA_MIN)){
                    casa[posAntiga.getX()][posAntiga.getY()].setJogador(null);
                    iterator.remove();
                    
                    System.out.println("O jogador " + jogador.getNome() + " foi eliminado por se desviar de sua jornada!");
                }

                //Caso jogador entre em setor privado
                else if (casa[posNova.getX()][posNova.getY()].isRestrito() != false){
                    casa[posNova.getX()][posNova.getY()].setJogador(null);
                    iterator.remove();
                    
                    System.out.println("O jogador " + jogador.getNome() + " foi eliminado por andar em setor privado!");
                }

                //Caso jogador colida com FakeNews
                else if (casa[posNova.getX()][posNova.getY()].getFakeNews() != null) {
                    casa[posNova.getX()][posNova.getY()].setJogador(null);
                    iterator.remove();

                    System.out.println("O jogador " + jogador.getNome() + " foi eliminado por confiar em FakeNews!");
                }

                //Caso jogador pegue um item
                else if (casa[posNova.getX()][posNova.getY()].getItem() != null) {
                    Item itemNome = casa[posNova.getX()][posNova.getY()].getItem();
                    casa[posNova.getX()][posNova.getY()].setItem(null);
                    itemList.remove(itemNome);
                    
                    casa[posNova.getX()][posNova.getY()].setJogador(jogador);
                    
                    jogador.adicionarItem(itemNome);
                    if(itemNome.getTipo() == 4){
                        System.out.println("Oh não! O jogador ouviu um boato, seu próximo movimento será aleatório!");
                    }
                    else
                        System.out.println("O jogador recebeu o direito de " + itemNome.getNome());

                    this.inicializaItem(casa, true); //Spawna novo item no tabuleiro
                }
                else{
                    casa[posNova.getX()][posNova.getY()].setJogador(jogador);
                }
                casa[posAntiga.getX()][posAntiga.getY()].setJogador(null);

                System.out.print("\n\n");
                System.out.println(jogador.getNome() + ": " + "(" + posAntiga.getX() + ", " + posAntiga.getY() + ")" + " ---> " + "(" + posNova.getX() + ", " + posNova.getY() + ")");
                terminal.limpaTerminal();
                tabuleiro.desenhaTabuleiro(casa);
            }
            else if (move == 2) {
                int acao;
                int quantDenun = 0;
                int quantFugir = 0;
                int quantLerReal = 0;
                
                //Contador
                for (Item item : jogador.getItens()) {
                    if (item.getTipo() == 1){
                        quantDenun++;
                    }
                    else if (item.getTipo() == 2){
                        quantFugir++;
                    }
                    else if (item.getTipo() == 3){
                        quantLerReal++;
                    }
                }
                
                
                boolean possuiItem = false; // Variável para verificar se o jogador possui um item válido
                do{
                    terminal.caixaAcao(quantDenun, quantFugir, quantLerReal);
                    
                    //Executa ação escolhida
                    acao = input.nextInt();
                    switch (acao) {
                        case 1:
                            for (Item item : jogador.getItens()) {
                                    if (item instanceof DenunciarFakeNewsItem) {
                                        DenunciarFakeNewsItem dFN = (DenunciarFakeNewsItem) item;
                                        dFN.usar(casa, fakeNewsList, jogador, jogador.getPosicao(), input);
                                        jogador.removerItem(dFN);
                                        possuiItem = true; // O jogador possui um item válido
                                    }
                                }
                            break;
                        case 2:
                            for (Item item : jogador.getItens()) {
                                if (item instanceof FugirItem) {
                                    FugirItem F = (FugirItem) item;
                                    F.usar(casa, fakeNewsList, jogador, jogador.getPosicao(), input);
                                    jogador.removerItem(F);
                                    possuiItem = true; // O jogador possui um item válido
                                }
                            }
                            break;
                        case 3:
                            for (Item item : jogador.getItens()) {
                                    if (item instanceof LerNoticiaRealItem) {
                                        LerNoticiaRealItem lNR = (LerNoticiaRealItem) item;
                                        lNR.usar(casa, fakeNewsList, jogador, jogador.getPosicao(), input);
                                        jogador.removerItem(lNR);
                                        possuiItem = true; // O jogador possui um item válido
                                    }
                                }
                            break;
                        case 4:
                            break;
                        }  
                        if(possuiItem == false)              
                            System.out.println("Você não possui nenhum item desse tipo");
                
                }while(possuiItem == false); 

                tabuleiro.desenhaTabuleiro(casa);
            }
        }
    }

    public int desenhaCaixas(InterfaceTerminal terminal, Jogador jogador){
        System.out.print(Cores.ANSI_WHITE + "\n\n É a vez de: " + jogador.getNome() + "\n\n" + Cores.ANSI_RESET);

        terminal.caixaSelecaoMove();
        if(jogador.getItens().size() > 0 && jogador.getItens().getFirst().getTipo() != 4)
            terminal.caixaSelecaoAcao();
            
        return input.nextInt();
    }

    
    public void encerrarLeitura(){
        input.close();
    }
}
