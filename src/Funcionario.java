public class Funcionario extends Pessoa {

    private static int last_id = 0;

    private int id;
    private double salario = .0d;

    public Funcionario(String nome, String cpf)
    {
        super(nome, cpf);

        this.id = ++last_id;
    }

    public int getId()
    {
        return id;
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
