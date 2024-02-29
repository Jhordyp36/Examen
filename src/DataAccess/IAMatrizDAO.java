/*---------------------------------------------------\
| Copyright (©) 2K24 EPN-FIS. All rights reserved.   |
| mateo.simbana@epn.edu.ec  PROPIETARY/CONFIDENTIAL. |
| Use is subject to license terms.       mateitopro  |
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

import DataAccess.DTO.IAMatrizDTO;
import Framework.PAException;

public class IAMatrizDAO extends SQLDataHelper implements IDAO <IAMatrizDTO> {

    @Override
    public IAMatrizDTO readBy(Integer id) throws Exception {
        IAMatrizDTO iAM = new IAMatrizDTO();
        String query = " SELECT IdIAMatriz "
                     + ", Nombre           "
                     + ", Estado           "
                     + ", FechaCrea        "
                     + ", FechaModifica    "
                     + " FROM IAMatriz     "
                     + " WHERE Estado ='A' AND IdIAMatriz = " + id.toString();
        try {
            Connection conn = getDBConnection();            
            Statement  stmt = conn.createStatement();      
            ResultSet rs   = stmt.executeQuery(query);            
            while(rs.next()) {
                iAM = new IAMatrizDTO(rs.getInt(1)     // IdIAMatriz
                                     ,rs.getString(2)  // Nombre 
                                     ,rs.getString(3)  // Estado  
                                     ,rs.getString(4)  // FechaCrea
                                     ,rs.getString(5));// FechaModifica 
            }
        } catch (Exception e) {
            throw new PAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return iAM;
    }

    @Override
    public List<IAMatrizDTO> readAll() throws Exception {
        List <IAMatrizDTO> lst = new  ArrayList<>();
        String query = " SELECT IdIAMatriz "
        + ", Nombre           "
        + ", Estado           "
        + ", FechaCrea        "
        + ", FechaModifica    "
        + " FROM IAMatriz     "
        + " WHERE Estado ='A' ";

        try {
            Connection conn = getDBConnection();            
            Statement  stmt = conn.createStatement();      
            ResultSet rs   = stmt.executeQuery(query);            
            while(rs.next()) {
                IAMatrizDTO iAM = new IAMatrizDTO(rs.getInt(1)    // IdIAMatriz
                                     ,rs.getString(2)             // Nombre 
                                     ,rs.getString(3)             // Estado  
                                     ,rs.getString(4)             // FechaCrea
                                     ,rs.getString(5));           // FechaModifica 
                lst.add(iAM);
            }
        } catch (Exception e) {
            throw new PAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(IAMatrizDTO entity) throws Exception {
        String query = "INSERT INTO IAMatriz (Nombre) VALUES (?)";
        try {
            Connection conn = getDBConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new PAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(IAMatrizDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE IAMatriz SET Nombre = ?, FechaModifica = ? WHERE IdIAMatriz = ?";
                try {
            Connection          conn = getDBConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdIAMatriz());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE IAMatriz SET Estado = ? WHERE IdIAMatriz = ?";
        try {
            Connection          conn = getDBConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) Total FROM IAMatriz "
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
