package Controlador;
import com.sun.jmx.remote.util.EnvHelp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validar {
    
    public java.sql.Date getFechaActual(){
        return (new java.sql.Date(new Date().getTime()));
    }
    
     public Date getFecha(Date jDateBirth) {  
        return (new java.sql.Date(jDateBirth.getTime()));
    }
    public boolean validarDateBirth(Date fecha){
        if((fecha.getYear() <= getFechaActual().getYear())
         && fecha.getMonth()<= getFechaActual().getMonth()
          &&fecha.getDay()  <= getFechaActual().getDay()){  
            System.out.println("Fecha de nacimiento ingresada es correcta");
            return true;
        }else{
            System.err.println("Ingrese una Fecha de nacimiento correcta");
            return false;
        }
              
    }
}
