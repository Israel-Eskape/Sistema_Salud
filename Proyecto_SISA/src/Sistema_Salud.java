import Controlador.ConEnfermera;
import Modelo.ConectionDB;
import Vista.RegMedico;
import Controlador.ConMedico;
import Controlador.CtrlMedico;
import Modelo.Medico;
import Modelo.ModelMedico;
import Vista.RegEnfermera;


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
