package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class modelPaciente{
    
    public boolean registrar(Paciente paciente) {
        ConectionDB conectionDB = new ConectionDB("DB_SISA", "localhost");
        PreparedStatement ps;
        String slqInsertPaciente = "insert into dbsisa.paciente values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqInsertPaciente);
            ps.setString(1, paciente.getName());
            ps.setString(2, paciente.getSurname());
            ps.setDate(3, paciente.getDateBirth());
            ps.setString(4, paciente.getCurp());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getBloodType());
            ps.setString(7, paciente.getAddress());
            ps.setString(8, paciente.getMunicipality());
            ps.setString(9, paciente.getState());
            ps.setInt(10, paciente.getCp());
            ps.setString(11, paciente.getEmail());
            ps.setString(12, paciente.getPhone());
            ps.setString(13, paciente.getOcupacion());
            ps.setString(14, paciente.getAlergias());
            ps.setString(15, paciente.getProbSalud());
            ps.setString(16, paciente.getResponsable());

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

    public boolean actualizar(Paciente paciente) {
        ConectionDB conectionDB = new ConectionDB("DB_SISA", "localhost");
        PreparedStatement ps;
        String slqUpdatePaciente = "UPDATE dbsisa.paciente SET curp = ?, nameP = ?, surname = ?, dateBirth = ?,"
                + "sexo =  ?,blodyType = ?, addressP = ?, municipality = ?, stateP = ?, cp = ?, email=?, phone = ?,"
                +" ocupacion = ?, alergias = ?, probSalud = ?, responsable = ? "
                +"where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdatePaciente);
            ps.setString(1, paciente.getCurp());
            ps.setString(2, paciente.getName());
            ps.setString(3, paciente.getSurname());
            ps.setDate(4, paciente.getDateBirth());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getBloodType());
            ps.setString(7, paciente.getAddress());
            ps.setString(8, paciente.getMunicipality());
            ps.setString(9, paciente.getState());
            ps.setInt(10, paciente.getCp());
            ps.setString(11, paciente.getEmail());
            ps.setString(12, paciente.getPhone());
            ps.setString(13, paciente.getOcupacion());
            ps.setString(14, paciente.getAlergias());
            ps.setString(15, paciente.getProbSalud());
            ps.setString(16, paciente.getResponsable());

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

    public boolean eliminar(Paciente paciente) {
        ConectionDB conectionDB = new ConectionDB("DB_SISA", "localhost");
        PreparedStatement ps;
        String slqUpdatePaciente = "DELETE FROM dbsisa.paciente where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdatePaciente);
            ps.setString(1, paciente.getCurp());
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

    public boolean buscar(Paciente paciente) {
        ConectionDB conectionDB = new ConectionDB("DB_SISA", "localhost");
        PreparedStatement ps;
        ResultSet resultSet = null;
        String slqUpdatePaciente = "SELECT * FROM dbsisa.paciente where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdatePaciente);
            ps.setString(1, paciente.getCurp());
            resultSet = ps.executeQuery();

            if(resultSet.next()){
                paciente.setCurp(resultSet.getString("curp"));
                paciente.setName(resultSet.getString("nameP"));
                paciente.setSurname(resultSet.getString("surname"));
                paciente.setDateBirth(resultSet.getDate("dateBirth"));
                paciente.setSexo(resultSet.getString("sexo"));
                paciente.setBloodType(resultSet.getString("blodyType"));
                paciente.setAddress(resultSet.getString("addressP"));
                paciente.setMunicipality(resultSet.getString("municipality"));
                paciente.setState(resultSet.getString("stateP"));
                paciente.setCp(Integer.parseInt(resultSet.getString("cp")));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setPhone(resultSet.getString("phone"));
                paciente.setOcupacion(resultSet.getString("cedulaProfesional"));
                paciente.setAlergias(resultSet.getString("tipo"));
                paciente.setProbSalud(resultSet.getString("puesto"));
                paciente.setResponsable(resultSet.getString("especialidad"));
                
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
