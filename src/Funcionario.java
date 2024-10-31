public class Funcionario extends Usuario {
    private double salario;

    public Funcionario(String nome, String cpf, String endereco, String telefone, double salario) {
        super(nome, cpf, endereco, telefone);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Cliente: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() + ", Salario: " + getSalario());
    }
}
