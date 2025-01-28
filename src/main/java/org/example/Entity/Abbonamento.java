package org.example.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abbonamento")
public class Abbonamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAb;

    @ManyToOne
    @JoinColumn(name = "idUtente", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "idTessera", nullable = false)
    private Tessera tessera;

    @ManyToOne
    @JoinColumn(name = "idEmissione", nullable = false)
    private PuntoEmissione puntoEmissione;

    @Column(nullable = false)
    private LocalDate scadenza;

    @Column(nullable = false)
    private LocalDate dataEmissione;

    @Column(nullable = false)
    private String tipoAbbonamento;

    // 🔹 Costruttore Vuoto (Obbligatorio per JPA)
    public Abbonamento() {}

    // 🔹 Costruttore con parametri
    public Abbonamento(LocalDate scadenza, LocalDate dataEmissione, String tipoAbbonamento,
                       Utente utente, Tessera tessera, PuntoEmissione puntoEmissione) {
        this.scadenza = scadenza;
        this.dataEmissione = dataEmissione;
        this.tipoAbbonamento = tipoAbbonamento;
        this.utente = utente;
        this.tessera = tessera;
        this.puntoEmissione = puntoEmissione;
    }

    // 🔹 Getter e Setter

    public Long getIdAb() {
        return idAb;
    }

    public void setIdAb(Long idAb) {
        this.idAb = idAb;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public PuntoEmissione getPuntoEmissione() {
        return puntoEmissione;
    }

    public void setPuntoEmissione(PuntoEmissione puntoEmissione) {
        this.puntoEmissione = puntoEmissione;
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

    public String getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(String tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    // 🔹 Metodo toString() (facoltativo ma utile per il debug)
    @Override
    public String toString() {
        return "Abbonamento{" +
                "idAb=" + idAb +
                ", utente=" + utente +
                ", tessera=" + tessera +
                ", puntoEmissione=" + puntoEmissione +
                ", scadenza=" + scadenza +
                ", dataEmissione=" + dataEmissione +
                ", tipoAbbonamento='" + tipoAbbonamento + '\'' +
                '}';
    }
}
