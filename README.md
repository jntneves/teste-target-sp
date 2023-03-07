# Teste Target
<br>
<br>

**1)** Observe o trecho de código abaixo:
<br>
<br>

```
int INDICE = 13, SOMA = 0, K = 0;

enquanto K < INDICE faça {

K = K + 1;

SOMA = SOMA + K;

}

imprimir(SOMA);
```

Ao final do processamento, qual será o valor da variável SOMA?
<br>
<br>
**RESPOSTA:** Primeiro foram inicializadas 3 variáveis: "INDICE" com valor 13 (que define o limite superior da soma, ou seja, até que número a soma deve ser realizada), "SOMA" (que armazena a soma dos números 1 a "INDICE") e "K" (que é utilizada como uma variável auxiliar para iterar os números no loop) com valor 0. Em seguida, um loop é executado enquanto "K" for menor que o "INDICE" (13). Em cada iteração do loop, "K" recebe a soma de "K" + 1 e logo após, a variável "SOMA" recebe a soma de "SOMA" + "K". Por fim, o valor final (91) será exibido na tela.

---
<br>

**2)** Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
<br>
IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
<br>
<br>

```java
import java.util.Scanner;

public class SegundoDesafio {
    public static void main(String[] args) {

        int previousNumber = 0;
        int currentNumber = 1;

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int number = scan.nextInt();

        while (currentNumber < number) {
            int nextNumber = previousNumber + currentNumber;
            previousNumber = currentNumber;
            currentNumber = nextNumber;
        }

        if (currentNumber == number) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci!");
        } else  {
            System.out.println("O número " + number + " não pertence à sequência de Fibonacci!");
        }

    }
}
```

**RESPOSTA:** No início do programa temos a inicialização de duas variáveis "previousNumber" e "currentNumber" para armazenar os dois primeiros números da sequência de Fibonacci. Logo em sequida, o programa irá ler um número que será fornecido pelo usuário utilizando a classe Scanner. Um loop while será executado para calcular a sequência de Fibonacci até que o número atual seja maior ou igual ao número fornecido pelo usuário, e uma variável "nextNumber" será criada para calcular o próximo número na sequência. Logo após calcular a sequência de Fibonacci, o programa verifica se o número fornecido pelo usuário é igual ao número atual da sequência. Se for igual, ele exibe uma mensagem informando que o número pertence à sequência de Fibonacci. Caso contrário, ele exibe uma mensagem informando que número não pertence à sequência de Fibonacci.

---
<br>

**3)** Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:<br>
• O menor valor de faturamento ocorrido em um dia do mês;<br>
• O maior valor de faturamento ocorrido em um dia do mês;<br>
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.<br>
<br>
IMPORTANTE:<br>
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;<br>
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;<br>

```java
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TerceiroDesafio {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        List<Double> valores = new ArrayList<>();

        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader("src/dados.json"));
            for (Object objeto : array) {
                JSONObject jsonObject = (JSONObject) objeto;
                Double valor = (Double) jsonObject.get("valor");
                valores.add(valor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Double menorValor = Double.MAX_VALUE;
        Double maiorValor = Double.MIN_VALUE;

        for (Double valor : valores) {
            if (valor < menorValor) {
                menorValor = valor;
            }
            if (valor > maiorValor) {
                maiorValor = valor;
            }
        }

        Double somaValores = 0.0;
        int numeroDias = 0;

        for (Double valor : valores) {
            if (valor > 0) {
                somaValores += valor;
                numeroDias++;
            }
        }

        Double mediaMensal = somaValores / numeroDias;
        int numeroDiasSuperiorMedia = 0;

        for (Double valor : valores) {
            if (valor > mediaMensal) {
                numeroDiasSuperiorMedia++;
            }
        }

        System.out.println("Menor valor de faturamento ocorrido em um dia do mês: " + menorValor);
        System.out.println("Maior valor de faturamento ocorrido em um dia do mês: " + maiorValor);
        System.out.println("Número de dias no mês com faturamento diário superior à média mensal: "
                + numeroDiasSuperiorMedia);
    }
}
```

**RESPOSTA:** O programa utiliza a biblioteca JSON para ler o arquivo JSON e armazenar os valores. Inicialmente, o programa acessa e percorre o arquivo JSON guardando os valores em uma array. Em seguida, ele percorre a array para encontrar o menor e o maior valor de faturamento diário no mês, por conseguinte, calcular a média mensal de faturamento diário, ignorando os dias sem faturamento. Por fim, ele percorre a array novamente para contar o número de dias em que o faturamento diário foi superior à média mensal. Finalmente, o resultado é exibido na tela contendo: o menor valor de faturamento ocorrido em um dia do mês, o maior valor de faturamento ocorrido em um dia do mês e o número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

---
<br>

**4)** Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:<br>
<br>
SP – R$67.836,43<br>
RJ – R$36.678,66<br>
MG – R$29.229,88<br>
ES – R$27.165,48<br>
Outros – R$19.849,53<br>
<br>
Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.<br>

```java
public class QuartoDesafio {
    public static void main(String[] args) {

        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double faturamentoTotal = sp + rj + mg + es + outros;

        double perSP = (sp / faturamentoTotal) * 100;
        double perRJ = (rj / faturamentoTotal) * 100;
        double perMG = (mg / faturamentoTotal) * 100;
        double perES = (es / faturamentoTotal) * 100;
        double perOutros = (outros / faturamentoTotal) * 100;

        System.out.printf("Percentual de representação de SP: %.2f%%\n", perSP);
        System.out.printf("Percentual de representação de RJ: %.2f%%\n", perRJ);
        System.out.printf("Percentual de representação de MG: %.2f%%\n", perMG);
        System.out.printf("Percentual de representação de ES: %.2f%%\n", perES);
        System.out.printf("Percentual de representação de Outros: %.2f%%\n", perOutros);

    }
}
```

**RESPOSTA:** Inicialmente, definimos as variáveis para guardar os valores de faturamento de cada estado e logo após definimos uma variável "faturamentoTotal" para calcular a soma do faturamento total de todos os estados. Em seguida, calculamos os percentuais de representação de cada estado dividindo o valor de faturamento do estado pelo valor de faturamento total e depois multiplicamos o resultado da divisão por 100. Concluindo, o programa irá exibir os percentuais de representação de cada estado formatados com o método "printf".

---
<br>

**5)** Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:

a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;

b) Evite usar funções prontas, como, por exemplo, reverse;

<br>

```java
import java.util.Scanner;

public class QuintoDesafio {
    public static void main(String[] args) {

        String invertedString = "";

        Scanner scan = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String string = scan.nextLine();

        for (int i = string.length() - 1; i >= 0; i--) {
            invertedString += string.charAt(i);
        }

        System.out.println("A inversão string informada é: " + invertedString);

    }
}
```

**RESPOSTA**: Primeiro inicializamos uma string vazia para armazenar a string invertida que será o resultado final do programa. Em seguida, solicitamos ao usuário que insira uma palavra ou texto utilizando a classe Scanner. A seguir, executamos um loop para percorrer a string informada pelo usuário de trás para frente, utilizando o contador "i" iniciando em "string.length()-1" (que realiza a contagem de caracteres da string) e decrementamos em cada iteração até chegar em 0. Dentro do próprio loop, cada caractere percorrido é adicionado à string vazia criada no início utilizando o método "charAt". Por fim, a string invertida será exibida na tela utilizando o método "println()".

<br>
<br>
<br>
By Jonathan Neves
