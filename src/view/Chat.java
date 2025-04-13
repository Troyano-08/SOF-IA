package view;

import ia.IAController;

import javax.swing.*;
import java.awt.*;

public class Chat extends JFrame {

    private JTextArea areaConversacion;
    private JTextField campoEntrada;

    public Chat() {
        setTitle("SOF-IA - Asistente Inteligente");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // para cerrar solo esta ventana
        setLocationRelativeTo(null);

        areaConversacion = new JTextArea();
        areaConversacion.setEditable(false);
        areaConversacion.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(areaConversacion);

        campoEntrada = new JTextField();
        JButton btnEnviar = new JButton("Enviar");

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(campoEntrada, BorderLayout.CENTER);
        panelInferior.add(btnEnviar, BorderLayout.EAST);

        add(scroll, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Acción al presionar el botón o Enter
        btnEnviar.addActionListener(e -> enviarMensaje());
        campoEntrada.addActionListener(e -> enviarMensaje());

        JButton btnIA = new JButton("Asistente IA");
        btnIA.addActionListener(e -> new Chat().setVisible(true));
    }

    private void enviarMensaje() {
        String entrada = campoEntrada.getText().trim();
        if (!entrada.isEmpty()) {
            areaConversacion.append("Tú: " + entrada + "\n");
            String respuesta = IAController.responder(entrada);
            areaConversacion.append("SOF-IA: " + respuesta + "\n\n");
            campoEntrada.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Chat().setVisible(true));
    }
}
