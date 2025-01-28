package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "puntoemissione")
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class PuntoEmissione {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idEmissione;

	@Column (name = "numerobiglietti")
	private int numeroBiglietti;

	@Column (name = "numeroabbonamenti")
	private int numeroAbbonamenti;

	@Column (name = "numeroemissioni")
	private int numeroEmissioni;

	public PuntoEmissione () {
	}

	public PuntoEmissione ( int numeroBiglietti, int numeroEmissioni, int numeroAbbonamenti) {
		this.numeroBiglietti = numeroBiglietti;
		this.numeroEmissioni = numeroEmissioni;
		this.numeroAbbonamenti = numeroAbbonamenti;
	}

	public int getIdEmissione () {
		return idEmissione;
	}

	public int getNumeroBiglietti () {
		return numeroBiglietti;
	}

	public int getNumeroEmissioni () {
		return numeroEmissioni;
	}

	public abstract String descrizione ();

	public enum StatoDistributore {
		IN_MANUTENZIONE,
		IN_SERVIZIO
	}
}


