package net.sytes.codeline.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author dusannesic
 * Predstavlja mapirani entitet za tabelu TEMA iz baze podataka
 */
@Entity
@Table(name="TEMA")
public class Tema {

	private int temaId;
	private String nazivTeme;
	private String opisTeme;
	private Date datumKreiranja;
	private Predmet predmetId;
	
	public Tema(int temaId, String nazivTeme, String opisTeme, Date datumKreiranja, Predmet predmetId) {
		this.temaId = temaId;
		this.nazivTeme = nazivTeme;
		this.opisTeme = opisTeme;
		this.datumKreiranja = datumKreiranja;
		this.predmetId = predmetId;
	}

	@Id
	@GeneratedValue
	@Column(name="TEMA_ID")
	public int getTemaId() {
		return temaId;
	}

	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}

	@Column(name="NAZIV_TEME")
	public String getNazivTeme() {
		return nazivTeme;
	}

	public void setNazivTeme(String nazivTeme) {
		this.nazivTeme = nazivTeme;
	}

	@Column(name="OPIS_TEME")
	public String getOpisTeme() {
		return opisTeme;
	}

	public void setOpisTeme(String opisTeme) {
		this.opisTeme = opisTeme;
	}
	
	@Column(name="DATUM_KREIRANJA")
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	@JoinColumn(name="PREDMET_ID", referencedColumnName="PREDMET_ID")
	@ManyToOne
	public Predmet getPredmetId() {
		return predmetId;
	}

	public void setPredmetId(Predmet predmetId) {
		this.predmetId = predmetId;
	}

	@Override
	public String toString() {
		return "Tema [temaId=" + temaId + ", nazivTeme=" + nazivTeme + ", opisTeme=" + opisTeme + ", datumKreiranja="
				+ datumKreiranja + ", predmetId=" + predmetId + "]";
	}
	
}
