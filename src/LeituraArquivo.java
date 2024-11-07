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

            ArrayList<Gerente> gerentes = new ArrayList<Gerente>();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\|");

                if (dados.length == 5) {
                    Gerente gerente = new Gerente();
                    gerente.setNome(dados[0]);
                    gerente.setCpf(dados[1]);
                    gerente.setEndereco(dados[2]);
                    gerente.setTelefone(dados[3]);
                    gerente.setSalario(Double.parseDouble(dados[4]));
                    gerentes.add(gerente);

                } else {
                    System.out.println("Dados incompletos na linha: " + linha);
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void lerArquivoCliente(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            ArrayList<Cliente> clientes = new ArrayList<Cliente>();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\|");

                if (dados.length == 4) {
                    Cliente cliente = new Cliente();
                    cliente.setNome(dados[0]);
                    cliente.setCpf(dados[1]);
                    cliente.setEndereco(dados[2]);
                    cliente.setTelefone(dados[3]);
                    clientes.add(cliente);

                } else {
                    System.out.println("Dados incompletos na linha: " + linha);
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }