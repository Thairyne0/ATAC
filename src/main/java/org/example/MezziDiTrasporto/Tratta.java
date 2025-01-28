package org.example.MezziDiTrasporto;

import jakarta.persistence.*;

import java.time.Duration;

@Entity
@Table (name = "Tratta")
public class Tratta {
    @Id
    @GeneratedValue
    private Long IDTratta;

    private String ZonaDiPartenza;
    private String Capolinea;
    private Duration TempoPrevisto;
    private int NumeroDiViete;
    private Duration TempoEffettivo;
    private Duration TempoMedio;

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

    public Duration getTempoPrevisto() {
        return TempoPrevisto;
    }

    public void setTempoPrevisto(Duration tempoPrevisto) {
        TempoPrevisto = tempoPrevisto;
    }

    public int getNumeroDiViete() {
        return NumeroDiViete;
    }

    public void setNumeroDiViete(int numeroDiViete) {
        NumeroDiViete = numeroDiViete;
    }

    public Duration getTempoEffettivo() {
        return TempoEffettivo;
    }

    public void setTempoEffettivo(Duration tempoEffettivo) {
        TempoEffettivo = tempoEffettivo;
    }

    public Duration getTempoMedio() {
        return TempoMedio;
    }

    public void setTempoMedio(Duration tempoMedio) {
        TempoMedio = tempoMedio;
    }
}
