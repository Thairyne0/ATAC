import java.time.LocalTime;

public class Rivenditore extends PuntoEmissione {
	private LocalTime orarioApertura;
	private LocalTime orarioChiusura;

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
		return String.format("Rivenditore [ID : %d] - Orario: %s - %s, Biglietti disponibili: %d, Numero emissioni: %d",
			getIdEmissione(), getOrarioApertura(), getOrarioChiusura(), getNumeroBiglietti(), getNumeroEmissioni());
	}
}
