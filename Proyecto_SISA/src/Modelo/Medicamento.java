package Modelo;

public class Medicamento{
    private String clave;
    private String nombreMedicamento;
    private String fechaRegistro;
    private String fechaVencimiento;
    private String Descripcion;

    public Medicamento(String clave, String nombreMedicamento, String fechaRegistro, String fechaVencimiento,
            String descripcion) {
        this.clave = clave;
        this.nombreMedicamento = nombreMedicamento;
        this.fechaRegistro = fechaRegistro;
        this.fechaVencimiento = fechaVencimiento;
        Descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Medicamento [Descripcion=" + Descripcion + ", clave=" + clave + ", fechaRegistro=" + fechaRegistro
                + ", fechaVencimiento=" + fechaVencimiento + ", nombreMedicamento=" + nombreMedicamento + "]";
    }

    

}