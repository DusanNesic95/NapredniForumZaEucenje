package net.sytes.codeline.dao;

import net.sytes.codeline.entities.Korisnik;
import net.sytes.codeline.entities.Rola;

/**
 * @author dusannesic
 * DAO sloj koji povezuje Rola entitet sa bazom podataka
 * Metode koje obezbedjuje DAO sloj su osnovne CRUD operacije
 */
public interface RolaDao {

	/**
	 * Dodaje rolu u bazu podataka prema prosledjenom objektu Rola
	 * 
	 * @param rola - objekat koji se prosledjuje
	 * @return - vraca true ukoliko rola nije vec dotata korisniku
	 * u suprotnom vraca false
	 */
	public boolean dodajRolu(Rola rola);
	
	/**
	 * Metoda menja postojecu rolu u bazi podataka prema objektu Rola
	 * koji je prosledjen
	 * 
	 * @param rola - objekat iz kojeg se citaju atributi za izmenu
	 * @return - vraca true ukoliko rola postoji i azuriranje je uspesno
	 * izvrseno, vraca false ukoliko rola ne postoji
	 */
	public boolean izmeniRolu(Rola rola);
	
	/**
	 * Brise role iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id role koje se prosledjuje
	 * @return - vraca true ukoliko je rola postojala u bazi, vraca false
	 * ukoliko rola nije pronadjena
	 */
	public boolean obrisiRolu(int id);
	
	/**
	 * Vraca rolu iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id po kojem se baza pretrazuje
	 * @return - vraca objekat Rola za pronadjenu rolu iz baze
	 * ukoliko ista postoji, vraca null ukoliko rola ne postoji
	 */
	public Rola ucitajRoluPoId(int id);
	
	/**
	 * Pretrazuje bazu podataka za rolu koju korisnik ima dodeljenu
	 * 
	 * @param korisnik - korisnik za kojeg se pretraga vrsi
	 * @return - objekat Rola ukoliko je korisniku dodeljena rola,
	 * vraca null ukoliko korisnik ne posoji, ili mu nije dodeljena ni
	 * jedna rola
	 */
	public Rola ucitajRoluKorisnika(Korisnik korisnik);
	
}
