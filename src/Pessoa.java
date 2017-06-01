
public class Pessoa {

    private int _id;
    private String _nome;
    private String _cpf;
    private String _endereco;
    private String _telefone;

    public int getId()
    {
        return _id;
    }

    public void setId(int id)
    {
        this._id = id;
    }

    public String getNome()
    {
        return _nome;
    }

    public void setNome(String nome)
    {
        this._nome = nome;
    }

    public String getCpf()
    {
        return _cpf;
    }

    public void setCpf(String cpf)
    {
        this._cpf = cpf;
    }

    public String getEndereco()
    {
        return _endereco;
    }

    public void setEndereco(String endereco)
    {
        this._endereco = endereco;
    }

    public String getTelefone()
    {
        return _telefone;
    }

    public void setTelefone(String telefone)
    {
        this._telefone = telefone;
    }
}
