package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "distributoreautomatico")
public class DistributoreAutomatico extends PuntoEmissione {

	@Enumerated (EnumType.STRING)
	@Column (name = "stato_distributore")
	private PuntoEmissione.StatoDistributore stato;

	@Column (name = "nomedistributore")
	private String nome;

	public DistributoreAutomatico () {
	}

	public DistributoreAutomatico ( int numeroBiglietti, int numeroEmissioni, PuntoEmissione.StatoDistributore stato, int numeroAbbonameti) {
		super(numeroBiglietti, numeroEmissioni, numeroAbbonameti);
		this.stato = stato;
	}

	public PuntoEmissione.StatoDistributore getStato () {
		return stato;
	}

	public void setStato (PuntoEmissione.StatoDistributore stato) {
		this.stato = stato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String descrizione () {
		return String.format("Distributore Automatico [ID: %d] - Stato: %s, Biglietti Disponibili: %d , Numero Emissioni: %d",
			getIdEmissione(), stato, getNumeroBiglietti(), getNumeroEmissioni());
	}

	public String stampaNome (){
		return ("Distributore: " + getNome());
	}
}
