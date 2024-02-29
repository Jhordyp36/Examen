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

import BussinessLogic.BPAlimentoBL;
import BussinessLogic.HormigaBL;
import BussinessLogic.HormigaTipoBL;
import DataAccess.DTO.HormigaTipoDTO;
import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) throws Exception {

        // HormigaTipoBL htBL = new HormigaTipoBL();
        // for (HormigaTipoDTO s : htBL.readAll()) {
        //     System.out.println(s.toString());
        // }
        // MainForm frmMain = new MainForm("IABsot");
        // String filePath = "C:/Users/clien/Desktop/Examen2/Examen_AntBot/setAlimento.txt";

        // try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        //     Class.forName("org.sqlite.JDBC");
        //     Connection connection = DriverManager.getConnection("jdbc:sqlite:database//PADatabaseAntBot.sqlite");

        //     String query = "INSERT INTO BPAlimento (NombreAlimento) VALUES (?)";
        //     try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        //         String line;
        //         while ((line = br.readLine()) != null) {
        //             // Suponiendo que los datos en el archivo están separados por comas
        //             String[] datos = line.split(",");
        //             String nombre = datos[0].trim();

        //             pstmt.setString(1, nombre);
        //             pstmt.executeUpdate();
        //         }
        //         System.out.println("Datos insertados con éxito.");
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

    }
}
