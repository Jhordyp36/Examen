package BussinessLogic;

import java.util.List;

import DataAccess.BPAlimentoDAO;
import DataAccess.DTO.BPAlimentoDTO;

public class BPAlimentoBL {
    private BPAlimentoDTO alimentoDTO;
    private BPAlimentoDAO alimentoDAO;

    public  BPAlimentoBL() {
        alimentoDAO = new BPAlimentoDAO();
    }

    public List<BPAlimentoDTO> readAll() throws Exception{
        return  alimentoDAO.readAll();
    }

    public boolean create(String nombre) throws Exception{   
        alimentoDTO = new BPAlimentoDTO();
        alimentoDTO.setNombreAlimento(nombre);
        return alimentoDAO.create(alimentoDTO);
    }

    public boolean update(BPAlimentoDTO alimentoDTO) throws Exception{
        return alimentoDAO.update(alimentoDTO);
    }
    // public boolean delete(Integer idHormiga) throws Exception{
    //     return alimentoDAO.delete(idHormiga);
    // }
    
    // public Integer getMaxRow() throws Exception{
    //     return alimentoDAO.getMaxRow();
    // }
}
