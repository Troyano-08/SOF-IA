package service;

import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    public static boolean validarLogin(String usuario, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario);
            pstmt.setString(2, contrasena);

            ResultSet rs = pstmt.executeQuery();

            // Si hay resultado, las credenciales son correctas
            return rs.next();

        } catch (SQLException e) {
            System.out.println("❌ Error al validar login: " + e.getMessage());
            return false;
        }
    }
}
