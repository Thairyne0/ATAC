package org.example.Entity;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = "Tratta")
public class Tratta {
    @Id
    @GeneratedValue
    private Long IDTratta;

    private String ZonaDiPartenza;
    private String Capolinea;
    private LocalTime TempoPrevisto;
    private int NumeroDiViete;
    private LocalTime TempoEffettivo;
    private LocalTime TempoMedio;

    public Long getIDTratta() {
        return IDTratta;
    }

    public String getZonaDiPartenza() {
        return ZonaDiPartenza;
    }

    public void setZonaDiPartenza(String zonaDiPartenza) {
        ZonaDiPartenza = zonaDiPartenza;
    }

    public String getCapolinea() {
        return Capolinea;
    }

    public void setCapolinea(String capolinea) {
        Capolinea = capolinea;
    }

    public LocalTime getTempoPrevisto() {
        return TempoPrevisto;
    }

    public void setTempoPrevisto(LocalTime tempoPrevisto) {
        TempoPrevisto = tempoPrevisto;
    }

    public int getNumeroDiViete() {
        return NumeroDiViete;
    }

    public void setNumeroDiViete(int numeroDiViete) {
        NumeroDiViete = numeroDiViete;
    }

    public LocalTime getTempoEffettivo() {
        return TempoEffettivo;
    }

    public void setTempoEffettivo(LocalTime tempoEffettivo) {
        TempoEffettivo = tempoEffettivo;
    }

    public LocalTime getTempoMedio() {
        return TempoMedio;
    }

    public void setTempoMedio(LocalTime tempoMedio) {
        TempoMedio = tempoMedio;
    }

    public String stampaNome (){
        return ("Tratta: " + getCapolinea());
    }

}