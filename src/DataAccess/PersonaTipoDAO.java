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

import DataAccess.DTO.PersonaTipoDTO;
import Framework.PAException;

public class PersonaTipoDAO extends SQLDataHelper implements IDAO<PersonaTipoDTO> {

    @Override
    public PersonaTipoDTO readBy(Integer id) throws Exception {
        PersonaTipoDTO  personaTipoDTO = new PersonaTipoDTO();
        String query = "SELECT IdPersonaTipo"
                    +  ",Nombre"
                    +  ",Estado"
                    +  ",FechaCrea"
                    +  ",FechaModifica"
                    +  " FROM PersonaTipo" 
                    +  " WHERE Estado = 'A' and IdPersonaTipo= " + id.toString();
        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                personaTipoDTO = new PersonaTipoDTO(
                                 rs.getInt(1)                    // IdPersonaTipo
                                ,rs.getString(2)                 // Nombre
                                ,rs.getString(3)                 // Estado
                                ,rs.getString(4)                 // FechaCita             
                                ,rs.getString(5));               // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return personaTipoDTO; 
    }

    @Override
    public List<PersonaTipoDTO> readAll() throws Exception {
        List<PersonaTipoDTO>  lst = new ArrayList<>();
        String query = "SELECT IdPersonaTipo"
                    +  ",Nombre"
                    +  ",Estado"
                    +  ",FechaCrea"
                    +  ",FechaModifica"
                    +  " FROM PersonaTipo" 
                    +  " WHERE Estado = 'A'";
        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                PersonaTipoDTO personaTipoDTO = new PersonaTipoDTO(
                                                 rs.getInt(1)                    // IdPersonaTipo
                                                ,rs.getString(2)                 // Nombre
                                                ,rs.getString(3)                 // Estado
                                                ,rs.getString(4)                 // FechaCita             
                                                ,rs.getString(5));               // FechaModifica
                lst.add(personaTipoDTO);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst; 
    }

    @Override
    public boolean create(PersonaTipoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO PersonaTipo(Nombre, FechaCrea) VALUEs (?, ?)";
        try {
            Connection conn = getDBConnection();          //
            PreparedStatement pstmt = conn.prepareStatement(query);// preparar sentencia
            pstmt.setString(1,entity.getNombre());       // setear
            pstmt.setString(2,dtf.format(now));           // setear
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update(PersonaTipoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE PersonaTipo SET Nombre = ?,FechaModifica = ? WHERE IdPersonaTipo = ? ";
        try {
            Connection conn = getDBConnection();         //
            PreparedStatement pstmt = conn.prepareStatement(query);     //preparar
            pstmt.setString(1,entity.getNombre());      //sete
            pstmt.setString(2,dtf.format(now));          //setea
            pstmt.setInt(3,entity.getIdPersonaTipo()); //where
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE PersonaTipo SET Estado = ? WHERE IdPersonaTipo = ?";
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
        String query =" SELECT COUNT(*) Total FROM PersonaTipo "
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
