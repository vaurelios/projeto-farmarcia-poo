public class Cliente extends Pessoa {

    private static int last_id = 0;

    private int id;

    public Cliente(String nome, String cpf)
    {
        super(nome, cpf);

        this.id = ++last_id;
    }

    public int getId()
    {
        return id;
    }
}
