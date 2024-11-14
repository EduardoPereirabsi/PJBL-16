public abstract class Veiculo {
    private String marca;
    private String modelo;
    private double preco;
    private int ano;
    private boolean disponivelParaVenda; 

    public Veiculo() {}

    public Veiculo(String marca, String modelo, double preco, int ano, boolean disponivelParaVenda) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.ano = ano;
        this.disponivelParaVenda = disponivelParaVenda;
    }
    public Veiculo(String marca, String modelo, double preco, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.ano = ano;
    }

    public Veiculo(String marca, String modelo, double preco, int ano, boolean disponivelParaVenda, String fabricante) {
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public boolean isDisponivelParaVenda() {
        return disponivelParaVenda; }

    public void setDisponivelParaVenda(boolean disponivelParaVenda) {
        this.disponivelParaVenda = disponivelParaVenda; }

    public abstract void mostrarInfo();
}
