import com.jogoDaVelha.JogoDaVelha;
import com.valores.Valores;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);  
        JogoDaVelha jogoDaVelha = new JogoDaVelha();

        int i = 0;
        final int[] valoresArmazenados = new int[10];
        Valores[][] velha = {{Valores.EMPTY, Valores.EMPTY, Valores.EMPTY}, {Valores.EMPTY, Valores.EMPTY, Valores.EMPTY}, {Valores.EMPTY, Valores.EMPTY, Valores.EMPTY}};
       final Valores[] valores = {Valores.O, Valores.X};

        mostrandoTabela(velha);

        while ( i  < valoresArmazenados.length -1) {

            System.out.print("Inseri a posição: ");
            int posicao = scanner.nextInt();

            try
            {
                jogoDaVelha.setJogoDaVelha(velha, i, posicao, valoresArmazenados);

                if (jogoDaVelha.verificandoJogada()) {
                    i++;
                    jogoDaVelha.Escolha();
                }

                if (verificandoVitoria(jogoDaVelha, valores)){
                    mostrandoTabela(velha);
                    Valores valor;

                    if (jogoDaVelha.getIteracao() % 2 == 0)
                         valor = Valores.X;
                    else
                         valor = Valores.O;

                    System.out.println("Vitória: " + valor );
                    break;
                }

                mostrandoTabela(velha);

            } catch (IllegalArgumentException e){
                System.out.printf("%nErro: %s%n%n", e.getMessage());
            } catch (InputMismatchException inputMismatchException){
                System.out.printf("%nErro: %s%n%n", inputMismatchException);
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static boolean verificandoVitoria(JogoDaVelha  jogoDaVelha, Valores[] valores){

        for (Valores valore : valores) {
            jogoDaVelha.setTest(valore);
            if ((jogoDaVelha.vitoria1() == 3) || (jogoDaVelha.vitoria2() == 3) || (jogoDaVelha.vitoria3() == 3) || (jogoDaVelha.vitoria4() == 3)) {
                return true;
            }
        }
        return false;
    }

    public static void mostrandoTabela(Valores[][] velha)
    {
        System.out.println();
        for (int counter = 0; counter < 3; counter++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%5s  ", velha[counter][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
