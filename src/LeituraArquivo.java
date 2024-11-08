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
                    carro.setPreco(Double.parseDouble(dados[2]));
                    carro.setAno(Integer.parseInt(dados[3]));
                    carro.setNumeroPortas(4);
                    // carro.setTemArCondicionado(5);
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
    public ArrayList<Moto> lerArquivoMoto(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            ArrayList<Moto> motos = new ArrayList<Moto>();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");

                if (dados.length == 5) {
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
