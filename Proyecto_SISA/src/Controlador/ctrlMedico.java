package Controlador;

import Modelo.Medico;
import Modelo.ModelMedico;
import Vista.RegMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class ctrlMedico implements ActionListener{
    private Medico medico;
    private ModelMedico modelMedico;
    private RegMedico regMedico;

    public ctrlMedico(Medico medico, ModelMedico modelMedico, RegMedico regMedico) {
        this.medico = medico;
        this.modelMedico = modelMedico;
        this.regMedico = regMedico;
        this.regMedico.btnGuardar.addActionListener(this);
        this.regMedico.btnModificar.addActionListener(this);
        this.regMedico.btnCancelar.addActionListener(this);
    }

    public void Star(){
        regMedico.setTitle("Medico");
        regMedico.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() ==  "btnGuardar"){
            
        }
    }
    
}
