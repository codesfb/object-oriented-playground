
```bash
#Para rodar os testes : 

mvn test 

#no diretorio geral mas tem muitas saida de erro pra limpar 

mvn -q test

mvn test | grep -E "\[ERROR\]|Results:|Failures:|Tests run:"

# Para um resumo bem limpo (Apenas nome do arquivo e status):

mvn test | awk -F'.' '/Tests run:.*in br.edu/ { print $NF " -> " ($0 ~ /FAILURE!/ ? "ERRO" : "OK") }'

# Para ver apenas os valores esperados e recebidos (expected vs but was):

mvn test | grep -E "expected:|but was:|\[ERROR\]   .*Test" | sed 's/\[ERROR\]   //'

# Para rodar apenas um teste específico (evita confusão com a ordem):

mvn test -Dtest=Ex04Test

# Para rodar um específico e ver apenas o erro limpo:

mvn test -Dtest=Ex04Test | grep -E "expected:|but was:|\[ERROR\]   .*Test" | sed 's/\[ERROR\]   //'

```
