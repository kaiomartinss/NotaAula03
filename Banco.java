import java.util.Scanner;

class Conta {
    private String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$" + saldo);
    }
}

class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String titular) {
        super(titular);
        this.limiteChequeEspecial = 1000.00;
    }

    public boolean usarChequeEspecial(double valor) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
            System.out.println("Uso do cheque especial de R$" + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Limite do cheque especial ultrapassado.");
            return false;
        }
    }
}

class ContaPoupanca extends Conta {
    private double taxaSelic;

    public ContaPoupanca(String titular, double taxaSelic) {
        super(titular);
        this.taxaSelic = taxaSelic;
    }

    public void calcularRendimento() {
        double rendimento;
        if (taxaSelic > 8.5) {
            rendimento = saldo * 0.005; // 0.5% ao mês
        } else {
            rendimento = saldo * (taxaSelic * 0.7 / 12); // 70% da Selic ao mês
        }
        saldo += rendimento;
        System.out.println("Rendimento calculado: R$" + rendimento);
    }
}

 class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema bancário!");
        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.print("Opção: ");
        int opcaoConta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (opcaoConta == 1) {
            System.out.print("Digite o nome do titular da Conta Corrente: ");
            String titular = scanner.nextLine();
            ContaCorrente contaCorrente = new ContaCorrente(titular);

            while (true) {
                exibirMenuContaCorrente();
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor a ser depositado: ");
                        double valorDeposito = scanner.nextDouble();
                        contaCorrente.depositar(valorDeposito);
                        break;
                    case 2:
                        System.out.print("Digite o valor a ser sacado: ");
                        double valorSaque = scanner.nextDouble();
                        contaCorrente.sacar(valorSaque);
                        break;
                    case 3:
                        System.out.print("Digite o valor a ser utilizado do cheque especial: ");
                        double valorChequeEspecial = scanner.nextDouble();
                        contaCorrente.usarChequeEspecial(valorChequeEspecial);
                        break;
                    case 4:
                        contaCorrente.exibirDados();
                        break;
                    case 5:
                        System.out.println("Saindo do sistema bancário...");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            }
        } else if (opcaoConta == 2) {
            System.out.print("Digite o nome do titular da Conta Poupança: ");
            String titular = scanner.nextLine();
            System.out.print("Digite a taxa Selic: ");
            double taxaSelic = scanner.nextDouble();
            ContaPoupanca contaPoupanca = new ContaPoupanca(titular, taxaSelic);

            while (true) {
                exibirMenuContaPoupanca();
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor a ser depositado: ");
                        double valorDeposito = scanner.nextDouble();
                        contaPoupanca.depositar(valorDeposito);
                        break;
                    case 2:
                        System.out.print("Digite o valor a ser sacado: ");
                        double valorSaque = scanner.nextDouble();
                        contaPoupanca.sacar(valorSaque);
                        break;
                    case 3:
                        contaPoupanca.calcularRendimento();
                        break;
                    case 4:
                        contaPoupanca.exibirDados();
                        break;
                    case 5:
                        System.out.println("Saindo do sistema bancário...");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            }
        } else {
            System.out.println("Opção inválida. Encerrando o programa...");
            System.exit(0);
        }
    }

    private static void exibirMenuContaCorrente() {
        System.out.println("\n======= MENU - CONTA CORRENTE =======");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Usar Cheque Especial");
        System.out.println("4. Exibir Dados da Conta");
        System.out.println("5. Sair");
        System.out.print("Opção: ");
    }

    private static void exibirMenuContaPoupanca() {
        System.out.println("\n======= MENU - CONTA POUPANÇA =======");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Calcular Rendimento");
        System.out.println("4. Exibir Dados da Conta");
        System.out.println("5. Sair");
        System.out.print("Opção: ");
    }
}
