/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| mateo.simbana@epn.edu.ec  PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       mateitopro  |
\---------------------------------------------------*/
package BussinessLogic;

import java.util.List;

import DataAccess.IAMatrizDAO;
import DataAccess.DTO.IAMatrizDTO;

public class IAMatrizBL {
    private IAMatrizDTO iAMatriz;
    private IAMatrizDAO iDAO = new IAMatrizDAO();

    public IAMatrizBL() {
    }

    public List<IAMatrizDTO> getAll() throws Exception{
        return iDAO.readAll();
    }

    public IAMatrizDTO getBy(int idIAMatriz) throws Exception{
        iAMatriz = iDAO.readBy(idIAMatriz);
        return iAMatriz;
    }

    public boolean create(IAMatrizDTO matrizDTO) throws Exception{   
        return iDAO.create(matrizDTO);
    }

    public boolean update(IAMatrizDTO matrizDTO) throws Exception{
        return iDAO.update(matrizDTO);
    }

    public boolean delete(int idIAMatriz) throws Exception{
        return iDAO.delete(idIAMatriz);
    }
    
    public Integer getMaxRow() throws Exception{
        return iDAO.getMaxRow();
    }

}