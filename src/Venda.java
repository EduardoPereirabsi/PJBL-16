import java.util.Date;

public class Venda {
    private Vendedor vendedor;
    private Cliente cliente;
    private Veiculo veiculo;
    private double preco;
    private Date dataVenda;

    public Venda(Vendedor vendedor, Cliente cliente, Veiculo veiculo, double preco, Date dataVenda) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.preco = preco;
        this.dataVenda = dataVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    public void mostrarVenda() {
        System.out.println("Vendedor: " + vendedor.getNome());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getMarca() + " " + veiculo.getModelo());
        System.out.println("Preço de Venda: " + preco);
        System.out.println("Venda realizada em " + dataVenda);
    }
}
