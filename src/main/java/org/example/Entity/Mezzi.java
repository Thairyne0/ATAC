package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Mezzi")
public class Mezzi {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long IDMezzo;
    @ManyToOne
    @JoinColumn(name ="IDTratta" )
    private Tratta tratta;
    private String TipoMezzo;
    private String Capienza;

    public Mezzi (){}

    public void setIDMezzo(Long IDMezzo) {
        this.IDMezzo = IDMezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public String getTipoMezzo() {
        return TipoMezzo;
    }

    public void setTipoMezzo(String tipoMezzo) {
        TipoMezzo = tipoMezzo;
    }

    public String getCapienza() {
        return Capienza;
    }

    public void setCapienza(String capienza) {
        Capienza = capienza;
    }

    public Long getIDMezzo() {
        return IDMezzo;
    }


    public String stampaMezzo (){
            return ("Mezzo: " + getTipoMezzo() + " " + getIDMezzo());
    }
}