/*
|----------------------------------------|
| ©2024 EPN-FIS, All rights reserved     |       
| andreachicaiza11@gmail.com             |
|________________________________________|
-Autor: Andrea Chicaiza
-Fecha: 28/02/2024
*/

package BussinessLogic;
import java.util.List;
import DataAccess.HormigaTipoDAO;
// import DataAccess.DTO.HormigaDTO;
import DataAccess.DTO.HormigaTipoDTO;

public class HormigaTipoBL {
    private HormigaTipoDTO hormigaTipoDTO;
    private HormigaTipoDAO hormigaTipoDAO = new HormigaTipoDAO();

    public HormigaTipoBL(){}

    public List<HormigaTipoDTO> readAll() throws Exception{
        return hormigaTipoDAO.readAll();
    }

    public HormigaTipoDTO readBy(int idHormigaTipo) throws Exception{
        hormigaTipoDTO = hormigaTipoDAO.readBy(idHormigaTipo);
        return hormigaTipoDTO;
    }
    
    public boolean create(HormigaTipoDTO hormigaDTO) throws Exception{   
        return hormigaTipoDAO.create(hormigaTipoDTO);
    }

    public boolean update(HormigaTipoDTO hormigaTipoDTO) throws Exception{
        return hormigaTipoDAO.update(hormigaTipoDTO);
    }
    
    public boolean delete(int idHormigaTipo) throws Exception{
        return hormigaTipoDAO.delete(idHormigaTipo);
    }
    
    public Integer getMaxRow() throws Exception{
        return hormigaTipoDAO.getMaxRow();
    }
}
