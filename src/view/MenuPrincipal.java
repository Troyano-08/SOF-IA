package view;

import javax.swing.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("SOF-IA - Menú Principal");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Bienvenido al sistema SOF-IA", SwingConstants.CENTER);
        add(label);
    }
}
