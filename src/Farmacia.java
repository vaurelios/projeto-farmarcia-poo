import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Farmacia {

    private static Farmacia instance = null;
    private Map<Integer, Cliente> clientes;
    private Map<Integer, Funcionario> funcionarios;
    private Map<Integer, Produto> produtos;
    private Map<Integer, Pedido> pedidos;

    private Farmacia() {
        clientes = new HashMap<>();
        funcionarios = new HashMap<>();
        produtos = new HashMap<>();
        pedidos = new HashMap<>();
    }

    public static Farmacia getInstance()
    {
        if (instance == null)
            instance = new Farmacia();

        return instance;
    }

	/**
	 * Este método adiciona um novo produto a ser negociado na farmacia. Esse
	 * novo produto precisa ser um produto válido.
	 *
	 * @param novoProduto
	 *            Produto a ser cadastrado na farmácia.
	 */
	public void cadastrarProduto(Produto novoProduto)
	{
        if (novoProduto != null && !produtos.containsKey(novoProduto.getId()))
        {
            produtos.put(novoProduto.getId(), novoProduto);
            return;
        }

        throw new IllegalArgumentException("Produto já cadastrado ou inválido!");
	}

	/**
	 * Este método remove um produto com o id especificado
	 *
	 * @param id
	 *            Id do produto a ser removido
	 *
	 * @return O produto que foi removido
	 */
	public Produto removerProduto(int id)
    {
        if (produtos.containsKey(id))
            return produtos.remove(id);

        throw new IndexOutOfBoundsException("Produto com ID especificado não existe!");
	}

	/**
	 * Este método adiciona um novo cliente no sistema da farmacia. Esse novo
	 * cliente precisa ser um cliente válido.
	 *
	 * @param novoCliente
	 *            o cliente a ser adicionado ao sistema
	 */
	public void cadastrarCliente(Cliente novoCliente)
    {
        if (novoCliente != null && !clientes.containsKey(novoCliente.getId()))
        {
            clientes.put(novoCliente.getId(), novoCliente);
            return;
        }


        throw new IllegalArgumentException("Cliente já existente ou inválido!");
	}

	/**
	 * Remove um Cliente com o id especificado
	 *
	 * @param id
	 *            Id do cliente
	 * @return o cliente removido
	 */
	public Cliente removerCliente(int id)
    {
        if (clientes.containsKey(id))
            return clientes.remove(id);

        throw new IndexOutOfBoundsException("Cliente com ID especificado não existe!");
	}

	/**
	 * Este método adiciona um novo funcionario no sistema da farmacia. Esse
	 * novo funcionario precisa ser um funcionario válido.
	 *
	 * @param novoFuncionario
	 *            o funcionario a ser adicionado no sistema
	 */
	public void cadastrarFuncionario(Funcionario novoFuncionario)
    {
        if (novoFuncionario != null && !funcionarios.containsKey(novoFuncionario.getId()))
		{
			funcionarios.put(novoFuncionario.getId(), novoFuncionario);
			return;
		}

        throw new IllegalArgumentException("Cliente já existente ou inválio!");
	}

	/**
	 * Remove um funcionario com o id especificado
	 *
	 * @param id
	 *            Id do funcionario
	 * @return o funcionario removido
	 */
	public Funcionario removerFuncionario(int id)
    {
        if (funcionarios.containsKey(id))
            return funcionarios.remove(id);

        throw new IndexOutOfBoundsException("Funcionario com ID especificado não existe!");
	}

	/**
	 * Este método adiciona um novo pedido a um cliente já cadastrado no sistema
	 * da farmacia. Esse novo pedido precisa ser um pedido válido, assim como a
	 * identificador do cliente relacionado ao pedido.
	 *
	 * @param novoPedido
	 *            o pedido a ser adicionado ao cliente já cadastrado
	 */
	public void adicionarPedido(Pedido novoPedido)
    {
        if (novoPedido != null)
        {
            pedidos.put(novoPedido.getId(), novoPedido);
            return;
        }

        throw new IllegalArgumentException("Pedido especificado inválido!");
	}

	/**
	 * Obtém a quantidade de clientes cadastrados no sistema.
	 *
	 * @return a quantidade de clientes cadastrados no sistema.
	 */
	public int getQtClientes()
    {
		return clientes.size();
	}

	/**
	 * Obtém a quantidade de produtos cadastrados no sistema.
	 *
	 * @return a quantidade de produtos cadastrados no sistema.
	 */
	public int getQtProdutos()
    {
		return produtos.size();
	}

	/**
	 * Obtém a quantidade de funcionarios cadastrados no sistema.
	 *
	 * @return a quantidade de funcionarios cadastrados no sistema.
	 */
	public int getQtFuncionarios()
    {
		return funcionarios.size();
	}

	/**
	 * Obtém o valor de um pedido especefico associado a um cliente especefico.
	 *
	 * @param idPedido
	 *            Id do pedido especefico.
	 *
	 * @return o valor do pedido com id informado associado ao cliente com id
	 *         informado.
	 */
	public double getValorPedido(int idPedido)
    {
        if (pedidos.containsKey(idPedido))
        {
            return pedidos.get(idPedido).getValor();
        }

        throw new IndexOutOfBoundsException("ID do cliente ou do Pedido não existe!");
	}

	/**
	 * Obtém a lista de pedidos associados a um cliente especefico.
	 *
	 * @param id
	 *            Id do cliente
	 * @return a lista de pedidos associados a um cliente com id informado.
	 */
	public List<Pedido> getPedidosDoCliente(int id)
    {
        if (clientes.containsKey(id))
            return pedidos.values().stream().filter(p -> p.getIdCliente() == id).collect(Collectors.toList());

        throw new IndexOutOfBoundsException("Cliente com ID especificado não existente!");
	}

	/**
	 * Obtém a lista de pedidos vendido por um funcionario especefico.
	 *
	 * @param id
	 *            Id do funcionario
	 * @return a lista de pedidos vendido pelo funcionario com id informado.
	 */
	public List<Pedido> getPedidosVendidosPorFuncionario(int id)
    {
        pedidos.values().forEach(p -> System.out.println(p.toString()));

        return pedidos.values().stream().filter(p -> p.getIdFuncionario() == id).collect(Collectors.toList());
    }

    public List<Pedido> getPedidos()
    {
        return new ArrayList<>(pedidos.values());
    }

	public List<Cliente> getClientes()
    {
        return new ArrayList<>(clientes.values());
    }

    public List<Funcionario> getFuncionarios()
    {
        return new ArrayList<>(funcionarios.values());
    }

    public List<Produto> getProdutos()
    {
        return new ArrayList<>(produtos.values());
    }

    public Funcionario getFuncionarioPorId(int id)
    {
        if (funcionarios.containsKey(id))
            return funcionarios.get(id);

        throw new IndexOutOfBoundsException("Funcioário com ID especificado não existe!");
    }

    public Cliente getClientePorId(int id)
    {
        if (clientes.containsKey(id))
            return clientes.get(id);

        throw new IndexOutOfBoundsException("Cliente com ID especificado não existe!");
    }
}
