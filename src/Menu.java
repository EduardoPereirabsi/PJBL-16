import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JButton button1;
    private JButton button2;
    private JPanel mainPanel;

    public Menu() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu1();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2();
            }
        });
    }

    public static void menu1() {
        JFrame frame = new JFrame("Cadrastro Funcionario");
        frame.setContentPane(new CatalogoVeiculos().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void menu2() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CatalogoVeiculos().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
