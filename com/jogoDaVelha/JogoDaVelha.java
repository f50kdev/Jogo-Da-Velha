package com.jogoDaVelha;

import com.valores.Valores;

public class JogoDaVelha {

    private Valores test;                   // Recebe um valor do tipo enum(X ou O), para fazer a verificação de vitória, usado nos métodos vitoria1, vitoria2, vitoria3 e vitoria4
    private int iteracao;                   // Usado para saber se foi o X ou O(bola) que deve ser jodaga, veja a condição.
    private int posicao;                    // Armazena o valor da posição desejada a ser jogada, usado na estrutura de condição SWITCH
    private Valores[][] valores;
    private int[] valoresJaArmazenados = new int[9];

    public void setJogoDaVelha(Valores[][] valores, int iteracao, int posicao, int[] valoresJaArmazenados){
        this.setIteracao(iteracao);
        this.valores = valores;
        this.setPosicao(posicao);
        this.valoresJaArmazenados = valoresJaArmazenados;
    }

    public void setValores(Valores[][] valores) {
        this.valores = valores;
    }

    public Valores[][] getValores() {
        return valores;
    }

    public void setValoresJaArmazenados(int[] valoresJaArmazenados) {
        this.valoresJaArmazenados = valoresJaArmazenados;
    }

    public int[] getValoresJaArmazenados() {
        return valoresJaArmazenados;
    }

    public void setIteracao(int iteracao) {
        this.iteracao = iteracao;
    }

    public int getIteracao() {
        return iteracao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setTest(Valores test) {
        this.test = test;
    }

    public Valores getTest() {
        return test;
    }

    public void Escolha(){

        Valores valor;

        if (iteracao % 2 == 0)          // Se o valor da iteração a dividir por 2 resultar em 0(usando o operador de resto)
            valor = Valores.X;          // então o valor recebe X
        else                            // Se não
            valor = Valores.O;          // valor recebe O(bola)

        switch (posicao) {                              // Esse SWITCH recebe o valor da posição, e vai adicionando
            case 1:                                     // nessa posição do array principal o valor recebido
                valores[0][0] = valor;  break;
            case 2:
                valores[0][1] = valor;  break;
            case 3:
                valores[0][2] = valor;  break;
            case 4:
                valores[1][0] = valor;  break;
            case 5:
                valores[1][1] = valor;  break;
            case 6:
                valores[1][2] = valor;  break;
            case 7:
                valores[2][0] = valor;  break;
            case 8:
                valores[2][1] = valor;  break;
            case 9:
                valores[2][2] = valor;  break;
        }
    }

    public boolean verificandoJogada(){                                 //início do método
        boolean jogada = false;
        for (int i = 0; i < valoresJaArmazenados.length; i++) {         // Este for percorre um array de 9 iteração
            if (getPosicao() == valoresJaArmazenados[i]) {              // compara a iteração inserida e se já estivar dentro do array ele não addiciona e quebra
                jogada = true;                                          // se for verdade, adiciona true na variável "jogada"
                break;                                                  // quebra o loop For retornando no final o seu valor
            } else {                                                    // se não encontrar o valor
                valoresJaArmazenados[i] = getPosicao();                 // adiciona no array "valoresJaArmazenado"
            }
        }
        return jogada;                                                  // retona o valor depois do loop For
    }                                                                   //fim do método

    public int vitoria1(){                                      //início do método
        int vitoria = 0;
        for (int i = 0; i < 3; i++) {                           // Este método faz a verificação de todas as linhas horizontais
            for (int j = 0; j < 3; j++) {                       // começando da iteração 0 até 2. O i está para representar a linha
                if (valores[i][j] == getTest())                 // e o j para representar a coluna; isso quer dizer que a verificação será feita por coluna
                    vitoria++;                                  // enquanto a linha matem o seu valor até que tudo sejá verificado
            }
            if (vitoria == 3)                                   // Se ao sair do segundo for o valor de vitoria for 3
                break;                                          // o loop é quebrado, isso significa que houve uma vitoria
            vitoria = 0;
        }
        return vitoria;
    }                                                          //fim do método
    public int vitoria2(){                                     //início do método
        int vitoria = 0;
        for (int i = 0; i < 3; i++) {                          // Este método faz a verificação de todas as linhas verticais
            for (int j = 0; j < 3; j++) {                      // começando da iteração 0 até 2. O i está para representar a coluna
                if (valores[j][i] == getTest())                // e o j para representar a linha; isso quer dizer que a verificação será feita por linha
                    vitoria++;                                 // enquanto a coluna matem o seu valor até que tudo sejá verificado
            }
            if (vitoria == 3)                                  // Se ao sair do segundo for o valor de vitoria for 3
                break;                                         // o loop é quebrado, isso significa que houve uma vitoria
            vitoria = 0;
        }
        return vitoria;
    }                                                         //fim do método

    public int vitoria3(){                                    // início do método
        int vitoria = 0;
        for (int i = 0; i < 3; i ++) {                        // Este método testa os valores da diagonal
                if (valores[i][i] == getTest())               // principal, com X ou O, dependendo do que
                    vitoria++;                                // for passado com jogada
        }
        return vitoria;
    }                                                         // fim do método

    public int vitoria4(){                                    //início do método
        int vitoria = 0;
        for (int i = 0, j = 2; i < 3;j--, i++) {              // Este método testa os valores da diagonal
             if (valores[i][j] == getTest())                  // secundaria, com X ou O, dependendo do que
                    vitoria++;                                // for passado com jogada
        }
        return vitoria;
    }                                                          // fim do método
}

