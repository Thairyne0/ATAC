package org.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table (name = "rivenditore")
public class Rivenditore extends PuntoEmissione {

	@Column (name = "nomerivenditore")
	private String nomeRivenditore;

	@Column (name = "orarioapertura")
	private String orarioApertura;

	@Column (name = "orariochiusura")
	private String orarioChiusura;

	public Rivenditore () {
	}

	public Rivenditore (String nomeRivenditore, int numeroBiglietti, int numeroEmissioni, String orarioApertura, String orarioChiusura, int numeroAbbonamenti) {
		super( numeroBiglietti, numeroEmissioni, numeroAbbonamenti);
		this.nomeRivenditore = nomeRivenditore;
		this.orarioApertura = orarioApertura;
		this.orarioChiusura = orarioChiusura;
	}

	public String getOrarioApertura () {
		return orarioApertura;
	}

	public void setOrarioApertura (String orarioApertura) {
		this.orarioApertura = orarioApertura;
	}

	public String getOrarioChiusura () {
		return orarioChiusura;
	}

	public void setOrarioChiusura (String orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}

	@Override
	public String descrizione () {
		return String.format("Rivenditore [ID : %d] - Orario: %s - %s, Biglietti disponibili: %d, Numero emissioni: %d",
			getIdEmissione(), getOrarioApertura(), getOrarioChiusura(), getNumeroBiglietti(), getNumeroEmissioni());
	}


}
