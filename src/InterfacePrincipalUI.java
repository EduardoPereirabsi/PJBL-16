import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacePrincipalUI {
    private JTextField textField1;
    private JLabel nomeLabel;
    private JButton button1;
    private JPanel painelPrincipal;

    public InterfacePrincipalUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String g = textField1.getText();

                System.out.println(g);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Escola Principal");
        frame.setContentPane((new InterfacePrincipalUI()).painelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
