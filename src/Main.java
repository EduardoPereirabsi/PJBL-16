public class Main {
    public static void main(String[] args) throws Exception {
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", "Rua A, 123", "99999-9999", 150);
        Vendedor vendedor1 = new Vendedor("Carlos Santos", "111.222.333-44", "Rua C, 789", 5.5, 20, "98888-8888");

        Carro carro1 = new Carro("Toyota", "Corolla", 95000.00, 2021, false, 4, true);
        Moto moto1 = new Moto("Honda", "CB 500", 30000.00, 2022, true, "Esportiva", true);

        System.out.println("Informações dos Usuários:");
        cliente1.mostrarInfo();
        vendedor1.mostrarInfo();

        cliente1.adicionarPontos(50);
        System.out.println("Pontos de fidelidade do cliente após adicionar pontos: " + cliente1.getPontosFidelidade());

        System.out.println("\nInformações dos Veículos:");
        carro1.mostrarInfo();
        moto1.mostrarInfo();

        if (!carro1.isDisponivelParaVenda()){
            throw new VeiculoException("Veículo indisponivel para a venda!");
        }
    }
}
