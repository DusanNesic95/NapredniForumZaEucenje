package net.sytes.codeline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.KorisnikDao;
import net.sytes.codeline.entities.Korisnik;

/**
 * @author dusannesic
 * Kontroler klasa za entitet Korisnik.
 * Pruza mapiranja za sve metode DAO slojeva, kao bi im se pristupalo iz spoljasnjih aplikacija
 * Koristi Spring RestController anotaciju
 */
@RestController
public class KorisnikController {

	@Autowired
	private KorisnikDao korisnikDao;
	
	/**
	 * Poziv metode DAO sloja za dodavanje objekta u bazu podataka
	 * 
	 * @param korisnik - objekat koji se ubacuje u bazu podataka
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/dodajkorisnika", method=RequestMethod.POST)
	public boolean dodajKorisnika(@RequestBody Korisnik korisnik) {
		return korisnikDao.dodajKorisnika(korisnik);
	}
	
	/**
	 * Poziv medota DAO sloja za izmenu postojeceg unosa u bazi prema prosledjenim
	 * parametrima novog objekta. Novi objekat mora imati isti ID i korisnicko ime
	 * 
	 * @param korisnik - objekat iz kojeg se preuzimaju atributi za azuriranje
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/izmenikorisnika", method=RequestMethod.POST)
	public boolean izmeniKorisnika(@RequestBody Korisnik korisnik) {
		return korisnikDao.izmeniKorisnika(korisnik);
	}
	
	/**
	 * Poziv metoda DAO sloja za brisanje objekata iz baze prema prosledjenom id-ju
	 * 
	 * @param id - id za pretragu u bazi
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/obrisikorisnika", method=RequestMethod.POST)
	public boolean obrisiKorisnika(int id) {
		return korisnikDao.obrisiKorisnika(id);
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje svih postojecih korisnika iz baze podataka
	 * 
	 * @return - lista korisnika java.util.List kolekcije
	 */
	@RequestMapping(value="/ucitajsvekorisnike", method=RequestMethod.POST)
	public List<Korisnik> ucitajSveKorisnike() {
		return korisnikDao.ucitajSveKorisnike();
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje korisnika prema prosledjenom id-ju
	 * 
	 * @param id - id za pretragu baze
	 * @return - vraca objekat Korisnik ili null u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/ucitajkorisnikapoid", method=RequestMethod.POST)
	public Korisnik ucitajKorisnikaPoId(int id) {
		return korisnikDao.ucitajKorsinikaPoId(id);
	}
}
