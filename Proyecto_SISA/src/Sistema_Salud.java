
import Vista.RegMedico;
import Controlador.CtrlMedico;
import Modelo.Medico;
import Modelo.ModelMedico;


public class Sistema_Salud {
    public static void main (String []args){
        
        Medico medico = new Medico(); 
        ModelMedico modelMedico = new ModelMedico();
        RegMedico regMedico = new RegMedico();
        
        CtrlMedico ctrlMedico = new CtrlMedico(medico, modelMedico, regMedico);
        ctrlMedico.init();
        regMedico.setVisible(true);
    }
    
}
