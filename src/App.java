import java.beans.Statement;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import BussinessLogic.BPAlimentoBL;
import BussinessLogic.HormigaBL;
import BussinessLogic.HormigaTipoBL;
import DataAccess.BPAlimentoDAO;
import DataAccess.HormigaDAO;
import DataAccess.DTO.BPAlimentoDTO;
import DataAccess.DTO.HormigaDTO;
import DataAccess.DTO.HormigaTipoDTO;
import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            // Establecer conexión a la base de datos
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/ruta/a/tu/base/de/datos.sqlite");

            // Simulando una Reina
            int idReina = 2; // Supongamos que el IdHormiga de la Reina es 1

            // Simulando 40 Larvas
            for (int i = 1; i <= 40; i++) {
                // Supongamos que el IdHormiga de la Larva es i
                int idLarva = i;

                // Simular que la Reina da de comer a la Larva (por ejemplo, Carnivoro)
                bpComer(conn, idReina, idLarva, "Carnivoro");

                // Simular que la Larva busca alimento (por ejemplo, Carnivoro)
                bpBuscar(conn, idLarva, "Carnivoro");
            }

            // Simulando un Soldado
            int idSoldado = 41; // Supongamos que el IdHormiga del Soldado es 41

            // Simular que el Soldado busca alimento (por ejemplo, Carnivoro)
            bpBuscar(conn, idSoldado, "Carnivoro");

            // Cerrar conexión a la base de datos
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para simular la acción de comer en la base de datos
    private static void bpComer(Connection conn, int idHormigaComedora, int idHormigaComida, String tipoAlimento) throws SQLException {
        // Supongamos que BPAlimento tiene una columna Estado y queremos cambiar el estado a 'X'
        String sql = "UPDATE BPAlimento SET Estado = 'X' WHERE IdHormiga = ? AND TipoAlimento = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idHormigaComida);
            pstmt.setString(2, tipoAlimento);
            pstmt.executeUpdate();
        }
    }

    // Método para simular la acción de buscar en la base de datos
    private static void bpBuscar(Connection conn, int idHormiga, String tipoAlimento) throws SQLException {
        // Supongamos que queremos eliminar los registros de BPAlimento donde el Estado es 'X'
        String sql = "DELETE FROM BPAlimento WHERE IdHormiga = ? AND TipoAlimento = 'X'";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idHormiga);
            pstmt.executeUpdate();
        }

        // Supongamos que queremos cambiar el estado en la tabla Hormiga (por ejemplo, cambiar Comio a 1)
        sql = "UPDATE Hormiga SET Comio = 1 WHERE IdHormiga = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idHormiga);
            pstmt.executeUpdate();
        }
    }
}