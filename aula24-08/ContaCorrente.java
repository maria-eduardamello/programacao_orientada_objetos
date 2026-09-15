public class ContaCorrente extends ContaBancaria {

    ContaCorrente(Titular titular) {
        super(titular);
    }

    @Override
    void sacar(double valor) {

        if (valor <= 0) {
            System.out.println("Valor de saque invalido!");
            return;
        }

        double valorComTarifa = valor + 0.50;

        if (saldo >= valorComTarifa) {

            saldo -= valorComTarifa;
            movimentacoes.add(-valorComTarifa);

            System.out.println("Saque concluido!");
            System.out.println("Tarifa de R$ 0,50 cobrada.");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}