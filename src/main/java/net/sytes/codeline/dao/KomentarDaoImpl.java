package net.sytes.codeline.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Komentar;
import net.sytes.codeline.entities.Materijal;

/**
 * @author dusannesic
 * Implementacija DAO sloja za pristup entitetu Komentar
 */
@Repository
public class KomentarDaoImpl implements KomentarDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public KomentarDaoImpl() {}
	
	public KomentarDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KomentarDao#dodajKomentar(net.sytes.codeline.entities.Komentar)
	 */
	@Override
	@Transactional
	public boolean dodajKomentar(Komentar komentar) {
		sessionFactory.getCurrentSession().save(komentar);
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KomentarDao#izmeniKomentar(net.sytes.codeline.entities.Komentar)
	 */
	@Override
	@Transactional
	public boolean izmeniKomentar(Komentar komentar) {
		Komentar postojeciKomentar = postojeciKomentar(komentar);
		
		if (postojeciKomentar == null) {
			return false;
		}
		
		postojeciKomentar.setSadrzaj(komentar.getSadrzaj());
		sessionFactory.getCurrentSession().update(postojeciKomentar);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KomentarDao#obrisiKomentar(int)
	 */
	@Override
	@Transactional
	public boolean obrisiKomentar(int id) {
		Komentar postojeciKomentar = ucitajKomentarPoId(id);
		
		if (postojeciKomentar == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(postojeciKomentar);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KomentarDao#ucitajSveKomentare()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Komentar> ucitajSveKomentare() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Komentar.class)
				.list();
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KomentarDao#ucitajKomentarPoId(int)
	 */
	@Override
	@Transactional
	public Komentar ucitajKomentarPoId(int id) {
		Komentar postojeciKomentar = (Komentar) sessionFactory.getCurrentSession()
				.createCriteria(Komentar.class)
				.add(Restrictions.eq("komentarId", id))
				.uniqueResult();
		
		if (postojeciKomentar == null) {
			return null;
		}
		
		return postojeciKomentar;
	}

	/* (non-Javadoc)
	 * @see net.sytes.codeline.dao.KomentarDao#ucitajKomentarePoMaterijalu(net.sytes.codeline.entities.Materijal)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Komentar> ucitajKomentarePoMaterijalu(Materijal materijal) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Komentar.class)
				.add(Restrictions.eq("materijalId", materijal))
				.list();
	}
	
	/**
	 * Ucitava objekat Komentar iz baze prema prosledjenom sadrzaju
	 * 
	 * @param komentar - objekat iz kojeg se izvlace parametri za pretragu
	 * @return - vraca objekat Komentar ukoliko u bazi podataka postoji komentar
	 * koji ispunjava kriterijume pretrage, vraca null ukoliko isti ne postoji
	 */
	private Komentar postojeciKomentar(Komentar komentar) {
		Komentar postojeciKomentar = (Komentar) sessionFactory.getCurrentSession()
				.createCriteria(Komentar.class)
				.add(Restrictions.eq("sadrzaj", komentar.getSadrzaj()))
				.uniqueResult();
		return postojeciKomentar;
	}

}
