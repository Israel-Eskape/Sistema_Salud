package Modelo;

public class ClasePrueba{
    public static void main(String [] args){
        Medico medico = new Medico("José", "Aquino", "20-03-2010", "AEMG940411HOCVRS07", "Hombre", "ORH+", "calle Nopalera", "San Antonio de la Cal ", "Oaxaca", 71,"Oaxaca", "isra.ixoye@gmail.com", "9513328988", "INGSC", "Médico", "Director","nada", "abcd");
        System.out.println(medico.toString());
    }
}