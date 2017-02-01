package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Predmet;
import net.sytes.codeline.entities.Tema;

/**
 * @author dusannesic
 * DAO sloj koji povezuje Tema entitet sa bazom podataka
 * Metode koje obezbedjuje DAO sloj su osnovne CRUD operacije
 */
public interface TemaDao {

	/**
	 * Dodaje temu u bazu podataka prema prosledjenom objektu Tema
	 * 
	 * @param tema - objekat koji se prosledjuje
	 * @return - vraca true ukoliko je tema uspesno dodata u bazu,
	 * vraca false ukoliko tema vec postoji
	 */
	public boolean dodajTemu(Tema tema);
	
	/**
	 * Metoda menja postojecu temu u bazi podataka prema objektu Tema
	 * koji je prosledjen
	 * 
	 * @param tema - objekat iz kojeg se citaju atributi za izmenu
	 * @return - vraca true ukoliko tema postoji i azuriranje je uspesno
	 * izvrseno, vraca false ukoliko tema ne postoji
	 */
	public boolean izmeniTemu(Tema tema);
	
	/**
	 * Brise temu iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id predmeta koji se prosledjuje
	 * @return - vraca true ukoliko je tema postojala u bazi, vraca false
	 * ukoliko tema nije pronadjena
	 */
	public boolean obrisiTemu(int id);
	
	/**
	 * @return - vraca listu svih tema iz baze podataka i smesta ih u
	 * java.util.List kolekciju
	 */
	public List<Tema> ucitajSveTeme();
	
	/**
	 * @param predmet - predmet po kojem se vrti pretraga u bazi podataka
	 * @return - vraca listu svih tema iz baze podataka koje su vezane za isti predmet
	 */
	public List<Tema> ucitajSveTemeZaPredmet(Predmet predmet);
	
	/**
	 * Vraca temu iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id po kojem se baza pretrazuje
	 * @return - vraca objekat Tema za pronadjeni predmet iz baze
	 * ukoliko isti postoji, vraca null ukoliko tema ne postoji
	 */
	public Tema ucitajTemuPoId(int id);
	
}
