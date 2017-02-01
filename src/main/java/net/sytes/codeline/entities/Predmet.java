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
	private Date skolskaGodina;
	private Date datumKreiranja;
	
	public Predmet(int predmetId, String nazivPredmeta, String opisPredmeta, Date skolskaGodina, Date datumKreiranja) {
		this.predmetId = predmetId;
		this.nazivPredmeta = nazivPredmeta;
		this.opisPredmeta = opisPredmeta;
		this.skolskaGodina = skolskaGodina;
		this.datumKreiranja = datumKreiranja;
	}

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
	public Date getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(Date skolskaGodina) {
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
