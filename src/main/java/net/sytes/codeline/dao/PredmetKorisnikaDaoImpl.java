package net.sytes.codeline.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.sytes.codeline.entities.Korisnik;
import net.sytes.codeline.entities.Predmet;
import net.sytes.codeline.entities.PredmetKorisnika;

/**
 * @author dusannesic
 * Implementacija DAO sloja za pristup entitetu PredmetKorisnika
 */
@Repository
public class PredmetKorisnikaDaoImpl implements PredmetKorisnikaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public PredmetKorisnikaDaoImpl() {}
	
	public PredmetKorisnikaDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.PredmetKorisnikaDao#dodajPredmetKorisniku(net.sytes.codeline.entities.PredmetKorisnika)
	 */
	@Override
	public boolean dodajPredmetKorisniku(PredmetKorisnika predmetKorisnika) {
		PredmetKorisnika trenutnoPoseduje = trenutnoPoseduje(predmetKorisnika);
		
		if (trenutnoPoseduje == null) {
			sessionFactory.getCurrentSession().save(predmetKorisnika);
			
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.PredmetKorisnikaDao#obrisiPredmetKorisniku(net.sytes.codeline.entities.PredmetKorisnika)
	 */
	@Override
	public boolean obrisiPredmetKorisniku(PredmetKorisnika predmetKorisnika) {
		PredmetKorisnika trenutnoPoseduje = trenutnoPoseduje(predmetKorisnika);
		
		if (trenutnoPoseduje == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(trenutnoPoseduje);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.PredmetKorisnikaDao#ucitajSvePredmeteKorisnika(net.sytes.codeline.entities.Korisnik)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Predmet> ucitajSvePredmeteKorisnika(Korisnik korisnik) {
		return sessionFactory.getCurrentSession()
				.createCriteria(PredmetKorisnika.class)
				.add(Restrictions.eq("korisnikId", korisnik))
				.list();
	}

	/**
	 * Metoda proverava da li je predmet vec dodeljen korisniku, prema prosledjenom
	 * objektu PredmetKorisnika
	 * 
	 * @param predmetKorisnika - objekat koji se koristi kao parametar za pretragu baze
	 * @return - objekat PredmetKorisnika ukoliko je predmet vec dodeljen korisniku,
	 * null ukoliko predmet nije dodeljen korisniku
	 */
	private PredmetKorisnika trenutnoPoseduje(PredmetKorisnika predmetKorisnika) {
		PredmetKorisnika trenutnoPoseduje = (PredmetKorisnika) sessionFactory.getCurrentSession()
				.createCriteria(PredmetKorisnika.class)
				.add(Restrictions.eq("predmetKorisnikaId", predmetKorisnika.getPredmetKorisnikaId()))
				.add(Restrictions.eq("predmetId", predmetKorisnika.getPredmetId()))
				.add(Restrictions.eq("korisnikId", predmetKorisnika.getKorisnikId()))
				.uniqueResult();
		return trenutnoPoseduje;
	}
	
}
