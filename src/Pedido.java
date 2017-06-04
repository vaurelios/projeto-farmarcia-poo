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

    private int id;
    private Map<Integer, ProdutoQuantidade> produtos;
    private int idCliente;
    private int idFuncionario;

    public Pedido(int idCliente, int idFuncionario)
    {
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

        for (ProdutoQuantidade pq : produtos.values())
        {
            valor += pq.getQuantidade() * pq.getProduto().getValor();
        }

        return valor;
    }
}
