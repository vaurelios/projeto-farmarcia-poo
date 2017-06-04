
public class Funcionario extends Pessoa {

    private double salario = .0d;

    public Funcionario(String nome, String cpf)
    {
        super(nome, cpf);
    }

    public double getSalario()
    {
        return salario;
    }

    public void setSalario(double salario)
    {
        this.salario = salario;
    }
}
