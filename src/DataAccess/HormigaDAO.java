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
                     +" ,Codigo        " 
                     +" ,Nombre               "
                     +" ,Comio               "
                     +" ,Recogio               "
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
                                                      ,rs.getInt(3)        // Estado         
                                                      ,rs.getString(4)        // FechaCre      
                                                      ,rs.getString(5)     // FechaModifica
                                                      ,rs.getString(6)      // FechaModifica
                                                      ,rs.getString(7)      // FechaModifica
                                                      ,rs.getString(8)      // FechaModifica
                                                      ,rs.getString(9));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw new PAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oHormigaDTO;
        // throw  new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<HormigaDTO> readAll() throws Exception {
        List <HormigaDTO> lst = new ArrayList<>();
        String query = " SELECT IdHormiga  " 
                         +" ,IdHormigaTipo        " 
                         +" ,Codigo        " 
                         +" ,Nombre               "
                         +" ,Comio               "
                         +" ,Recogio               "
                         +" ,Estado               "
                         +" ,FechaCrea            "
                         +" ,FechaModifica        "
                         +" FROM    Hormiga       "
                         +" WHERE   Estado ='A'";

        try {
            Connection conn = getDBConnection();          // conectar a DB     
            Statement  stmt = conn.createStatement();     // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                HormigaDTO HormigaDTO = new HormigaDTO( rs.getInt(1)     // IdHormiga
                                                       ,rs.getInt(2)  // IdHormigaTipo          
                                                       ,rs.getInt(3)  // Codigo             
                                                       ,rs.getString(4)  // Nombre             
                                                       ,rs.getString(5)  // Comio         
                                                       ,rs.getString(6)  // Recogio      
                                                       ,rs.getString(7) //Estado
                                                       ,rs.getString(8)
                                                       ,rs.getString(9));// FechaModifica
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
        String query = " UPDATE Hormiga SET IdHormigaTipo = ?, Comio = ? , Recogio = ?, FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = getDBConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdHormigaTipo());
            pstmt.setString(2, entity.getComio());
            pstmt.setString(3, entity.getRecogio());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdHormiga());
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
        // throw  new UnsupportedOperationException("Not supported yet.");
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
