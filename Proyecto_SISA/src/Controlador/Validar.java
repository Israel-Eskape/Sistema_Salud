package Controlador;

import java.util.Date;

public class Validar {
    private String patternCurp = "^([A-Z&]|[a-z&]{1})([AEIOU]|[aeiou]{1})([A-Z&]|[a-z&]{1})([A-Z&]|[a-z&]{1})([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])([HM]|[hm]{1})([AS|as|BC|bc|BS|bs|CC|cc|CS|cs|CH|ch|CL|cl|CM|cm|DF|df|DG|dg|GT|gt|GR|gr|HG|hg|JC|jc|MC|mc|MN|mn|MS|ms|NT|nt|NL|nl|OC|oc|PL|pl|QT|qt|QR|qr|SP|sp|SL|sl|SR|sr|TC|tc|TS|ts|TL|tl|VZ|vz|YN|yn|ZS|zs|NE|ne]{2})([^A|a|E|e|I|i|O|o|U|u]{1})([^A|a|E|e|I|i|O|o|U|u]{1})([^A|a|E|e|I|i|O|o|U|u]{1})([0-9]{2})$";

    public boolean validaCurp(String curp) {

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
        for (var i = 0; i < 17; i++)
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
        return (new java.sql.Date(jDateBirth.getTime()));
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
}
