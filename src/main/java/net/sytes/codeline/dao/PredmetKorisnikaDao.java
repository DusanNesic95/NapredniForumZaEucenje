package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Korisnik;
import net.sytes.codeline.entities.Predmet;
import net.sytes.codeline.entities.PredmetKorisnika;

/**
 * @author dusannesic
 * DAO sloj koji povezuje PredmetKorisnika entitet sa bazom podataka
 * Metode koje obezbedjuje DAO sloj su osnovne CRUD operacije
 */
public interface PredmetKorisnikaDao {

	
	/**
	 * Dodaje predmet korisniku prema prosledjenom objektu PredmetKorisnika
	 * 
	 * @param predmetKorisnika - par predmet-korisnik po kojem se vrsi upit ka bazi
	 * @return - vraca true ukoliko je predmet uspesno dodat korisniku, false ukoliko
	 * je predmet vec dodat korisniku
	 */
	public boolean dodajPredmetKorisniku(PredmetKorisnika predmetKorisnika);
	
	/**
	 * Brise predmet korisniku, kako ne bi mogao da vidi isti
	 * 
	 * @param predmetKorisnika - par po kojem se vrsi upit ka bazi podataka
	 * @return - vraca true ukoliko je predmet uspesno sklonjen sa liste predmeta
	 * koje korisnik moze da vidi, vraca false ukoliko predmet nije ni bio dodeljen
	 * korisniku
	 */
	public boolean obrisiPredmetKorisniku(PredmetKorisnika predmetKorisnika);
	
	/**
	 * Vraca listu predmeta koje prosledjeni korisnik moze da vidi, u obliku
	 * java.util.Liste kolekcije
	 * 
	 * @param korisnik - korisnik za kojeg se pretrazuje baza podataka
	 * @return - lista predmeta ukoliko korisnik ima predmete koji su mu dodeljeni,
	 * ili prazna lista ukoliko korisnik nema predmete
	 */
	public List<Predmet> ucitajSvePredmeteKorisnika(Korisnik korisnik);
	
}
