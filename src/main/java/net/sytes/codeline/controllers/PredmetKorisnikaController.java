package net.sytes.codeline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.PredmetKorisnikaDao;
import net.sytes.codeline.entities.Korisnik;
import net.sytes.codeline.entities.Predmet;
import net.sytes.codeline.entities.PredmetKorisnika;

/**
 * @author dusannesic
 * Kontroler klasa za entitet PredmetKorisnika.
 * Pruza mapiranja za sve metode DAO slojeva, kao bi im se pristupalo iz spoljasnjih aplikacija
 * Koristi Spring RestController anotaciju
 */
@RestController
public class PredmetKorisnikaController {

	@Autowired
	private PredmetKorisnikaDao predmetKorisnikaDao;
	
	/**
	 * Dodaje predmet korisniku prema prosledjenom objektu PredmetKorisnika
	 * 
	 * @param predmetKorisnika - par predmet-korisnik po kojem se vrsi upit ka bazi
	 * @return - vraca true ukoliko je predmet uspesno dodat korisniku, false ukoliko
	 * je predmet vec dodat korisniku
	 */
	@RequestMapping(value="/dodajpredmetkorisniku", method=RequestMethod.POST)
	public boolean dodajPredmetKorisniku(@RequestBody PredmetKorisnika predmetKorisnika) {
		return predmetKorisnikaDao.dodajPredmetKorisniku(predmetKorisnika);
	}

	/**
	 * Brise predmet korisniku prema prosledjenom objektu PredmetKorisnika
	 * 
	 * @param predmetKorisnika - par predmet-korisnik po kojem se vrsi upit ka bazi
	 * @return - vraca true ukoliko je predmet uspesno obrisan korisniku, false ukoliko
	 * predmet nije ni bio dodeljen korisniku
	 */
	@RequestMapping(value="/obrisipredmetkorisniku", method=RequestMethod.POST)
	public boolean obrisiPredmetKorisniku(@RequestBody PredmetKorisnika predmetKorisnika) {
		return predmetKorisnikaDao.obrisiPredmetKorisniku(predmetKorisnika);
	}
	
	/**
	 * Pronalazi sve predmete korisnika
	 * 
	 * @param korisnik - korisnik za kojeg se vrsi upis u bazi podataka
	 * @return - vraca popunjenu listu predmeta koji su pronadjeni u bazi, ili praznu
	 * listu ukoliko korisnik nema ni jedan dodeljen predmet
	 */
	@RequestMapping(value="/ucitajsvepredmetekorisnika", method=RequestMethod.POST)
	public List<Predmet> ucitajSvePredmeteKorisnika(@RequestBody Korisnik korisnik) {
		return predmetKorisnikaDao.ucitajSvePredmeteKorisnika(korisnik);
	}
	
}
