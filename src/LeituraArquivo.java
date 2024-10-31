import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraArquivo {

    public void lerArquivoFuncionario(String caminhoArquivo) {
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