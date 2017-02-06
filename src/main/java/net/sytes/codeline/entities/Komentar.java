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
 * Predstavlja mapirani entitet za tabelu KOMENTAR iz baze podataka
 */
@Entity
@Table(name="KOMENTAR")
public class Komentar {

	private int komentarId;
	private String sadrzaj;
	private Date datumKreiranja;
	private Materijal materijalId;
	private Korisnik korisnikId;
	
	@Id
	@GeneratedValue
	@Column(name="KOMENTAR_ID")
	public int getKomentarId() {
		return komentarId;
	}
	public void setKomentarId(int komentarId) {
		this.komentarId = komentarId;
	}
	
	@Column(name="SADRZAJ")
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	
	@Column(name="DATUM_KREIRANJA")
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	
	@JoinColumn(name="MATERIJAL_ID", referencedColumnName="MATERIJAL_ID")
	@ManyToOne
	public Materijal getMaterijalId() {
		return materijalId;
	}
	public void setMaterijalId(Materijal materijalId) {
		this.materijalId = materijalId;
	}
	
	@JoinColumn(name="KORISNIK_ID", referencedColumnName="KORISNIK_ID")
	@ManyToOne
	public Korisnik getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(Korisnik korisnikId) {
		this.korisnikId = korisnikId;
	}
	
	@Override
	public String toString() {
		return "Komentar [komentarId=" + komentarId + ", sadrzaj=" + sadrzaj + ", datumKreiranja=" + datumKreiranja
				+ ", materijalId=" + materijalId + ", korisnikId=" + korisnikId + "]";
	}
	
}
