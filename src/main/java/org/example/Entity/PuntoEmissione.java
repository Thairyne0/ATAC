package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "puntoemissione")
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PuntoEmissione {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idEmissione;

	@Column (name = "numero_biglietti")
	private int numeroBiglietti;

	@Column (name = "numero_emissioni")
	private int numeroEmissioni;

	public PuntoEmissione () {
	}

	public PuntoEmissione (int idEmissione, int numeroBiglietti, int numeroEmissioni) {
		this.idEmissione = idEmissione;
		this.numeroBiglietti = numeroBiglietti;
		this.numeroEmissioni = numeroEmissioni;
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


