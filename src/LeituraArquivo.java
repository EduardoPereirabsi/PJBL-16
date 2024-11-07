import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LeituraArquivo {

    public ArrayList<Vendedor> lerArquivoVendedor(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");

                if (dados.length == 6) {
                    Vendedor vendedor = new Vendedor();
                    vendedor.setNome(dados[0]);
                    vendedor.setCpf(dados[1]);
                    vendedor.setEndereco(dados[2]);
                    vendedor.setTelefone(dados[3]);
                    vendedor.setSalario(Double.parseDouble(dados[4]));
                    vendedor.setBonusMeta(Double.parseDouble(dados[5]));
                    vendedores.add(vendedor);
                } else {
                    System.out.println("Dados incompletos na linha: " + linha);
                }
            }
            return vendedores;

        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
    public void lerArquivoGerente(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");

                if (dados.length == 5) {
                    String nome = dados[0];
                    String cpf = dados[1];
                    String endereco = dados[2];
                    String telefone = dados[3];
                    double salario = Double.parseDouble(dados[4]);

                    System.out.println("Nome: " + nome);
                    System.out.println("CPF: " + cpf);
                    System.out.println("Endereço: " + endereco);
                    System.out.println("Telefone: " + telefone);
                    System.out.println("Salário: " + salario);
                    System.out.println("-------------------------");
                } else {
                    System.out.println("Dados incompletos na linha: " + linha);
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
