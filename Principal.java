public class Principal {
    public static void main(String[] args) {

        InterfaceTerminal terminal = new InterfaceTerminal();
        Audio audio = new Audio();
        Setor casa[][] = new Setor[9][9];
        Jogo jogo = new Jogo();
        Tabuleiro tabuleiro = new Tabuleiro(casa);
        
        audio.tocarSom("Undertale_FallenDown.wav");

        terminal.menuInicializacao();
        jogo.inicializaJogador(terminal, casa);
        jogo.inicializaFakeNews(casa);
        jogo.inicializaSetor(casa);
        jogo.inicializaItem(casa);
        jogo.limpaTerminal();
        tabuleiro.desenhaTabuleiro(casa);
        jogo.atualizarJogadores(tabuleiro, casa, terminal, true);
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
        jogo.atualizarJogadores(tabuleiro, casa, terminal, true);
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
        jogo.atualizarJogadores(tabuleiro, casa, terminal, true);
        jogo.encerrarLeitura();
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
        jogo.atualizaFakeNews(tabuleiro, casa);
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
        jogo.atualizaFakeNews(tabuleiro, casa);
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
        jogo.atualizaFakeNews(tabuleiro, casa);
    }
}
