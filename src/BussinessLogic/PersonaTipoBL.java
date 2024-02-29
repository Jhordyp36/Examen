/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| jhordy.parra@epn.edu.ec   PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       FloorJansen |
\---------------------------------------------------*/
package BussinessLogic;

import java.util.List;

import DataAccess.PersonaTipoDAO;
import DataAccess.DTO.PersonaTipoDTO;

public class PersonaTipoBL {
    private PersonaTipoDTO personaTipo;
    private PersonaTipoDAO pDAO;
    
    public PersonaTipoBL() {}

    public List<PersonaTipoDTO> readAll() throws Exception{
        return  pDAO.readAll();
    }

    public PersonaTipoDTO readBy(Integer idPersonaTipo) throws Exception{
        personaTipo = pDAO.readBy(idPersonaTipo);
        return personaTipo;
    }

    public boolean create(PersonaTipoDTO personaDTO) throws Exception{   
        return pDAO.create(personaDTO);
    }

    public boolean update(PersonaTipoDTO personaDTO) throws Exception{
        return pDAO.update(personaDTO);
    }

    public boolean delete(Integer idPersonaTipo) throws Exception{
        return pDAO.delete(idPersonaTipo);
    }
    
    public Integer getMaxRow() throws Exception{
        return pDAO.getMaxRow();
    }
}
