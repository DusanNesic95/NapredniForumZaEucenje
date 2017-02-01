package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Predmet;

/**
 * @author dusannesic
 * DAO sloj koji povezuje Predmet entitet sa bazom podataka
 * Metode koje obezbedjuje DAO sloj su osnovne CRUD operacije
 */
public interface PredmetDao {

	/**
	 * Dodaje predmet u bazu podataka prema prosledjenom objektu Predmet
	 * 
	 * @param predmet - objekat koji se prosledjuje
	 * @return - vraca true ukoliko je predmet uspesno dodat u bazu,
	 * vraca false ukoliko predmet vec postoji
	 */
	public boolean dodajPredmet(Predmet predmet);
	
	/**
	 * Metoda menja postojeci predmet u bazi podataka prema objektu Predmet
	 * koji je prosledjen
	 * 
	 * @param predmet - objekat iz kojeg se citaju atributi za izmenu
	 * @return - vraca true ukoliko predmet postoji i azuriranje je uspesno
	 * izvrseno, vraca false ukoliko predmet ne postoji
	 */
	public boolean izmeniPredmet(Predmet predmet);
	
	/**
	 * Brise predmet iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id predmeta koji se prosledjuje
	 * @return - vraca true ukoliko je predmet postojao u bazi, vraca false
	 * ukoliko predmet nije pronadjen
	 */
	public boolean obrisiPredmet(int id);
	
	/**
	 * @return - vraca listu svih predmeta iz baze podataka i smesta ih u
	 * java.util.List kolekciju
	 */
	public List<Predmet> ucitajSvePredmete();
	
	/**
	 * Vraca predmet iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id po kojem se baza pretrazuje
	 * @return - vraca objekat Predmet za pronadjeni predmet iz baze
	 * ukoliko isti postoji, vraca null ukoliko predmet ne postoji
	 */
	public Predmet ucitajPredmetPoId(int id);
	
}
