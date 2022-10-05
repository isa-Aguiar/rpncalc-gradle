
![workflow status](https://github.com/roger-willian/rpncalc-gradle/actions/workflows/build.yml/badge.svg)

Esse repositório foi criado para que os alunos de Engenharia de Software I possam aprender sobre a rotina diária de desenvolvimento em uma equipe ágil.
Essa é uma disciplina introdutória e, por isso, o repositório é bem simples.

Os arquivos fonte estão em `app/src/main/`.
Existem alguns testes unitários implementados em `app/src/test/`.
Além disso, existem alguns testes de aceitação escritos como arquivos texto em `acceptance/` com a entrada e a saída esperada para alguns UC e fluxos de exceção.
Os testes de aceitação são executados por um shell script bem simples localizado no mesmo diretório que eles.

Abaixo são listados apenas as _user stories_ e os _use cases_.
Alguns já estão implementados, outros devem ser implementados pelos alunos.

# US00: Funcionalidades básicas

Como usuário, eu gostaria de rodar a aplicação, usar o comando `ajuda` para obter ajuda ou obter ajuda se usar um comando inválido e terminar a aplicação usando o comando `sair`.

## UC001: Terminar a aplicação

1. O usuário digita `sair` e dá enter;
2. A aplicação imprime `Tchauzinho!` abaixo da pilha e termina normalmente.

## UC002: Pedir ajuda

1. O usuário digita o comando `ajuda` (E1);
2. A aplicação mostra as operações válidas antes de mostrar a pilha.

### Fluxos de exceção

__E1__: usuário digitou comando inválido.

1. A aplicação mostra a mensagem `Operação inválida!`;
2. A aplicação mostra as operações válidas, como se o usuário tivesse pedido ajuda.
3. Os outros passos não são executados.

## UC003: Ver tela inicial

1. O usuário começa a rodar a aplicação;
2. A aplicação mostra as operações válidas, como se o usuário tivesse pedido ajuda.

# US01: Inserir números na pilha

Como usuário, eu gostaria de digitar números e inseri-los no topo da pilha.

## UC011: Inserir um número no topo da pilha

1. O usuário digita um número e dá enter;
2. Esse número vai para o topo da pilha.

## UC012: Inserir dois números no topo da pilha

1. O usuário digita um número x e dá enter;
2. Esse número vai para o topo da pilha;
2. O usuário digita um número y e dá enter;
3. O número y fica no topo da pilha, na posição N, deslocando x para a posição N-1.

# US02: Limpar a pilha

Como usuário, eu gostaria de usar o comando `limpar` para limpar a pilha.

## UC021: Limpar os números da pilha

__Pré-condições__: pelo menos um número na pilha.

1. O usuário digita `limpar` e dá enter;
2. Todos os números da pilha são descartados (E1);

### Fluxos de exceção

__E1__: a pilha já estava vazia.

1. A aplicação não modifica a pilha;
2. Os outros passos não são executados.

# US03: Somar números do topo da pilha

Como usuário, eu gostaria de somar os números que estão no topo da pilha.

## UC031: Somar dois números do topo da pilha

__Pré-condições__: pelo menos dois números na pilha.

1. O usuário digita `+` e dá enter;
2. Os dois números do topo da pilha são removidos (E1);
3. A soma desses números é inserida no topo da pilha.

### Fluxos de exceção

__E1__: menos que dois números na pilha.

1. A aplicação não modifica a pilha;
2. A aplicação mostra a mensagem `Poucos operandos!`;
3. Os outros passos não são executados.

# US04: Subtrair números do topo da pilha

Como usuário, eu gostaria de subtrair os números que estão no topo da pilha.

## UC041: Subtrair dois números do topo da pilha

__Pré-condições__: pelo menos dois números na pilha.

1. O usuário digita `-` e dá enter;
2. Os dois números do topo da pilha são removidos (E1);
3. A diferença entre esses números é inserida no topo da pilha.

__Nota__: Se x está no topo (posição N) e y logo em seguida (posção N-1), a diferença é y-x e __não__ x-y.

### Fluxos de exceção

__E1__: menos que dois números na pilha.

1. A aplicação não modifica a pilha;
2. A aplicação mostra a mensagem `Poucos operandos!`;
3. Os outros passos não são executados.

# US05: Multiplicar números do topo da pilha

Como usuário, eu gostaria de multiplicar os números que estão no topo da pilha.

## UC051: Multiplicar dois números do topo da pilha

__Pré-condições__: pelo menos dois números na pilha.

1. O usuário digita `*` e dá enter;
2. Os dois números do topo da pilha são removidos (E1);
3. O produto desses números é inserido no topo da pilha.

### Fluxos de exceção

__E1__: menos que dois números na pilha.

1. A aplicação não modifica a pilha;
2. A aplicação mostra a mensagem `Poucos operandos!`;
3. Os outros passos não são executados.

# US06: Dividir números do topo da pilha

Como usuário, eu gostaria de dividir os números que estão no topo da pilha.

## UC061: Dividir dois números do topo da pilha

__Pré-condições__: pelo menos dois números na pilha, o número do topo não é zero.

1. O usuário digita `/` e dá enter;
2. Os dois números do topo da pilha são removidos (E1) (E2);
3. O quociente desses números é inserido no topo da pilha.

__Nota__: Se x está no topo (posição N) e y logo em seguida (posção N-1), o quociente é y/x e __não__ x/y.

### Fluxos de exceção

__E1__: menos que dois números na pilha.

1. A aplicação não modifica a pilha;
2. A aplicação mostra a mensagem `Poucos operandos!`;
3. Os outros passos não são executados.

__E2__: o número no topo da pilha é zero.

1. A aplicação não modifica a pilha;
2. A aplicação mostra a mensagem `Divisão por zero!`;
3. Os outros passos não são executados.

# US07: Raiz quadrada do topo da pilha

Como usuário, eu gostaria de usar o comando `raiz` para extrair a raiz quadrada do número do topo da pilha.

## UC071: Extrair a raiz quadrada do topo da pilha

__Pré-condições__: a pilha não está vazia, o número do topo não é negativo.

1. O usuário digita `raiz` e dá enter;
2. O número do topo da pilha é removido (E1) (E2);
3. A raiz quadrada desse número é inserida no topo da pilha.

### Fluxos de exceção

__E1__: a pilha está vazia.

1. A aplicação não modifica a pilha;
2. A aplicação mostra a mensagem `Poucos operandos!`;
3. Os outros passos não são executados.

__E1__: o número do topo é negativo.

1. A aplicação não modifica a pilha;
2. A aplicação mostra a mensagem `Raiz complexa!`;
3. Os outros passos não são executados.
