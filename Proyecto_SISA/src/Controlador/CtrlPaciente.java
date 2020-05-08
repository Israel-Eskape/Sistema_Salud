
package Controlador;

import Modelo.Paciente;
import Modelo.ModelPaciente;
import Modelo.Validar;
import Vista.RegPaciente;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;

public class CtrlPaciente implements ActionListener, KeyListener,FocusListener{

    private Paciente paciente;
    private ModelPaciente modelPaciente;
    private RegPaciente regPaciente;
    private Validar validar = new Validar();
    private boolean flag = true;
    private Color colorTrue = new ColorUIResource(35, 163, 50);


    public CtrlPaciente(Paciente paciente,ModelPaciente modelPaciente,RegPaciente regPaciente){
        this.paciente = paciente;
        this.modelPaciente = modelPaciente;
        this.regPaciente = regPaciente;
        //ActionListener a los buttons
        this.regPaciente.btnGuardar.addActionListener(this);
        this.regPaciente.btnModificar.addActionListener(this);
        this.regPaciente.btnCancelar.addActionListener(this);
        
        //KeyListener a los jtexField
        this.regPaciente.txtCurp.addKeyListener(this);
        this.regPaciente.txtName.addKeyListener(this);
        this.regPaciente.txtSurname.addKeyListener(this);
        this.regPaciente.jDateBirth.addKeyListener(this);
        this.regPaciente.txtCp.addKeyListener(this);
        this.regPaciente.txtAddress.addKeyListener(this);
        this.regPaciente.txtMunicipality.addKeyListener(this);
        this.regPaciente.txtState.addKeyListener(this);
        this.regPaciente.txtNationality.addKeyListener(this);
        this.regPaciente.txtTipSangre.addKeyListener(this);
        this.regPaciente.txtPhone.addKeyListener(this);
        this.regPaciente.txtOcupacion.addKeyListener(this);
        this.regPaciente.txtProblemaSalud.addKeyListener(this);
        this.regPaciente.txtResponsable.addKeyListener(this);

        //FocusListener a los jtexField
        this.regPaciente.txtCurp.addFocusListener(this);
        this.regPaciente.txtName.addFocusListener(this);
        this.regPaciente.txtSurname.addFocusListener(this);
        this.regPaciente.jDateBirth.addFocusListener(this);
        this.regPaciente.txtCp.addFocusListener(this);
        this.regPaciente.txtAddress.addFocusListener(this);
        this.regPaciente.txtMunicipality.addFocusListener(this);
        this.regPaciente.txtState.addFocusListener(this);
        this.regPaciente.txtNationality.addFocusListener(this);
        this.regPaciente.txtTipSangre.addFocusListener(this);
        this.regPaciente.txtPhone.addFocusListener(this);
        this.regPaciente.txtOcupacion.addFocusListener(this);
        this.regPaciente.txtProblemaSalud.addFocusListener(this);
        this.regPaciente.txtResponsable.addFocusListener(this);
    }
    public void init(){
        regPaciente.setTitle("Paciente");
        regPaciente.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand() == "Guardar") {

            paciente.setName(regPaciente.txtName.getText());
            paciente.setSurname(regPaciente.txtSurname.getText());

            Date fecha = validar.getFecha(regPaciente.jDateBirth.getDate());
            //Valida la fecha de nacimiento sea correcta
            //if (validar.validarDateBirth(fecha)) {
                java.sql.Date date = new java.sql.Date(fecha.getTime());
                paciente.setDateBirth((java.sql.Date) date);
            //} else {
            //    flag = false;
            //}
            //Valida la curp
            //if (validar.validarCurp(regPaciente.txtCurp.getText())) {
                paciente.setCurp(regPaciente.txtCurp.getText());
            //} else {
            //    flag = false;
            //}

            paciente.setSexo(regPaciente.cbxSexo.getSelectedItem().toString());
            paciente.setBloodType(regPaciente.txtTipSangre.getText());
            paciente.setAddress(regPaciente.txtAddress.getText());
            paciente.setMunicipality(regPaciente.txtMunicipality.getText());
            paciente.setState(regPaciente.txtState.getText());
            paciente.setColonia(regPaciente.txtNationality.getText());
            paciente.setCp(Integer.parseInt(regPaciente.txtCp.getText()));
            //Validar correo Electronico
            //if (validar.validarEmail(regPaciente.txtEmail.getText())) {
                paciente.setEmail(regPaciente.txtEmail.getText());
            //} else {
            //    flag = false;
            //}
            //Validar numero de celular
            //if (validar.validarPhone(regPaciente.txtPhone.getText())) {
                paciente.setPhone(regPaciente.txtPhone.getText());
            //} else {
            //    flag = false;
            //}
            
            paciente.setOcupacion(regPaciente.txtOcupacion.getText());
            paciente.setProbSalud(regPaciente.txtProblemaSalud.getText());
            paciente.setResponsable(regPaciente.txtResponsable.getText());

            if (flag == true){
                if (modelPaciente.registrar(paciente)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente ");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al intentar guardar los campos ");
                }    
            }else{
                JOptionPane.showMessageDialog(null, "Verifique que los campos esten correctamente ");
            }

        }

        if (evt.getActionCommand() == "Modificar") {
            paciente.setName(regPaciente.txtName.getText());
            paciente.setSurname(regPaciente.txtSurname.getText());

            Date fecha = validar.getFecha(regPaciente.jDateBirth.getDate());
            //Valida la fecha de nacimiento sea correcta
            if (validar.validarDateBirth(fecha)) {
                paciente.setDateBirth((java.sql.Date) (fecha));
            } else {
                flag = false;
            }
            //Valida la curp
            if (validar.validarCurp(regPaciente.txtCurp.getText())) {
                paciente.setCurp(regPaciente.txtCurp.getText());
            } else {
                flag = false;
            }

            paciente.setSexo(regPaciente.cbxSexo.getSelectedItem().toString());
            paciente.setBloodType(regPaciente.txtTipSangre.getText());
            paciente.setAddress(regPaciente.txtAddress.getText());
            paciente.setMunicipality(regPaciente.txtMunicipality.getText());
            paciente.setState(regPaciente.txtState.getText());
            paciente.setColonia(regPaciente.txtNationality.getText());
            paciente.setCp(Integer.parseInt(regPaciente.txtCp.getText()));
            //Validar correo Electronico
            if (validar.validarEmail(regPaciente.txtEmail.getText())) {
                paciente.setEmail(regPaciente.txtEmail.getText());
            } else {
                flag = false;
            }
            //Validar numero de celular
            if (validar.validarPhone(regPaciente.txtPhone.getText())) {
                paciente.setPhone(regPaciente.txtPhone.getText());
            } else {
                flag = false;
            }

           /* paciente.setPuesto(regPaciente.cbxPuesto.getSelectedItem().toString());
            paciente.setEspecialidad(regPaciente.txtEspecialidad.getText());
            paciente.setPassword(regPaciente.txtPassword.getText());
*/
            paciente.setOcupacion(regPaciente.txtOcupacion.getText());
            paciente.setProbSalud(regPaciente.txtProblemaSalud.getText());
            paciente.setResponsable(regPaciente.txtResponsable.getText());

            if (modelPaciente.registrar(paciente)) {
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente ");
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar modificar los campos ");
            }

        }

        if (evt.getSource() == "btnEliminar") {

            //Valida la curp
            if (validar.validarCurp(regPaciente.txtCurp.getText())) {
                paciente.setCurp(regPaciente.txtCurp.getText());
            } else {
                flag = false;
            }

            if (modelPaciente.eliminar(paciente)) {
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
        if(fe.getSource().equals(regPaciente.txtCurp)){
            //            regPaciente.txtName.requestFocus();
            
            if (validar.validarCurp(regPaciente.txtCurp.getText())) 
                regPaciente.txtCurp.setBorder(BorderFactory.createLineBorder(colorTrue, 2));
                else{
                    //regPaciente.txtCurp.requestFocus(); 
                    regPaciente.txtCurp.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    regPaciente.txtCurp.setSelectionStart(0);
                    regPaciente.txtCurp.setSelectionEnd(regPaciente.txtCurp.getText().length());
                    flag = false;
                }
           }
            if(fe.getSource().equals(regPaciente.txtName)){
                if(validar.validarLetras(regPaciente.txtName.getText()) && !regPaciente.txtName.getText().isEmpty())
                    regPaciente.txtName.setBorder(BorderFactory.createLineBorder(colorTrue,2));
                else{
                    regPaciente.txtName.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                    regPaciente.txtName.setSelectionStart(0);
                    regPaciente.txtName.setSelectionEnd(regPaciente.txtName.getText().length());
                    flag=false;
                }
            }
            if(fe.getSource().equals(regPaciente.txtSurname)){
                if(validar.validarLetras(regPaciente.txtSurname.getText()) && !regPaciente.txtSurname.getText().isEmpty())
                    regPaciente.txtSurname.setBorder(BorderFactory.createLineBorder(colorTrue,2));
                else{
                    regPaciente.txtSurname.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                    regPaciente.txtSurname.setSelectionStart(0);
                    regPaciente.txtSurname.setSelectionEnd(regPaciente.txtSurname.getText().length());
                    flag=false;
                }
            }
            if(fe.getSource().equals(regPaciente.txtCp)){
                if(validar.validarNumero(regPaciente.txtCp.getText()) && !regPaciente.txtCp.getText().isEmpty())
                    regPaciente.txtCp.setBorder(BorderFactory.createLineBorder(colorTrue,2));
                else{
                    regPaciente.txtCp.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                    regPaciente.txtCp.setSelectionStart(0);
                    regPaciente.txtCp.setSelectionEnd(regPaciente.txtCp.getText().length());
                    flag=false;
                }
            }
            if(fe.getSource().equals(regPaciente.txtMunicipality)){
                if(validar.validarLetras(regPaciente.txtMunicipality.getText()) && !regPaciente.txtMunicipality.getText().isEmpty())
                    regPaciente.txtMunicipality.setBorder(BorderFactory.createLineBorder(colorTrue,2));
                else{
                    regPaciente.txtMunicipality.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                    regPaciente.txtMunicipality.setSelectionStart(0);
                    regPaciente.txtMunicipality.setSelectionEnd(regPaciente.txtMunicipality.getText().length());
                    flag=false;
                }
            }
            if(fe.getSource().equals(regPaciente.txtState)){
                if(validar.validarLetras(regPaciente.txtState.getText()) && !regPaciente.txtState.getText().isEmpty())
                    regPaciente.txtState.setBorder(BorderFactory.createLineBorder(colorTrue,2));
                else{
                    regPaciente.txtState.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                    regPaciente.txtState.setSelectionStart(0);
                    regPaciente.txtState.setSelectionEnd(regPaciente.txtState.getText().length());
                    flag=false;
                }
            }
            if(fe.getSource().equals(regPaciente.txtNationality)){
                if(validar.validarLetras(regPaciente.txtNationality.getText()) && !regPaciente.txtNationality.getText().isEmpty())
                    regPaciente.txtNationality.setBorder(BorderFactory.createLineBorder(colorTrue,2));
                else{
                    regPaciente.txtNationality.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                    regPaciente.txtNationality.setSelectionStart(0);
                    regPaciente.txtNationality.setSelectionEnd(regPaciente.txtNationality.getText().length());
                    flag=false;
                }
            }
            if(fe.getSource().equals(regPaciente.txtPhone)){
                if(validar.validarPhone(regPaciente.txtPhone.getText()) && !regPaciente.txtPhone.getText().isEmpty()){
                    regPaciente.txtPhone.setBorder(BorderFactory.createLineBorder(colorTrue));
                }else{
                            //regPaciente.txtPhone.requestFocus(); 
                    regPaciente.txtPhone.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    regPaciente.txtPhone.setSelectionStart(0);
                    regPaciente.txtPhone.setSelectionEnd(regPaciente.txtPhone.getText().length());
                    flag = false;
                }
            }                 
    }

    @Override
    public void keyTyped(KeyEvent ke) {
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
            if(ke.getSource().equals(regPaciente.txtCurp))        regPaciente.txtName.requestFocus();
            if(ke.getSource().equals(regPaciente.txtName))        regPaciente.txtSurname.requestFocus();
            if(ke.getSource().equals(regPaciente.txtSurname))     regPaciente.jDateBirth.requestFocus();
            if(ke.getSource().equals(regPaciente.jDateBirth))     regPaciente.txtCp.requestFocus();
            if(ke.getSource().equals(regPaciente.txtCp))          regPaciente.txtAddress.requestFocus();
            if(ke.getSource().equals(regPaciente.txtAddress))     regPaciente.txtMunicipality.requestFocus();
            if(ke.getSource().equals(regPaciente.txtMunicipality))regPaciente.txtState.requestFocus();
            if(ke.getSource().equals(regPaciente.txtState))       regPaciente.txtNationality.requestFocus();
            if(ke.getSource().equals(regPaciente.txtNationality)) regPaciente.cbxSexo.requestFocus();
            if(ke.getSource().equals(regPaciente.cbxSexo))        regPaciente.txtTipSangre.requestFocus();
            if(ke.getSource().equals(regPaciente.txtTipSangre))   regPaciente.boxEstadoCivil.requestFocus();
            if(ke.getSource().equals(regPaciente.boxEstadoCivil)) regPaciente.txtOcupacion.requestFocus();
            if(ke.getSource().equals(regPaciente.txtOcupacion))regPaciente.txtProblemaSalud.requestFocus();
            if(ke.getSource().equals(regPaciente.txtProblemaSalud))      regPaciente.txtPhone.requestFocus();
            if(ke.getSource().equals(regPaciente.txtPhone))       regPaciente.txtEmail.requestFocus();
            if(ke.getSource().equals(regPaciente.txtEmail))       regPaciente.txtResponsable.requestFocus();
            if(ke.getSource().equals(regPaciente.txtResponsable))       regPaciente.btnGuardar.requestFocus();           
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
