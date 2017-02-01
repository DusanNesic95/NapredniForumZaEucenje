package net.sytes.codeline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.RolaDao;
import net.sytes.codeline.entities.Korisnik;
import net.sytes.codeline.entities.Rola;

/**
 * @author dusannesic
 * Kontroler klasa za entitet Rola.
 * Pruza mapiranja za sve metode DAO slojeva, kao bi im se pristupalo iz spoljasnjih aplikacija
 * Koristi Spring RestController anotaciju
 */
@RestController
public class RolaController {

	@Autowired
	private RolaDao rolaDao;
	
	/**
	 * Poziv metode DAO sloja za dodavanje objekta u bazu podataka
	 * 
	 * @param rola - objekat koji se ubacuje u bazu podataka
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/dodajrolu", method=RequestMethod.POST)
	public boolean dodajRolu(@RequestBody Rola rola) {
		return rolaDao.dodajRolu(rola);
	}
	
	/**
	 * Poziv medota DAO sloja za izmenu postojeceg unosa u bazi prema prosledjenim
	 * parametrima novog objekta. Novi objekat mora imati isti ID
	 * 
	 * @param rola - objekat iz kojeg se preuzimaju atributi za azuriranje
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/izmenirolu", method=RequestMethod.POST)
	public boolean izmeniRolu(@RequestBody Rola rola) {
		return rolaDao.izmeniRolu(rola);
	}
	
	/**
	 * Poziv metoda DAO sloja za brisanje objekata iz baze prema prosledjenom id-ju
	 * 
	 * @param id - id za pretragu u bazi
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/obrisirolu", method=RequestMethod.POST)
	public boolean obrisiRolu(int id) {
		return rolaDao.obrisiRolu(id);
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje role prema prosledjenom id-ju
	 * 
	 * @param id - id za pretragu baze
	 * @return - vraca objekat Rola ili null u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/ucitajrolupoid", method=RequestMethod.POST)
	public Rola ucitajRoluPoId(int id) {
		return rolaDao.ucitajRoluPoId(id);
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje role prema prosledjenom
	 * korisniku
	 * 
	 * @param korisnik - korisnik za kojeg se baza pretrazuje
	 * @return - vraca objekat Rola ili null u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/ucitajrolukorisnika", method=RequestMethod.POST)
	public Rola ucitajRoluKorisnika(@RequestBody Korisnik korisnik) {
		return rolaDao.ucitajRoluKorisnika(korisnik);
	}
}
