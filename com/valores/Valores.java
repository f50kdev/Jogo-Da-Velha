package com.valores;

public enum Valores {
    EMPTY(0), X(1), O(2);

    private int valor;
    Valores(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }

}
