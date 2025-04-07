import java.util.Scanner;
public class Menu {
    Scanner sc = new Scanner(System.in);
    Produto[] produtos = new Produto[3];
    Cliente[] clientes = new Cliente[3];
    int indiceProdutos = 0;
    int indiceClientes = 0;
    Venda venda = new Venda();
    int opcao;

    public void executar() {
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Vender Produto");
            System.out.println("4 - Adicionar estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    if (indiceProdutos < produtos.length) {
                        System.out.print("Nome do produto: ");
                        String nome = sc.nextLine();

                        System.out.print("Preço: R$ ");
                        double preco = sc.nextDouble();

                        System.out.print("Quantidade em estoque: ");
                        int qnt = sc.nextInt();
                        sc.nextLine();

                        produtos[indiceProdutos] = new Produto(nome, preco, qnt);
                        indiceProdutos++;
                        System.out.println("Produto cadastrado!");
                    } else {
                        System.out.println("Limite de produtos atingido.");
                    }
                    break;
                }

                case 2: {
                    if (indiceClientes < clientes.length) {
                        System.out.print("Nome do cliente: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF do cliente: ");
                        String cpf = sc.nextLine();

                        clientes[indiceClientes] = new Cliente(nome, cpf);
                        indiceClientes++;
                        System.out.println("Cliente cadastrado!");
                    } else {
                        System.out.println("Limite de clientes atingido.");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Nome do produto para venda: ");
                    String nomeVenda = sc.nextLine();

                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] != null && nomeVenda.equalsIgnoreCase(produtos[i].nome)) {
                            System.out.print("Quantidade desejada: ");
                            int qntVenda = sc.nextInt();
                            sc.nextLine();

                            venda.venda(produtos[i], qntVenda);
                            i = produtos.length;
                        }
                        if (i == produtos.length - 1) {
                            System.out.println("Produto não encontrado.");
                        }
                        System.out.println("Total da venda: R$"+venda.Total);
                    }
                    break;
                }


                case 4: {
                    System.out.print("Nome do produto para adicionar ao estoque: ");
                    String nomeestoque = sc.nextLine();

                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] != null && nomeestoque.equalsIgnoreCase(produtos[i].nome)) {
                            System.out.print("Quantidade desejada: ");
                            int addestoque = sc.nextInt();
                            sc.nextLine();

                            produtos[i].addEstoque(addestoque);
                            i = produtos.length;
                            System.out.println("Adicionado com sucesso!");
                        }
                        if (i == produtos.length - 1) {
                            System.out.println("Produto não encontrado.");
                        }
                    }
                    break;
                }


                case 0: {
                    System.out.println("Saindo");
                    sc.close();
                    break;
                }

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}