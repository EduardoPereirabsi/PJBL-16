import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogoCarro extends JFrame {
    private JTable tabelaCarros;
    private DefaultTableModel modeloTabela;
    private JTextField campoModelo, campoAno, campoPreco, campoFabricante;
    private JButton btnAdicionar, btnRemover;

    public CatalogoCarro() {
        setTitle("Catálogo de Carros");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurando a tabela
        modeloTabela = new DefaultTableModel(new String[]{"Modelo", "Ano", "Preço", "Fabricante"}, 0);
        tabelaCarros = new JTable(modeloTabela);

        // Painel de entrada de dados
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(5, 2, 5, 5));

        painelEntrada.add(new JLabel("Modelo:"));
        campoModelo = new JTextField();
        painelEntrada.add(campoModelo);

        painelEntrada.add(new JLabel("Ano:"));
        campoAno = new JTextField();
        painelEntrada.add(campoAno);

        painelEntrada.add(new JLabel("Preço:"));
        campoPreco = new JTextField();
        painelEntrada.add(campoPreco);

        painelEntrada.add(new JLabel("Fabricante:"));
        campoFabricante = new JTextField();
        painelEntrada.add(campoFabricante);

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
                String modelo = campoModelo.getText();
                String ano = campoAno.getText();
                String preco = campoPreco.getText();
                String fabricante = campoFabricante.getText();

                if (!modelo.isEmpty() && !ano.isEmpty() && !preco.isEmpty() && !fabricante.isEmpty()) {
                    modeloTabela.addRow(new Object[]{modelo, ano, preco, fabricante});
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                }
            }
        });

        // Ação do botão remover
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaCarros.getSelectedRow();
                if (linhaSelecionada != -1) {
                    modeloTabela.removeRow(linhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um carro para remover.");
                }
            }
        });
    }

    // Método para limpar os campos de entrada
    private void limparCampos() {
        campoModelo.setText("");
        campoAno.setText("");
        campoPreco.setText("");
        campoFabricante.setText("");
    }

    private void inicializaRegistros(){
        LeituraArquivo leituraArquivo = new LeituraArquivo();
        ArrayList<Carro> carros = leituraArquivo.lerArquivoCarro("C:\\DadosCarro.txt");
        for (Carro carro : carros) {
            modeloTabela.addRow(new Object[]{carro.getModelo(), carro.getAno(), carro.getPreco(),carro.getFabricante()});
        }
    }
}
