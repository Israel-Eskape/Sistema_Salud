package Controlador;

import Modelo.Validar;
import Modelo.Medico;
import Modelo.ModelMedico;
import Vista.RegMedico;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class CtrlMedico implements ActionListener,KeyListener,FocusListener{

    private Medico medico;
    private ModelMedico modelMedico;
    private RegMedico regMedico;
    private Validar validar = new Validar();

    public CtrlMedico(Medico medico, ModelMedico modelMedico, RegMedico regMedico) {
        this.medico = medico;
        this.modelMedico = modelMedico;
        this.regMedico = regMedico;
        //ActionLitener a los Buttons
        this.regMedico.btnGuardar.addActionListener(this);
        this.regMedico.btnModificar.addActionListener(this);
        this.regMedico.btnCancelar.addActionListener(this);

        //KeyListener a los jtexField
        this.regMedico.txtCurp.addKeyListener(this);
        this.regMedico.txtName.addKeyListener(this);
        this.regMedico.txtSurname.addKeyListener(this);
        this.regMedico.jDateBirth.addKeyListener(this);
        this.regMedico.txtCp.addKeyListener(this);
        this.regMedico.txtAddress.addKeyListener(this);
        this.regMedico.txtMunicipality.addKeyListener(this);
        this.regMedico.txtState.addKeyListener(this);
        this.regMedico.txtNationality.addKeyListener(this);
        this.regMedico.txtTipSangre.addKeyListener(this);
        this.regMedico.txtEspecialidad.addKeyListener(this);
        this.regMedico.txtPhone.addKeyListener(this);
        this.regMedico.txtEmail.addKeyListener(this);
        this.regMedico.txtPassword.addKeyListener(this);

        
        //FocusListener a los jtexField 
        this.regMedico.txtCurp.addFocusListener(this);
        this.regMedico.txtName.addFocusListener(this);
        this.regMedico.txtSurname.addFocusListener(this);
        this.regMedico.jDateBirth.addFocusListener(this);
        this.regMedico.txtCp.addFocusListener(this);
        this.regMedico.txtAddress.addFocusListener(this);
        this.regMedico.txtMunicipality.addFocusListener(this);
        this.regMedico.txtState.addFocusListener(this);
        this.regMedico.txtNationality.addFocusListener(this);
        this.regMedico.txtTipSangre.addFocusListener(this);
        this.regMedico.txtEspecialidad.addFocusListener(this);
        this.regMedico.txtPhone.addFocusListener(this);
        this.regMedico.txtEmail.addFocusListener(this);
        this.regMedico.txtPassword.addFocusListener(this);


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
                java.sql.Date date = new java.sql.Date(fecha.getTime());
                medico.setDateBirth((java.sql.Date) date);
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
                medico.setDateBirth((java.sql.Date) (fecha));
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

    @Override
    public void focusGained(FocusEvent fe) {
        
    }

    @Override
    public void focusLost(FocusEvent fe) {

        if(fe.getSource().equals(regMedico.txtCurp)){
//            regMedico.txtName.requestFocus();

            if (validar.validarCurp(regMedico.txtCurp.getText())) 
                regMedico.txtCurp.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
            else{
                //regMedico.txtCurp.requestFocus(); 
                regMedico.txtCurp.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                regMedico.txtCurp.setSelectionStart(0);
                regMedico.txtCurp.setSelectionEnd(regMedico.txtCurp.getText().length());
            }
        }
        if(fe.getSource().equals(regMedico.txtPhone)){
            if(validar.validarPhone(regMedico.txtPhone.getText())){
                regMedico.txtPhone.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            }else{
                //regMedico.txtPhone.requestFocus(); 
                regMedico.txtPhone.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                regMedico.txtPhone.setSelectionStart(0);
                regMedico.txtPhone.setSelectionEnd(regMedico.txtPhone.getText().length());
            }
        }
        if(fe.getSource().equals(regMedico.txtEmail)){
            if(validar.validarEmail(regMedico.txtEmail.getText())){
                regMedico.txtEmail.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            }else{
                //regMedico.txtEmail.requestFocus(); 
                regMedico.txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                regMedico.txtEmail.setSelectionStart(0);
                regMedico.txtEmail.setSelectionEnd(regMedico.txtEmail.getText().length());
            }
        }
//        if(fe.getSource().equals(regMedico.jDateBirth)){
//                                System.out.println("datos ");
//
//            if(validar.validarDateBirth(regMedico.jDateBirth.getDate())){
//                regMedico.jDateBirth.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//            }else{
//                //regMedico.jDateBirth.requestFocus(); 
//                regMedico.jDateBirth.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
//            }
//        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()== KeyEvent.VK_TAB){
            System.out.print("evento tab");
        }
        if(ke.getKeyCode()== KeyEvent.VK_SPACE){
            System.out.print("evento SCA");
        }
        if(ke.getKeyCode()== KeyEvent.VK_ENTER){
            if(ke.getSource().equals(regMedico.txtCurp))        regMedico.txtName.requestFocus();
            if(ke.getSource().equals(regMedico.txtName))        regMedico.txtSurname.requestFocus();
            if(ke.getSource().equals(regMedico.txtSurname))     regMedico.jDateBirth.requestFocus();
            if(ke.getSource().equals(regMedico.jDateBirth))     regMedico.txtCp.requestFocus();
            if(ke.getSource().equals(regMedico.txtCp))          regMedico.txtAddress.requestFocus();
            if(ke.getSource().equals(regMedico.txtAddress))     regMedico.txtMunicipality.requestFocus();
            if(ke.getSource().equals(regMedico.txtMunicipality))regMedico.txtState.requestFocus();
            if(ke.getSource().equals(regMedico.txtState))       regMedico.txtNationality.requestFocus();
            if(ke.getSource().equals(regMedico.txtNationality)) regMedico.cbxSexo.requestFocus();
            if(ke.getSource().equals(regMedico.cbxSexo))        regMedico.txtTipSangre.requestFocus();
            if(ke.getSource().equals(regMedico.txtTipSangre))   regMedico.boxEstadoCivil.requestFocus();
            if(ke.getSource().equals(regMedico.boxEstadoCivil)) regMedico.txtEspecialidad.requestFocus();
            if(ke.getSource().equals(regMedico.txtEspecialidad))regMedico.cbxPuesto.requestFocus();
            if(ke.getSource().equals(regMedico.cbxPuesto))      regMedico.txtPhone.requestFocus();
            if(ke.getSource().equals(regMedico.txtPhone))       regMedico.txtEmail.requestFocus();
            if(ke.getSource().equals(regMedico.txtEmail))       regMedico.txtPassword.requestFocus();
            if(ke.getSource().equals(regMedico.txtPassword))    regMedico.btnGuardar.requestFocus();           
                        
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
