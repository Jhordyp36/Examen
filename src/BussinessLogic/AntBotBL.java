package BussinessLogic;

import java.util.List;

import DataAccess.AntBotDAO;
import DataAccess.DTO.AntBotDTO;

public class AntBotBL {
    AntBotDTO abDTO;
    AntBotDAO abDAO = new AntBotDAO();

    public AntBotBL(){}

    public List<AntBotDTO> getAll() throws Exception{
        return abDAO.readAll();
    }

    public AntBotDTO getBy(int idAntBot) throws Exception{
        abDTO = abDAO.readBy(idAntBot);
        return abDTO;
    }

    public boolean add(AntBotDTO abDTO) throws Exception{
        return abDAO.create(abDTO);
    }
    
    public boolean update(AntBotDTO abDTO) throws Exception{
        return abDAO.update(abDTO);
    }

    public boolean delete(int idAntBot) throws Exception{
        return abDAO.delete(idAntBot);
    }

}
