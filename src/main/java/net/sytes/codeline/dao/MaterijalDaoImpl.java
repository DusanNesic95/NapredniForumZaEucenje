package net.sytes.codeline.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Materijal;
import net.sytes.codeline.entities.Tema;

/**
 * @author dusannesic
 * Implementacija DAO sloja za pristup entitetu Materijal
 */
@Repository
public class MaterijalDaoImpl implements MaterijalDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public MaterijalDaoImpl() {}
	
	public MaterijalDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.MaterijalDao#dodajMaterijal(net.sytes.codeline.entities.Materijal)
	 */
	@Override
	@Transactional
	public boolean dodajMaterijal(Materijal materijal) {
		Materijal postojeciMaterijal = postojeciMaterijal(materijal);
		
		if (postojeciMaterijal == null) {
			sessionFactory.getCurrentSession().save(materijal);
			
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.MaterijalDao#izmeniMaterijal(net.sytes.codeline.entities.Materijal)
	 */
	@Override
	@Transactional
	public boolean izmeniMaterijal(Materijal materijal) {
		Materijal postojeciMaterijal = postojeciMaterijal(materijal);
		
		if (postojeciMaterijal == null) {
			return false;
		}
		
		postojeciMaterijal.setOpisMaterijala(materijal.getOpisMaterijala());
		postojeciMaterijal.setLink(materijal.getLink());
		postojeciMaterijal.setVideo(materijal.getVideo());
		postojeciMaterijal.setAudio(materijal.getAudio());
		postojeciMaterijal.setBrojPreporukaPozitivno(materijal.getBrojPreporukaPozitivno());
		postojeciMaterijal.setBrojPreporukaNegativno(materijal.getBrojPreporukaNegativno());
		postojeciMaterijal.setMaterijalFleg(materijal.getMaterijalFleg());
		sessionFactory.getCurrentSession().update(postojeciMaterijal);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.MaterijalDao#obrisiMaterijal(int)
	 */
	@Override
	@Transactional
	public boolean obrisiMaterijal(int id) {
		Materijal postojeciMaterijal = ucitajMaterijalPoId(id);
		
		if (postojeciMaterijal == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(postojeciMaterijal);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.MaterijalDao#ucitajSveMaterijale()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Materijal> ucitajSveMaterijale() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Materijal.class)
				.list();
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.MaterijalDao#ucitajMaterijalPoId(int)
	 */
	@Override
	@Transactional
	public Materijal ucitajMaterijalPoId(int id) {
		Materijal postojeciMaterijal = (Materijal) sessionFactory.getCurrentSession()
				.createCriteria(Materijal.class)
				.add(Restrictions.eq("materijalId", id))
				.uniqueResult();
		
		if (postojeciMaterijal == null) {
			return null;
		}
		
		return postojeciMaterijal;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.MaterijalDao#ucitajMaterijalePoTemi(net.sytes.codeline.entities.Tema)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Materijal> ucitajMaterijalePoTemi(Tema tema) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Materijal.class)
				.add(Restrictions.eq("temaId", tema))
				.list();
	}

	/**
	 * Ucitava objekat Materijal iz baze prema prosledjenom parametru naziv materijala
	 * 
	 * @param materijal - objekat iz kojeg se izvlace parametri za pretragu
	 * @return - vraca objekat Materijal ukoliko u bazi podataka postoji materijal
	 * koji ispunjava kriterijume pretrage, vraca null ukoliko isti ne postoji
	 */
	private Materijal postojeciMaterijal(Materijal materijal) {
		Materijal postojeciMaterijal = (Materijal) sessionFactory.getCurrentSession()
				.createCriteria(Materijal.class)
				.add(Restrictions.eq("nazivMaterijala", materijal.getNazivMaterijala()))
				.uniqueResult();
		return postojeciMaterijal;
	}
	
}
