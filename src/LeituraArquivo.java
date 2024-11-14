import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Gerente> lerArquivoGerente(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            ArrayList<Gerente> gerentes = new ArrayList<Gerente>();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");

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
            return gerentes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cliente> lerArquivoCliente(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            ArrayList<Cliente> clientes = new ArrayList<Cliente>();

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split("\\|");

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
            return clientes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Carro> lerArquivoCarro(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            ArrayList<Carro> carros = new ArrayList<Carro>();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");

                if (dados.length == 6) {
                    Carro carro = new Carro();
                    carro.setMarca(dados[0]);
                    carro.setModelo(dados[1]);
                    carro.setAno(Integer.parseInt(dados[2]));
                    carro.setPreco(Double.parseDouble(dados[3]));
                    carro.setPlaca(dados[4]);
                    carro.setNumPortas(Integer.parseInt(dados[5]));
                    carros.add(carro);

                } else {
                    System.out.println("Dados incompletos na linha: " + linha);
                }
            }
            return carros;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void salvarArquivoCarro(String caminhoArquivo, Carro carro) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
                bw.write(carro.getMarca() + "|" +
                        carro.getModelo() + "|" +
                        carro.getAno() + "|" +
                        carro.getPreco() + "|" +
                        carro.getPlaca() + "|" +
                        carro.getNumPortas());

                bw.newLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void removerLinhas(String caminhoArquivo, String placa) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));

            List<String> linhasFiltradas = new ArrayList<>();
            for (String linha : linhas) {
                if (!linha.contains(placa)) {
                    linhasFiltradas.add(linha);
                }
            }

            Files.write(Paths.get(caminhoArquivo), linhasFiltradas);


        } catch (Exception e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
    public ArrayList<Moto> lerArquivoMoto(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            ArrayList<Moto> motos = new ArrayList<Moto>();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");

                if (dados.length == 4) {
                    Moto moto = new Moto();
                    moto.setMarca(dados[0]);
                    moto.setModelo(dados[1]);
                    moto.setPreco(Double.parseDouble(dados[2]));
                    moto.setAno(Integer.parseInt(dados[3]));
                    //   moto.setTemABS(4);
                    motos.add(moto);

                } else {
                    System.out.println("Dados incompletos na linha: " + linha);
                }
            }
            return motos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
