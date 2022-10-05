package br.edu.ifrs.canoas.rpncalc;

public class Token {
    private Tipo tipo;
    private String operacao;
    private Double valor;

    Token() {
        this.tipo = Tipo.INVALIDO;
    }

    Token(String operacao) {
        this.tipo = Tipo.OPERACAO;
        this.operacao = operacao;
    }

    Token(Double valor) {
        this.tipo = Tipo.OPERANDO;
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getOperacao() {
        if (this.tipo != Tipo.OPERACAO)
            throw new RuntimeException("Tipo errado!");
        else
            return operacao;
    }

    public Double getValor() {
        if (this.tipo != Tipo.OPERANDO)
            throw new RuntimeException("Tipo errado");
        else
            return valor;
    }
}
