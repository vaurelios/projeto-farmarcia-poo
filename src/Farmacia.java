import java.util.List;

public class Farmacia {

	/**
	 * Este método adiciona um novo produto a ser negociado na farmacia. Esse
	 * novo produto precisa ser um produto válido.
	 * 
	 * @param novoProduto
	 *            Produto a ser cadastrado na farmácia.
	 */
	public void cadastrarProduto(Produto novoProduto) {
		
		if (novoProduto == null) {
			throw new IllegalArgumentException("Produto não pode ser null.");
		}

	}

	/**
	 * Este método remove um produto com o id especificado
	 * 
	 * @param idProduto
	 *            Id do produto a ser removido
	 * 
	 * @return O produto que foi removido
	 */
	public Produto removerProduto(int idProduto) {
		return null;
	}

	/**
	 * Este método adiciona um novo cliente no sistema da farmacia. Esse novo
	 * cliente precisa ser um cliente válido.
	 * 
	 * @param novoCliente
	 *            o cliente a ser adicionado ao sistema
	 */
	public void cadastrarCliente(Cliente novoCliente) {

	}

	/**
	 * Remove um Cliente com o id especificado
	 * 
	 * @param idCliente
	 *            Id do cliente
	 * @return o cliente removido
	 */
	public Cliente removerCliente(int idCliente) {

		return null;
	}

	/**
	 * Este método adiciona um novo funcionario no sistema da farmacia. Esse
	 * novo funcionario precisa ser um funcionario válido.
	 * 
	 * @param novoFuncionario
	 *            o funcionario a ser adicionado no sistema
	 */
	public void cadastrarFuncionario(Funcionario novoFuncionario) {

	}

	/**
	 * Remove um funcionario com o id especificado
	 * 
	 * @param idFuncionario
	 *            Id do funcionario
	 * @return o funcionario removido
	 */
	public Funcionario removerFuncionario(int idFuncionario) {

		return null;
	}

	/**
	 * Este método adiciona um novo pedido a um cliente já cadastrado no sistema
	 * da farmacia. Esse novo pedido precisa ser um pedido válido, assim como a
	 * identificador do cliente relacionado ao pedido.
	 * 
	 * @param idCliente
	 *            Id do cliente que realizaou o pedido
	 * @param novoPedido
	 *            o pedido a ser adicionado ao cliente já cadastrado
	 */
	public void adicionarPedido(int idCliente, Pedido novoPedido) {

	}

	/**
	 * Obtém a quantidade de clientes cadastrados no sistema.
	 * 
	 * @return a quantidade de clientes cadastrados no sistema.
	 */
	public int getQtClientes() {
		return -1;
	}

	/**
	 * Obtém a quantidade de produtos cadastrados no sistema.
	 * 
	 * @return a quantidade de produtos cadastrados no sistema.
	 */
	public int getQtProdutos() {
		return -1;
	}

	/**
	 * Obtém a quantidade de funcionarios cadastrados no sistema.
	 * 
	 * @return a quantidade de funcionarios cadastrados no sistema.
	 */
	public int getQtFuncionarios() {
		return -1;
	}

	/**
	 * Obtém o valor de um pedido específico associado a um cliente específico.
	 * 
	 * @param idCliente
	 *            Id do cliente que realizou o pedido.
	 * @param idPedido
	 *            Id do pedido específico.
	 * 
	 * @return o valor do pedido com id informado associado ao cliente com id
	 *         informado.
	 */
	public double getValorPedido(int idCliente, int idPedido) {
		return -1;
	}

	/**
	 * Obtém a lista de pedidos associados a um cliente específico.
	 * 
	 * @param idCliente
	 *            Id do cliente
	 * @return a lista de pedidos associados a um cliente com id informado.
	 */
	public List<Pedido> getPedidosDoCliente(int idCliente) {

		return null;
	}

	/**
	 * Obtém a lista de pedidos vendido por um funcionario específico.
	 * 
	 * @param idFuncionario
	 *            Id do funcionario
	 * @return a lista de pedidos vendido pelo funcionario com id informado.
	 */
	public List<Pedido> getPedidosVendidosPorFuncionario(int idFuncionario) {

		return null;
	}

}
