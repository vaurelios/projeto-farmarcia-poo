import java.util.ArrayList;
import java.util.List;

class ProdutoQuantidade {

    private Produto prod;
    private int quant;

    public ProdutoQuantidade(Produto prod, int quant)
    {
        this.prod = prod;
        this.quant = quant;
    }

    public Produto getProduto()
    {
        return prod;
    }

    public int getQuantidade()
    {
        return quant;
    }

    public void setQuantquantidade(int quant)
    {
        this.quant = quant;
    }
}

public class Pedido {

    private static int last_id = 0;

    private int id;
    private List<ProdutoQuantidade> produtos;
    private int idCliente;
    private int idFuncionario;

    public Pedido(int idCliente, int idFuncionario)
    {
        this.id = ++last_id;

        produtos = new ArrayList<>();

        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
    }

    public int getId()
    {
        return id;
    }

    public int getIdCliente()
    {
        return idCliente;
    }

    public int getIdFuncionario()
    {
        return idFuncionario;
    }

    public double getValor()
    {
        double valor = .0d;

        for (ProdutoQuantidade pq : produtos)
        {
            valor += pq.getQuantidade() * pq.getProduto().getValor();
        }

        return valor;
    }

    public List<ProdutoQuantidade> getProdutos()
    {
        return produtos;
    }

    public void addProduto(Produto produto, int quant)
    {
        ProdutoQuantidade pq = null;

        for (ProdutoQuantidade prodq : produtos)
        {
            if (prodq.getProduto().getId() == produto.getId())
            {
                pq = prodq;
                break;
            }
        }

        if (pq == null)
        {
            pq = new ProdutoQuantidade(produto, quant);

            produtos.add(pq);
        } else
        {
            pq.setQuantquantidade(pq.getQuantidade() + quant);
        }
    }

    /**
     * Altera a quantidade de determinado produto no pedido.
     *
     * @param idProduto Id do Produto especefico.
     * @param quant nova quantidade
     * @return true se bem sucedido, false se pedido não contém produto.
     */
    public boolean setQuantidadeProduto(int idProduto, int quant)
    {
        ProdutoQuantidade prodq = null;

        for (ProdutoQuantidade pq : produtos)
        {
            if (pq.getProduto().getId() == idProduto)
                prodq = pq;
        }

        if (prodq == null) return false;

        prodq.setQuantquantidade(quant);

        return true;
    }
}
