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
 * Klasa Materijal mapira tabelu MATERIJAL iz baze podataka
 * predstavlja entitet koji se koristi za predstavljanje materijala
 */
@Entity
@Table(name="MATERIJAL")
public class Materijal {

	private int materijalId;
	private String nazivMaterijala;
	private String opisMaterijala;
	private String link;
	private String video;
	private String audio;
	private Date datumKreiranja;
	private int brojPreporukaPozitivno;
	private int brojPreporukaNegativno;
	private int materijalFleg;
	private Tema temaId;
	private Korisnik korisnikId;
	
	@Id
	@GeneratedValue
	@Column(name="MATERIJAL_ID")
	public int getMaterijalId() {
		return materijalId;
	}
	public void setMaterijalId(int materijalId) {
		this.materijalId = materijalId;
	}
	
	@Column(name="NAZIV_MATERIJALA")
	public String getNazivMaterijala() {
		return nazivMaterijala;
	}
	public void setNazivMaterijala(String nazivMaterijala) {
		this.nazivMaterijala = nazivMaterijala;
	}
	
	@Column(name="OPIS_MATERIJALA")
	public String getOpisMaterijala() {
		return opisMaterijala;
	}
	public void setOpisMaterijala(String opisMaterijala) {
		this.opisMaterijala = opisMaterijala;
	}
	
	@Column(name="LINK")
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@Column(name="VIDEO")
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	
	@Column(name="AUDIO")
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	@Column(name="DATUM_KREIRANJA")
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	
	@Column(name="BROJ_PREPORUKA_POZITIVNO")
	public int getBrojPreporukaPozitivno() {
		return brojPreporukaPozitivno;
	}
	public void setBrojPreporukaPozitivno(int brojPreporukaPozitivno) {
		this.brojPreporukaPozitivno = brojPreporukaPozitivno;
	}
	
	@Column(name="BROJ_PREPORUKA_NEGATIVNO")
	public int getBrojPreporukaNegativno() {
		return brojPreporukaNegativno;
	}
	public void setBrojPreporukaNegativno(int brojPreporukaNegativno) {
		this.brojPreporukaNegativno = brojPreporukaNegativno;
	}
	
	@Column(name="MATERIJAL_FLAG")
	public int getMaterijalFleg() {
		return materijalFleg;
	}
	public void setMaterijalFleg(int materijalFleg) {
		this.materijalFleg = materijalFleg;
	}
	
	@JoinColumn(name="TEMA_ID", referencedColumnName="TEMA_ID")
	@ManyToOne
	public Tema getTemaId() {
		return temaId;
	}
	public void setTemaId(Tema temaId) {
		this.temaId = temaId;
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
		return "Materijal [materijalId=" + materijalId + ", nazivMaterijala=" + nazivMaterijala + ", opisMaterijala="
				+ opisMaterijala + ", link=" + link + ", video=" + video + ", audio=" + audio + ", datumKreiranja="
				+ datumKreiranja + ", brojPreporukaPozitivno=" + brojPreporukaPozitivno + ", brojPreporukaNegativno="
				+ brojPreporukaNegativno + ", materijalFleg=" + materijalFleg + ", temaId=" + temaId + ", korisnikId="
				+ korisnikId + "]";
	}

}
