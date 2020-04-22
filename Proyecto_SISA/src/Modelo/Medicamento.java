package Modelo;

public class Medicamento{
    private String codigo;
    private String nombreMedicamento;
    private String fechaRegistro;
    private String fechaVencimiento;
    private int existencia;
    private String Descripcion;

    public Medicamento(String codigo, String nombreMedicamento, String fechaRegistro, String fechaVencimiento,
            int existencia, String descripcion) {
        this.codigo = codigo;
        this.nombreMedicamento = nombreMedicamento;
        this.fechaRegistro = fechaRegistro;
        this.fechaVencimiento = fechaVencimiento;
        this.existencia = existencia;
        Descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Medicamento [Descripcion=" + Descripcion + ", codigo=" + codigo + ", existencia=" + existencia
                + ", fechaRegistro=" + fechaRegistro + ", fechaVencimiento=" + fechaVencimiento + ", nombreMedicamento="
                + nombreMedicamento + "]";
    }

    

}