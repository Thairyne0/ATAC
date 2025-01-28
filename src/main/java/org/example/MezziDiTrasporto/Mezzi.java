package org.example.MezziDiTrasporto;

import jakarta.persistence.*;

@Entity
@Table (name = "Mezzi")
public class Mezzi {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long IDMezzo;

    private int IdTratta;
    private String TipoMezzo;
    private String Capienza;

    public Mezzi (){}

    public int getIdTratta() {
        return IdTratta;
    }

    public void setIdTratta(int idTratta) {
        IdTratta = idTratta;
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
}
