package Controlador;

import Modelo.Medico;
import Modelo.ModelMedico;
import Vista.RegMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Action;

public class ctrlMedico implements ActionListener{
    private Medico medico;
    private ModelMedico modelMedico;
    private RegMedico regMedico;
    private Validar validar;

    public ctrlMedico(Medico medico, ModelMedico modelMedico, RegMedico regMedico) {
        this.medico = medico;
        this.modelMedico = modelMedico;
        this.regMedico = regMedico;
        this.regMedico.btnGuardar.addActionListener(this);
        this.regMedico.btnModificar.addActionListener(this);
        this.regMedico.btnCancelar.addActionListener(this);
        
    }

    public void init(){
        regMedico.setTitle("Medico");
        regMedico.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        boolean flag = true;
        if(evt.getSource() ==  "btnGuardar"){
            medico.setName(regMedico.txtName.getText());
            medico.setSurname(regMedico.txtSurname.getText());
            
            Date fecha = validar.getFecha(regMedico.jDateBirth.getDate());
            //Valida la fecha de nacimiento sea correcta
            if(validar.validarDateBirth(fecha)) medico.setDateBirth((java.sql.Date) fecha);
            else flag = false;
            //Valida la curp
            if(validar.validarCurp(regMedico.txtCurp.getText())) medico.setCurp(regMedico.txtCurp.getText());
            else flag = false;

            medico.setSexo(regMedico.cbxSexo.getSelectedItem().toString());
            medico.setBloodType(regMedico.txtTipSangre.getText());
            medico.setAddress(regMedico.txtAddress.getText());
            medico.setMunicipality(regMedico.txtMunicipality.getText());
            medico.setState(regMedico.txtState.getText());
            medico.setNacionality(regMedico.txtNationality.getText());
            medico.setCp(Integer.parseInt(regMedico.txtCp.getText()));
            //Validar correo Electronico
            if(validar.validarEmail(regMedico.txtEmail.getText())) medico.setEmail(regMedico.txtEmail.getText());
            else flag = false;
            //Validar numero de celular
            if(validar.validarPhone(regMedico.txtPhone.getText())) medico.setPhone(regMedico.txtPhone.getText());
            else flag = false;
            
            medico.setPuesto(regMedico.cbxPuesto.getSelectedItem().toString());
            medico.setEspecialidad(regMedico.txtEspecialidad.getText());
            medico.setPassword(regMedico.txtPassword.getText());
        }
    }
    
}
