import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        LeituraArquivo arqVendedor = new LeituraArquivo();
        ArrayList<Vendedor> vendedores = arqVendedor.lerArquivoVendedor("C:\\DadosVendedor.txt");

        LeituraArquivo arqGerente = new LeituraArquivo();
        ArrayList<Gerente> gerentes = arqGerente.lerArquivoGerente("C:\\DadosGerente.txt");

        LeituraArquivo arqCliente = new LeituraArquivo();
        ArrayList<Cliente> clientes = arqCliente.lerArquivoCliente("C:\\DadosCliente.txt");


        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", "Rua A, 123", "99999-9999", 150);
        Vendedor vendedor1 = new Vendedor("Carlos Santos", "111.222.333-44", "Rua C, 789", 5.5, 20, "98888-8888");

        Veiculo carro1 = new Carro("Toyota", "Corolla", 95000.00, 2021, true, 4, true);
        Veiculo moto1 = new Moto("Honda", "CB 500", 30000.00, 2022, true, "Esportiva", true);

        Venda venda1 = new Venda(vendedor1, cliente1, carro1, carro1.getPreco(), new Date());

        venda1.mostrarVenda();

        System.out.println("\nInformações dos Usuários:");
        cliente1.mostrarInfo();
        vendedor1.mostrarInfo();

        cliente1.adicionarPontos(50);
        System.out.println("Pontos de fidelidade do cliente após adicionar pontos: " + cliente1.getPontosFidelidade());

        System.out.println("\nInformações dos Veículos:");
        carro1.mostrarInfo();
        moto1.mostrarInfo();


        if (!carro1.isDisponivelParaVenda()) {
            throw new VeiculoIndisponivelException("Veículo indisponivel para a venda!");
        }
    }
}
