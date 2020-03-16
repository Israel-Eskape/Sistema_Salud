public class Paciente{
    Persona persona = new Persona();
    private String ocupacion;
    private String alergias;
    private String probSalud;
    private String responsable;

    public Paciente(Persona persona, String ocupacion, String alergias, String probSalud, String responsable) {
        this.persona = persona;
        this.ocupacion = ocupacion;
        this.alergias = alergias;
        this.probSalud = probSalud;
        this.responsable = responsable;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getProbSalud() {
        return probSalud;
    }

    public void setProbSalud(String probSalud) {
        this.probSalud = probSalud;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Paciente [persona=" + persona + ", alergias=" + alergias + ", ocupacion=" + ocupacion + ",  probSalud="
                + probSalud + ", responsable=" + responsable + "]";
    }
    
}