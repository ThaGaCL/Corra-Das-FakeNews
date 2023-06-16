public class Tabuleiro {

    private static final int TAM = 9;

    //Construtor 
    public Tabuleiro(Setor casa[][]){
        for(int i = 0; i < TAM; i++){
            for(int j = 0; j < TAM; j++){
                Posicao posicao = new Posicao(i, j);
                casa[i][j] = new Setor(posicao, false);
           }
        }
    }

    //Outros métodos
    public void desenhaTabuleiro(Setor casa[][]) {
        for (int j = 0; j < TAM; j++) {
            System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
            for (int i = 0; i < TAM; i++) {
                System.out.print(Cores.ANSI_WHITE + "| " + Cores.ANSI_RESET);
                if (casa[i][j].getJogador() != null) {
                    System.out.print(Cores.ANSI_GREEN + casa[i][j].getJogador().getNome() + " " + Cores.ANSI_RESET);
                } else if (casa[i][j].getFakeNews() != null) {
                    System.out.print(Cores.ANSI_RED + casa[i][j].getFakeNews().getNome() + " " + Cores.ANSI_RESET);
                } else if (casa[i][j].isRestrito() == true) {
                    System.out.print(Cores.ANSI_WHITE + "XX" + " " + Cores.ANSI_RESET);
                } else if (casa[i][j].getItem() != null) {
                    System.out.print(Cores.ANSI_YELLOW + "??" + " " + Cores.ANSI_RESET);
                } else {
                    System.out.print(Cores.ANSI_WHITE + "   " + Cores.ANSI_RESET);
                }
            }
            System.out.print(Cores.ANSI_WHITE + "|" + Cores.ANSI_RESET);
            System.out.println(Cores.ANSI_WHITE + " 0" + j + Cores.ANSI_RESET);
        }
        System.out.println(Cores.ANSI_WHITE + "+----+----+----+----+----+----+----+----+----+" + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_WHITE + "  00   01   02   03   04   05   06   07   08  " + Cores.ANSI_RESET);
    }    
}
