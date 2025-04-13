package view;

import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login() {
        setTitle("SOF-IA - Inicio de Sesión");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Usuario de prueba
        Usuario usuarioValido = new Usuario("admin", "1234");

        // Componentes
        JLabel lblUsuario = new JLabel("Usuario:");
        JTextField txtUsuario = new JTextField(15);

        JLabel lblContrasena = new JLabel("Contraseña:");
        JPasswordField txtContrasena = new JPasswordField(15);

        JButton btnIngresar = new JButton("Ingresar");

        // Layout
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblContrasena);
        panel.add(txtContrasena);
        panel.add(new JLabel()); // vacío
        panel.add(btnIngresar);

        add(panel);

        // Acción del botón
        btnIngresar.addActionListener(e -> {
            String user = txtUsuario.getText();
            String pass = new String(txtContrasena.getPassword());

            if (usuarioValido.validarCredenciales(user, pass)) {
                JOptionPane.showMessageDialog(this, "Acceso concedido.");
                this.dispose(); // Cerrar ventana de login
                new MenuPrincipal().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
