package view;

import service.LoginService;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login() {
        setTitle("SOF-IA - Inicio de Sesión");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Componentes del formulario
        JLabel lblUsuario = new JLabel("Usuario:");
        JTextField txtUsuario = new JTextField(15);

        JLabel lblContrasena = new JLabel("Contraseña:");
        JPasswordField txtContrasena = new JPasswordField(15);

        JButton btnIngresar = new JButton("Ingresar");

        // Diseño del formulario
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblContrasena);
        panel.add(txtContrasena);
        panel.add(new JLabel()); // Celda vacía
        panel.add(btnIngresar);

        add(panel);

        // Acción del botón "Ingresar"
        btnIngresar.addActionListener(e -> {
            String user = txtUsuario.getText();
            String pass = new String(txtContrasena.getPassword());

            if (LoginService.validarLogin(user, pass)) {
                JOptionPane.showMessageDialog(this, "✅ Acceso concedido.");
                this.dispose(); // Cierra ventana de login
                new MenuPrincipal().setVisible(true); // Abre menú
            } else {
                JOptionPane.showMessageDialog(this, "❌ Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
