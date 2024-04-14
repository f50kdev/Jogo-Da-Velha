package com.jogoDaVelha;

import com.valores.Valores;

public final class JogoDaVelha {

    private Valores test;
    private int iteracao;
    private int posicao;
    private Valores[][] valores;
    private int[] valoresJaArmazenados;

    public JogoDaVelha() {
        this.test = Valores.X;
        this.iteracao = 0;
        this.posicao = 0;
        this.valores = new Valores[3][3];
        this.valoresJaArmazenados = new int[9];
    }

    public void setJogoDaVelha(Valores[][] valores, int iteracao, int posicao, int[] valoresJaArmazenados) {
        this.valores = valores;
        this.iteracao = iteracao;
        this.posicao = posicao;
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

    public void escolherJogada() {
        Valores valor;

        if (iteracao % 2 == 0) {
            valor = Valores.X;
        } else {
            valor = Valores.O;
        }

        switch (posicao) {
            case 1:
                valores[0][0] = valor;
                break;
            case 2:
                valores[0][1] = valor;
                break;
            case 3:
                valores[0][2] = valor;
                break;
            case 4:
                valores[1][0] = valor;
                break;
            case 5:
                valores[1][1] = valor;
                break;
            case 6:
                valores[1][2] = valor;
                break;
            case 7:
                valores[2][0] = valor;
                break;
            case 8:
                valores[2][1] = valor;
                break;
            case 9:
                valores[2][2] = valor;
                break;
        }

        iteracao++;
    }

    public boolean verificarJogada() {
        for (int i = 1; i < valoresJaArmazenados.length; i++) {
            if (getPosicao() == valoresJaArmazenados[i]) {
                throw new IllegalArgumentException("A jogada nesta posição já foi feita.");
            }
        }

        valoresJaArmazenados[getPosicao()] = getPosicao();
        return true;
    }

    public boolean verificarVitoria() {
        return verificarVitoriaHorizontal() || verificarVitoriaVertical() || verificarVitoriaDiagonalPrincipal() || verificarVitoriaDiagonalSecundaria();
    }

    private boolean verificarVitoriaHorizontal() {
        int vitoria = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (valores[i][j] == getTest()) {
                    vitoria++;
                }
            }

            if (vitoria == 3) {
                return true;
            }

            vitoria = 0;
        }

        return false;
    }

    private boolean verificarVitoriaVertical() {
        int vitoria = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (
