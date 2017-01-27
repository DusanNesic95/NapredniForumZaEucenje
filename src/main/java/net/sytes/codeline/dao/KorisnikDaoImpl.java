package net.sytes.codeline.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.sytes.codeline.entities.Korisnik;

/**
 * @author dusannesic
 * Implementacija DAO sloja za pristup entitetu Korisnik
 */
@Repository
public class KorisnikDaoImpl implements KorisnikDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public KorisnikDaoImpl() {}
	
	public KorisnikDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KorisnikDao#dodajKorisnika(net.sytes.codeline.entities.Korisnik)
	 */
	@Override
	public boolean dodajKorisnika(Korisnik korisnik) {
		Korisnik postojeciKorisnik = postojeciKorisnik(korisnik);
		
		if (postojeciKorisnik == null) {
			sessionFactory.getCurrentSession().save(korisnik);
			
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KorisnikDao#izmeniKorisnika(net.sytes.codeline.entities.Korisnik)
	 */
	@Override
	public boolean izmeniKorisnika(Korisnik korisnik) {
		Korisnik postojeciKorisnik = postojeciKorisnik(korisnik);
		
		if (postojeciKorisnik == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().update(korisnik);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KorisnikDao#obrisiKorisnika(int)
	 */
	@Override
	public boolean obrisiKorisnika(int id) {
		Korisnik postojeciKorisnik = ucitajKorsinikaPoId(id);
		
		if (postojeciKorisnik == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(postojeciKorisnik);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KorisnikDao#ucitajSveKorisnike()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Korisnik> ucitajSveKorisnike() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Korisnik.class)
				.list();
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KorisnikDao#ucitajKorsinikaPoId(int)
	 */
	@Override
	public Korisnik ucitajKorsinikaPoId(int id) {
		Korisnik postojeciKorisnik = (Korisnik) sessionFactory.getCurrentSession()
				.createCriteria(Korisnik.class)
				.add(Restrictions.eq("korisnikId", id))
				.uniqueResult();
		
		if (postojeciKorisnik == null) {
			return null;
		}
		
		return postojeciKorisnik;
	}

	/**
	 * Ucitava objekat Korisnik iz baze prema prosledjenim parametrima id i korisnicko ime
	 * @param korisnik - objekat iz kojeg se izvlace parametri za pretragu
	 * @return - vraca objekat Korisnik ukoliko u bazi podataka postoji korisnik
	 * koji ispunjava kriterijume pretrage, vraca null ukoliko isti ne postoji
	 */
	private Korisnik postojeciKorisnik(Korisnik korisnik) {
		Korisnik postojeciKorisnik = (Korisnik) sessionFactory.getCurrentSession()
				.createCriteria(Korisnik.class)
				.add(Restrictions.eq("korisnikId", korisnik.getKorisnikId()))
				.add(Restrictions.eq("korisnickoIme", korisnik.getKorisnickoIme()))
				.uniqueResult();
		return postojeciKorisnik;
	}
	
}
