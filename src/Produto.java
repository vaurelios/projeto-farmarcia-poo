public class Produto {

    private static int last_id = 0;

    private int id;
    private String nome;
    private String fabricante;
    private String fornecedor;
    private double valor = .0d;

    public Produto(String nome, String fabricante, String fornecedor)
    {
        this.id = ++last_id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.fornecedor = fornecedor;
    }

    public int getId()
    {
        return id;
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

    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }
}
