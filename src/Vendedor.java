public class Vendedor extends Funcionario {
    private double comissao;

    public Vendedor(String nome, String cpf, String endereco, double comissao, double salario, String telefone) {
        super(nome, cpf, endereco, telefone, salario);
        this.comissao = comissao;
    }

    public double getComissao() { return comissao; }
    public void setComissao(double comissao) { this.comissao = comissao; }


    @Override
    public void mostrarInfo() {
        System.out.println("Vendedor: " + getNome() + ", CPF: " + getCpf() + ", Comissão: " + comissao );
    }
}
