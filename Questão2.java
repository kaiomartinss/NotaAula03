import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    private String nome;
    private int estoque;
    private double preco;

    public Produto(String nome, int estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public boolean vender(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
            System.out.println(quantidade + " unidades de " + nome + " vendidas com sucesso!");
            return true;
        } else {
            System.out.println("Desculpe, não há estoque suficiente de " + nome + ".");
            return false;
        }
    }
}

class CadastroVendaProdutos {
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarProduto(scanner);
                    break;
                case "2":
                    venderProduto(scanner);
                    break;
                case "3":
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("======= MENU =======");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Vender Produto");
        System.out.println("3. Sair");
        System.out.println("====================");
    }

    private static void cadastrarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade em estoque: ");
        int estoque = Integer.parseInt(scanner.nextLine());
        System.out.print("Preço unitário: ");
        double preco = Double.parseDouble(scanner.nextLine());
        produtos.add(new Produto(nome, estoque, preco));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void venderProduto(Scanner scanner) {
        System.out.print("Digite o nome do produto a ser vendido: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite a quantidade a ser vendida: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        for (Produto produto : produtos) {
            if (produto.toString().toLowerCase().contains(nomeProduto.toLowerCase())) {
                produto.vender(quantidade);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}
