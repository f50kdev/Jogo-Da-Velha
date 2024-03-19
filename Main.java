import com.jogoDaVelha.JogoDaVelha;
import com.valores.Valores;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  
        JogoDaVelha jogoDaVelha = new JogoDaVelha();

        boolean jogada;
        int i = 0;      // Valor inicial do loop - while;
        int[] valoresArmazenados = new int[9];
        Valores[] valore = Valores.values();

        Valores[][] velha = {{Valores.EMPTY, Valores.EMPTY, Valores.EMPTY}, {Valores.EMPTY, Valores.EMPTY, Valores.EMPTY},  // Valores iniciais a serem apresentados
                {Valores.EMPTY, Valores.EMPTY, Valores.EMPTY}};                                                             // no em todas as posiçõoes;

        //  Este é um método Static que apresenta a tabela a cada modificação;
        mostrandoTabela(velha);

        while ( i < valoresArmazenados.length) {                                            // Toda a jogada é feita neste loop, permitindo apenas 9 jogada;
                                                                                            // só increnta o "i" se a jogada for aceitavel na posição que ainda não foi jogada
            System.out.print("Qual posição?\nPosição: ");                                   // se a posição inserida já tiver um valor o loop congela no tempo( increta 0 no "i", mantendo assim a mesma posição enquanto não receber uma posição correta
            int posicao = scanner.nextInt();                                        // Faz a leitura da posição

            jogoDaVelha.setJogoDaVelha(velha, i, posicao, valoresArmazenados);
            jogada = jogoDaVelha.verificandoJogada();

            if (jogada == true) {
                System.out.printf("%nValor nesta posição(%d) já foi feito, joga em uma outra posição...%n", jogoDaVelha.getPosicao());
                System.out.println();
                i += 0;
                continue;
            } else {
                i++;
                jogoDaVelha.Escolha();
            }

            jogoDaVelha.setTest(Valores.O);
            if ((jogoDaVelha.vitoria1() == 3) || (jogoDaVelha.vitoria2() == 3) || (jogoDaVelha.vitoria3() == 3) || (jogoDaVelha.vitoria4() == 3)) {
                mostrandoTabela(velha);
                System.out.printf("Vencedor: %s%n", jogoDaVelha.getTest());
                break;
            }

            jogoDaVelha.setTest(Valores.X);
            if ((jogoDaVelha.vitoria1() == 3) || (jogoDaVelha.vitoria2() == 3) || (jogoDaVelha.vitoria3() == 3) || (jogoDaVelha.vitoria4() == 3)){
                mostrandoTabela(velha);
                System.out.printf("%nVencedor: %s%n", jogoDaVelha.getTest());
                break;
            }

            //  Este é um método Static que apresenta a tabela a cada modificação;
            mostrandoTabela(velha);
        }
    }

    //  Este é um método Static que apresenta a tabela a cada modificação;
    public static void mostrandoTabela(Valores[][] velha){
        System.out.println();
        for (int counter = 0; counter < 3; counter++) {                 // Apresenta a tábela como se fosse
            for (int j = 0; j < 3; j++) {                               // uma matriz do tipo três por três
                System.out.printf("%5s  ", velha[counter][j]);
            }
            System.out.println();                                       // Sempre que apresenta três iterações pula
        }                                                               // para outra linha;
        System.out.println();
    }
}
