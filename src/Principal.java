public class Principal {

    public static void main(String[] args)
    {
        // dados de demonstração
        if (true)
        {
            Funcionario func = new Funcionario("Idnis Sorim", "123.456.789-00");
            func.setTelefone("N/A");
            func.setSalario(937.50);

            Cliente clien = new Cliente("Victor Aurélio", "987.654.321-00");
            clien.setEndereco("Remígio-PB");

            Produto prod = new Produto("Laptop", "LP", "LP LTDA");
            prod.setValor(1500);

            Farmacia.getInstance().cadastrarFuncionario(func);
            Farmacia.getInstance().cadastrarCliente(clien);
            Farmacia.getInstance().cadastrarProduto(prod);

            Pedido ped = new Pedido(clien.getId(), func.getId());
            ped.addProduto(prod, 5);

            Farmacia.getInstance().adicionarPedido(ped);
        }

        MenuUI.getInstance().run();
    }
}
