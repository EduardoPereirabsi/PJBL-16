public class Gerente extends Funcionario {


    public Gerente(String nome, String cpf, String endereco, String telefone, double salario) {
        super(nome, cpf, endereco, telefone, salario);
    }


    public void mostrarInfo() {
        System.out.println("Gerente: " + getNome() + ", CPF: " + getCpf() + getEndereco() + ", Telefone: " + getTelefone() );
    }
}