public class Principal {
    public static void main(String[] args) {

        InterfaceTerminal terminal = new InterfaceTerminal();
        Setor casa[][] = new Setor[9][9];
        Jogo jogo = new Jogo();
        Tabuleiro tabuleiro = new Tabuleiro(casa);
        
        terminal.menuInicializacao();
        jogo.inicializaJogador(terminal, casa);
        jogo.inicializaFakeNews(casa);
        jogo.inicializaSetor(casa);
        jogo.inicializaItem(casa);
        tabuleiro.desenhaTabuleiro(casa);
        jogo.atualizaFakeNews(tabuleiro, casa);
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
        jogo.atualizaFakeNews(tabuleiro, casa);
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
        jogo.atualizaFakeNews(tabuleiro, casa);
        jogo.atualizarJogadores(tabuleiro, casa, terminal);
    }
}
