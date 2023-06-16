public class Principal {

    private static final int NUM_TURNOS = 20;
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
        jogo.inicializaItem(casa, false);
        terminal.limpaTerminal();
        tabuleiro.desenhaTabuleiro(casa);
        for (int i = 0; i < NUM_TURNOS / 2; i++) {
            int turno = (i * 2) + 1;
            terminal.turnoDaVez(turno);
            jogo.atualizarJogadores(tabuleiro, casa, terminal);
        
            turno = (i * 2) + 2;
            terminal.turnoDaVez(turno);
            jogo.atualizarFakeNews(tabuleiro, casa, terminal);
        }
        String msgDerrota = "Os jogadores não conseguiram eliminar todas as FakeNews!";
        terminal.derrota(msgDerrota);

    }
}
