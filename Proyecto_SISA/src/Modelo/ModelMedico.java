package Modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelMedico{
    private String nameDataBase = "DB_SISA";
    private String host         = "localhost";
    private String user         = "postgres";
    private String password     = "77israel77";
    private String nameSchema   = "sisa";
    
    public boolean registrar(Medico medico) {
        ConectionDB conectionDB = new ConectionDB(nameDataBase, host, user, password);
        PreparedStatement ps;
        String slqInsertMedico = "insert into "+nameSchema+".medico values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqInsertMedico);
            ps.setString(1, medico.getCurp());
            ps.setString(2, medico.getName());
            ps.setString(3, medico.getSurname());
            ps.setDate(4,   medico.getDateBirth());
            ps.setString(5, medico.getSexo());
            ps.setString(6, medico.getBloodType());
            ps.setString(7, medico.getAddress());
            ps.setString(8, medico.getMunicipality());
            ps.setString(9, medico.getState());
            ps.setString(10,medico.getColonia());
            ps.setInt(11,   medico.getCp());
            ps.setString(12, medico.getEmail());
            ps.setString(13, medico.getPhone());
            ps.setString(14, medico.getCedulaProfesional());
            ps.setString(15, medico.getPuesto());
            ps.setString(16, medico.getEspecialidad());
            ps.setString(17, medico.getPassword());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("error " + e);
            return false;
        } finally {
            try {
                conectionDB.closeConexion();
            } catch (Exception e) {
                System.err.println("" + e);
            }
        }
    }

    public boolean actualizar(Medico medico) {
        ConectionDB conectionDB = new ConectionDB(nameDataBase, host, user, password);
        PreparedStatement ps;
        String slqUpdateMedico = "UPDATE "+nameSchema+".medico SET curp = ?, nameP = ?, surname = ?, dateBirth = ?,"
                + "sexo =  ?,blodyType = ?, addressP = ?, municipality = ?, stateP = ?, colonia = ?,cp = ?, email=?, phone = ?,"
                +" cedulaProfesional = ?, tipo = ?, puesto = ?, especialidad = ?,password =  ? "
                +"where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdateMedico);
            ps.setString(1, medico.getCurp());
            ps.setString(2, medico.getName());
            ps.setString(3, medico.getSurname());
            ps.setDate(4, (Date) medico.getDateBirth());
            ps.setString(5, medico.getSexo());
            ps.setString(6, medico.getBloodType());
            ps.setString(7, medico.getAddress());
            ps.setString(8, medico.getMunicipality());
            ps.setString(9, medico.getState());
            ps.setString(10,medico.getColonia());
            ps.setInt(11, medico.getCp());
            ps.setString(12, medico.getEmail());
            ps.setString(13, medico.getPhone());
            ps.setString(14, medico.getCedulaProfesional());
            ps.setString(15, medico.getPuesto());
            ps.setString(16, medico.getEspecialidad());
            ps.setString(17, medico.getPassword());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("error " + e);
            return false;
        } finally {
            try {
                conectionDB.closeConexion();
            } catch (Exception e) {
                System.err.println("" + e);
            }
        }
    }

    public boolean eliminar(Medico medico) {
        ConectionDB conectionDB = new ConectionDB(nameDataBase, host, user, password);
        PreparedStatement ps;
        String slqUpdateMedico = "DELETE FROM "+nameSchema+".medico where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdateMedico);
            ps.setString(1, medico.getCurp());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("error " + e);
            return false;
        } finally {
            try {
                conectionDB.closeConexion();
            } catch (Exception e) {
                System.err.println("" + e);
            }
        }
    }

    public boolean buscar(Medico medico) {
        ConectionDB conectionDB = new ConectionDB(nameDataBase, host, user, password);
        PreparedStatement ps;
        ResultSet resultSet = null;
        String slqUpdateMedico = "SELECT * FROM "+nameSchema+".medico where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdateMedico);
            ps.setString(1, medico.getCurp());
            resultSet = ps.executeQuery();

            if(resultSet.next()){
                medico.setCurp(resultSet.getString("curp"));
                medico.setName(resultSet.getString("nameP"));
                medico.setSurname(resultSet.getString("surname"));
                medico.setDateBirth(resultSet.getDate("dateBirth"));
                medico.setSexo(resultSet.getString("sexo"));
                medico.setBloodType(resultSet.getString("blodyType"));
                medico.setAddress(resultSet.getString("addressP"));
                medico.setMunicipality(resultSet.getString("municipality"));
                medico.setState(resultSet.getString("stateP"));
                medico.setColonia(resultSet.getString("colonia"));
                medico.setCp(Integer.parseInt(resultSet.getString("cp")));
                medico.setEmail(resultSet.getString("email"));
                medico.setPhone(resultSet.getString("phone"));
                medico.setCedulaProfesional(resultSet.getString("cedulaProfesional"));
                medico.setPuesto(resultSet.getString("puesto"));
                medico.setEspecialidad(resultSet.getString("especialidad"));
                medico.setPassword(resultSet.getString("password"));

                return true;
    
            }
            return false;
        } catch (SQLException e) {
            System.err.println("error " + e);
            return false;
        } finally {
            try {
                conectionDB.closeConexion();
            } catch (Exception e) {
                System.err.println("" + e);
            }
        }
    }

}