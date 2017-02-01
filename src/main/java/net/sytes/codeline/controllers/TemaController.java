package net.sytes.codeline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.sytes.codeline.dao.TemaDao;
import net.sytes.codeline.entities.Predmet;
import net.sytes.codeline.entities.Tema;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dusannesic
 * Kontroler klasa za entitet Tema.
 * Pruza mapiranja za sve metode DAO slojeva, kao bi im se pristupalo iz spoljasnjih aplikacija
 * Koristi Spring RestController anotaciju
 */
@RestController
public class TemaController {

	@Autowired
	private TemaDao temaDao;
	
	/**
	 * Dodaje temu predmetu prema prosledjenom objektu Tema
	 * 
	 * @param tema - objekat prema kojem se atributi upisuju u bazu
	 * @return - vraca true ukoliko je tema uspesno dodata, false ukoliko
	 * je tema vec dodata
	 */
	@RequestMapping(value="/dodajtemu", method=RequestMethod.POST)
	public boolean dodajTemu(@RequestBody Tema tema) {
		return temaDao.dodajTemu(tema);
	}
	
	/**
	 * Menja temu prema prosledjenom objektu Tema
	 * 
	 * @param tema - objekat prema kojem se atributi upisuju u bazu
	 * @return - vraca true ukoliko je tema uspesno izmenjena, false ukoliko
	 * tema nije ni pronadjena
	 */
	@RequestMapping(value="/izmenitemu", method=RequestMethod.POST)
	public boolean izmeniTemu(@RequestBody Tema tema) {
		return temaDao.izmeniTemu(tema);
	}
	
	/**
	 * Brise temu prema prosledjenom objektu Tema
	 * 
	 * @param tema - objekat prema kojem se atributi upisuju u bazu
	 * @return - vraca true ukoliko je tema uspesno izmenjena, false ukoliko
	 * tema nije ni pronadjena
	 */
	@RequestMapping(value="/obrisitemu", method=RequestMethod.POST)
	public boolean obrisiTemu(@RequestBody Tema tema) {
		return temaDao.obrisiTemu(tema.getTemaId());
	}
	
	/**
	 * Ucitava sve teme koje postoje u bazi podataka
	 * 
	 * @return - vraca listu tema ukoliko u bazi postoje teme, vraca praznu
	 * listu ukoliko u bazi nema kreiranih tema
	 */
	@RequestMapping(value="/ucitajsveteme", method=RequestMethod.POST)
	public List<Tema> ucitajSveTeme() {
		return temaDao.ucitajSveTeme();
	}
	
	/**
	 * Ucitava sve teme koje postoje u bazi podataka, a koje su vezane za predmet
	 * prosledjen kroz objekat Predmet
	 * 
	 * @param predmet - predmet za koji se pretrazuje baza podataka
	 * @return - vraca listu tema ukoliko u bazi postoje teme, vraca praznu
	 * listu ukoliko u bazi nema kreiranih tema
	 */
	@RequestMapping(value="/ucitajsvetemezapredmet", method=RequestMethod.POST)
	public List<Tema> ucitajSveTemeZaPredmet(@RequestBody Predmet predmet) {
		return temaDao.ucitajSveTemeZaPredmet(predmet);
	}
	
	/**
	 * Ucitava temu iz baze podataka po prosledjenom parametru id iz objekt Tema
	 * 
	 * @param tema - objekat Tema po cijem se id-ju pretrazuje baza
	 * @return - vraca objekat Tema ukoliko je isti pronadjen, ili null ukoliko
	 * u bazi ne postoji tema
	 */
	@RequestMapping(value="/ucitajsvetemezapredmet", method=RequestMethod.POST)
	public Tema ucitajTemuPoId(@RequestBody Tema tema) {
		return temaDao.ucitajTemuPoId(tema.getTemaId());
	}
	
}
