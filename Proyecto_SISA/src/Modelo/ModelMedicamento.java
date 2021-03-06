package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ModelMedicamento {

    public boolean registrar(Medicamento medicamento) {
        ConectionDB conectionDB = new ConectionDB("sisa","localhost","postgres","77israel77");
        PreparedStatement ps = null;
        String sqlInsertMedicamento = "INSERT INTO dbsisa.medicamento  VALUES (?, ?, ?, ?, ?, ?);";
        try {
            ps = conectionDB.getConexion().prepareStatement(sqlInsertMedicamento);
            ps.setString(1, medicamento.getCodigo());
            ps.setString(2, medicamento.getNombreMedicamento());
            ps.setString(3, medicamento.getFechaRegistro());
            ps.setString(4, medicamento.getFechaVencimiento());
            ps.setInt(5, medicamento.getExistencia());
            ps.setString(6, medicamento.getDescripcion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error " + e);
            return false;
        } finally {
            try {
                conectionDB.closeConexion();
            } catch (Exception e) {
                System.err.println("Error = " + e);
            }
        }
    }

    public boolean actualizar(Medicamento medicamento) {
        ConectionDB conectionDB = new ConectionDB("sisa","localhost","postgres","77israel77");
        PreparedStatement ps;
        String sqlInsertMedicamento = "UPDATE dbsisa.medicamento  SET codigo = ?, nombreMed = ?, "
        +"registro = ?, vencimiento = ?, existencia = ?, descripcion = ?"
        +"where codigo = ? ";
        try {
            ps = conectionDB.getConexion().prepareStatement(sqlInsertMedicamento);
            ps.setString(1, medicamento.getCodigo());
            ps.setString(2, medicamento.getNombreMedicamento());
            ps.setString(3, medicamento.getFechaRegistro());
            ps.setString(4, medicamento.getFechaVencimiento());
            ps.setInt(5, medicamento.getExistencia());
            ps.setString(6, medicamento.getDescripcion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error " + e);
            return false;
        } finally {
            try {
                conectionDB.closeConexion();
            } catch (Exception e) {
                System.err.println("Error = " + e);
            }
        }
    }


    public boolean eliminar(Medicamento medicamento) {
        ConectionDB conectionDB = new ConectionDB("sisa","localhost","postgres","77israel77");
        PreparedStatement ps;
        String sqlInsertMedicamento = "DELETE FROM dbsisa.medicamento where codigo = ? ";
        try {
            ps = conectionDB.getConexion().prepareStatement(sqlInsertMedicamento);
            ps.setString(1, medicamento.getCodigo());
           
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error " + e);
            return false;
        } finally {
            try {
                conectionDB.closeConexion();
            } catch (Exception e) {
                System.err.println("Error = " + e);
            }
        }
    }

    public boolean buscar(Medicamento medicamento) {
        ConectionDB conectionDB = new ConectionDB("sisa","localhost","postgres","77israel77");
        PreparedStatement ps;
        ResultSet resultSet = null;
        String sqlInsertMedicamento = "DELETE FROM dbsisa.medicamento where codigo = ? ";
        try {
            ps = conectionDB.getConexion().prepareStatement(sqlInsertMedicamento);
            ps.setString(1, medicamento.getCodigo());
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                // medico.setCurp(resultSet.getString("curp"));
               
                medicamento.setCodigo(resultSet.getString("codigo"));
                medicamento.setNombreMedicamento(resultSet.getString("nombreMed"));
                medicamento.setFechaRegistro(resultSet.getString("registro"));
                medicamento.setFechaVencimiento(resultSet.getString("vencimiento"));
                medicamento.setExistencia(Integer.parseInt(resultSet.getString("existencia")));
                medicamento.setDescripcion(resultSet.getString("descrpcion"));
                return true;
            }

            ps.executeUpdate();
            return true;
        } catch (NumberFormatException | SQLException e) {
            System.err.println("Error " + e);
            return false;
        } finally {
            try {
                conectionDB.closeConexion();
            } catch (Exception e) {
                System.err.println("Error = " + e);
            }
        }
    }

}
