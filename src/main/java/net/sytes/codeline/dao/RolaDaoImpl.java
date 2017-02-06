package net.sytes.codeline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Korisnik;
import net.sytes.codeline.entities.Rola;

/**
 * @author dusannesic
 * Implementacija DAO sloja za pristup entitetu Korisnik
 */
@Repository
public class RolaDaoImpl implements RolaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public RolaDaoImpl() {}
	
	public RolaDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.RolaDao#dodajRolu(net.sytes.codeline.entities.Rola)
	 */
	@Override
	@Transactional
	public boolean dodajRolu(Rola rola) {
		Rola postojecaRola = postojecaRola(rola);
		
		if (postojecaRola == null) {
			sessionFactory.getCurrentSession().save(rola);
			
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.RolaDao#izmeniRolu(net.sytes.codeline.entities.Rola)
	 */
	@Override
	@Transactional
	public boolean izmeniRolu(Rola rola) {
		Rola postojecaRola = postojecaRola(rola);
		
		if (postojecaRola == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().update(rola);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.RolaDao#obrisiRolu(int)
	 */
	@Override
	@Transactional
	public boolean obrisiRolu(int id) {
		Rola postojecaRola = ucitajRoluPoId(id);
		
		if (postojecaRola == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(postojecaRola);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.RolaDao#ucitajRoluPoId(int)
	 */
	@Override
	@Transactional
	public Rola ucitajRoluPoId(int id) {
		Rola postojecaRola = (Rola) sessionFactory.getCurrentSession()
				.createCriteria(Rola.class)
				.add(Restrictions.eq("rolaId", id))
				.uniqueResult();
		
		if (postojecaRola == null) {
			return null;
		}
		
		return postojecaRola;
	}
	
	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.RolaDao#ucitajRoluKorisnika(net.sytes.codeline.entities.Korisnik)
	 */
	@Override
	@Transactional
	public Rola ucitajRoluKorisnika(Korisnik korisnik) {
		return (Rola) sessionFactory.getCurrentSession()
				.createCriteria(Rola.class)
				.add(Restrictions.eq("korisnikId", korisnik))
				.uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.RolaDao#ucitajSveProfesore()
	 */
	@Override
	@Transactional
	public List<Korisnik> ucitajSveProfesore() {
		return ucitajKorisnikePoRoli("PROFESOR");
	}
	
	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.RolaDao#ucitajSveStudente()
	 */
	@Override
	@Transactional
	public List<Korisnik> ucitajSveStudente() {
		return ucitajKorisnikePoRoli("STUDENT");
	}
	
	/**
	 * Ucitava objekat Rola iz baze prema prosledjenim parametrima id
	 * @param rola - objekat iz kojeg se izvlace parametri za pretragu
	 * @return - vraca objekat Rola ukoliko u bazi podataka postoji rola
	 * kola ispunjava kriterijume pretrage, vraca null ukoliko ista ne postoji
	 */
	private Rola postojecaRola(Rola rola) {
		Rola postojecaRola = (Rola) sessionFactory.getCurrentSession()
				.createCriteria(Rola.class)
				.add(Restrictions.eq("rolaId", rola.getRolaId()))
				.add(Restrictions.eq("korisnikId", rola.getKorisnikId()))
				.add(Restrictions.eq("nazivRole", rola.getNazivRole()))
				.uniqueResult();
		
		return postojecaRola;
	}

	/**
	 * Ucitava sve korisnike iz baze podataka prema prosledjenoj roli
	 * 
	 * @param trenutnaRola - rola koju pretrazujemo
	 * @return - vraca listu korisnika ukoliko u bazi postoje korisnici
	 * sa trazenom rolom, ili vraca praznu listu
	 */
	@SuppressWarnings("unchecked")
	private List<Korisnik> ucitajKorisnikePoRoli(String trenutnaRola) {
		List<Rola> sveRoleProfesora = sessionFactory.getCurrentSession()
				.createCriteria(Rola.class)
				.add(Restrictions.eq("nazivRole", trenutnaRola))
				.list();
		
		List<Korisnik> profesori = new ArrayList<>();
		
		for (Rola rola : sveRoleProfesora) {
			profesori.add(rola.getKorisnikId());
		}
		
		return profesori;
	}
	
}
