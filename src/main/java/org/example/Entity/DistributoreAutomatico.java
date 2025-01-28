package org.example.Entity;

import jakarta.persistence.Entity;

@Entity
public class DistributoreAutomatico extends PuntoEmissione {
	private PuntoEmissione.StatoDistributore stato;

	public DistributoreAutomatico (int idEmissione, int numeroBiglietti, int numeroEmissioni, PuntoEmissione.StatoDistributore stato) {
		super(idEmissione, numeroBiglietti, numeroEmissioni);
		this.stato = stato;
	}

	public PuntoEmissione.StatoDistributore getStato () {
		return stato;
	}

	public void setStato (PuntoEmissione.StatoDistributore stato) {
		this.stato = stato;
	}

	@Override
	public String descrizione () {
		return String.format("Distributore Automatico [ID: %d] - Stato: %s, Biglietti Disponibili: %d , Numero Emissioni: %d",
			getIdEmissione(), stato, getNumeroBiglietti(), getNumeroEmissioni());
	}
}
