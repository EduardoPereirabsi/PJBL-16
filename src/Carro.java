public class Carro extends Veiculo {
    private int numPortas;
    public Carro() {
    }

    public Carro(String marca, String modelo, double preco, int ano, String placa,boolean disponivelParaVenda, int numPortas) {
        super(marca, modelo, preco, ano ,placa ,disponivelParaVenda);
        this.numPortas = numPortas;
    }

    public Carro(String marca, String modelo, double preco, int ano) {
        super(marca, modelo, preco, ano);
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Carro: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAno() + ", Preço: " + getPreco());
    }
}

