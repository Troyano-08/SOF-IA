package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexion {
    public static void main(String[] args) {
        Connection conn = Conexion.conectar();

        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String usuario = rs.getString("usuario");

                    System.out.println("ID: " + id + " | Nombre: " + nombre + " | Usuario: " + usuario);
                }

                conn.close();
            } catch (Exception e) {
                System.out.println("❌ Error ejecutando consulta: " + e.getMessage());
            }
        }
    }
}
