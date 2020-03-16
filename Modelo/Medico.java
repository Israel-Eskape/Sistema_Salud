public class Medico{
    Persona persona;
    private String cedulaProfesional;
    private String puesto; //Enfermera o Medico
    private String especialidad;
    private String password;

    public Medico(Persona persona, String cedulaProfesional, String puesto, String especialidad, String password) {
        this.persona = persona;
        this.cedulaProfesional = cedulaProfesional;
        this.puesto = puesto;
        this.especialidad = especialidad;
        this.password = password;
    }

    public Medico() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

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
        return "Medico [persona=" + persona + ", cedulaProfesional=" + cedulaProfesional + ", especialidad=" + especialidad + ", password="
                + password + ", persona=" + persona + ", puesto=" + puesto + "]";
    }

    
}



//23508008