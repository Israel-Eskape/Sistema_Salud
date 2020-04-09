import Modelo.ConectionDB;
import Vista.RegMedico;
import Controlador.ConMedico;
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
    }
    
}
