import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Banco banco = new Banco();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== BANCO =====");
            System.out.println("1 - Criar conta corrente");
            System.out.println("2 - Criar conta poupanca");
            System.out.println("3 - Criar conta universitaria");
            System.out.println("4 - Sacar");
            System.out.println("5 - Depositar");
            System.out.println("6 - Consultar saldo");
            System.out.println("7 - Aplicar rendimento");
            System.out.println("8 - Listar contas");
            System.out.println("9 - Sacar R$ 50 de todas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            try {

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1:

                        System.out.print("Nome: ");
                        String nomeCorrente = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpfCorrente = scanner.nextLine();

                        System.out.print("Data de nascimento: ");
                        String dataCorrente = scanner.nextLine();

                        Titular titularCorrente = new Titular(
                            nomeCorrente,
                            cpfCorrente,
                            dataCorrente
                        );

                        int numeroCorrente =
                            banco.criarContaCorrente(titularCorrente);

                        System.out.println(
                            "Conta corrente criada! Numero: "
                            + numeroCorrente
                        );

                        break;

                    case 2:

                        System.out.print("Nome: ");
                        String nomePoupanca = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpfPoupanca = scanner.nextLine();

                        System.out.print("Data de nascimento: ");
                        String dataPoupanca = scanner.nextLine();

                        Titular titularPoupanca = new Titular(
                            nomePoupanca,
                            cpfPoupanca,
                            dataPoupanca
                        );

                        int numeroPoupanca =
                            banco.criarContaPoupanca(titularPoupanca);

                        System.out.println(
                            "Conta poupanca criada! Numero: "
                            + numeroPoupanca
                        );

                        break;

                    case 3:

                        System.out.print("Nome: ");
                        String nomeUniversitaria = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpfUniversitaria = scanner.nextLine();

                        System.out.print("Data de nascimento: ");
                        String dataUniversitaria = scanner.nextLine();

                        Titular titularUniversitaria = new Titular(
                            nomeUniversitaria,
                            cpfUniversitaria,
                            dataUniversitaria
                        );

                        int numeroUniversitaria =
                            banco.criarContaUniversitaria(
                                titularUniversitaria
                            );

                        System.out.println(
                            "Conta universitaria criada! Numero: "
                            + numeroUniversitaria
                        );

                        break;

                    case 4:

                        System.out.print("Numero da conta: ");
                        int contaSaque = scanner.nextInt();

                        System.out.print("Valor do saque: ");
                        double valorSaque = scanner.nextDouble();

                        banco.sacar(contaSaque, valorSaque);

                        break;

                    case 5:

                        System.out.print("Numero da conta: ");
                        int contaDeposito = scanner.nextInt();

                        System.out.print("Valor do deposito: ");
                        double valorDeposito = scanner.nextDouble();

                        banco.depositar(contaDeposito, valorDeposito);

                        break;

                    case 6:

                        System.out.print("Numero da conta: ");
                        int contaSaldo = scanner.nextInt();

                        banco.consultarSaldo(contaSaldo);

                        break;

                    case 7:

                        System.out.print("Numero da conta: ");
                        int contaRendimento = scanner.nextInt();

                        System.out.print("Percentual: ");
                        double percentual = scanner.nextDouble();

                        banco.aplicarRendimento(
                            contaRendimento,
                            percentual
                        );

                        break;

                    case 8:

                        banco.listarContas();

                        break;

                    case 9:

                        banco.sacarDeTodas();

                        break;

                    case 0:

                        System.out.println("Programa encerrado.");

                        break;

                    default:

                        System.out.println("Opcao invalida!");

                        break;
                }

            } catch (Exception e) {

                System.out.println("Entrada invalida! Tente novamente.");

                scanner.nextLine();
            }
        }

        scanner.close();
    }
}