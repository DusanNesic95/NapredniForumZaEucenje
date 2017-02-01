package net.sytes.codeline.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dusannesic
 * Klasa Korisnik mapira tabelu KORISNIK iz baze podataka
 * predstavlja entitet koji se koristi za predstavljanje korisnika
 */
@Entity
@Table(name="KORISNIK")
public class Korisnik {

	private int korisnikId;
	private String korisnickoIme;
	private String lozinka;
	private String adresa;
	private String brojTelefona;
	private Date datumKreiranja;

	@Id
	@GeneratedValue
	@Column(name="KORISNIK_ID")
	public int getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(int korisnikId) {
		this.korisnikId = korisnikId;
	}
	
	@Column(name="KORISNICKO_IME")
	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	@Column(name="LOZINKA")
	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Column(name="ADRESA")
	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@Column(name="BROJ_TELEFONA")
	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
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
		return "Korisnik [korisnikId=" + korisnikId + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka
				+ ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", datumKreiranja=" + datumKreiranja + "]";
	}
	
}
