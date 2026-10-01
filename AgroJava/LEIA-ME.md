# AgroJava — Sistema Integrado do Agronegócio

Implementação do trabalho de Arrays e Matrizes solicitado no documento AgroJava.docx.

## Requisitos atendidos

- Registro de chuva dos 7 dias da semana em `double[7]`.
- Cálculo da média semanal de pluviosidade.
- Identificação do dia com maior volume de chuva.
- Mapeamento da umidade em uma matriz `double[4][4]`.
- Exibição formatada do mapa do campo.
- Alerta de irrigação para talhões com umidade abaixo de 30%.
- Menu interativo com `do-while` e `switch-case`.
- Entrada de dados usando `Scanner`.

## Observação sobre esta versão

Conforme solicitado, o arquivo principal `AgroJava.java` contém erros intencionais de ponto e vírgula. Eles estão identificados nos comentários `ERRO INTENCIONAL` das linhas de declaração do `Scanner` e do vetor de chuvas.

Por isso, esta versão não compila até que os dois pontos e vírgulas sejam adicionados:

```java
Scanner entrada = new Scanner(System.in);
double[] chuvas = new double[DIAS_DA_SEMANA];
```

Depois da correção, compile e execute com:

```bash
javac AgroJava.java
java AgroJava
```
