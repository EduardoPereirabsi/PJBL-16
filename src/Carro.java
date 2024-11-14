public class Carro extends Veiculo {
    public Carro() {
    }

    public Carro(String marca, String modelo, double preco, int ano, boolean disponivelParaVenda) {
        super(marca, modelo, preco, ano, disponivelParaVenda);
    }


    public Carro(String marca, String modelo, double preco, int ano) {
        super(marca, modelo, preco, ano);
    }


    @Override
    public void mostrarInfo() {
        System.out.println("Carro: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAno() + ", Preço: " + getPreco());
    }
}

