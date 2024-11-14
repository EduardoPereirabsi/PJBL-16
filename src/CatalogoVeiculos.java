import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogoVeiculos extends JFrame {
    private JTable tabelaVeiculos;
    private DefaultTableModel modeloTabela;
    private JTextField campoMarca, campoModelo, campoAno, campoPreco, campoNumPortas, campoPlaca;
    private JButton btnAdicionar, btnRemover;
    public JPanel panel1;
    private DefaultTableModel modeloTabelaFuncionario;

    // Campos Cadastro Usuario
    private JTextField campoNome, campoCpf, campoEndereco, campoTelefone;
    private JButton btnSalvarFuncionario;
    private JTable tabelaFuncionario;
    private JButton btnRemoverFuncionario;


    public CatalogoVeiculos() {
        setTitle("Catálogo de Veículos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        modeloTabela = new DefaultTableModel(new String[]{"Marca", "Modelo", "Ano", "Preço", "Placa", "Número de Portas"}, 0);
        tabelaVeiculos = new JTable(modeloTabela);

        modeloTabelaFuncionario = new DefaultTableModel(new String[]{"Nome", "Cpf", "Endereço", "Telefone"}, 0);
        tabelaFuncionario = new JTable(modeloTabelaFuncionario);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        Dimension tamanhoCampo = new Dimension(150, 25);

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

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAdicionar = new JButton("Adicionar");
        btnRemover = new JButton("Remover Selecionado");
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnRemover);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 4;
        painelEntrada.add(painelBotoes, gbc);

       // painelEntrada.add(tabelaFuncionario);

        add(new JScrollPane(tabelaVeiculos), BorderLayout.CENTER);
        add(painelEntrada, BorderLayout.SOUTH);

        inicializaRegistros();

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVeiculo();
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerVeiculo();
            }
        });
        btnSalvarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarFuncionario();
            }
        });
        btnRemoverFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerFuncionario();
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

    private boolean validarCadastroCarro() {
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
        if (!validarCadastroCarro()) {
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
        int linhaSelecionada = tabelaVeiculos.getSelectedRow();
        if (linhaSelecionada != -1) {
            LeituraArquivo leituraArquivo = new LeituraArquivo();
            Object valorCelula = tabelaVeiculos.getValueAt(linhaSelecionada, 4);
            leituraArquivo.removerLinhas("C:\\DadosCarro.txt",valorCelula.toString());
            modeloTabela.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Veículo para remover.");
        }
    }
    private boolean validarCadastroFuncionario() {
        boolean erro = false;
        if (campoNome.getText() == null || campoNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Nome Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoCpf.getText() == null || campoCpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Cpf Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoEndereco.getText() == null || campoEndereco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Endereço Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        if (campoTelefone.getText() == null || campoTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Telefone Obrigatório!", null, JOptionPane.INFORMATION_MESSAGE);
            erro = true;
        }
        return erro;
    }
    private void adicionarFuncionario() {
        if (!validarCadastroFuncionario()) {
            String nome = campoNome.getText();
            String cpf = campoCpf.getText();
            String endereco = campoEndereco.getText();
            String telefone = campoTelefone.getText();

            LeituraArquivo leituraArquivo = new LeituraArquivo();

            Funcionario funcionario = new Funcionario(nome, cpf, endereco, telefone);
            leituraArquivo.salvarDadosFuncionarioEmArquivo("C:\\DadosFuncionario.txt", funcionario);

            modeloTabelaFuncionario.addRow(new Object[]{nome, cpf, endereco, telefone});
            limparCampos();
        }
    }
    private void removerFuncionario() {
        int linhaSelecionada = tabelaFuncionario.getSelectedRow();
        if (linhaSelecionada != -1) {
            LeituraArquivo leituraArquivo = new LeituraArquivo();
            Object valorCelula = tabelaFuncionario.getValueAt(linhaSelecionada, 1);
            leituraArquivo.removerLinhas("C:\\DadosFuncionario.txt",valorCelula.toString());
            modeloTabela.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Funcionario para remover.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(".");
        frame.setContentPane(new CatalogoVeiculos().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(500, 300);
        frame.setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CatalogoVeiculos().setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

