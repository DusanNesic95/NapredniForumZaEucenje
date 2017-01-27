package net.sytes.codeline.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
