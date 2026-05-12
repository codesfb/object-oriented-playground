
import prova_simulada_2.src.Declaracao;
import prova_simulada_2.src.DeclaracaoCompleta;
import prova_simulada_2.src.DeclaracaoSimplificada;
import prova_simulada_2.src.GastoEducacao;
import prova_simulada_2.src.GastoSaude;

import java.util.*;

//TODO implemetar classe generica
private static final Map<String, Declaracao> bancoDados = new LinkedHashMap<>();
private static final Scanner scanner = new Scanner(System.in);

void main(String[] args) {
        boolean rodando = true;

        while (rodando) {
            exibirMenu();
            int opcao = lerInteiro();

            switch (opcao) {
                case 1 -> cadastrarDeclaracao(true);
                case 2 -> cadastrarDeclaracao(false);
                case 3 -> adicionarGasto();
                case 4 -> listarDeclaracoes();
                case 5 -> calcularImpostoIndividual();
                case 0 -> rodando = false;
                default -> System.out.println("Opção inválida!");
            }
        }
        System.out.println("Sistema encerrado.");
    }

    private static void exibirMenu() {
        System.out.println("\n===== SISTEMA  DECLARAÇÂO 2026) =====");
        System.out.println("1 - Nova Declaração Completa");
        System.out.println("2 - Nova Declaração Simplificada");
        System.out.println("3 - Adicionar Gasto (Apenas p/ Completa)");
        System.out.println("4 - Listar Todas as Declarações");
        System.out.println("5 - Ver Imposto Final por ID");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static void cadastrarDeclaracao(boolean completa) {
        //System.out.print("ID da Declaração: ");
        //String id = scanner.nextLine();
        System.out.print("Ganhos Tributáveis: ");
        double ganhos = lerDouble();
        System.out.print("Valor já pago no ano: ");
        double pago = lerDouble();

        Declaracao dec = completa ?
                new DeclaracaoCompleta(ganhos, pago) :
                new DeclaracaoSimplificada(ganhos, pago);
        String id = String.valueOf(UUID.randomUUID());//just a test
        bancoDados.put(id, dec);
        System.out.println("✓ Declaração salva com sucesso!");
    }

    private static void adicionarGasto() {
        System.out.print("ID da Declaração: ");
        String id = scanner.nextLine();

        Declaracao dec = bancoDados.get(id);

        if (dec instanceof DeclaracaoCompleta dc) {
            System.out.println("Tipo de Gasto: 1-Saúde | 2-Educação");
            int tipo = lerInteiro();

            System.out.print("Descrição: ");
            String desc = scanner.nextLine();
            System.out.print("Valor do Gasto: ");
            double valor = lerDouble();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();

            if (tipo == 1) {
                System.out.print("Registro do Conselho: ");

                dc.AddGasto(new GastoSaude(System.currentTimeMillis(), desc, valor, cnpj, scanner.nextLine()));
            } else {
                System.out.print("Nome da Instituição: ");
                dc.AddGasto(new GastoEducacao(System.currentTimeMillis(), desc, valor, cnpj, scanner.nextLine()));
            }
            System.out.println("✓ Gasto adicionado!");
        } else {
            System.out.println("X Erro: ID não encontrado ou não é Declaração Completa.");
        }
    }

    private static void listarDeclaracoes() {
        if (bancoDados.isEmpty()) System.out.println("Nenhuma declaração registrada.");
        bancoDados.forEach((id, dec) -> {
            System.out.printf("ID: %s | Tipo: %s | Imposto a Pagar: R$ %.2f%n",
                    id, dec.getClass().getSimpleName(), dec.getValorAPagar());
        });
    }

    private static void calcularImpostoIndividual() {
        System.out.print("Digite o ID: ");
        String id = scanner.nextLine();
        Declaracao dec = bancoDados.get(id);
        if (dec != null) {
            System.out.println("------------------------------------");
            System.out.println("Resultado para ID: " + id);
            System.out.printf("Valor do Imposto (Base): R$ %.2f%n", dec.getValorImposto());
            System.out.printf("Deduções Aplicadas: R$ %.2f%n", dec.getDespesaDedutivel());
            System.out.printf("TOTAL A PAGAR/RESTITUIR: R$ %.2f%n", dec.getValorAPagar());
            System.out.println("------------------------------------");
        } else {
            System.out.println("ID inexistente.");
        }
    }


    private static int lerInteiro() {
      try {
          int i = scanner.nextInt();
          scanner.nextLine();
          return i;
      }catch (InputMismatchException e){
          scanner.nextLine();
          System.err.println("Erro: Digite apenas números decimais (use vírgula ou ponto conforme seu sistema).");
          return 0;
      }
    }

    private static double lerDouble() {
        try {
            double d = scanner.nextDouble();
            scanner.nextLine();
            return d;
        }catch(InputMismatchException e){
            scanner.nextLine();
            System.err.println("Erro: Digite apenas números decimais (use vírgula ou ponto conforme seu sistema).");
            return 0;
        }
    }
