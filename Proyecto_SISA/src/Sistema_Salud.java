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
        ConectionDB modelo = new ConectionDB("sisa","localhost","postgres","77israel77");
        
        Medico medico = new Medico(); 
        ModelMedico modelMedico = new ModelMedico();
        RegMedico regMedico = new RegMedico();
        
        CtrlMedico ctrlMedico = new CtrlMedico(medico, modelMedico, regMedico);
        ctrlMedico.init();
        regMedico.setVisible(true);
        /*RegMedico vista = new RegMedico();
        ConMedico controlador = new ConMedico(vista, modelo);
        vista.connectController(controlador);
        
        RegEnfermera vista2 = new RegEnfermera();
        ConEnfermera controlador2 = new ConEnfermera(vista2, modelo);
        vista2.connectController(controlador2);
        vista2.setVisible(true);*/
    }
    
}
