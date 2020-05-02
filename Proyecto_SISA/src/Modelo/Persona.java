package Modelo;

import java.sql.Date;

public class Persona {

    private String name;
    private String surname;
    private Date dateBirth;
    private String curp;
    private String sexo;
    private String bloodType;
    private String address;//Street,number and colony.
    private String municipality;
    private String state;
    private String nacionality;
    private int cp;
    private String email;
    private String phone;

    public Persona(String name, String surname, Date dateBirth, String curp, String sexo, String bloodType,
            String address, String municipality, String state,String nacionality, int cp, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.curp = curp;
        this.sexo = sexo;
        this.bloodType = bloodType;
        this.address = address;
        this.municipality = municipality;
        this.state = state;
        this.nacionality = nacionality;
        this.cp = cp;
        this.email = email;
        this.phone = phone;
    }

    public Persona() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        System.err.println("PerDate"+dateBirth);
        this.dateBirth = dateBirth;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getNacionality(){
        return nacionality;
    }
    public void setNacionality(String nacionality){
        this.nacionality = nacionality;
    }
    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Persona [address=" + address + ", bloodType=" + bloodType + ", cp=" + cp + ", curp=" + curp
                + ", dateBirth=" + dateBirth + ", email=" + email + ", municipality=" + municipality + ", nacionality="
                + nacionality + ", name=" + name + ", phone=" + phone + ", sexo=" + sexo + ", state=" + state
                + ", surname=" + surname + "]";
    }



}
