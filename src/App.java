import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BussinessLogic.BPAlimentoBL;
import BussinessLogic.HormigaBL;
import BussinessLogic.HormigaTipoBL;
import DataAccess.DTO.BPAlimentoDTO;
import DataAccess.DTO.HormigaDTO;
import DataAccess.DTO.HormigaTipoDTO;
import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) throws Exception {

        List<HormigaDTO> hormigas = new ArrayList<>();
        List<BPAlimentoDTO> alimento = new ArrayList<>();
        HormigaBL h = new HormigaBL();
        BPAlimentoBL a = new BPAlimentoBL();
        Scanner Scanner = new Scanner(System.in);

        // ----------------- LEER ARCHIVO DE SET ALIMENTO ----------------------------
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
        for (BPAlimentoDTO aDTO : a.readAll()) {
            alimento.add(aDTO);
        }
        for (HormigaDTO hDTO : h.readAll()) {
            hormigas.add(hDTO);
        }
        bpLimpiarConsola();
        System.out.println("----------------Todas las Hormigas---------------------");
        for (HormigaDTO hormiga : hormigas) {
            System.out.println(hormiga.toString());
        }
        bpEsperarTecla(Scanner);
        bpLimpiarConsola();
        System.out.println("-------Hormiga Reina--------");
        for (HormigaDTO hormiga : hormigas) {
            if ("Reina".equals(hormiga.getNombre())) {
                System.out.println("ID: " + hormiga.getIdHormiga() + ", Nombre: " + hormiga.getNombre());
            }
        }
        bpEsperarTecla(Scanner);
        bpLimpiarConsola();
        for (BPAlimentoDTO aDTO : alimento) {
            if ("Carnivoro".equals(aDTO.getNombreAlimento())) {
                aDTO.setEstado("X");
                // Encuentra todas las larvas en las hormigas y actualiza su estado
                for (HormigaDTO hormiga : hormigas) {
                    if ("Larva".equals(hormiga.getNombre())) {
                        // Cambiar el nombre de la larva a "Soldado"
                        hormiga.setNombre("Soldado");
                        // Cambiar el estado de Comio de A a X
                        hormiga.setComio("A");
                        // Puedes realizar otras acciones si es necesario
                    }
                }
            }
            else{
                for (HormigaDTO hormiga : hormigas) {
                    if ("Larva".equals(hormiga.getNombre())) {
                        // Cambiar el nombre de la larva a "Soldado"
                        hormiga.setEstado("X");
                        // Cambiar el estado de Comio de A a X
                        hormiga.setComio("A");
                        // Puedes realizar otras acciones si es necesario
                    }
                }
            }
        }

        System.out.println("------------ Hormigas que comieron -----------------");
        for (HormigaDTO hormiga : hormigas) {
            if (!hormiga.getEstado().equals("X") || !hormiga.getComio() .equals("X")) {
                System.out.println(hormiga.toString());
            }
        }
        bpEsperarTecla(Scanner);
        bpLimpiarConsola();
        System.out.println("----------Alimento Sobrante-----------------");
        for (BPAlimentoDTO bpAlimentoDTO : alimento) {
            if(!bpAlimentoDTO.getEstado().equalsIgnoreCase("X")){
                System.out.println(bpAlimentoDTO);
            }
        }
        bpEsperarTecla(Scanner);
        bpLimpiarConsola();


        

        // for


        
        // for (BPAlimentoDTO aL : alimento) {
        //     System.out.println(aL.toString());
        // }
        //     for (HormigaDTO hormiga : hormigas) {
    //         if ("Larva".equals(hormiga.getNombre())) {
    //             hormiga.setComio("X");
    //             hormiga.setNombre("Soldado");
    //         }
    //     }
    //     for (HormigaDTO hormiga : hormigas) {
    //         System.out.println(hormiga);
    //     }
    
    }
    private static void bpEsperarTecla(Scanner sc) {
        System.out.print("\nPresione cualquier tecla para continuar...");
        sc.nextLine();
    }
    private static void bpLimpiarConsola() throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
}
}
