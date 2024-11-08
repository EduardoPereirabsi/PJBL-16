public class Carro extends Veiculo {
    private int numeroPortas;
    private boolean temArCondicionado;

    public Carro() {

    }

    public Carro(String marca, String modelo, double preco, int ano, boolean disponivelParaVenda, int numeroPortas, boolean temArCondicionado) {
        super(marca, modelo, preco, ano, disponivelParaVenda);
        this.numeroPortas = numeroPortas;
        this.temArCondicionado = temArCondicionado;
    }


    public int getNumeroPortas() { return numeroPortas; }
    public void setNumeroPortas(int numeroPortas) { this.numeroPortas = numeroPortas; }

    public boolean isTemArCondicionado() { return temArCondicionado; }
    public void setTemArCondicionado(boolean temArCondicionado) { this.temArCondicionado = temArCondicionado; }

    @Override
    public void mostrarInfo() {
        System.out.println("Carro: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAno() + ", Preço: " + getPreco() + ", Portas: " + numeroPortas + ", Ar Condicionado: " + temArCondicionado);
    }
}
