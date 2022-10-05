package br.edu.ifrs.canoas.rpncalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tokenizer {
    List<String> operacoes;
    Scanner scanner;

    Tokenizer(List<String> operacoesValidas) {
        operacoes = new ArrayList<>(operacoesValidas);
        scanner = new Scanner(System.in);
        scanner.useDelimiter(Pattern.compile("\\s"));
    }

    public Token getToken() {
        if (scanner.hasNextDouble()) {
            return new Token(scanner.nextDouble());
        } else if (scanner.hasNext()) {
            String tkStr = scanner.next();
            return new Token(tkStr);
        } else {
            return new Token();
        }
    }
}
