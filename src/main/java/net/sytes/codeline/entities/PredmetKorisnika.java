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
 * Predstavlja mapirani entitet za tabelu PREDMET_KORISNIKA iz baze podataka
 */
@Entity
@Table(name="PREDMET_KORISNIKA")
public class PredmetKorisnika {

	private int predmetKorisnikaId;
	private Korisnik korisnikId;
	private Predmet predmetId;
	private Date datumKreiranja;
	
	@Id
	@GeneratedValue
	@Column(name="PREDMET_KORISNIKA_ID")
	public int getPredmetKorisnikaId() {
		return predmetKorisnikaId;
	}

	public void setPredmetKorisnikaId(int predmetKorisnikaId) {
		this.predmetKorisnikaId = predmetKorisnikaId;
	}

	@JoinColumn(name="KORISNIK_ID", referencedColumnName="KORISNIK_ID")
	@ManyToOne
	public Korisnik getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Korisnik korisnikId) {
		this.korisnikId = korisnikId;
	}

	@JoinColumn(name="PREDMET_ID", referencedColumnName="PREDMET_ID")
	@ManyToOne
	public Predmet getPredmetId() {
		return predmetId;
	}

	public void setPredmetId(Predmet predmetId) {
		this.predmetId = predmetId;
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
		return "PredmetKorisnika [predmetKorisnikaId=" + predmetKorisnikaId + ", korisnikId=" + korisnikId
				+ ", predmetId=" + predmetId + ", datumKreiranja=" + datumKreiranja + "]";
	}

}
