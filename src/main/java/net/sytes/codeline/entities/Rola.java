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
 * Predstavlja mapirani entitet za tabelu ROLA iz baze podataka
 */
@Entity
@Table(name="ROLA")
public class Rola {

	private int rolaId;
	private String nazivRole;
	private Date datumKreiranja;
	private Korisnik korisnikId;

	@Id
	@GeneratedValue
	@Column(name="ROLA_ID")
	public int getRolaId() {
		return rolaId;
	}

	public void setRolaId(int rolaId) {
		this.rolaId = rolaId;
	}

	@Column(name="NAZIV_ROLE")
	public String getNazivRole() {
		return nazivRole;
	}

	public void setNazivRole(String nazivRole) {
		this.nazivRole = nazivRole;
	}

	@Column(name="DATUM_KREIRANJA")
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	@JoinColumn(name = "KORISNIK_ID", referencedColumnName = "KORISNIK_ID")
    @ManyToOne
	public Korisnik getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Korisnik korisnikId) {
		this.korisnikId = korisnikId;
	}

	@Override
	public String toString() {
		return "Rola [rolaId=" + rolaId + ", nazivRole=" + nazivRole + ", datumKreiranja=" + datumKreiranja
				+ ", korisnikId=" + korisnikId + "]";
	}
	
}
