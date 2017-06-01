
public class Produto {

    private int id;
    private String nome;
    private String fabricante;
    private String fornecedor;
    private String valor;

    public Produto()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }

    public String getFornecedor()
    {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor)
    {
        this.fornecedor = fornecedor;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }
}
