package br.edu.ifrs.canoas.rpncalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Engine {
    private Stack<Double> pilha;
    private List<String> operacoes = Arrays.asList("+","-","*","/","limpar","ajuda","sair","raiz");
    private boolean rodando = true;

    public Engine(Stack pilha) {
        this.pilha = pilha;
    }

    public List<String> operacoesValidas() {
        return new ArrayList<>(operacoes);
    }

    public void poucosOperandos() {
        System.out.println("Poucos operandos!");
    }

    public void divisaoPorZero() {
        System.out.println("Divisão por zero!");
    }

    public void raizComplexa() {
        System.out.println("Raiz complexa!");
    }

    public void operacaoInvalida() {
        System.out.println("Operação inválida!");
    }

    void soma() {
        if (pilha.size() < 2) {
            poucosOperandos();
        } else {
            Double a, b;
            b = pilha.pop();
            a = pilha.pop();
            pilha.push(a+b);
        }
    }

    void subtracao() {
        System.out.println("Não implementado ainda!");
    }

    void multiplicacao() {
        System.out.println("Não implementado ainda!");
    }

    void divisao() {
        System.out.println("Não implementado ainda!");
    }

    void limpar() {
        pilha.clear();
    }

    void raizQuadrada() {
        System.out.println("Não implementado ainda!");
    }

    public void operando(Double numero) {
        pilha.push(numero);
    }

    void ajuda() {
        System.out.println("Operações:");
        System.out.println(String.join(", ", operacoes));
    }

    void sair() {
        rodando = false;
    }

    boolean estaRodando() {
        return rodando;
    }

    void atualizarTela() {
        final int MAX_TAMANHO = 5;
        Double[] numeros = pilha.toArray(new Double[0]);
        for (int i = pilha.size() - MAX_TAMANHO; i < pilha.size(); i++) {
            if (i < 0)
                System.out.println(" :");
            else {
                String numStr = String.format("%10g", numeros[i]);
                if (!numStr.contains("e")) {
                    numStr = numStr.replaceAll("0+$", "")
                            .replaceAll("[,.]$", "");
                }

                System.out.printf("%d: %11s\n",i,numStr);
            }
        }
        System.out.println("--------------");
        System.out.print("^: ");
    }

    void limparTela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    void operar(String operacao) {

        switch (operacao) {
            case "+":
                soma();
                break;
            case "-":
                subtracao();
                break;
            case "*":
                multiplicacao();
                break;
            case "/":
                divisao();
                break;
            case "raiz":
                raizQuadrada();
                break;
            case "limpar":
                limpar();
                break;
            case "ajuda":
                ajuda();
                break;
            case "sair":
                sair();
                break;
            default:
                operacaoInvalida();
                ajuda();
                break;
        }
    }
}
