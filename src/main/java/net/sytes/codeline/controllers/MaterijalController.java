package net.sytes.codeline.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.MaterijalDao;
import net.sytes.codeline.dao.TemaDao;
import net.sytes.codeline.entities.Materijal;
import net.sytes.codeline.entities.Tema;
import net.sytes.codeline.entities.Predmet;

/**
 * @author dusannesic
 * Kontroler klasa za entitet Materijal.
 * Pruza mapiranja za sve metode DAO slojeva, kao bi im se pristupalo iz spoljasnjih aplikacija
 * Koristi Spring RestController anotaciju
 */
@RestController
public class MaterijalController {

	@Autowired
	private MaterijalDao materijalDao;
	@Autowired
	private TemaDao temaDao;
	
	/**
	 * Poziv metode DAO sloja za dodavanje objekta u bazu podataka
	 * 
	 * @param materijal - objekat koji se ubacuje u bazu podataka
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/dodajmaterijal", method=RequestMethod.POST)
	public boolean dodajMaterijal(@RequestBody Materijal materijal) {
		return materijalDao.dodajMaterijal(materijal);
	}
	
	/**
	 * Poziv medota DAO sloja za izmenu postojeceg unosa u bazi prema prosledjenim
	 * parametrima novog objekta. Novi objekat mora imati isti naziv materijala
	 * 
	 * @param materijal - objekat iz kojeg se preuzimaju atributi za azuriranje
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/izmenimaterijal", method=RequestMethod.POST)
	public boolean izmeniMaterijal(@RequestBody Materijal materijal) {
		return materijalDao.izmeniMaterijal(materijal);
	}
	
	/**
	 * Poziv metoda DAO sloja za brisanje objekata iz baze prema prosledjenom id-ju
	 * 
	 * @param materijal - id za pretragu u bazi
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/obrisimaterijal", method=RequestMethod.POST)
	public boolean obrisiMaterijal(@RequestBody Materijal materijal) {
		return materijalDao.obrisiMaterijal(materijal.getMaterijalId());
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje svih postojecih materijala iz baze podataka
	 * 
	 * @return - lista korisnika java.util.List kolekcije
	 */
	@CrossOrigin
	@RequestMapping(value="/ucitajsvematerijale", method=RequestMethod.POST)
	public List<Materijal> ucitajSveMaterijale() {
		return materijalDao.ucitajSveMaterijale();
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje materijala prema prosledjenom id-ju
	 * 
	 * @param materijal - id za pretragu baze
	 * @return - vraca objekat Materijal ili null u zavisnosti od DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/ucitajmaterijalpoid", method=RequestMethod.POST)
	public Materijal ucitajMaterijalPoId(@RequestBody Materijal materijal) {
		return materijalDao.ucitajMaterijalPoId(materijal.getMaterijalId());
	}
	
	/**
	 * Vraca listu materijala prema prosledjenoj temi
	 * 
	 * @param tema - tema po kojoj se pretrazuje baza podataka
	 * @return - vraca listu materijala ili praznu listu u zavisnosti od
	 * DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/ucitajmaterijalepotemi", method=RequestMethod.POST)
	public List<Materijal> ucitajMaterijalePoTemi(@RequestBody Tema tema) {
		return materijalDao.ucitajMaterijalePoTemi(tema);
	}
	
	/**
	 * Vraca listu materijala prema prosledjenom predmetu, koji su obelezeni
	 * za nastavni materijal
	 * 
	 * @param predmet - predmet po kojem se pretrazuje baza podataka
	 * @return - vraca listu materijala ili praznu listu u zavisnosti od
	 * DAO sloja
	 */
	@CrossOrigin
	@RequestMapping(value="/ucitajmaterijalepopredmetu", method=RequestMethod.POST)
	public List<Materijal> ucitajMaterijalePoPredmetu(@RequestBody Predmet predmet) {
		List<Tema> temePredmeta = temaDao.ucitajSveTemeZaPredmet(predmet);

		List<Materijal> sviMaterijali = new ArrayList<>();
		for (Tema tema : temePredmeta) {
			sviMaterijali.addAll(materijalDao.ucitajMaterijalePoTemi(tema));
		}

		List<Materijal> ukljucenMaterijal = new ArrayList<>();
		for (Materijal materijal : sviMaterijali) {
			if (materijal.getMaterijalFleg() == 1) {
				ukljucenMaterijal.add(materijal);
			}
		}

		return ukljucenMaterijal;
	}

}
