package net.sytes.codeline.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Predmet;

/**
 * @author dusannesic
 * Implementacija DAO sloja za pristup entitetu Predmet
 */
@Repository
public class PredmetDaoImpl implements PredmetDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public PredmetDaoImpl() {}
	
	public PredmetDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.PredmetDao#dodajPredmet(net.sytes.codeline.entities.Predmet)
	 */
	@Override
	@Transactional
	public boolean dodajPredmet(Predmet predmet) {
		Predmet postojeciPredmet = postojeciPredmet(predmet);
		
		if (postojeciPredmet == null) {
			sessionFactory.getCurrentSession().save(predmet);
			
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.PredmetDao#izmeniPredmet(net.sytes.codeline.entities.Predmet)
	 */
	@Override
	@Transactional
	public boolean izmeniPredmet(Predmet predmet) {
		Predmet postojeciPredmet = postojeciPredmet(predmet);
		
		if (postojeciPredmet == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().update(predmet);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.PredmetDao#obrisiPredmet(int)
	 */
	@Override
	@Transactional
	public boolean obrisiPredmet(int id) {
		Predmet postojeciPredmet = ucitajPredmetPoId(id);
		
		if (postojeciPredmet == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(postojeciPredmet);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.PredmetDao#ucitajSvePredmete()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Predmet> ucitajSvePredmete() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Predmet.class)
				.list();
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.PredmetDao#ucitajPredmetPoId(int)
	 */
	@Override
	@Transactional
	public Predmet ucitajPredmetPoId(int id) {
		Predmet postojeciPredmet = (Predmet) sessionFactory.getCurrentSession()
				.createCriteria(Predmet.class)
				.add(Restrictions.eq("predmetId", id))
				.uniqueResult();
		
		if (postojeciPredmet == null) {
			return null;
		}
		
		return postojeciPredmet;
	}

	/**
	 * Ucitava objekat Predmet iz baze prema prosledjenim parametrima id, naziv predmeta
	 * i skolska godina u kojoj se predmet predaje/slusa
	 * 
	 * @param predmet - objekat iz kojeg se izvlace parametri za pretragu
	 * @return - vraca objekat Predmet ukoliko u bazi podataka postoji predmet
	 * koji ispunjava kriterijume pretrage, vraca null ukoliko isti ne postoji
	 */
	private Predmet postojeciPredmet(Predmet predmet) {
		Predmet postojeciPredmet = (Predmet) sessionFactory.getCurrentSession()
				.createCriteria(Predmet.class)
				.add(Restrictions.eq("predmetId", predmet.getPredmetId()))
				.add(Restrictions.eq("nazivPredmeta", predmet.getNazivPredmeta()))
				.add(Restrictions.eq("skolskaGodina", predmet.getSkolskaGodina()))
				.uniqueResult();
		return postojeciPredmet;
	}
	
}
