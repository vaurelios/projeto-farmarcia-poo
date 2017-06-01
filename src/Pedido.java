import java.util.Map;

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

    private Map<Integer, ProdutoQuantidade> produtos;
    private Funcionario funcionario;
}
