package org.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table (name = "rivenditore")
public class Rivenditore extends PuntoEmissione {

	@Column (name = "orario_apertura")
	private LocalTime orarioApertura;

	@Column (name = "orario_chiusura")
	private LocalTime orarioChiusura;

	public Rivenditore () {
	}

	public Rivenditore (int idEmissione, int numeroBiglietti, int numeroEmissioni, LocalTime orarioApertura, LocalTime orarioChiusura) {
		super(idEmissione, numeroBiglietti, numeroEmissioni);
		this.orarioApertura = orarioApertura;
		this.orarioChiusura = orarioChiusura;
	}

	public LocalTime getOrarioApertura () {
		return orarioApertura;
	}

	public void setOrarioApertura (LocalTime orarioApertura) {
		this.orarioApertura = orarioApertura;
	}

	public LocalTime getOrarioChiusura () {
		return orarioChiusura;
	}

	public void setOrarioChiusura (LocalTime orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}

	@Override
	public String descrizione () {
		return String.format("org.example.Entity.Rivenditore [ID : %d] - Orario: %s - %s, Biglietti disponibili: %d, Numero emissioni: %d",
			getIdEmissione(), getOrarioApertura(), getOrarioChiusura(), getNumeroBiglietti(), getNumeroEmissioni());
	}
}
