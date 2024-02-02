import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        ArrayList<Conta> contas = new ArrayList<Conta>(10);

        do {
            System.out.println("Escolha uma opção");
            System.out.println("1 - Para criar uma nova conta");
            System.out.println("2 - Efetuar um deposito");
            System.out.println("3 - Efetuar um saque");
            System.out.println("4 - Ver saldo");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    criarConta(scanner, contas);
                    break;
                case 2:
                    deposito(scanner, contas);
                    break;
                case 4:
                    System.out.println("Informe o numero da conta");
                    String n = scanner.next();

                    for(Conta conta : contas) {
                        if(conta.getNumero().equals(n)) {
                            conta.imprimirSaldo();
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        } while(opcao != 0);
    }

    private static void deposito(Scanner scanner, ArrayList<Conta> contas) {
        System.out.println("Informe o numero da conta");
        String numero = scanner.next();

        System.out.println("Informe o valor");
        String valor = scanner.next();

        for(Conta conta : contas) {
            if(conta.getNumero().equals(numero)) {
                conta.deposito(new BigDecimal(valor));
                System.out.println("Deposito feito com sucesso " + conta.getNumero());
            }
        }
    }

    private static void criarConta(Scanner scanner, ArrayList contas) {
        System.out.println("Informe o tipo de conta");
        System.out.println("0 - conta corrente");
        System.out.println("1 - poupanca");
        int tipo = scanner.nextInt();
        TipoDeConta tipoDeConta = null;
        switch (tipo) {
            case 0:
                tipoDeConta = TipoDeConta.CORRENTE;
                break;
            case 1:
                tipoDeConta = TipoDeConta.POUPANCA;
                break;
            default:
                System.out.println("Opcao de conta invalida");
        }
        System.out.println("Informe a agencia");
        String agencia = scanner.next();

        Conta conta = new Conta(agencia, tipoDeConta);
        contas.add(conta);
        System.out.println("Conta criada com sucesso, " +
                "o numero da conta: " + conta.getNumero());
    }
}