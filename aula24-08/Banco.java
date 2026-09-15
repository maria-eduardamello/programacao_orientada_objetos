import java.util.ArrayList;

public class Banco {

    private ArrayList<ContaBancaria> contas;
    private int proximoNumero;

    Banco() {
        contas = new ArrayList<>();
        proximoNumero = 1;
    }

    public int criarContaCorrente(Titular titular) {

        ContaCorrente conta = new ContaCorrente(titular);

        contas.add(conta);

        int numero = proximoNumero;
        proximoNumero++;

        return numero;
    }

    public int criarContaPoupanca(Titular titular) {

        ContaPoupanca conta = new ContaPoupanca(titular);

        contas.add(conta);

        int numero = proximoNumero;
        proximoNumero++;

        return numero;
    }

    public int criarContaUniversitaria(Titular titular) {

        ContaUniversitaria conta = new ContaUniversitaria(titular);

        contas.add(conta);

        int numero = proximoNumero;
        proximoNumero++;

        return numero;
    }

    private ContaBancaria encontrarConta(int numero) {

        if (numero >= 1 && numero <= contas.size()) {
            return contas.get(numero - 1);
        }

        return null;
    }

    public void depositar(int numero, double valor) {

        ContaBancaria conta = encontrarConta(numero);

        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Conta nao encontrada!");
        }
    }

    public void sacar(int numero, double valor) {

        ContaBancaria conta = encontrarConta(numero);

        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Conta nao encontrada!");
        }
    }

    public void consultarSaldo(int numero) {

        ContaBancaria conta = encontrarConta(numero);

        if (conta != null) {
            System.out.println("Saldo: R$ " + conta.getSaldo());
        } else {
            System.out.println("Conta nao encontrada!");
        }
    }

    public void exibirExtrato(int numero) {

        ContaBancaria conta = encontrarConta(numero);

        if (conta != null) {
            conta.exibirExtrato();
        } else {
            System.out.println("Conta nao encontrada!");
        }
    }

    public void aplicarRendimento(int numero, double percentual) {

        ContaBancaria conta = encontrarConta(numero);

        if (conta == null) {
            System.out.println("Conta nao encontrada!");
            return;
        }

        if (conta instanceof ContaPoupanca) {

            ContaPoupanca poupanca = (ContaPoupanca) conta;

            poupanca.aplicarRendimento(percentual);

        } else {
            System.out.println("Essa conta nao possui rendimento!");
        }
    }

    public void transferir(int origem, int destino, double valor) {

        if (origem == destino) {
            System.out.println("Nao e possivel transferir para a mesma conta!");
            return;
        }

        ContaBancaria contaOrigem = encontrarConta(origem);
        ContaBancaria contaDestino = encontrarConta(destino);

        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Conta nao encontrada!");
            return;
        }

        if (valor <= 0) {
            System.out.println("Valor de transferencia invalido!");
            return;
        }

        double saldoAntes = contaOrigem.getSaldo();

        contaOrigem.sacar(valor);

        if (contaOrigem.getSaldo() < saldoAntes) {
            contaDestino.depositar(valor);
            System.out.println("Transferencia concluida!");
        }
    }

    public void listarContas() {

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("\nContas cadastradas:");

        for (int i = 0; i < contas.size(); i++) {

            ContaBancaria conta = contas.get(i);

            String tipo;

            if (conta instanceof ContaCorrente) {
                tipo = "Conta Corrente";
            } else if (conta instanceof ContaPoupanca) {
                tipo = "Conta Poupanca";
            } else {
                tipo = "Conta Universitaria";
            }

            System.out.println(
                "Conta: " + (i + 1)
                + " | Tipo: " + tipo
                + " | Titular: " + conta.getTitular().getTitular()
                + " | CPF: " + conta.getTitular().getCpf()
                + " | Saldo: R$ " + conta.getSaldo()
            );
        }
    }

    public void sacarDeTodas() {

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("\nSaque de R$ 50 de todas as contas:");

        for (ContaBancaria conta : contas) {
            conta.sacar(50);
        }
    }
}