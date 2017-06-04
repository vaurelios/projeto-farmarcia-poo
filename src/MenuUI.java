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
                // listarPedidos();
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

    private void criar()
    {
        System.out.println(" - 1: Criar Funcionário");
        System.out.println(" - 2: Criar Cliente");
        System.out.println(" - 3: Criar Produto");
        System.out.println(" - 4: Retornar");

        switch (promptInt("Selecione uma opção [4]: ", 4))
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

    private void modificar()
    {
        System.out.println(" - 1: Alterar Funcionário");
        System.out.println(" - 2: Apagar Funcionário");
        System.out.println(" - 3: Alterar Cliente");
        System.out.println(" - 4: Apagar Cliente");
        System.out.println(" - 5: Alterar Produto");
        System.out.println(" - 6: Apagar Produto");
        System.out.println(" - 7: Retornar");

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
                // alterarAluno();
                break;
            case 6:
                removerProduto();
                break;
            case 7:
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

    private void removerProduto()
    {
        listarProdutos();

        int id = promptInt("Digite um ID (-1 Para Voltar) [-1]: ", -1);

        if (id == -1) return;

        Farmacia.getInstance().removerProduto(id);

        removerProduto();
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
