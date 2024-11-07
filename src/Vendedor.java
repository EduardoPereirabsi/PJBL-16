public class Vendedor extends Funcionario {
    private double bonusMeta;

    public Vendedor() {
        super();
    }

    public Vendedor(String nome, String cpf, String endereco, double bonusMeta, double salario, String telefone) {
        super(nome, cpf, endereco, telefone, salario);
        this.bonusMeta = bonusMeta;
    }

    public double getBonusMeta() { return bonusMeta; }
    public void setBonusMeta(double bonusMeta) { this.bonusMeta = bonusMeta; }


    @Override
    public void mostrarInfo() {
        System.out.println("Vendedor: " + getNome() + ", CPF: " + getCpf() + ", Bonus Meta: " + bonusMeta );
    }
}
