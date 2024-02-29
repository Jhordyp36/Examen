/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| jhordy.parra@epn.edu.ec   PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       FloorJansen |
\---------------------------------------------------*/
package BussinessLogic;

import java.util.List;

import DataAccess.PersonaDAO;
import DataAccess.DTO.PersonaDTO;

public class PersonaBL {
    private PersonaDTO persona;
    private PersonaDAO pDAO;
    
    public PersonaBL() {}

    public List<PersonaDTO> readAll() throws Exception{
        return  pDAO.readAll();
    }

    public PersonaDTO readBy(Integer idPersona) throws Exception{
        persona = pDAO.readBy(idPersona);
        return persona;
    }

    public boolean create(PersonaDTO personaDTO) throws Exception{   
        return pDAO.create(personaDTO);
    }

    public boolean update(PersonaDTO personaDTO) throws Exception{
        return pDAO.update(personaDTO);
    }

    public boolean delete(Integer idPersona) throws Exception{
        return pDAO.delete(idPersona);
    }
    
    public Integer getMaxRow() throws Exception{
        return pDAO.getMaxRow();
    }
}
