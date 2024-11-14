import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogoCarro extends JFrame {
    private JTable tabelaCarros;
    private DefaultTableModel modeloTabela;
    private JTextField campoMarca, campoModelo, campoAno, campoPreco, campoNumPortas, campoPlaca;
    private JButton btnAdicionar, btnRemover;
    public JPanel panel1;

    public CatalogoCarro() {
        setTitle("Catálogo de Veículos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurando a tabela
        modeloTabela = new DefaultTableModel(new String[]{"Marca", "Modelo", "Ano", "Preço", "Placa", "Número de Portas"}, 0);
        tabelaCarros = new JTable(modeloTabela);

        // Painel de entrada de dados com GridBagLayout
        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Definindo tamanho padrão para os campos de texto
        Dimension tamanhoCampo = new Dimension(150, 25);

        // Linha 1 - Marca e Modelo
        gbc.gridx = 0; gbc.gridy = 0;
        painelEntrada.add(new JLabel("Marca:"), gbc);
        campoMarca = new JTextField();
        campoMarca.setPreferredSize(tamanhoCampo);
        gbc.gridx = 1;
        painelEntrada.add(campoMarca, gbc);

        gbc.gridx = 2;
        painelEntrada.add(new JLabel("Modelo:"), gbc);
        campoModelo = new JTextField();
        campoModelo.setPreferredSize(tamanhoCampo);
        gbc.gridx = 3;
        painelEntrada.add(campoModelo, gbc);

        // Linha 2 - Ano e Preço
        gbc.gridx = 0; gbc.gridy = 1;
        painelEntrada.add(new JLabel("Ano:"), gbc);
        campoAno = new JTextField();
        campoAno.setPreferredSize(tamanhoCampo);
        gbc.gridx = 1;
        painelEntrada.add(campoAno, gbc);

        gbc.gridx = 2;
        painelEntrada.add(new JLabel("Preço:"), gbc);
        campoPreco = new JTextField();
        campoPreco.setPreferredSize(tamanhoCampo);
        gbc.gridx = 3;
        painelEntrada.add(campoPreco, gbc);

        // Linha 3 - Placa e Número de Portas
        gbc.gridx = 0; gbc.gridy = 2;
        painelEntrada.add(new JLabel("Placa:"), gbc);
        campoPlaca = new JTextField();
        campoPlaca.setPreferredSize(tamanhoCampo);
        gbc.gridx = 1;
        painelEntrada.add(campoPlaca, gbc);

        gbc.gridx = 2;
        painelEntrada.add(new JLabel("Número de Portas:"), gbc);
        campoNumPortas = new JTextField();
        campoNumPortas.setPreferredSize(tamanhoCampo);
        gbc.gridx = 3;
        painelEntrada.add(campoNumPortas, gbc);

        // Linha 4 - Botões Adicionar e Remover
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAdicionar = new JButton("Adicionar");
        btnRemover = new JButton("Remover Selecionado");
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnRemover);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 4;
        painelEntrada.add(painelBotoes, gbc);

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
        campoMarca.setText("");
        campoModelo.setText("");
        campoAno.setText("");
        campoPreco.setText("");
        campoNumPortas.setText("");
        campoPlaca.setText("");
    }

    private void inicializaRegistros() {
        LeituraArquivo leituraArquivo = new LeituraArquivo();
        ArrayList<Carro> carros = leituraArquivo.lerArquivoCarro("C:\\DadosCarro.txt");
        for (Carro carro : carros) {
            modeloTabela.addRow(new Object[]{carro.getMarca(), carro.getModelo(), carro.getAno(), carro.getPreco(), carro.getPlaca(), carro.getNumPortas()});
        }
    }

    private boolean validarCadastro() {
        boolean erro = false;
        if (campoMarca.getText() == null || campoMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Marca Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoModelo.getText() == null || campoModelo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Modelo Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoAno.getText() == null || campoAno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Ano Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoPreco.getText() == null || campoPreco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Preço Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoPlaca.getText() == null || campoPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Placa Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoNumPortas.getText() == null || campoNumPortas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Número de Portas Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        return erro;
    }

    private void adicionarVeiculo() {
        if (!validarCadastro()) {
            String modelo = campoModelo.getText();
            String ano = campoAno.getText();
            String preco = campoPreco.getText();
            String marca = campoMarca.getText();
            String placa = campoPlaca.getText();
            String numPortas = campoNumPortas.getText();
            Double precoNumber = Double.parseDouble(preco);
            Integer anoNumber = Integer.parseInt(ano);
            Integer numPortasNumber = Integer.parseInt(numPortas);

            LeituraArquivo leituraArquivo = new LeituraArquivo();

            Carro carro = new Carro(marca, modelo, precoNumber, anoNumber, placa, true, numPortasNumber);
            leituraArquivo.salvarArquivoCarro("C:\\DadosCarro.txt", carro);

            modeloTabela.addRow(new Object[]{marca, modelo, ano, preco, placa, numPortasNumber});
            limparCampos();
        }
    }

    private void removerVeiculo() {
        int linhaSelecionada = tabelaCarros.getSelectedRow();
        if (linhaSelecionada != -1) {
            LeituraArquivo leituraArquivo = new LeituraArquivo();
            Object valorCelula = tabelaCarros.getValueAt(linhaSelecionada, 4);
            leituraArquivo.removerLinhas("C:\\DadosCarro.txt",valorCelula.toString());
            modeloTabela.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Veículo para remover.");
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CatalogoCarro().setVisible(true);
            }
        });
    }
}
