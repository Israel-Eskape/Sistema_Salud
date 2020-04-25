package Controlador;

import Modelo.Medico;
import Modelo.ModelMedico;
import Vista.RegMedico;
import java.awt.event.ActionListener;

public class ctrlMedico implements ActionListener{
    private Medico medico;
    private ModelMedico modelMedico;
    private RegMedico regMedico;

    public ctrlMedico(Medico medico, ModelMedico modelMedico, RegMedico regMedico) {
        this.medico = medico;
        this.modelMedico = modelMedico;
        this.regMedico = regMedico;
    }
    
    
}
