package org.example.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Tessera {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idTessera;

	@OneToOne
	@JoinColumn (name = "idutente", nullable = false)
	private Utente utente;

	private LocalDate scadenza;
	private LocalDate dataEmissione;

	public Tessera () {
	}

	public Tessera (Utente utente) {
		this.scadenza = LocalDate.now().plusYears(1);
		this.dataEmissione = LocalDate.now();
		this.utente = utente;

	}

	public Long getIdTessera () {
		return idTessera;
	}

	public void setIdTessera (Long idTessera) {
		this.idTessera = idTessera;
	}

	public Utente getUtente () {
		return utente;
	}

	public void setUtente (Utente utente) {
		this.utente = utente;
	}

	public LocalDate getScadenza () {
		return scadenza;
	}

	public void setScadenza (LocalDate scadenza) {
		this.scadenza = scadenza;
	}

	public LocalDate getDataEmissione () {
		return dataEmissione;
	}

	public void setDataEmissione (LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	@Override
	public String toString () {
		return "tessera ID: " + idTessera + " | Intestatario: " + utente.getNome() + " " + utente.getCognome() + " | Validità: " + dataEmissione.toString() + " - " + scadenza.toString();
	}
}
