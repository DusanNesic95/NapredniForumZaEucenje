package net.sytes.codeline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.KomentarDao;
import net.sytes.codeline.entities.Komentar;
import net.sytes.codeline.entities.Materijal;

/**
 * @author dusannesic
 * Kontroler klasa za entitet Komentar.
 * Pruza mapiranja za sve metode DAO slojeva, kao bi im se pristupalo iz spoljasnjih aplikacija
 * Koristi Spring RestController anotaciju
 */
@RestController
public class KomentarController {

	@Autowired
	private KomentarDao komentarDao;
	
	/**
	 * Poziv metode DAO sloja za dodavanje objekta u bazu podataka
	 * 
	 * @param komentar - objekat koji se ubacuje u bazu podataka
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/dodajkomentar", method=RequestMethod.POST)
	public boolean dodajKomentar(@RequestBody Komentar komentar) {
		return komentarDao.dodajKomentar(komentar);
	}
	
	/**
	 * Poziv medota DAO sloja za izmenu postojeceg unosa u bazi prema prosledjenim
	 * parametrima novog objekta. Novi objekat mora imati isti sadrzaj
	 * 
	 * @param komentar - objekat iz kojeg se preuzimaju atributi za azuriranje
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/izmenikomentar", method=RequestMethod.POST)
	public boolean izmeniKomentar(@RequestBody Komentar komentar) {
		return komentarDao.izmeniKomentar(komentar);
	}
	
	/**
	 * Poziv metoda DAO sloja za brisanje objekata iz baze prema prosledjenom id-ju
	 * 
	 * @param komentar - id za pretragu u bazi
	 * @return - vraca true/false u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/obrisikomentar", method=RequestMethod.POST)
	public boolean obrisiKomentar(@RequestBody Komentar komentar) {
		return komentarDao.obrisiKomentar(komentar.getKomentarId());
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje svih postojecih komentara iz baze podataka
	 * 
	 * @return - lista korisnika java.util.List kolekcije
	 */
	@RequestMapping(value="/ucitajsvekomentare", method=RequestMethod.POST)
	public List<Komentar> ucitajSveKomentare() {
		return komentarDao.ucitajSveKomentare();
	}
	
	/**
	 * Poziv metode DAO sloja za ucitavanje komentara prema prosledjenom id-ju
	 * 
	 * @param komentar - id za pretragu baze
	 * @return - vraca objekat Komentar ili null u zavisnosti od DAO sloja
	 */
	@RequestMapping(value="/ucitajkomentarpoid", method=RequestMethod.POST)
	public Komentar ucitajKomentarPoId(@RequestBody Komentar komentar) {
		return komentarDao.ucitajKomentarPoId(komentar.getKomentarId());
	}
	
	/**
	 * Vraca listu komentara prema prosledjenom materijalu
	 * 
	 * @param materijal - materijal po kojem se pretrazuje baza podataka
	 * @return - vraca listu komentara ili praznu listu u zavisnosti od
	 * DAO sloja
	 */
	@RequestMapping(value="/ucitajkomentarepomaterijalu", method=RequestMethod.POST)
	public List<Komentar> ucitajKomentarePoMaterijalu(Materijal materijal) {
		return komentarDao.ucitajKomentarePoMaterijalu(materijal);
	}
	
}
