package org.example.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Biglietto")
public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDBiglietto;
    private int IDUtente;
    private int IDEmissione;
    private int IDMezzo;
    @Column(name = "DataEmissione")
    private LocalDate dataEmissione;
    @Column(name = "Scadenza")
    private LocalDate scadenza;
    @Column(name = "BoolVidimato")
    private boolean vidimato;

    public Biglietto(boolean vidimato, LocalDate scadenza, LocalDate dataEmissione, int IDMezzo, int IDEmissione) {
        this.vidimato = vidimato;
        this.scadenza = scadenza;
        this.dataEmissione = dataEmissione;
        this.IDMezzo = IDMezzo;
        this.IDEmissione = IDEmissione;
    }


    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public boolean isVidimato() {
        return vidimato;
    }

    public void setVidimato(boolean vidimato) {
        this.vidimato = vidimato;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public int getIDMezzo() {
        return IDMezzo;
    }

    public void setIDMezzo(int IDMezzo) {
        this.IDMezzo = IDMezzo;
    }

    public int getIDEmissione() {
        return IDEmissione;
    }

    public void setIDEmissione(int IDEmissione) {
        this.IDEmissione = IDEmissione;
    }

    public int getIDUtente() {
        return IDUtente;
    }

    public void setIDUtente(int IDUtente) {
        this.IDUtente = IDUtente;
    }

    public int getIDBiglietto() {
        return IDBiglietto;
    }

    public void setIDBiglietto(int IDBiglietto) {
        this.IDBiglietto = IDBiglietto;
    }
}
