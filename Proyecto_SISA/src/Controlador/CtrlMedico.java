package Controlador;

import Modelo.Medico;
import Modelo.ModelMedico;
import Vista.RegMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

public class CtrlMedico implements ActionListener {

    private Medico medico;
    private ModelMedico modelMedico;
    private RegMedico regMedico;
    private Validar validar;

    public CtrlMedico(Medico medico, ModelMedico modelMedico, RegMedico regMedico) {
        this.medico = medico;
        this.modelMedico = modelMedico;
        this.regMedico = regMedico;
        this.regMedico.btnGuardar.addActionListener(this);
        this.regMedico.btnModificar.addActionListener(this);
        this.regMedico.btnCancelar.addActionListener(this);

    }

    public void init() {
        regMedico.setTitle("Medico");
        regMedico.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        boolean flag = true;
 
        if (evt.getActionCommand() == "Guardar") {
            medico.setName(regMedico.txtName.getText());
            medico.setSurname(regMedico.txtSurname.getText());

            Date fecha = validar.getFecha(regMedico.jDateBirth.getDate());
            //Valida la fecha de nacimiento sea correcta
            if (validar.validarDateBirth(fecha)) {
                medico.setDateBirth((java.sql.Date) fecha);
            } else {
                flag = false;
            }
            //Valida la curp
            if (validar.validarCurp(regMedico.txtCurp.getText())) {
                medico.setCurp(regMedico.txtCurp.getText());
            } else {
                flag = false;
            }

            medico.setSexo(regMedico.cbxSexo.getSelectedItem().toString());
            medico.setBloodType(regMedico.txtTipSangre.getText());
            medico.setAddress(regMedico.txtAddress.getText());
            medico.setMunicipality(regMedico.txtMunicipality.getText());
            medico.setState(regMedico.txtState.getText());
            medico.setNacionality(regMedico.txtNationality.getText());
            medico.setCp(Integer.parseInt(regMedico.txtCp.getText()));
            //Validar correo Electronico
            if (validar.validarEmail(regMedico.txtEmail.getText())) {
                medico.setEmail(regMedico.txtEmail.getText());
            } else {
                flag = false;
            }
            //Validar numero de celular
            if (validar.validarPhone(regMedico.txtPhone.getText())) {
                medico.setPhone(regMedico.txtPhone.getText());
            } else {
                flag = false;
            }

            medico.setPuesto(regMedico.cbxPuesto.getSelectedItem().toString());
            medico.setEspecialidad(regMedico.txtEspecialidad.getText());
            medico.setPassword(regMedico.txtPassword.getText());

            if (modelMedico.registrar(medico)) {
                JOptionPane.showMessageDialog(null, "Registro guardado correctamente ");
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar guardar los campos ");
            }

        }

        if (evt.getActionCommand() == "Modificar") {
            medico.setName(regMedico.txtName.getText());
            medico.setSurname(regMedico.txtSurname.getText());

            Date fecha = validar.getFecha(regMedico.jDateBirth.getDate());
            //Valida la fecha de nacimiento sea correcta
            if (validar.validarDateBirth(fecha)) {
                medico.setDateBirth((java.sql.Date) fecha);
            } else {
                flag = false;
            }
            //Valida la curp
            if (validar.validarCurp(regMedico.txtCurp.getText())) {
                medico.setCurp(regMedico.txtCurp.getText());
            } else {
                flag = false;
            }

            medico.setSexo(regMedico.cbxSexo.getSelectedItem().toString());
            medico.setBloodType(regMedico.txtTipSangre.getText());
            medico.setAddress(regMedico.txtAddress.getText());
            medico.setMunicipality(regMedico.txtMunicipality.getText());
            medico.setState(regMedico.txtState.getText());
            medico.setNacionality(regMedico.txtNationality.getText());
            medico.setCp(Integer.parseInt(regMedico.txtCp.getText()));
            //Validar correo Electronico
            if (validar.validarEmail(regMedico.txtEmail.getText())) {
                medico.setEmail(regMedico.txtEmail.getText());
            } else {
                flag = false;
            }
            //Validar numero de celular
            if (validar.validarPhone(regMedico.txtPhone.getText())) {
                medico.setPhone(regMedico.txtPhone.getText());
            } else {
                flag = false;
            }

            medico.setPuesto(regMedico.cbxPuesto.getSelectedItem().toString());
            medico.setEspecialidad(regMedico.txtEspecialidad.getText());
            medico.setPassword(regMedico.txtPassword.getText());

            if (modelMedico.registrar(medico)) {
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente ");
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar modificar los campos ");
            }

        }

        if (evt.getSource() == "btnEliminar") {

            //Valida la curp
            if (validar.validarCurp(regMedico.txtCurp.getText())) {
                medico.setCurp(regMedico.txtCurp.getText());
            } else {
                flag = false;
            }

            if (modelMedico.eliminar(medico)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado correctamente ");
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar Eliminar los campos ");
            }

        }
        
        if (evt.getActionCommand() == "Cancelar"){
            JOptionPane.showMessageDialog(null, " Comunicarse con el Ing de Desarrollo de Software ");
        }

    }

}
