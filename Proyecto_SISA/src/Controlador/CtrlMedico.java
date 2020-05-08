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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

public class CtrlMedico implements ActionListener,KeyListener,FocusListener{

    private Medico medico;
    private ModelMedico modelMedico;
    private RegMedico regMedico;
    private Validar validar = new Validar();
    private boolean flag = true;
    Color colorTrue = new ColorUIResource(35, 163, 50);


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
        this.regMedico.txtColonia.addKeyListener(this);
        this.regMedico.txtAddress.addKeyListener(this);
        this.regMedico.txtMunicipality.addKeyListener(this);
        this.regMedico.txtState.addKeyListener(this);
        this.regMedico.txtTipSangre.addKeyListener(this);
        this.regMedico.txtPhone.addKeyListener(this);
        this.regMedico.txtEspecialidad.addKeyListener(this);
        this.regMedico.txtCedula.addKeyListener(this);
        this.regMedico.txtEmail.addKeyListener(this);
        this.regMedico.txtPassword.addKeyListener(this);

        
        //FocusListener a los jtexField 
        this.regMedico.txtCurp.addFocusListener(this);
        this.regMedico.txtName.addFocusListener(this);
        this.regMedico.txtSurname.addFocusListener(this);
        this.regMedico.jDateBirth.addFocusListener(this);
        this.regMedico.txtCp.addFocusListener(this);
        this.regMedico.txtColonia.addFocusListener(this);
        this.regMedico.txtAddress.addFocusListener(this);
        this.regMedico.txtMunicipality.addFocusListener(this);
        this.regMedico.txtState.addFocusListener(this);
        this.regMedico.txtTipSangre.addFocusListener(this);
        this.regMedico.txtEspecialidad.addFocusListener(this);
        this.regMedico.txtCedula.addFocusListener(this);
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
 
        if (evt.getActionCommand() == "Guardar") {

            medico.setName(regMedico.txtName.getText());
            medico.setSurname(regMedico.txtSurname.getText());

            Date fecha = validar.getFecha(regMedico.jDateBirth.getDate());
            //Valida la fecha de nacimiento sea correcta
            //if (validar.validarDateBirth(fecha)) {
                java.sql.Date date = new java.sql.Date(fecha.getTime());
                medico.setDateBirth( date);
            //} else {
            //    flag = false;
            //}
            //Valida la curp
            //if (validar.validarCurp(regMedico.txtCurp.getText())) {
                medico.setCurp(regMedico.txtCurp.getText());
            //} else {
            //    flag = false;
            //}

            medico.setSexo(regMedico.cbxSexo.getSelectedItem().toString());
            medico.setBloodType(regMedico.txtTipSangre.getText());
            medico.setAddress(regMedico.txtAddress.getText());
            medico.setMunicipality(regMedico.txtMunicipality.getText());
            medico.setState(regMedico.txtState.getText());
            medico.setColonia(regMedico.txtColonia.getSelectedItem().toString());
            medico.setCp(Integer.parseInt(regMedico.txtCp.getText()));
            //Validar correo Electronico
            //if (validar.validarEmail(regMedico.txtEmail.getText())) {
                medico.setEmail(regMedico.txtEmail.getText());
            //} else {
            //    flag = false;
            //}
            //Validar numero de celular
            //if (validar.validarPhone(regMedico.txtPhone.getText())) {
                medico.setPhone(regMedico.txtPhone.getText());
            //} else {
            //    flag = false;
            //}

            medico.setPuesto(regMedico.cbxPuesto.getSelectedItem().toString());
            medico.setEspecialidad(regMedico.txtEspecialidad.getText());
            medico.setCedulaProfesional(regMedico.txtCedula.getText());
            medico.setPassword(regMedico.txtPassword.getText());
            if (flag == true){
                if (modelMedico.registrar(medico)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente ");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al intentar guardar los campos ");
                }    
            }else{
                JOptionPane.showMessageDialog(null, "Verifique que los campos esten correctamente ");
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
            medico.setAddress(regMedico.txtColonia.getSelectedItem().toString());
            medico.setMunicipality(regMedico.txtAddress.getText());
            medico.setState(regMedico.txtMunicipality.getText());
            medico.setColonia(regMedico.txtState.getText());
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
                regMedico.txtCurp.setBorder(BorderFactory.createLineBorder(colorTrue, 2));
            else{          ArrayList<String> arregloCp = new ArrayList<String>();
  
                //regMedico.txtCurp.requestFocus(); 
                regMedico.txtCurp.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                regMedico.txtCurp.setSelectionStart(0);
                regMedico.txtCurp.setSelectionEnd(regMedico.txtCurp.getText().length());
                flag = false;
            }
        }
        if(fe.getSource().equals(regMedico.txtName)){
            if(validar.validarLetras(regMedico.txtName.getText()) && !regMedico.txtName.getText().isEmpty())
                regMedico.txtName.setBorder(BorderFactory.createLineBorder(colorTrue,2));
            else{
                regMedico.txtName.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                regMedico.txtName.setSelectionStart(0);
                regMedico.txtName.setSelectionEnd(regMedico.txtName.getText().length());
                flag=false;
            }
        }
        if(fe.getSource().equals(regMedico.txtSurname)){
            if(validar.validarLetras(regMedico.txtSurname.getText()) && !regMedico.txtSurname.getText().isEmpty())
                regMedico.txtSurname.setBorder(BorderFactory.createLineBorder(colorTrue,2));
            else{
                regMedico.txtSurname.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                regMedico.txtSurname.setSelectionStart(0);
                regMedico.txtSurname.setSelectionEnd(regMedico.txtSurname.getText().length());
                flag=false;
            }
        }
        if(fe.getSource().equals(regMedico.txtCp)){
            ArrayList<String> arregloCp = new ArrayList<String>();
            
            if(validar.validarNumero(regMedico.txtCp.getText()) && !regMedico.txtCp.getText().isEmpty()){
                regMedico.txtCp.setBorder(BorderFactory.createLineBorder(colorTrue,2));
                try{
                    arregloCp = validar.validarCp(regMedico.txtCp.getText());
                    regMedico.txtMunicipality.setText(arregloCp.get(3));
                    regMedico.txtState.setText(arregloCp.get(6));
                    setCbxCp(arregloCp,regMedico.txtColonia , 0);
                
                    
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "        Ingrese un CP correcto \nO Compruebe su conexion a internet ");
                }
                       
            }
            else{
                regMedico.txtCp.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                regMedico.txtCp.setSelectionStart(0);
                regMedico.txtCp.setSelectionEnd(regMedico.txtCp.getText().length());
                flag=false;
            }
        }
        if(fe.getSource().equals(regMedico.txtAddress)){
            if(validar.validarLetras(regMedico.txtAddress.getText()) && !regMedico.txtAddress.getText().isEmpty())
                regMedico.txtAddress.setBorder(BorderFactory.createLineBorder(colorTrue,2));
            else{
                regMedico.txtAddress.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                regMedico.txtAddress.setSelectionStart(0);
                regMedico.txtAddress.setSelectionEnd(regMedico.txtAddress.getText().length());
                flag=false;
            }
        }
        if(fe.getSource().equals(regMedico.txtMunicipality)){
            if(validar.validarLetras(regMedico.txtMunicipality.getText()) && !regMedico.txtMunicipality.getText().isEmpty())
                regMedico.txtMunicipality.setBorder(BorderFactory.createLineBorder(colorTrue,2));
            
            else{
                regMedico.txtMunicipality.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                regMedico.txtMunicipality.setSelectionStart(0);
                regMedico.txtMunicipality.setSelectionEnd(regMedico.txtMunicipality.getText().length());
                flag=false;
            }
        }
        if(fe.getSource().equals(regMedico.txtState)){
            if(validar.validarLetras(regMedico.txtState.getText()) && !regMedico.txtState.getText().isEmpty())
                regMedico.txtState.setBorder(BorderFactory.createLineBorder(colorTrue,2));
            else{
                regMedico.txtState.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                regMedico.txtState.setSelectionStart(0);
                regMedico.txtState.setSelectionEnd(regMedico.txtState.getText().length());
                flag=false;
            }
        }
        if(fe.getSource().equals(regMedico.txtPhone)){
            if(validar.validarPhone(regMedico.txtPhone.getText()) && !regMedico.txtPhone.getText().isEmpty()){
                regMedico.txtPhone.setBorder(BorderFactory.createLineBorder(colorTrue));
            }else{
                //regMedico.txtPhone.requestFocus(); 
                regMedico.txtPhone.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                regMedico.txtPhone.setSelectionStart(0);
                regMedico.txtPhone.setSelectionEnd(regMedico.txtPhone.getText().length());
                flag = false;
            }
        }
        if(fe.getSource().equals(regMedico.txtEspecialidad)){
            if(validar.validarLetras(regMedico.txtEspecialidad.getText()) && !regMedico.txtEspecialidad.getText().isEmpty())
                regMedico.txtEspecialidad.setBorder(BorderFactory.createLineBorder(colorTrue,2));
            else{
                regMedico.txtEspecialidad.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                regMedico.txtEspecialidad.setSelectionStart(0);
                regMedico.txtEspecialidad.setSelectionEnd(regMedico.txtEspecialidad.getText().length());
                flag=false;
            }
        }
        if(fe.getSource().equals(regMedico.txtCedula)){
            if(validar.validarLetras(regMedico.txtCedula.getText()) && !regMedico.txtCedula.getText().isEmpty())
                regMedico.txtCedula.setBorder(BorderFactory.createLineBorder(colorTrue,2));
            else{
                regMedico.txtCedula.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                regMedico.txtCedula.setSelectionStart(0);
                regMedico.txtCedula.setSelectionEnd(regMedico.txtCedula.getText().length());
                flag=false;
            }
        }        
        if(fe.getSource().equals(regMedico.txtEmail)){
            if(validar.validarEmail(regMedico.txtEmail.getText()) && !regMedico.txtEmail.getText().isEmpty()){
                regMedico.txtEmail.setBorder(BorderFactory.createLineBorder(colorTrue));
            }else{
                //regMedico.txtEmail.requestFocus(); 
                regMedico.txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                regMedico.txtEmail.setSelectionStart(0);
                regMedico.txtEmail.setSelectionEnd(regMedico.txtEmail.getText().length());
                flag = false;
            }
        }
        if(fe.getSource().equals(regMedico.txtTipSangre)){
            if(!regMedico.txtTipSangre.getText().isEmpty()){
                regMedico.txtTipSangre.setBorder(BorderFactory.createLineBorder(colorTrue));
            }else{
                //regMedico.txtTipSangre.requestFocus(); 
                regMedico.txtTipSangre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                regMedico.txtTipSangre.setSelectionStart(0);
                regMedico.txtTipSangre.setSelectionEnd(regMedico.txtTipSangre.getText().length());
                flag = false;
            }
        }
        if(fe.getSource().equals(regMedico.txtPassword)){
            if( !regMedico.txtPassword.getText().isEmpty()){
                regMedico.txtPassword.setBorder(BorderFactory.createLineBorder(colorTrue));
            }else{
                //regMedico.txtPassword.requestFocus(); 
                regMedico.txtPassword.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                regMedico.txtPassword.setSelectionStart(0);
                regMedico.txtPassword.setSelectionEnd(regMedico.txtPassword.getText().length());
                flag = false;
            }
        }
        if(fe.getSource().equals(regMedico.txtCedula)){
            if( !regMedico.txtCedula.getText().isEmpty()){
                regMedico.txtCedula.setBorder(BorderFactory.createLineBorder(colorTrue));
            }else{
                //regMedico.txtPassword.requestFocus(); 
                regMedico.txtCedula.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                regMedico.txtCedula.setSelectionStart(0);
                regMedico.txtCedula.setSelectionEnd(regMedico.txtCedula.getText().length());
                flag = false;
            }
        }
    }

    public void setCbxCp(ArrayList ar,JComboBox nameCbx,int colum){
        int size = ar.size();
        Iterator<String> i = ar.iterator();
        nameCbx.removeAllItems();
       
        for(int j = colum; j<size; j=j+7)
            nameCbx.addItem((String) ar.get(j));
            
    }
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if(ke.getKeyCode()== KeyEvent.VK_ENTER){
            if(ke.getSource().equals(regMedico.txtCurp))        regMedico.txtName.requestFocus();
            if(ke.getSource().equals(regMedico.txtName))        regMedico.txtSurname.requestFocus();
            if(ke.getSource().equals(regMedico.txtSurname))     regMedico.jDateBirth.requestFocus();
            if(ke.getSource().equals(regMedico.jDateBirth))     regMedico.txtCp.requestFocus();
            if(ke.getSource().equals(regMedico.txtCp))          regMedico.txtColonia.requestFocus();
            if(ke.getSource().equals(regMedico.txtColonia))     regMedico.txtAddress.requestFocus();
            if(ke.getSource().equals(regMedico.txtAddress))     regMedico.txtMunicipality.requestFocus();
            if(ke.getSource().equals(regMedico.txtMunicipality))regMedico.txtState.requestFocus();
            if(ke.getSource().equals(regMedico.txtState))       regMedico.cbxSexo.requestFocus();
            if(ke.getSource().equals(regMedico.cbxSexo))        regMedico.txtTipSangre.requestFocus();
            if(ke.getSource().equals(regMedico.txtTipSangre))   regMedico.txtEspecialidad.requestFocus();
            if(ke.getSource().equals(regMedico.txtEspecialidad))regMedico.txtCedula.requestFocus();
            if(ke.getSource().equals(regMedico.txtCedula))      regMedico.cbxPuesto.requestFocus();
            if(ke.getSource().equals(regMedico.cbxPuesto))      regMedico.txtPhone.requestFocus();
            if(ke.getSource().equals(regMedico.txtPhone))       regMedico.txtEmail.requestFocus();
            if(ke.getSource().equals(regMedico.txtEmail))       regMedico.txtPassword.requestFocus();
            if(ke.getSource().equals(regMedico.txtPassword))    regMedico.btnGuardar.requestFocus();           
                        
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
