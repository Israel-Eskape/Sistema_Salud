package Controlador;

import Modelo.Medico;
import Modelo.ModelMedico;
import Vista.RegMedico;
import com.sun.jmx.remote.util.EnvHelp;
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
        if(evt.getSource() ==  "btnGuardar"){
            medico.setName(regMedico.txtName.getText());
            medico.setSurname(regMedico.txtSurname.getText());
            
            Date fecha = validar.getFecha(regMedico.jDateBirth.getDate());
            boolean validarDate = validar.validarDateBirth(fecha);
            if(validarDate){
                medico.setDateBirth((java.sql.Date) fecha);
            }
            

            medico.setCurp(regMedico.txtCurp.getText());
            
        }
    }
    
}
