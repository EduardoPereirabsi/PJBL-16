import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogoCarro extends JFrame {
    private JTable tabelaCarros;
    private DefaultTableModel modeloTabela;
    private JTextField campoModelo, campoAno, campoPreco, campoMarca;
    private JButton btnAdicionar, btnRemover;
    public JPanel panel1;

    public CatalogoCarro() {
        setTitle("Catálogo de Veiculos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurando a tabela
        modeloTabela = new DefaultTableModel(new String[]{"Marca","Modelo", "Ano", "Preço"}, 0);
        tabelaCarros = new JTable(modeloTabela);

        // Painel de entrada de dados
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(5, 2, 5, 5));

        painelEntrada.add(new JLabel("Marca:"));
        campoMarca = new JTextField();
        painelEntrada.add(campoMarca);

        painelEntrada.add(new JLabel("Modelo:"));
        campoModelo = new JTextField();
        painelEntrada.add(campoModelo);

        painelEntrada.add(new JLabel("Ano:"));
        campoAno = new JTextField();
        painelEntrada.add(campoAno);

        painelEntrada.add(new JLabel("Preço:"));
        campoPreco = new JTextField();
        painelEntrada.add(campoPreco);



        // Botões de adicionar e remover
        btnAdicionar = new JButton("Adicionar");
        btnRemover = new JButton("Remover Selecionado");

        painelEntrada.add(btnAdicionar);
        painelEntrada.add(btnRemover);

        // Configuração do painel principal
        add(new JScrollPane(tabelaCarros), BorderLayout.CENTER);
        add(painelEntrada, BorderLayout.SOUTH);

        inicializaRegistros();

        // Ação do botão adicionar
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVeiculo();
            }
        });

        // Ação do botão remover
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerVeiculo();
            }
        });
    }

    private void limparCampos() {
        campoModelo.setText("");
        campoAno.setText("");
        campoPreco.setText("");
        campoMarca.setText("");
    }

    private void inicializaRegistros(){
        LeituraArquivo leituraArquivo = new LeituraArquivo();
        ArrayList<Carro> carros = leituraArquivo.lerArquivoCarro("C:\\DadosCarro.txt");
        for (Carro carro : carros) {
            modeloTabela.addRow(new Object[]{carro.getModelo(), carro.getAno(), carro.getPreco(),carro.getMarca()});
        }
    }
    private boolean validarCadastro(){
        boolean erro = false;
        if (campoModelo.getText() == null || campoModelo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo Modelo Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoAno.getText() == null || campoAno.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo Ano Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoPreco.getText() == null || campoPreco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo Preço Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoAno.getText() == null || campoMarca.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo Marca Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        return erro;
    }
    private void adicionarVeiculo(){
        if (!validarCadastro()){
            String modelo = campoModelo.getText();
            String ano = campoAno.getText();
            String preco = campoPreco.getText();
            String marca = campoMarca.getText();
            Double precoNumber = Double.parseDouble(preco);
            Integer anoNumber = Integer.parseInt(ano);

            LeituraArquivo leituraArquivo = new LeituraArquivo();

            Carro carro = new Carro(marca,modelo, precoNumber, anoNumber );
            leituraArquivo.salvarArquivoCarro("C:\\DadosCarro.txt", carro);

            modeloTabela.addRow(new Object[]{modelo, ano, preco, marca});
        }
        limparCampos();
    }
    private void removerVeiculo(){
        int linhaSelecionada = tabelaCarros.getSelectedRow();
        if (linhaSelecionada != -1) {
            modeloTabela.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um carro para remover.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Secretario");
        frame.setContentPane(new CatalogoCarro().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
