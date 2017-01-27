package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Korisnik;

/**
 * @author dusannesic
 * DAO sloj koji povezuje Korisnik entitet sa bazom podataka
 * Metode koje obezbedjuje DAO sloj su osnovne CRUD operacije
 */
public interface KorisnikDao {

	/**
	 * Dodaje korisnika u bazu podataka prema prosledjenom objektu Korisnik
	 * 
	 * @param korisnik - objekat koji se prosledjuje
	 * @return - vraca true ukoliko korisnik nije vec registrovan
	 * u suprotnom vraca false
	 */
	public boolean dodajKorisnika(Korisnik korisnik);
	
	/**
	 * Metoda menja postojeceg korisnika u bazi podataka prema objektu Korisnik
	 * koji je prosledjen
	 * 
	 * @param korisnik - objekat iz kojeg se citaju atributi za izmenu
	 * @return - vraca true ukoliko korisnik postoji i azuriranje je uspesno
	 * izvrseno, vraca false ukoliko korisnik ne postoji
	 */
	public boolean izmeniKorisnika(Korisnik korisnik);
	
	/**
	 * Brise korisnika iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id korisnika koje se prosledjuje
	 * @return - vraca true ukoliko je korisnik postojao u bazi, vraca false
	 * ukoliko korisnik nije pronadjen
	 */
	public boolean obrisiKorisnika(int id);
	
	/**
	 * @return - vraca listu svih korisnika iz baze podataka i smesta ih u
	 * java.util.List kolekciju
	 */
	public List<Korisnik> ucitajSveKorisnike();
	
	/**
	 * Vraca korisnika iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id po kojem se baza pretrazuje
	 * @return - vraca objekat Korisnik za pronadjenog korisnika iz baze
	 * ukoliko isti postoji, vraca null ukoliko korisnik ne postoji
	 */
	public Korisnik ucitajKorsinikaPoId(int id);
	
}
