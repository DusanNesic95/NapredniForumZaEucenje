package net.sytes.codeline.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dusannesic
 * Predstavlja mapirani entitet za tabelu PREDMET iz baze podataka
 */
@Entity
@Table(name="PREDMET")
public class Predmet {

	private int predmetId;
	private String nazivPredmeta;
	private String opisPredmeta;
	private String skolskaGodina;
	private Date datumKreiranja;

	@Id
	@GeneratedValue
	@Column(name="PREDMET_ID")
	public int getPredmetId() {
		return predmetId;
	}

	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}

	@Column(name="NAZIV_PREDMETA")
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	@Column(name="OPIS_PREDMETA")
	public String getOpisPredmeta() {
		return opisPredmeta;
	}

	public void setOpisPredmeta(String opisPredmeta) {
		this.opisPredmeta = opisPredmeta;
	}

	@Column(name="SKOLSKA_GODINA")
	public String getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(String skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	@Column(name="DATUM_KREIRANJA")
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	@Override
	public String toString() {
		return "Predmet [predmetId=" + predmetId + ", nazivPredmeta=" + nazivPredmeta + ", opisPredmeta=" + opisPredmeta
				+ ", skolskaGodina=" + skolskaGodina + ", datumKreiranja=" + datumKreiranja + "]";
	}
	
}
