public class Moto extends Veiculo {
    private String tipo;
    private boolean temABS;

    public Moto() {
        super();
    }

    public Moto(String marca, String modelo, double preco, int ano, boolean disponivelParaVenda, String tipo, boolean temABS) {
        super(marca, modelo, preco, ano, disponivelParaVenda);
        this.tipo = tipo;
        this.temABS = temABS;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isTemABS() { return temABS; }
    public void setTemABS(boolean temABS) { this.temABS = temABS; }

    @Override
    public void mostrarInfo() {
        System.out.println("Moto: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAno() + ", Preço: " + getPreco() + ", Tipo: " + tipo + ", ABS: " + temABS);
    }
}
