package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.RegEnfermera; 
import Modelo.ConectionDB;
import Modelo.Medico;

 
public class ConEnfermera implements ActionListener{
   private RegEnfermera view;
   private ConectionDB modelo;

    public ConEnfermera( RegEnfermera view , ConectionDB modelo){
        this.view   = view;
	this.modelo = modelo;
    }
 
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos
  
	Medico m;
        String comando  = arg0.getActionCommand();
 
        switch (comando) {
            case "GUARDAR":
			    //DATOS A GUARDAR
            break;
 
            case "MODIFICAR":
                
            break;
 
            case "CANCELAR":
			    				
            break;
			
            default:
                System.err.println("Comando no definido");
            break;
        }      
        limpia();
    }
 
    //Método para limpiar los datos del medico
    private void limpia(){
       //LLama metodos set y le asigna "" vacío 
    }  
}
