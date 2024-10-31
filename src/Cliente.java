public class Cliente extends Usuario {
    private int pontosFidelidade;

    public Cliente(String nome, String cpf, String endereco,String telefone, int pontosFidelidade) {
        super(nome, cpf, endereco, telefone);
        this.pontosFidelidade = pontosFidelidade;

    }


    public int getPontosFidelidade() { return pontosFidelidade; }
    public void adicionarPontos(int pontos) { this.pontosFidelidade += pontos; }


    @Override
    public void mostrarInfo() {
        System.out.println("Cliente: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() );
    }
}
