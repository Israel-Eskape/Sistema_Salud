package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Validar {
    private String patternCurp   = "^([A-Z&]|[a-z&]{1})([AEIOU]|[aeiou]{1})([A-Z&]|[a-z&]{1})([A-Z&]|[a-z&]{1})([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([HM]|[hm]{1})([AS|as|BC|bc|BS|bs|CC|cc|CS|cs|CH|ch|CL|cl|CM|cm|DF|df|DG|dg|GT|gt|GR|gr|HG|hg|JC|jc|MC|mc|MN|mn|MS|ms|NT|nt|NL|nl|OC|oc|PL|pl|QT|qt|QR|qr|SP|sp|SL|sl|SR|sr|TC|tc|TS|ts|TL|tl|VZ|vz|YN|yn|ZS|zs|NE|ne]{2})([^A|a|E|e|I|i|O|o|U|u]{1})([^A|a|E|e|I|i|O|o|U|u]{1})([^A|a|E|e|I|i|O|o|U|u]{1})([0-9]{2})$";
    private String patternEmail  = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";    
    private String patternPhone  = "^([0-9]{3})(-| )([0-9]{3})(-| )([0-9]{2})(-| )([0-9]{2})$";
    private String patternCadena = "^([A-Z]|[a-z]|[ ])*$";
    private String patternNumero = "^[0-9]*$";

    public boolean validarCurp(String curp) {
        if (curp.matches(patternCurp)) {
            String digito = curp.charAt(17) + "";
            String digitoValida = digitoVerificador(curp) + "";
            if (digito.equals(digitoValida))
                return true;
        }
        return false;
    }

    public int digitoVerificador(String curp) {
        String diccionario = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int suma = 0;
        int digito = 0;
        for (int i = 0; i < 17; i++)
            suma = suma + diccionario.indexOf(curp.charAt(i)) * (18 - i);
        digito = 10 - suma % 10;
        if (digito == 10)
            return 0;
        return digito;
    }

    public java.sql.Date getFechaActual() {
        return (new java.sql.Date(new Date().getTime()));
    }

    public Date getFecha(Date jDateBirth) {
        return (new Date(jDateBirth.getTime()));
    }

    public boolean validarDateBirth(Date fecha) {
        if ((fecha.getYear() <= getFechaActual().getYear()) && fecha.getMonth() <= getFechaActual().getMonth()
                && fecha.getDay() <= getFechaActual().getDay()) {
            System.out.println("Fecha de nacimiento ingresada es correcta");
            return true;
        } else {
            System.err.println("Ingrese una Fecha de nacimiento correcta");
            return false;
        }

    }
   
    public boolean validarEmail(String email){
        return email.matches(patternEmail);
    }

    public boolean validarPhone(String phone){
        return phone.matches(patternPhone);
    }

    public boolean validarLetras(String cadena){
        return cadena.matches(patternCadena);
    }

    public boolean validarNumero(String cadena){
        return cadena.matches(patternNumero);
    }
    
    public ArrayList validarCp(String cp){
        ArrayList<String> arregloCp = new ArrayList<String>();
        arregloCp.clear();
        try {
            Document document = Jsoup.connect("https://micodigopostal.org/buscarcp.php?buscar="+cp).get();
                for(Element input: document.getElementsByTag("td"))
                    arregloCp.add(input.text());
            throw new Exception("CP incorrecto ");
        } catch (Exception e) {
            System.err.println(""+e.getMessage());
        }
            return arregloCp;
    }
    
    public ArrayList getCp(ArrayList arregloCp,int colum){
        int size = arregloCp.size();
        Iterator<String> i = arregloCp.iterator();
        ArrayList<String> aux = new ArrayList<String>();
        for(int j = colum; j<size; j=j+7)
            aux.add((String) arregloCp.get(j));
        return aux;
     }
}
