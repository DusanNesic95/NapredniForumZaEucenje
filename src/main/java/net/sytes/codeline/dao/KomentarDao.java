package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Komentar;
import net.sytes.codeline.entities.Materijal;

/**
 * @author dusannesic
 * DAO sloj koji povezuje Komentar entitet sa bazom podataka
 * Metode koje obezbedjuje DAO sloj su osnovne CRUD operacije
 */
public interface KomentarDao {

	/**
	 * Dodaje komentar u bazu podataka prema prosledjenom objektu Komentar
	 * 
	 * @param komentar - objekat koji se prosledjuje
	 * @return - vraca true ukoliko je komentar uspesno dodat u bazu,
	 * vraca false ukoliko dodavanje nije moguce
	 */
	public boolean dodajKomentar(Komentar komentar);
	
	/**
	 * Metoda menja postojeci komentar u bazi podataka prema objektu Komentar
	 * koji je prosledjen
	 * 
	 * @param komentar - objekat iz kojeg se citaju atributi za izmenu
	 * @return - vraca true ukoliko komentar postoji i azuriranje je uspesno
	 * izvrseno, vraca false ukoliko komentar ne postoji
	 */
	public boolean izmeniKomentar(Komentar komentar);
	
	/**
	 * Brise komentar iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id komentara koji se prosledjuje
	 * @return - vraca true ukoliko je komentar postojao u bazi, vraca false
	 * ukoliko komentar nije pronadjen
	 */
	public boolean obrisiKomentar(int id);
	
	/**
	 * @return - vraca listu svih komentara iz baze podataka i smesta ih u
	 * java.util.List kolekciju
	 */
	public List<Komentar> ucitajSveKomentare();
	
	/**
	 * Vraca komentar iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id po kojem se baza pretrazuje
	 * @return - vraca objekat Komentar za pronadjeni komentar iz baze
	 * ukoliko isti postoji, vraca null ukoliko komentar ne postoji
	 */
	public Komentar ucitajKomentarPoId(int id);
	
	/**
	 * Ucitava sve komentare iz baze koji su vezani za odredjeni materijal
	 * koji se prosledjuje
	 * 
	 * @param materijal - materijal za kojeg se vrsi pretraga
	 * @return - vraca listu komentara ukoliko za kriterijum pretrage postoje
	 * komentari, vraca praznu listu ukoliko ne isti ne postoje
	 */
	public List<Komentar> ucitajKomentarePoMaterijalu(Materijal materijal);
	
}
