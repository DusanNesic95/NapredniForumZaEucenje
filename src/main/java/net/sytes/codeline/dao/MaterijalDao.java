package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Materijal;
import net.sytes.codeline.entities.Tema;

/**
 * @author dusannesic
 * DAO sloj koji povezuje Materijal entitet sa bazom podataka
 * Metode koje obezbedjuje DAO sloj su osnovne CRUD operacije
 */
public interface MaterijalDao {

	/**
	 * Dodaje materijal u bazu podataka prema prosledjenom objektu Materijal
	 * 
	 * @param materijal - objekat koji se prosledjuje
	 * @return - vraca true ukoliko je materijal uspesno dodat u bazu,
	 * vraca false ukoliko materijal vec postoji
	 */
	public boolean dodajMaterijal(Materijal materijal);
	
	/**
	 * Metoda menja postojeci materijal u bazi podataka prema objektu Materijal
	 * koji je prosledjen
	 * 
	 * @param materijal - objekat iz kojeg se citaju atributi za izmenu
	 * @return - vraca true ukoliko materijal postoji i azuriranje je uspesno
	 * izvrseno, vraca false ukoliko materijal ne postoji
	 */
	public boolean izmeniMaterijal(Materijal materijal);
	
	/**
	 * Brise materijal iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id materijala koji se prosledjuje
	 * @return - vraca true ukoliko je materijal postojao u bazi, vraca false
	 * ukoliko materijal nije pronadjen
	 */
	public boolean obrisiMaterijal(int id);
	
	/**
	 * @return - vraca listu svih materijala iz baze podataka i smesta ih u
	 * java.util.List kolekciju
	 */
	public List<Materijal> ucitajSveMaterijale();
	
	/**
	 * Vraca materijal iz baze podataka prema prosledjenom id-ju
	 * 
	 * @param id - id po kojem se baza pretrazuje
	 * @return - vraca objekat Materijal za pronadjeni materijal iz baze
	 * ukoliko isti postoji, vraca null ukoliko predmet ne postoji
	 */
	public Materijal ucitajMaterijalPoId(int id);
	
	/**
	 * Ucitava sve materijale iz baze koji su povezani sa odredjenom temom
	 * koja se prosledjuje metodi
	 * 
	 * @param tema - objekat Tema po kojem se pretrazuje baza
	 * @return - vraca listu svih materijala iz baze podataka koji odgovaraju
	 * kriterijumu pretrage i smesta ih u java.util.List kolekciju
	 */
	public List<Materijal> ucitajMaterijalePoTemi(Tema tema);
	
}
