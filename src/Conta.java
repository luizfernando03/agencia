import java.math.BigDecimal;
import java.util.Random;

public class Conta {
    private String numero;
    private String agencia;
    private TipoDeConta tipoDeConta;
    private BigDecimal saldo;

    public Conta(String agencia, TipoDeConta tipoDeConta) {
        this.agencia = agencia;
        this.tipoDeConta = tipoDeConta;
        this.numero = String.valueOf(new Random().nextInt(20));
        this.saldo = new BigDecimal(0);
    }

    /**
     * Remove o valor informado do saldo
     * @return BigDecimal - saldo remanescente em conta
     */
    public BigDecimal saque(BigDecimal valor) {
        if (valor.compareTo(saldo) <= 0) {
            saldo = saldo.subtract(valor);
        }
        return saldo;
    }

    public void deposito(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public void imprimirSaldo() {
        System.out.println("O saldo da conta é " + saldo);
    }

    public String getNumero() {
        return numero;
    }
}
