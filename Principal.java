import java.util.Scanner;
public class Principal
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        
        tabuleiro.desenhaTabuleiro();
        scanner.close();
    }
}