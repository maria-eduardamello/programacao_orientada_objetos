public class ContaUniversitaria extends ContaBancaria {

    ContaUniversitaria(Titular titular) {
        super(titular);
    }

  
    @Override
    void sacar(double valor) {

        if (valor <= 0) {
            System.out.println("Valor de saque invalido!");
            return;
        }

        if (valor > 300) {
            System.out.println("O saque maximo e de R$ 300!");
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
}