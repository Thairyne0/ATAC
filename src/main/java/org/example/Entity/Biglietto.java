package org.example.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Biglietto")
public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDBiglietto;
    @ManyToOne
    @JoinColumn(name = "IDUtente")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "IDEmissione")
    private PuntoEmissione puntoEmissione;
    @ManyToOne
    @JoinColumn(name = "IDMezzo")
    private Mezzi mezzoDiTrasporto;
    @Column(name = "DataEmissione")
    private LocalDate dataEmissione;
    @Column(name = "BoolVidimato")
    private boolean vidimato;


     public Biglietto(){}

    public Biglietto(boolean vidimato,LocalDate dataEmissione, Mezzi mezzoDiTrasporto, PuntoEmissione puntoEmissione, Utente utente) {
        this.vidimato = vidimato;
        this.dataEmissione = dataEmissione;
        this.mezzoDiTrasporto = mezzoDiTrasporto;
        this.puntoEmissione = puntoEmissione;
        this.utente = utente;
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

    public PuntoEmissione getPuntoEmissione() {
        return puntoEmissione;
    }

    public void setPuntoEmissione(PuntoEmissione puntoEmissione) {
        this.puntoEmissione = puntoEmissione;
    }

    public Mezzi getMezzoDiTrasporto() {
        return mezzoDiTrasporto;
    }

    public void setMezzoDiTrasporto(Mezzi mezzoDiTrasporto) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public int getIDBiglietto() {
        return IDBiglietto;
    }

    public void setIDBiglietto(int IDBiglietto) {
        this.IDBiglietto = IDBiglietto;
    }
}
