exer 7
/*
    Um motorista de Uber estipula o preço de uma determinada viagem dada a quantidade de quilômetros percorrida.
    Para viagens de até X km, é cobrado um valor R$ V1 por km. Acima de X km, é cobrado o valor R$ V2.
    Faça um programa que leia X, V1, V2 e a quantidade de quilômetros A da viagem e imprima o valor total
    com duas casas decimais.

    Exemplos de entrada e saída:
    Entrada    	Saída
    100         75.00
    1.50
    1.25
    50
    Entrada    	Saída
    100         187.50
    1.50
    1.25
    150
*/

x v1 v2 a 
 
acima dx e v1 e v2

double custo;

if( a <= x  ){
    custo = a * v1;


}else if(a > x){
    custo = a * v2;


}


8


/*
    Alan quer comprar limões para fazer uma limonada. Próximo da sua casa há um mercadinho que vende limões da seguinte
    forma: O primeiro limão é vendido por C centavos, o segundo por C − 1 centavos, o terceiro por C − 2 e assim
    por diante até o menor valor de 1 centavo. Por exemplo, se C = 3 e Alan quiser comprar *5* limões, o preço total
    será 3 + 2 + 1 + 1 + 1 = 8.

    Faça um programa que leia dois inteiros *N* e *C* que indicam respectivamente o número de limões e o valor em
    centavos do primeiro limão. Em seguida imprima o valor total em centavos.

    ### Exemplos de entrada e saída:

    | Entrada  | Saída  |
    | -------  | ------ |
    | 5 3      | 8      |
    | 3 3      | 6      |

    Fonte: Adaptado de https://neps.academy/problem/193
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi e Adenilso Simão (ICMC/USP)
*/

n =numero de limoes 

c preço do primero limão 



saida custo total 

``` java

5 3

for(int i =0; i < 5; i++){
            
        if(c == 1){
                valorTotal+=1;
            }else {
                valorTotal += c; 
            }
            
            if (c != 1){
                   c--; 

            }
        }

c = 3 

valor = 6
0  if c == 1 false 
    else valor + 3 
    
c  - 1 

c== 2 



1 if c == 1 false 
else valor + 2 


c = 1
2 if c == 1 true 
    valor + 1 





/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/

    //criar variaveis 
    int somaIdades;
    double mediaDasIdades;
    int maioresDeIdade;
    int qtdIdosos;
    double   porcentagemIdosos;
    int contador;

    //percorrer o array 
    int i =0;
    while(input[i] != -1 ){

        
        somaIdades += input[i];
        if(input[i] >= 18 ){maioresDeIdade++;}
        if(input[i]>= 75){
            qtdIdosos++;

        }

        contador++;    
        i++;
    }

    mediaDasIdades= somaIdades/ contador;

    porcentagemIdosos = qtdIdosos/ contador;




    // retornar os 3 valores 
    return mediaDasIdades maioresDeIdade porcentagemIdosos;


// descobrir como  passa array como arg e return mais de um valor 

```        