package org.example.Entity;

abstract class PuntoEmissione {

	private int idEmissione;
	private int numeroBiglietti;
	private int numeroEmissioni;

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


