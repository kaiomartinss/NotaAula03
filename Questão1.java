import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int sair;
        do{
            System.out.println("Dados do funcionário");

            System.out.println("Informe o numero da matrícula:");
            int matricula = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Informe o nome do Funcionário:");
            String nome = scanner.nextLine();

            System.out.println("Informe o salário bruto do Funcionário:");
            double salarioBruto = scanner.nextDouble();

            double descontoInss = salarioBruto * 0.15;
            double salarioLiquido = salarioBruto - descontoInss;

            System.out.println("Matricula:" + matricula);
            System.out.println("Nome:" +nome);
            System.out.println("Salário Bruto: R$" + salarioBruto);
            System.out.println("Dedução INSS: R$" + descontoInss);
            System.out.println("Salário Líquido: R$" + salarioLiquido);

            System.out.println("Digite 0 para repetir:");
            sair = scanner.nextInt();
        } while(sair ==0);
        System.out.println("Programa Encerrado!");
    }
}
