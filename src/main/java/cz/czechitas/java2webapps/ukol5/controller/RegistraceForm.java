package cz.czechitas.java2webapps.ukol5.controller;
import cz.czechitas.java2webapps.ukol5.controller.Pohlavi;
import cz.czechitas.java2webapps.ukol5.controller.Sport;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.EnumSet;


public class RegistraceForm {
    private String telefon;
    @NotBlank
    private String jmeno;
    @NotBlank
    private String prijmeni;
    @NotBlank
    private String datum;
    @NotNull
    private Pohlavi pohlavi;
    @Email
    private String email;
    @NotBlank
    private String turnus;
    @NotNull
    private EnumSet<Sport> sporty;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Pohlavi getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(Pohlavi pohlavi) {
        this.pohlavi = pohlavi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTurnus() {
        return turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public EnumSet<Sport> getSporty() {
        return sporty;
    }

    public void setSporty(EnumSet<Sport> sporty) {
        this.sporty = sporty;
    }
}
