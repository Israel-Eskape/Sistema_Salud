package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelMedico{

    public boolean registrar(Medico medico) {
        ConectionDB conectionDB = new ConectionDB("DB_SISA", "localhost");
        PreparedStatement ps;
        String slqInsertMedico = "insert into dbsisa.medico values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqInsertMedico);
            ps.setString(1, medico.getName());
            ps.setString(2, medico.getSurname());
            ps.setString(3, medico.getDateBirth());
            ps.setString(4, medico.getCurp());
            ps.setString(5, medico.getSexo());
            ps.setString(6, medico.getBloodType());
            ps.setString(7, medico.getAddress());
            ps.setString(8, medico.getMunicipality());
            ps.setString(9, medico.getState());
            ps.setInt(10, medico.getCp());
            ps.setString(11, medico.getEmail());
            ps.setString(12, medico.getPhone());
            ps.setString(13, medico.getCedulaProfesional());
            ps.setString(14, medico.getTipo());
            ps.setString(15, medico.getPuesto());
            ps.setString(16, medico.getEspecialidad());
            ps.setString(17, medico.getPassword());

            ps.executeUpdate();
            System.out.println("Modelo.ClasePrueba.main()");
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
        ConectionDB conectionDB = new ConectionDB("DB_SISA", "localhost");
        PreparedStatement ps;
        String slqUpdateMedico = "UPDATE dbsisa.medico SET curp = ?, nameP = ?, surname = ?, dateBirth = ?,"
                + "sexo =  ?,blodyType = ?, addressP = ?, municipality = ?, stateP = ?, cp = ?, email=?, phone = ?,"
                +" cedulaProfesional = ?, tipo = ?, puesto = ?, especialidad = ?,password =  ? "
                +"where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdateMedico);
            ps.setString(1, medico.getCurp());
            ps.setString(2, medico.getName());
            ps.setString(3, medico.getSurname());
            ps.setString(4, medico.getDateBirth());
            ps.setString(5, medico.getSexo());
            ps.setString(6, medico.getBloodType());
            ps.setString(7, medico.getAddress());
            ps.setString(8, medico.getMunicipality());
            ps.setString(9, medico.getState());
            ps.setInt(10, medico.getCp());
            ps.setString(11, medico.getEmail());
            ps.setString(12, medico.getPhone());
            ps.setString(13, medico.getCedulaProfesional());
            ps.setString(14, medico.getTipo());
            ps.setString(15, medico.getPuesto());
            ps.setString(16, medico.getEspecialidad());
            ps.setString(17, medico.getPassword());

            ps.executeUpdate();
            System.out.println("Modelo.ClasePrueba.main()");
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
        ConectionDB conectionDB = new ConectionDB("DB_SISA", "localhost");
        PreparedStatement ps;
        String slqUpdateMedico = "DELETE FROM dbsisa.medico where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdateMedico);
            ps.setString(1, medico.getCurp());
            ps.execute();
            System.out.println("Modelo.ClasePrueba.main()");
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
        ConectionDB conectionDB = new ConectionDB("DB_SISA", "localhost");
        PreparedStatement ps;
        ResultSet resultSet = null;
        String slqUpdateMedico = "SELECT * FROM dbsisa.medico where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdateMedico);
            ps.setString(1, medico.getCurp());
            resultSet = ps.executeQuery();

            if(resultSet.next()){
                medico.setCurp(resultSet.getString("curp"));
                medico.setName(resultSet.getString("nameP"));
                medico.setSurname(resultSet.getString("surname"));
                medico.setDateBirth(resultSet.getString("dateBirth"));
                medico.setSexo(resultSet.getString("sexo"));
                medico.setBloodType(resultSet.getString("blodyType"));
                medico.setAddress(resultSet.getString("addressP"));
                medico.setMunicipality(resultSet.getString("municipality"));
                medico.setState(resultSet.getString("stateP"));
                medico.setCp(Integer.parseInt(resultSet.getString("cp")));
                medico.setEmail(resultSet.getString("email"));
                medico.setPhone(resultSet.getString("phone"));
                medico.setCedulaProfesional(resultSet.getString("cedulaProfesional"));
                medico.setTipo(resultSet.getString("tipo"));
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