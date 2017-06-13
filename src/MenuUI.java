import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class MenuUI {
    private static MenuUI instance = null;
    private BufferedReader br;

    private MenuUI()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static MenuUI getInstance()
    {
        if (instance == null)
            instance = new MenuUI();

        return instance;
    }

    public void run()
    {
        System.out.println(" - 1: Listar Objetos");
        System.out.println(" - 2: Criar Objetos");
        System.out.println(" - 3: Modificar Objetos");
        System.out.println(" - 4: Sair");

        switch (promptInt("Selecione uma opção [4]: ", 4))
        {
            case 1:
                listar();
                break;
            case 2:
                criar();
                break;
            case 3:
                modificar();
                break;
            case 4:
            default:
                return;
        }

        run();
    }

    private void listar()
    {
        System.out.println(" - 1: Listar Clientes");
        System.out.println(" - 2: Listar Funcionários");
        System.out.println(" - 3: Listar Produtos");
        System.out.println(" - 4: Listar Pedidos");
        System.out.println(" - 5: Retornar");

        switch (promptInt("Selecione uma opção [5]: ", 5))
        {
            case 1:
                listarClientes();
                break;
            case 2:
                listarFuncionarios();
                break;
            case 3:
                listarProdutos();
                break;
            case 4:
                listarPedidos();
                break;
            case 5:
            default:
                return;
        }

        listar();
    }

    private void listarClientes()
    {
        System.out.printf("%-4s | %-25s | %-14s | %-30s | %-15s\n",
                "ID", "Nome", "CPF", "Endereço", "Telefone");


        for (Cliente cliente : Farmacia.getInstance().getClientes())
        {
            System.out.printf("%-4d | %-25s | %-14s | %-30s | %-15s\n",
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getCpf(),
                    cliente.getEndereco(),
                    cliente.getTelefone());
        }
    }

    private void listarFuncionarios()
    {
        System.out.printf("%-4s | %-22s | %-14s | %-23s | %-15s | %-7s\n",
                "ID", "Nome", "CPF", "Endereço", "Telefone", "Salário");

        for (Funcionario func : Farmacia.getInstance().getFuncionarios())
        {
            System.out.printf("%-4d | %-22s | %-14s | %-23s | %-15s | %-7.2f\n",
                    func.getId(),
                    func.getNome(),
                    func.getCpf(),
                    func.getEndereco(),
                    func.getTelefone(),
                    func.getSalario());
        }
    }

    private void listarProdutos()
    {
        System.out.printf("%-4s | %-27s | %-25s | %-25s | %-7s\n",
                "ID", "Nome", "Fabricante", "Fornecedor", "Valor");

        for (Produto prod : Farmacia.getInstance().getProdutos())
        {

            System.out.printf("%-4d | %-27s | %-25s | %-25s | %-7.2f\n",
                    prod.getId(),
                    prod.getNome(),
                    prod.getFabricante(),
                    prod.getFornecedor(),
                    prod.getValor());
        }
    }

    private void listarPedidos()
    {
        System.out.println(" - 1: Listar por Clientes");
        System.out.println(" - 2: Listar por Funcionários");
        System.out.println(" - 3: Listar Todos");
        System.out.println(" - 4: Retornar");

        switch (promptInt("Selecione uma opção [4]: ", 4))
        {
            case 1:
                listarPedidosPorCliente();
                break;
            case 2:
                listarPedidosPorFuncionario();
                break;
            case 3:
                listarTodosPedidos();
                break;
            case 4:
            default:
                break;
        }
    }

    private void listarPedidosPorCliente()
    {
        listarClientes();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);

        if (id == -1) return;

        Farmacia.getInstance().getPedidosDoCliente(id).forEach(p -> prettyPrintPedido(p));

        listarPedidosPorCliente();
    }

    private void listarPedidosPorFuncionario()
    {
        listarFuncionarios();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);

        if (id == -1) return;

        Farmacia.getInstance().getPedidosVendidosPorFuncionario(id).forEach(p -> prettyPrintPedido(p));

        listarPedidosPorFuncionario();
    }

    private void listarTodosPedidos()
    {
        Farmacia.getInstance().getPedidos().forEach(p -> prettyPrintPedido(p));
    }

    private void prettyPrintPedido(Pedido p)
    {
        System.out.printf("Pedido: %d | Cliente: %d | Funcionário: %d\n",
                p.getId(), p.getIdCliente(), p.getIdFuncionario());

        System.out.println(" - Produtos:");
        System.out.printf(" -- %-4s | %-20s | %-20s | %-20s | %-10s | %-3s | %-7s\n",
                "ID", "Nome", "Fabricante", "Fornecedor", "Valor Und.", "Qtd", "Total");
        p.getProdutos().forEach(pq ->
        {
            System.out.printf(" -- %-4d | %-20s | %-20s | %-20s | %-10.2f | %-3d | %-7.2f\n",
                    pq.getProduto().getId(),
                    pq.getProduto().getNome(),
                    pq.getProduto().getFabricante(),
                    pq.getProduto().getFornecedor(),
                    pq.getProduto().getValor(),
                    pq.getQuantidade(),
                    pq.getQuantidade() * pq.getProduto().getValor());
        });
    }

    private void criar()
    {
        System.out.println(" - 1: Criar Funcionário");
        System.out.println(" - 2: Criar Cliente");
        System.out.println(" - 3: Criar Produto");
        System.out.println(" - 4: Criar Pedido");
        System.out.println(" - 4: Retornar");

        switch (promptInt("Selecione uma opção [5]: ", 5))
        {
            case 1:
                criarFuncionario();
                break;
            case 2:
                criarCliente();
                break;
            case 3:
                criarProduto();
            case 4:
                criarPedido();
                break;
            case 5:
            default:
                return;
        }

        criar();
    }

    private void criarFuncionario()
    {
        System.out.println("Entre com os dados do novo Funcionário...");
        String nome = promptString("Entre com Nome: ", "");
        String cpf = promptString("Entre com o CPF: ", "");
        String endereco = promptString("Entre com o Endereço: ", "");
        String telefone = promptString("Entre com o Telefone: ", "");
        double salario = promptDouble("Entre com o salário: ", 0.0);

        Funcionario func = new Funcionario(nome, cpf);
        func.setEndereco(endereco);
        func.setTelefone(telefone);
        func.setSalario(salario);
        Farmacia.getInstance().cadastrarFuncionario(func);
    }

    private void criarCliente()
    {
        System.out.println("Entre com os dados do novo Cliente...");
        String nome = promptString("Entre com Nome: ", "");
        String cpf = promptString("Entre com o CPF: ", "");
        String endereco = promptString("Entre com o Endereço: ", "");
        String telefone = promptString("Entre com o Telefone: ", "");

        Cliente clien = new Cliente(nome, cpf);
        clien.setEndereco(endereco);
        clien.setTelefone(telefone);
        Farmacia.getInstance().cadastrarCliente(clien);
    }

    private void criarProduto()
    {
        System.out.println("Entre com os dados do novo Produto...");
        String nome = promptString("Entre com o Nome: ", "");
        String fabricante = promptString("Entre com o Fabricante: ", "");
        String fornecedor = promptString("Entre com o Fornecedor: ", "");
        double valor = promptDouble("Entre com o Valor: ", 0.0);

        Produto prod = new Produto(nome, fabricante, fornecedor);
        prod.setValor(valor);
        Farmacia.getInstance().cadastrarProduto(prod);
    }

    private void criarPedido()
    {
        System.out.println("Entre com os dados do novo Pedido...");

        listarClientes();
        int idCliente = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);
        if (idCliente == -1) return;

        listarFuncionarios();
        int idFuncionario = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);
        if (idFuncionario == -1) return;

        Pedido pedido = new Pedido(idCliente, idFuncionario);

        int idProd = 0;
        while (idProd != -1)
        {
            if ((idProd = promptInt("Digite um ID (-1 Para Terminar) [-1]: ", -1)) != -1)
            {
                int quant = promptInt("Digite uma Quantidade [1]: ", 1);
                pedido.addProduto(Farmacia.getInstance().getProdutoPorId(idProd), quant);
            }
        }

        Farmacia.getInstance().adicionarPedido(pedido);
    }

    private void modificar()
    {
        System.out.println(" - 1: Alterar Funcionário");
        System.out.println(" - 2: Apagar Funcionário");
        System.out.println(" - 3: Alterar Cliente");
        System.out.println(" - 4: Apagar Cliente");
        System.out.println(" - 5: Alterar Produto");
        System.out.println(" - 6: Apagar Produto");
        System.out.println(" - 7: Alterar Pedido");
        System.out.println(" - 8: Apagar Pedido");
        System.out.println(" - 9: Retornar");

        switch (promptInt("Selecione uma opção [7]: ", 7))
        {
            case 1:
                alterarFuncionario();
                break;
            case 2:
                removerFuncionario();
                break;
            case 3:
                alterarCliente();
                break;
            case 4:
                removerCliente();
                break;
            case 5:
                alterarProduto();
                break;
            case 6:
                removerProduto();
                break;
            case 7:
                alterarPedido();
            case 8:
                removerPedido();
            case 9:
            default:
                return;
        }

        modificar();
    }

    private void alterarFuncionario()
    {
        System.out.println("Alterando Funcionário...");
        listarFuncionarios();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);

        if (id == -1) return;

        System.out.println("Digite os dados, enter para não modificar...");
        String nome = promptString("Entre com Nome: ", "");
        String cpf = promptString("Entre com o CPF: ", "");
        String endereco = promptString("Entre com o Endereço: ", "");
        String telefone = promptString("Entre com o Telefone: ", "");
        double salario = promptDouble("Entre com o salário: ", Double.MIN_VALUE);

        Funcionario func = Farmacia.getInstance().getFuncionarioPorId(id);

        if (!nome.isEmpty())
            func.setNome(nome);

        if (!cpf.isEmpty())
            func.setCpf(cpf);

        if (!endereco.isEmpty())
            func.setEndereco(endereco);

        if (!telefone.isEmpty())
            func.setTelefone(telefone);

        if (salario != Double.MIN_VALUE)
            func.setSalario(salario);

        alterarFuncionario();
    }

    private void alterarCliente()
    {
        System.out.println("Alterar professor...");
        listarClientes();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);

        if (id == -1) return;

        System.out.println("Digite os dados, enter para não modificar...");
        String nome = promptString("Entre com Nome: ", "");
        String cpf = promptString("Entre com o CPF: ", "");
        String endereco = promptString("Entre com o Endereço: ", "");
        String telefone = promptString("Entre com o Telefone: ", "");

        Cliente clien = Farmacia.getInstance().getClientePorId(id);

        if (!nome.isEmpty())
            clien.setNome(nome);

        if (!cpf.isEmpty())
            clien.setCpf(cpf);

        if (!endereco.isEmpty())
            clien.setEndereco(endereco);

        if (!telefone.isEmpty())
            clien.setTelefone(telefone);
    }

    private void removerFuncionario()
    {
        listarFuncionarios();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);

        if (id == -1) return;

        Farmacia.getInstance().removerFuncionario(id);

        removerFuncionario();
    }

    private void removerCliente()
    {
        listarClientes();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);

        if (id == -1) return;

        Farmacia.getInstance().removerCliente(id);

        removerCliente();
    }

    private void alterarProduto()
    {
        listarProdutos();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);
        if (id == -1) return;

        String nome = promptString("Digite o Nome: ", "");
        String fabricante = promptString("Digite o Fabricante: ", "");
        String fornecedor = promptString("Digite o Fornecedor: ", "");
        double valor = promptDouble("Digite o Valor: ", Double.MIN_VALUE);

        Produto prod = Farmacia.getInstance().getProdutoPorId(id);

        if (!stringNullOrEmpty(nome))
            prod.setNome(nome);

        if (!stringNullOrEmpty(fabricante))
            prod.setFabricante(fabricante);

        if (!stringNullOrEmpty(fornecedor))
            prod.setFornecedor(fornecedor);

        if (valor != Double.MIN_VALUE)
            prod.setValor(valor);

        System.out.println("Produto atualizado!");
    }

    private void removerProduto()
    {
        listarProdutos();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);
        if (id == -1) return;

        Farmacia.getInstance().removerProduto(id);

        removerProduto();
    }

    private void alterarPedido()
    {
        listarTodosPedidos();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);
        if (id == -1) return;

        Pedido ped = Farmacia.getInstance().getPedidoPorId(id);

        System.out.println(" - 1: Adicionar Produto ao Pedido");
        System.out.println(" - 2: Alterar quantidade de Produto no Pedido");
        System.out.println(" - 3: Sair");
        switch (promptInt("Selecione uma opção[3]: ", 3))
        {
            case 1:
            {
                listarProdutos();

                int idProduto = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);
                if (idProduto == -1) break;

                Produto prod = Farmacia.getInstance().getProdutoPorId(idProduto);

                int quantidade = promptInt("Digite a quantidade [1]: ", 1);

                ped.addProduto(prod, quantidade);
                break;
            }
            case 2:
            {
                listarProdutos();

                while (true)
                {
                    int idProduto = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);
                    if (idProduto == -1) break;

                    int quantidade = promptInt("Digite a quantidade [1]: ", 1);

                    if (ped.setQuantidadeProduto(idProduto, quantidade))
                    {
                        break;
                    }

                    System.out.println("Pedido não contém o produto específicado!");
                }
                break;
            }
            case 3:
            default:
                break;
        }

        System.out.println("Pedido atualizado!");
    }

    private void removerPedido()
    {
        listarTodosPedidos();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);
        if (id == -1) return;

        Farmacia.getInstance().removerPedido(id);

        removerPedido();
    }

    private int promptInt(String msg, int def)
    {
        if (!stringNullOrEmpty(msg))
            System.out.printf("%s", msg);

        try
        {
            String line = br.readLine();

            if (stringNullOrEmpty(line))
                return def;

            try
            {
                return Integer.parseInt(line);
            } catch (NumberFormatException e)
            {
                System.out.println("Entrada não é um número inteiro!");
                return promptInt(msg, def);
            }
        } catch (IOException e)
        {
            System.out.println("Erro de E/S: " + e.getMessage());
        }

        return def;
    }

    private Double promptDouble(String msg, double def)
    {
        if (!stringNullOrEmpty(msg))
            System.out.printf("%s", msg);

        try
        {
            String line = br.readLine();

            if (stringNullOrEmpty(line))
                return def;

            try
            {
                return Double.parseDouble(line);
            } catch (NumberFormatException e)
            {
                System.out.println("Entrada não é um número real!");
                return promptDouble(msg, def);
            }
        } catch (IOException e)
        {
            System.out.println("Erro de E/S: " + e.getMessage());
        }

        return def;
    }

    private String promptString(String msg, String def)
    {
        if (!stringNullOrEmpty(msg))
            System.out.printf("%s", msg);

        try
        {
            String line = br.readLine();

            if (stringNullOrEmpty(line))
                return def;

            return line;
        } catch (IOException e)
        {
            System.out.println("Erro de E/S: " + e.getMessage());
        }

        return def;
    }

    private boolean stringNullOrEmpty(String str)
    {
        if (str != null)
            if (!str.isEmpty())
                return false;

        return true;
    }
}
