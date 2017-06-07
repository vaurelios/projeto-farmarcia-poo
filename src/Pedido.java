import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

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

        this.id = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
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
}
