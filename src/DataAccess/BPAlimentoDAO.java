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

import DataAccess.DTO.BPAlimentoDTO;

public class BPAlimentoDAO extends SQLDataHelper implements IDAO<BPAlimentoDTO>{

    @Override
    public BPAlimentoDTO readBy(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBy'");
    }

    @Override
    public List<BPAlimentoDTO> readAll() throws Exception {
        List <BPAlimentoDTO> lst = new ArrayList<>();
        String query =    " SELECT IdBPAlimento  "
                        + ",NombreAlimento"
                        + ",IdHormigaTipo "
                        + ",Codigo        "
                        + ",IdHormiga     "
                        + ",Estado        "
                        + ",FechaCrea     "
                        + ",FechaModifica "
                        + " FROM   BPAlimento"
                        + " WHERE  Estado = 'A' ";
        try{
            Connection conn = getDBConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                BPAlimentoDTO s = new BPAlimentoDTO( rs.getInt(1)
                                                    ,rs.getString(2)
                                                    ,rs.getInt(3)
                                                    ,rs.getInt(4)
                                                    ,rs.getInt(5)
                                                    ,rs.getString(6)
                                                    ,rs.getString(7)
                                                    ,rs.getString(8));
                lst.add(s);
            }
        } 
        catch(SQLException e){
            throw e; //new ACException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(BPAlimentoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "INSERT INTO BPAlimento (NombreAlimento, FechaCrea) VALUES (?, ?);";
        try {
            Connection conn = getDBConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreAlimento());
            pstmt.setString(2, dtf.format(now));
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    public boolean update(BPAlimentoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE BPAlimento SET IdHormigaTipo = ?, Codigo = ?, IdHormiga = ?,Estado = ?, FechaModifica = ? WHERE IdBPAlimento = ? ";
        try {
            Connection conn = getDBConnection();         //
            PreparedStatement pstmt = conn.prepareStatement(query);     //preparar
            pstmt.setInt(1, entity.getIdHormigaTipo());
            pstmt.setInt(2, entity.getCodigo());
            pstmt.setInt(3,entity.getIdHormiga());          //sete
            pstmt.setString(4,entity.getEstado());          //sete
            pstmt.setString(5,dtf.format(now));          //setea
            pstmt.setInt(6,entity.getIdBPAlimento()); //where
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
