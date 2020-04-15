import Controlador.ConEnfermera;
import Modelo.ConectionDB;
import Vista.RegMedico;
import Controlador.ConMedico;
import Vista.RegEnfermera;
/**
 *
 * @author Elvia
 */
public class Sistema_Salud {
    public static void main (String []args){
        ConectionDB modelo = new ConectionDB("SISA","localhost");
        RegMedico vista = new RegMedico();
        ConMedico controlador = new ConMedico(vista, modelo);
        vista.connectController(controlador);
        
        RegEnfermera vista2 = new RegEnfermera();
        ConEnfermera controlador2 = new ConEnfermera(vista2, modelo);
        vista2.connectController(controlador2);
        vista2.setVisible(true);
    }
    
}
