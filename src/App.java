import BussinessLogic.HormigaBL;
import BussinessLogic.HormigaTipoBL;
import DataAccess.DTO.HormigaTipoDTO;
import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) throws Exception {

        HormigaTipoBL htBL = new HormigaTipoBL();
        for (HormigaTipoDTO s : htBL.readAll()) {
            System.out.println(s.toString());
        }
        MainForm frmMain = new MainForm("IABsot");
    }
}
