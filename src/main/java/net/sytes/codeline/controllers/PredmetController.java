package net.sytes.codeline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.PredmetDao;
import net.sytes.codeline.entities.Predmet;

/**
 * @author dusannesic
 * Kontroler klasa za entitet Predmet.
 * Pruza mapiranja za sve metode DAO slojeva, kao bi im se pristupalo iz spoljasnjih aplikacija
 * Koristi Spring RestController anotaciju
 */
@RestController
public class PredmetController {

	@Autowired
	private PredmetDao predmetDao;
	
	/**
	 * Poziv metode DAO sloja za dodavanje objekta u bazu podataka
	 * 
	 * @param predmet - objekat koji se ubacuje u bazu podataka
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/dodajpredmet", method=RequestMethod.POST)
	public boolean dodajPredmet(@RequestBody Predmet predmet) {
		return predmetDao.dodajPredmet(predmet);
	}
	
	/**
	 * Poziv medota DAO sloja za izmenu postojeceg unosa u bazi prema prosledjenim
	 * parametrima novog objekta. Novi objekat mora imati isti ID, naziv predmeta i 
	 * skolsku godinu
	 * 
	 * @param predmet - objekat iz kojeg se preuzimaju atributi za azuriranje
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/izmenipredmet", method=RequestMethod.POST)
	public boolean izmeniPredmet(@RequestBody Predmet predmet) {
		return predmetDao.izmeniPredmet(predmet);
	}
	
	/**
	 * Poziv metoda DAO sloja za brisanje objekata iz baze prema prosledjenom id-ju
	 * 
	 * @param id - id za pretragu u bazi
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/obrisipredmet", method=RequestMethod.POST)
	public boolean obrisiPredmet(int id) {
		return predmetDao.obrisiPredmet(id);
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje svih postojecih predmeta iz baze podataka
	 * 
	 * @return - lista korisnika java.util.List kolekcije
	 */
	@CrossOrigin
	@RequestMapping(value="/ucitajsvepredmete", method=RequestMethod.POST)
	public List<Predmet> ucitajSvePredmete() {
		return predmetDao.ucitajSvePredmete();
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje predmeta prema prosledjenom id-ju
	 * 
	 * @param id - id za pretragu baze
	 * @return - vraca objekat Predmet ili null u zavisnosti od DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/ucitajpredmetpoid", method=RequestMethod.POST)
	public Predmet ucitajPredmetPoId(int id) {
		return predmetDao.ucitajPredmetPoId(id);
	}
}
