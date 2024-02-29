/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| jhordy.parra@epn.edu.ec   PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       FloorJansen |
\---------------------------------------------------*/
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.PersonaDTO;
import Framework.PAException;

public class PersonaDAO  extends SQLDataHelper implements IDAO<PersonaDTO>{

    @Override
    public PersonaDTO readBy(Integer id) throws Exception {
        PersonaDTO  personaDTO = new PersonaDTO();
        String query = "SELECT IdPersona"
                    +  ",IdPersonaTipo"
                    +  ",IdPersonaSexo"
                    +  ",Nombre"
                    +  ",Estado"
                    +  ",FechaCrea"
                    +  ",FechaModifica"
                    +  " FROM Persona" 
                    +  " WHERE Estado = 'A' and IdPersona= " + id.toString();
        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                personaDTO = new PersonaDTO(
                                 rs.getInt(1)                    // IdPersona
                                ,rs.getInt(2)                    // IdPersonaTipo
                                ,rs.getInt(3)                    // IdPersonaSexo
                                ,rs.getString(4)                 // Nombre
                                ,rs.getString(5)                 // Estado
                                ,rs.getString(6)                 // FechaCita             
                                ,rs.getString(7));               // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return personaDTO; 
    }

    @Override
    public List<PersonaDTO> readAll() throws Exception {
        List<PersonaDTO>  lst = new ArrayList<>();
        String query = "SELECT IdPersona"
                    +  ",IdPersonaTipo"
                    +  ",IdPersonaSexo"
                    +  ",Nombre"
                    +  ",Estado"
                    +  ",FechaCrea"
                    +  ",FechaModifica"
                    +  " FROM Persona" 
                    +  " WHERE Estado = 'A'";
        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                PersonaDTO personaDTO = new PersonaDTO(
                                            rs.getInt(1)     
                                            ,rs.getInt(2)     
                                            ,rs.getInt(3)     
                                            ,rs.getString(4)  
                                            ,rs.getString(5)  
                                            ,rs.getString(6)  
                                            ,rs.getString(7));               
                lst.add(personaDTO);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst; 
    }

    @Override
    public boolean create(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO Persona(IdPersonaTipo, IdPersonaSexo, Nombre, FechaCrea) VALUES (? ,? ,? , ?)";
        try {
            Connection conn = getDBConnection();          //
            PreparedStatement pstmt = conn.prepareStatement(query);// preparar sentencia
            pstmt.setInt(1, entity.getIdPersonaTipo());
            pstmt.setInt(2, entity.getIdPersonaSexo());
            pstmt.setString(3,entity.getNombre());       // setear
            pstmt.setString(4,dtf.format(now));           // setear
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Persona SET IdPersonaTipo = ?, IdPersonaSexo = ?, Nombre = ?,FechaModifica = ? WHERE IdPersona = ? ";
        try {
            Connection conn = getDBConnection();         //
            PreparedStatement pstmt = conn.prepareStatement(query);     //preparar
            pstmt.setInt(1, entity.getIdPersonaTipo());
            pstmt.setInt(2, entity.getIdPersonaSexo());
            pstmt.setString(3,entity.getNombre());          //sete
            pstmt.setString(4,dtf.format(now));          //setea
            pstmt.setInt(5,entity.getIdPersona()); //where
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Persona SET Estado = ? WHERE IdPersona = ?";
        try {
            Connection conn = getDBConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,"X");
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) Total FROM Persona "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = getDBConnection();             
            Statement  stmt = conn.createStatement();       
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                return rs.getInt(1);                  
            }
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "delete()");
        }
        return 0;
    }
    
}
