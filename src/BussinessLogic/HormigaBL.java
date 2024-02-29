package BussinessLogic;

import java.util.List;
import DataAccess.HormigaDAO;
import DataAccess.DTO.HormigaDTO;

public class HormigaBL {
    private HormigaDTO hormigaDTO;
    private HormigaDAO hormigaDAO;

    public  HormigaBL() {
        this.hormigaDAO = new HormigaDAO();
    }

    public List<HormigaDTO> readAll() throws Exception{
        return hormigaDAO.readAll();
    }

    public HormigaDTO readBy(Integer idHormiga) throws Exception{
        hormigaDTO = hormigaDAO.readBy(idHormiga);
        return hormigaDTO;
    }

    public boolean create(HormigaDTO hormigaDTO) throws Exception{   
        return hormigaDAO.create(hormigaDTO);
    }

    public boolean update(HormigaDTO hormigaDTO) throws Exception{
        return hormigaDAO.update(hormigaDTO);
    }

    public boolean delete(Integer idHormiga) throws Exception{
        return hormigaDAO.delete(idHormiga);
    }
    
    public Integer getMaxRow() throws Exception{
        return hormigaDAO.getMaxRow();
    }
}
