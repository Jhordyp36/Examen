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
        BPLogicaDTO bp = new BPLogicaDTO();
        bp.BPInicarAntBot();
    }
}   
