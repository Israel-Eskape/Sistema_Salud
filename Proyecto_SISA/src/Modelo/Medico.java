package Modelo;

import java.sql.Date;

public class Medico extends Persona{

    private String cedulaProfesional;
    private String puesto;//Jefa de Medico,Director o empleado
    private String especialidad;
    private String password;

    

    public Medico(String name, String surname, Date dateBirth, String curp, String sexo, String bloodType,
    String address, String municipality, String state, String nacionality,int cp, String email, String phone,String cedulaProfesional, String tipo,String puesto, String especialidad, String password) {
        
        super(name,surname,dateBirth,curp,sexo,bloodType,address,municipality,state,nacionality,cp,email,phone);
        this.cedulaProfesional = cedulaProfesional;
        this.puesto = puesto;
        this.especialidad = especialidad;
        this.password = password;
    }

    public Medico() {}

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }
   
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Medico [Nombre = "+ getName()+ "Apellidos = "+getSurname()
        +", Fecha de Nacimiento = "+getDateBirth() + ", Curp ="+getCurp()+" , Sexo = "+getSexo()
        +" , Tipo de Sangre = "+ getBloodType()+ " , Dirección = "+ getAddress()+" , Municipio = "+ getMunicipality()
        + " , Estado = "+getState()+" , Nacionalidad = "+getColonia() +" , CP = "+getCp()+" , Email = "+ getEmail()
        +" , Celular = "+getPhone()+ ", cedulaProfesional=" + cedulaProfesional +", especialidad=" + especialidad 
        + ", password="+password;
        
    }
}