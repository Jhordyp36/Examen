/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
\---------------------------------------------------*/
package BussinessLogic;

import java.util.List;

import DataAccess.PersonaSexoDAO;
import DataAccess.DTO.PersonaSexoDTO;

public class PersonaSexoBL {
    private PersonaSexoDTO personaSexoDTO;
    private PersonaSexoDAO personaSexoDAO = new PersonaSexoDAO();

    public PersonaSexoBL() {
    }
    public List<PersonaSexoDTO> readAll() throws Exception{
        return  personaSexoDAO.readAll();
    }
    public PersonaSexoDTO readBy(Integer idPersonaSexo) throws Exception{
        personaSexoDTO = personaSexoDAO.readBy(idPersonaSexo);
        return personaSexoDTO;
    }
    public boolean create(PersonaSexoDTO personaSexoDTO) throws Exception{   
        return personaSexoDAO.create(personaSexoDTO);
    }
    public boolean update(PersonaSexoDTO personaSexoDTO) throws Exception{   
        return personaSexoDAO.update(personaSexoDTO);
    }
    public boolean delete(Integer idPersonaSexo) throws Exception{
        return personaSexoDAO.delete(idPersonaSexo);
    }
    public Integer getMaxRow() throws Exception{
        return personaSexoDAO.getMaxRow();
    }
}
