package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelPaciente{
    
    public boolean registrar(Paciente paciente) {
        //                                      name_DataBase,localhost,postgres,Password
        ConectionDB conectionDB = new ConectionDB("DB_SISA","localhost","postgres","77israel77");
        PreparedStatement ps;
        //                                      name_Schema.nameTable
        String slqInsertPaciente = "insert into sisa.paciente values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqInsertPaciente);
            ps.setString(1, paciente.getCurp());
            ps.setString(2, paciente.getName());
            ps.setString(3, paciente.getSurname());
            ps.setDate(4,   paciente.getDateBirth());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getBloodType());
            ps.setString(7, paciente.getAddress());
            ps.setString(8, paciente.getMunicipality());
            ps.setString(9, paciente.getState());
            ps.setString(10,paciente.getColonia());
            ps.setInt(11,   paciente.getCp());
            ps.setString(12, paciente.getEmail());
            ps.setString(13, paciente.getPhone());
            ps.setString(14, paciente.getOcupacion());
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
        ConectionDB conectionDB = new ConectionDB("DB_SISA","localhost","postgres","77israel77");
        PreparedStatement ps;
        String slqUpdatePaciente = "UPDATE sisa.paciente SET curp = ?, nameP = ?, surname = ?, dateBirth = ?,"
                + "sexo =  ?,blodyType = ?, addressP = ?, municipality = ?, stateP = ?,colonia = ?, cp = ?, email=?, phone = ?,"
                +" ocupacion = ?, alergias = ?, probSalud = ?, responsable = ? "
                +"where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdatePaciente);
            ps.setString(1, paciente.getCurp());
            ps.setString(2, paciente.getName());
            ps.setString(3, paciente.getSurname());
            ps.setDate(4,   paciente.getDateBirth());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getBloodType());
            ps.setString(7, paciente.getAddress());
            ps.setString(8, paciente.getMunicipality());
            ps.setString(9, paciente.getState());
            ps.setString(10,paciente.getColonia());
            ps.setInt(11,   paciente.getCp());
            ps.setString(12, paciente.getEmail());
            ps.setString(13, paciente.getPhone());
            ps.setString(14, paciente.getOcupacion());
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
        ConectionDB conectionDB = new ConectionDB("DB_SISA","localhost","postgres","77israel77");
        PreparedStatement ps;
        String slqUpdatePaciente = "DELETE FROM sisa.paciente where curp = ?";
        try {
            ps = conectionDB.getConexion().prepareStatement(slqUpdatePaciente);
            ps.setString(1, paciente.getCurp());
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

    public boolean buscar(Paciente paciente) {
        ConectionDB conectionDB = new ConectionDB("DB_SISA","localhost","postgres","77israel77");
        PreparedStatement ps;
        ResultSet resultSet = null;
        String slqUpdatePaciente = "SELECT * FROM sisa.paciente where curp = ?";
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
                paciente.setColonia(resultSet.getString("colonia"));
                paciente.setCp(Integer.parseInt(resultSet.getString("cp")));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setPhone(resultSet.getString("phone"));
                paciente.setOcupacion(resultSet.getString("cedulaProfesional"));
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
