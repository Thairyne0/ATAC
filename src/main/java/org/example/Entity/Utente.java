package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utente {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idUtente;
	private String nome;
	private String cognome;
	private boolean boolTessera;

	public Utente () {
	}

	public Utente (String nome, String cognome, boolean boolTessera) {
		this.nome = nome;
		this.cognome = cognome;
		this.boolTessera = boolTessera;
	}

	public boolean isBoolTessera () {
		return boolTessera;
	}

	public void setBoolTessera (boolean boolTessera) {
		this.boolTessera = boolTessera;
	}

	public String getCognome () {
		return cognome;
	}

	public void setCognome (String cognome) {
		this.cognome = cognome;
	}

	public String getNome () {
		return nome;
	}

	public void setNome (String nome) {
		this.nome = nome;
	}

	public Long getIdUtente () {
		return idUtente;
	}

	public void setIdUtente (Long idUtente) {
		this.idUtente = idUtente;
	}

	@Override
	public String toString () {
		return ("Nome: " + nome + "Cognome: " + cognome + (boolTessera ? "tesserato" : "non tesserato"));
	}
}
