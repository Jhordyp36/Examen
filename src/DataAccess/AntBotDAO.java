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

import DataAccess.DTO.AntBotDTO;

public class AntBotDAO extends SQLDataHelper implements IDAO<AntBotDTO> {

    @Override
    public AntBotDTO readBy(Integer id) throws Exception {
        AntBotDTO oS = new AntBotDTO();
        String query =    " SELECT IdAntBot  "
                        + " ,IdHormiga         "
                        + " ,IdIAMatriz          "
                        + " ,IdExpertoIngles        "
                        + " ,IdExpertoRuso          "
                        + " ,Nombre   "
                        + " ,Estado          "
                        + " ,FechaCrea       "
                        + " ,FechaModifica   "
                        + " FROM   AntBot"
                        + " WHERE  Estado = 'A' "
                        + " AND IdAntBot = " + id.toString()
                        + " WHERE  Estado = 'A' ";
        try{
            Connection conn = getDBConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                oS = new AntBotDTO( rs.getInt(1)
                                   ,rs.getInt(2)
                                   ,rs.getInt(3)
                                   ,rs.getInt(4)
                                   ,rs.getInt(5)
                                   ,rs.getString(6)
                                   ,rs.getString(7)
                                   ,rs.getString(8)
                                   ,rs.getString(9));            
            }
        } 
        catch(SQLException e){
            throw e; //new ACException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<AntBotDTO> readAll() throws Exception {
        List <AntBotDTO> lst = new ArrayList<>();
        String query =    " SELECT IdAntBot  "
                        + " ,IdHormiga         "
                        + " ,IdIAMatriz          "
                        + " ,IdExpertoIngles        "
                        + " ,IdExpertoRuso          "
                        + " ,Nombre   "
                        + " ,Estado          "
                        + " ,FechaCrea       "
                        + " ,FechaModifica   "
                        + " FROM   AntBot"
                        + " WHERE  Estado = 'A' ";
        try{
            Connection conn = getDBConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                AntBotDTO s = new AntBotDTO( rs.getInt(1)
                                            ,rs.getInt(2)
                                            ,rs.getInt(3)
                                            ,rs.getInt(4)
                                            ,rs.getInt(5)
                                            ,rs.getString(6)
                                            ,rs.getString(7)
                                            ,rs.getString(8)
                                            ,rs.getString(9));
                lst.add(s);
            }
        } 
        catch(SQLException e){
            throw e; //new ACException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(AntBotDTO entity) throws Exception {
        String query   = "INSERT INTO AntBot (IdHormiga, IdIAMatriz, IdExpertoIngles, IdExpertoRuso, Nombre)"
                         + "VALUES (?, ?, ?, ?, ?);";
        try {
            Connection conn = getDBConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,entity.getIdHormiga());
            pstmt.setInt(2,entity.getIdIAMatriz());
            pstmt.setInt(3,entity.getIdExpertoIngles());
            pstmt.setInt(4,entity.getIdExpertoRuso());
            pstmt.setString(5,entity.getNombre());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw e; //new ACException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(AntBotDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE AntBot SET IdHormiga = ?, IdIAMAtriz = ?, IdExpertoIngles = ?"
                       + ",IdExpertoRuso = ?, Nombre = ?, FechaModifica = ?"
                       + "WHERE IdAntBot = ?";
        try {
            Connection conn = getDBConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdHormiga());
            pstmt.setInt(2, entity.getIdIAMatriz());
            pstmt.setInt(3, entity.getIdExpertoIngles());
            pstmt.setInt(4, entity.getIdExpertoRuso());
            pstmt.setString(5, entity.getNombre());
            pstmt.setString(6, dtf.format(now).toString());
            pstmt.setInt(7, entity.getIdAntBot());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw e;// new ACException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String  query = "UPDATE AntBot SET Estado = ? WHERE IdAntBot = ?";
        try {
            Connection conn = getDBConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,"X"); 
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw e; //new ACException(e.getMessage(), getClass().getName(), "delete()");
        }
    }   
}
