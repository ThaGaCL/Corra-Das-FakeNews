import java.util.Scanner;

public class InterfaceTerminal {
    
    //Atributos
    private Scanner input = new Scanner(System.in);
    private int numJogadores;

    //Construtor
    public InterfaceTerminal(){
        this.setNumJogadores(0);
    }

    //Métodos get/set
    public int getNumJogadores(){
        return this.numJogadores;
    }
    
    public void setNumJogadores(int numJogadores){
        if(numJogadores > 0 && numJogadores <= 4)
            this.numJogadores = numJogadores;
    }

    //Outros métodos
    public void menuInicializacao(){
        System.out.print(Cores.ANSI_CYAN + "\n##Bem Vindo Ao Jogo 'Corra das Fake News'!##\n\n");

        System.out.print(Cores.ANSI_CYAN + " ----------------------------- \n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "         1 Jogador           " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + " ----------------------------- \n" + Cores.ANSI_RESET);

        System.out.print(Cores.ANSI_CYAN + " ----------------------------- \n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "         2 Jogadores         " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + " ----------------------------- \n" + Cores.ANSI_RESET);

        System.out.print(Cores.ANSI_CYAN + " ----------------------------- \n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "         3 Jogadores         " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + " ----------------------------- \n" + Cores.ANSI_RESET);

        System.out.print(Cores.ANSI_CYAN + " ----------------------------- \n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "         4 Jogadores         " + Cores.ANSI_CYAN +  "|\n");
        System.out.print(Cores.ANSI_CYAN + " ----------------------------- \n\n" + Cores.ANSI_RESET);

        System.out.print("Digite uma opção: \n");

        this.setNumJogadores(input.nextInt());
        if(getNumJogadores() == 0)
            this.menuInicializacao(); 
    }

    public void caixaSelecaoMove(){
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "1    Mover         👣" + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
    }

    public void caixaSelecaoAcao(){
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "2    Ação          ⁉️ " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
    }

    public void caixaMovimento(){
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "1    Cima          ⬆️ " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);

        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "2    Baixo         ⬇️ " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);

        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "3    Direita       ➡️ " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);

        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "4    Esquerda      ⬅️ " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);

        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "5    Voltar        ↩️ " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+---------------------+\n" + Cores.ANSI_RESET);
    }

    public void caixaAcao(int quantDenun, int quantFugir, int quantLerReal){
        System.out.print(Cores.ANSI_CYAN + "+-----------------------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "1    Denunciar FakeNews       ⚠️  " + quantDenun + "x" + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+-----------------------------------+\n" + Cores.ANSI_RESET);
    
        System.out.print(Cores.ANSI_CYAN + "+-----------------------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "2    Fugir                    💨 " + quantFugir + "x" + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+-----------------------------------+\n" + Cores.ANSI_RESET);
    
        System.out.print(Cores.ANSI_CYAN + "+-----------------------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "3    Ler Notícia Real         📰 " + quantLerReal + "x" + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+-----------------------------------+\n" + Cores.ANSI_RESET);

        System.out.print(Cores.ANSI_CYAN + "+-----------------------------------+\n" + Cores.ANSI_RESET);
        System.out.print(Cores.ANSI_CYAN + "|" + Cores.ANSI_WHITE + "4    Voltar                   ↩️    " + Cores.ANSI_CYAN + "|\n");
        System.out.print(Cores.ANSI_CYAN + "+-----------------------------------+\n" + Cores.ANSI_RESET);
    }

    public void vitoria(String msg) {
        System.out.println(Cores.ANSI_CYAN + "       _      _                   " + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "      (_)    | |                  " + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "__   ___  ___| |_ ___  _ __ _   _ " + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "\\ \\ / / |/ __| __/ _ \\| '__| | | |" + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + " \\ V /| | (__| || (_) | |  | |_| |" + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "  \\_/ |_|\\___|\\__\\___/|_|   \\__, |" + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "                             __/ |" + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "                            |___/ " + Cores.ANSI_RESET);

        System.out.println("\n" + Cores.ANSI_CYAN + msg + Cores.ANSI_RESET);
    }
    

    public void derrota(String msg){
        System.out.println(Cores.ANSI_CYAN + "  _____          __  __ ______    ______      ________ _____  " + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + " / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ " + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "| |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |" + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "| | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / " + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + "| |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ " + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_CYAN + " \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\" + Cores.ANSI_RESET);

        System.out.println("\n" + Cores.ANSI_CYAN + msg + Cores.ANSI_RESET);
    }

    public void turnoDaVez(int turno){
            if (turno >= 1 && turno <= 8)
                System.out.print(Cores.ANSI_WHITE + "\n\n Turno: " + Cores.ANSI_GREEN + turno + Cores.ANSI_WHITE + " / " + "20" + Cores.ANSI_RESET);
            else if (turno > 8 && turno < 15)
                System.out.print(Cores.ANSI_WHITE + "\n\n Turno: " + Cores.ANSI_YELLOW + turno + Cores.ANSI_WHITE + " / " + "20" + Cores.ANSI_RESET);
            else
                System.out.print(Cores.ANSI_WHITE + "\n\n Turno: " + Cores.ANSI_RED + turno + Cores.ANSI_WHITE + " / " + "20" + Cores.ANSI_RESET);
    }

    public void limpaTerminal() {
        System.out.print("\033[H\033[2J");
    }
}
