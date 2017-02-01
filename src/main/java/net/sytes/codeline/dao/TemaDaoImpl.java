package net.sytes.codeline.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Predmet;
import net.sytes.codeline.entities.Tema;

/**
 * @author dusannesic
 * Implementacija DAO sloja za pristup entitetu Tema
 */
@Repository
public class TemaDaoImpl implements TemaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public TemaDaoImpl() {}
	
	public TemaDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.TemaDao#dodajTemu(net.sytes.codeline.entities.Tema)
	 */
	@Override
	@Transactional
	public boolean dodajTemu(Tema tema) {
		Tema postojecaTema = postojecaTema(tema);
		
		if (postojecaTema == null) {
			sessionFactory.getCurrentSession().save(tema);
			
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.TemaDao#izmeniTemu(net.sytes.codeline.entities.Tema)
	 */
	@Override
	@Transactional
	public boolean izmeniTemu(Tema tema) {
		Tema postojecaTema = postojecaTema(tema);
		
		if (postojecaTema == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().update(tema);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.TemaDao#obrisiTemu(int)
	 */
	@Override
	@Transactional
	public boolean obrisiTemu(int id) {
		Tema postojecaTema = ucitajTemuPoId(id);
		
		if (postojecaTema == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(postojecaTema);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.TemaDao#ucitajSveTeme()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Tema> ucitajSveTeme() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Tema.class)
				.list();
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.TemaDao#ucitajSveTemeZaPredmet(net.sytes.codeline.entities.Predmet)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Tema> ucitajSveTemeZaPredmet(Predmet predmet) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Tema.class)
				.add(Restrictions.eq("predmetId", predmet))
				.list();
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.TemaDao#ucitajTemuPoId(int)
	 */
	@Override
	@Transactional
	public Tema ucitajTemuPoId(int id) {
		Tema postojecaTema = (Tema) sessionFactory.getCurrentSession()
				.createCriteria(Tema.class)
				.add(Restrictions.eq("temaId", id))
				.uniqueResult();
		
		if (postojecaTema == null) {
			return null;
		}
		
		return postojecaTema;
	}

	/**
	 * Ucitava objekat Tema iz baze prema prosledjenim parametrima id i naziv teme
	 * 
	 * @param tema - objekat iz kojeg se izvlace parametri za pretragu
	 * @return - vraca objekat Tema ukoliko u bazi podataka postoji tema
	 * koji ispunjava kriterijume pretrage, vraca null ukoliko isti ne postoji
	 */
	private Tema postojecaTema(Tema tema) {
		Tema postojecaTema = (Tema) sessionFactory.getCurrentSession()
				.createCriteria(Tema.class)
				.add(Restrictions.eq("temaId", tema.getTemaId()))
				.add(Restrictions.eq("nazivTeme", tema.getNazivTeme()))
				.uniqueResult();
		return postojecaTema;
	}
	
}
