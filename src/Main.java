import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws Exception {
        LeituraArquivo leituraArquivo = new LeituraArquivo();
        ArrayList<Vendedor> vendedores = leituraArquivo.lerArquivoVendedor("C:\\DadosVendedor.txt");

        ArrayList<Gerente> gerentes = leituraArquivo.lerArquivoGerente("C:\\DadosGerente.txt");

        ArrayList<Cliente> clientes = leituraArquivo.lerArquivoCliente("C:\\DadosCliente.txt");

        ArrayList<Carro> carros = leituraArquivo.lerArquivoCarro("C:\\DadosCarro.txt");

        ArrayList<Moto> motos = leituraArquivo.lerArquivoMoto("C:\\DadosMoto.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Gp\\Gpt.txt"))){
            bw.write("Pai");
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CatalogoCarro().setVisible(true);
            }
        });

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
