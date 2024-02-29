/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| angeltomasbq@gmail.com    PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.     AngelTBarahona|
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

import DataAccess.DTO.PersonaSexoDTO;
import Framework.PAException;

public class PersonaSexoDAO extends SQLDataHelper implements IDAO<PersonaSexoDTO> {

    @Override
    public PersonaSexoDTO readBy(Integer id) throws Exception {
        PersonaSexoDTO personaSexoDTO = new PersonaSexoDTO();
        String query =" SELECT IdPersonaSexo  " 
                    +" ,Nombre        " 
                    +" ,Estado        " 
                    +" ,FechaCrea     " 
                    +" ,FechaModifica "
                    +" FROM    PersonaSexo   "
                    +" WHERE   Estado ='A' AND IdPersonaSexo =   "+ id.toString() ;
        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                personaSexoDTO = new PersonaSexoDTO(rs.getInt(1)           // IdSexo
                                                   ,rs.getString(2)        // Nombre             
                                                   ,rs.getString(3)        // Estado         
                                                   ,rs.getString(4)        // FechaCreacion     
                                                   ,rs.getString(5));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return personaSexoDTO;
    }

    @Override
    public List<PersonaSexoDTO> readAll() throws Exception {
        List <PersonaSexoDTO> lst = new ArrayList<>();
        String query =" SELECT IdPersonaSexo  " 
                    +" ,Nombre        " 
                    +" ,Estado        " 
                    +" ,FechaCrea     " 
                    +" ,FechaModifica "
                    +" FROM    PersonaSexo   "
                    +" WHERE   Estado ='A' ";

        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                PersonaSexoDTO s = new PersonaSexoDTO( rs.getInt(1)     // IdSexo
                                                      ,rs.getString(2)  // Nombre             
                                                      ,rs.getString(3)  // Estado         
                                                      ,rs.getString(4)  // FechaCrea     
                                                      ,rs.getString(5));// FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;//new PTException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(PersonaSexoDTO entity) throws Exception {
        String query = " INSERT INTO PersonaSexo (Nombre) VALUES (?)";
        try {
            Connection        conn  = getDBConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean update(PersonaSexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE PersonaSexo SET Nombre = ?, FechaModifica = ? WHERE IdPersonaSexo = ?";
        try {
            Connection          conn = getDBConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdPersonaSexo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE PersonaSexo SET Estado = ? WHERE IdPersonaSexo = ?";
        try {
            Connection          conn = getDBConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM PersonaSexo "
                        +" WHERE   Estado ='A' ";
        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "delete()");
        }
        return 0;
    }
    
}
