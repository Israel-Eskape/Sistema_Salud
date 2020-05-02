package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ClasePrueba{
    public static void main(String [] args) throws SQLException{
        ConectionDB conectionDB = new ConectionDB("sisa","localhost","postgres","77israel77");
        PreparedStatement ps;
        String slqInsertMedico = "insert into dbsisa.medico values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        try{
            ps = conectionDB.getConexion().prepareStatement(slqInsertMedico);
            ps.setString(1,"jose");
            ps.setString(2, "Aquino");
            ps.setString(3, "12");
            ps.setString(4, "AEMGHOCVRS07");
            ps.setString(5, "h");
            ps.setString(6, "OR");
            ps.setString(7, "lera");
            ps.setString(8, "a cal");
            ps.setString(9, "aca");
            ps.setInt(10, 36);
            ps.setString(11, "ca");
            ps.setString(12, "l.com");
            ps.setString(13, "9513");
            ps.setString(14, "INGSC");
            ps.setString(15, "Medico");
            ps.setString(16, "Director");
            ps.setString(17, "Nada");
            ps.setString(18, "abcd");
            
            
            ps.executeUpdate();
            System.out.println("Modelo.ClasePrueba.main()");
            
        }catch(Exception e){
            System.err.println("error "+e);
        }
//        Medico medico = new Medico("José", "Aquino", "20-03-2010", "AEMG940411HOCVRS07",
//"Hombre", "ORH+", "calle Nopalera", "San Antonio de la Cal ", "Oaxaca", 71,"Oaxaca", 7
//"isra.ixoye@gmail.com", "9513328988", "INGSC", "Médico", "Director","nada", "abcd");
//        System.out.println(medico.toString());
    }
}