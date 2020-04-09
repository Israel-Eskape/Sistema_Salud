package Modelo;

public class Persona{
    private String name;
    private String surname;
    private String dateBirth;
    private String curp;
    private String sexo;
    private String bloodType;
    private String address;//Street,number and colony.
    private String municipality;
    private String state;
    private int cp;
    private String city;
    private String email;
    private String phone;
    
    public Persona(String name, String surname, String dateBirth, String curp, String sexo, String bloodType,
    String address, String municipality, String state, int cp, String city, String email, String phone) {
this.name = name;
this.surname = surname;
this.dateBirth = dateBirth;
this.curp = curp;
this.sexo = sexo;
this.bloodType = bloodType;
this.address = address;
this.municipality = municipality;
this.state = state;
this.cp = cp;
this.city = city;
this.email = email;
this.phone = phone;
}

    public Persona() {
    }

    public Persona(String name2, String surname2, String dateBirth2, String curp2, String sexo2, String bloodType2,
			String address2, String municipality2, String state2, int cp2, String city2, String email2, String phone2,
			String ocupacion, String alergias, String probSalud, String responsable) {
	}

	public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(final String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(final String curp) {
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

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(final String municipality) {
        this.municipality = municipality;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(final int cp) {
        this.cp = cp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Persona [address=" + address + ", bloodType=" + bloodType + ", city=" + city + ", cp=" + cp + ", curp="
                + curp + ", dateBirth=" + dateBirth + ", email=" + email + ", municipality=" + municipality + ", name="
                + name + ", phone=" + phone + ", sexo=" + sexo + ", state=" + state + ", surname=" + surname + "]";
    }

    
   



}