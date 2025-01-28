package org.example.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Tessera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTessera;

    @OneToOne
    @JoinColumn(name = "idutente", nullable = false)
    private Utente utente;

    private LocalDate scadenza;
    private LocalDate dataEmissione;

    public Tessera(LocalDate scadenza, LocalDate dataEmissione, Utente utente, Long idTessera) {
        this.scadenza = scadenza;
        this.dataEmissione = dataEmissione;
        this.utente = utente;
        this.idTessera = idTessera;
    }

    public Long getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(Long idTessera) {
        this.idTessera = idTessera;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }
}
