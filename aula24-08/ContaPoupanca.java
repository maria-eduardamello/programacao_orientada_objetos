public class ContaPoupanca extends ContaBancaria {

    ContaPoupanca(Titular titular) {
        super(titular);
    }

    @Override
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

    void aplicarRendimento(double percentual) {

        if (percentual >= 0 && percentual <= 100) {

            double rendimento = saldo * (percentual / 100);

            saldo += rendimento;

            System.out.println("Rendimento aplicado!");
            System.out.println("Rendimento: R$ " + rendimento);
            System.out.println("Novo saldo: R$ " + saldo);

        } else {
            System.out.println("Percentual invalido!");
        }
    }
}