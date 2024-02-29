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
import DataAccess.DTO.HormigaDTO;
import Framework.PAException;


public class HormigaDAO extends SQLDataHelper implements IDAO<HormigaDTO>{
    @Override
    public HormigaDTO readBy(Integer id) throws Exception {
        HormigaDTO oHormigaDTO = new HormigaDTO();
        String query =" SELECT IdHormiga  " 
                     +" ,IdHormigaTipo        " 
                     +" ,Nombre               "
                     +" ,Estado               "
                     +" ,FechaCrea            "
                     +" ,FechaModifica        "
                     +" FROM    Hormiga       "
                     +" WHERE   Estado ='A' AND IdHormiga =   "+ id.toString() ;
        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();    // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);   // ejecutar la
            while (rs.next()) {
                oHormigaDTO = new HormigaDTO(rs.getInt(1)           // IdHormigaTipo
                                                      ,rs.getInt(2)        // Nombre             
                                                      ,rs.getString(3)        // Estado         
                                                      ,rs.getString(4)        // FechaCre      
                                                      ,rs.getString(5)     // FechaModifica
                                                      ,rs.getString(6));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oHormigaDTO;
    }

    @Override
    public List<HormigaDTO> readAll() throws Exception {
        List <HormigaDTO> lst = new ArrayList<>();
        String query =" SELECT IdHormiga  " 
                     +" ,IdHormigaTipo        " 
                     +" ,Nombre               " 
                     +" ,Estado               "
                     +" ,FechaCrea            "
                     +" ,FechaModifica        "
                     +" FROM    Hormiga       "
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = getDBConnection();          // conectar a DB     
            Statement  stmt = conn.createStatement();     // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                HormigaDTO HormigaDTO = new HormigaDTO( rs.getInt(1)     // IdHormigaTipo
                                                                      ,rs.getInt(2)  // Nombre             
                                                                      ,rs.getString(3)  // Nombre             
                                                                      ,rs.getString(4)  // Estado         
                                                                      ,rs.getString(5)  // FechaCrea      
                                                                      ,rs.getString(6));// FechaModifica
                lst.add(HormigaDTO);
            }
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(HormigaDTO entity) throws Exception {
        String query = " INSERT INTO Hormiga (IdHormigaTipo, Nombre) VALUES (?, ?)";
        try {
            Connection        conn  = getDBConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdHormigaTipo());
            pstmt.setString(2, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(HormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Hormiga SET IdHormigaTipo = ?, Nombre = ?, FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = getDBConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdHormigaTipo());
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Hormiga SET Estado = ? WHERE IdHormiga = ?";
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
        String query =" SELECT COUNT(*) TotalReg FROM Hormiga "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = getDBConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();    // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);   // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);         // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
