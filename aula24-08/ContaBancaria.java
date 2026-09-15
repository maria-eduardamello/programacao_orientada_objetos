import java.util.ArrayList;

public class ContaBancaria {

    private Titular titular;

    protected double saldo;
    protected ArrayList<Double> movimentacoes;

    ContaBancaria(Titular titular) {
        this.titular = titular;
        this.saldo = 0;
        this.movimentacoes = new ArrayList<>();
    }

    public Titular getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOperacoes() {
        return movimentacoes.size();
    }

    void setTitular(String novo) {
        if (novo != null && !novo.trim().isEmpty()) {
            titular.setTitular(novo);
        } else {
            System.out.println("Nome do titular nao pode ser vazio!");
        }
    }

    void depositar(double valor) {

        if (valor > 0) {
            saldo += valor;
            movimentacoes.add(valor);

            System.out.println("Deposito concluido!");
        } else {
            System.out.println("Valor de deposito invalido!");
        }
    }

    void sacar(double valor) {

        if (valor <= 0) {
            System.out.println("Valor de saque invalido!");
            return;
        }

        if (saldo >= valor) {
            saldo -= valor;
            movimentacoes.add(-valor);

            System.out.println("Saque concluido!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void exibirExtrato() {

        System.out.println("\nExtrato:");

        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma movimentacao realizada.");
            return;
        }

        for (Double movimentacao : movimentacoes) {
            System.out.println("R$ " + movimentacao);
        }
    }

    public void totalDepositado() {

        double soma = 0;

        for (Double movimentacao : movimentacoes) {
            if (movimentacao > 0) {
                soma += movimentacao;
            }
        }

        System.out.println("Total depositado: R$ " + soma);
    }

    public void maiorSaque() {

        double maior = 0;

        for (Double movimentacao : movimentacoes) {

            if (movimentacao < 0) {

                double saque = movimentacao * -1;

                if (saque > maior) {
                    maior = saque;
                }
            }
        }

        if (maior > 0) {
            System.out.println("Maior saque: R$ " + maior);
        } else {
            System.out.println("Nenhum saque realizado.");
        }
    }
}