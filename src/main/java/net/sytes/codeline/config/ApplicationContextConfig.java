package net.sytes.codeline.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.sytes.codeline.dao.KorisnikDao;
import net.sytes.codeline.dao.KorisnikDaoImpl;
import net.sytes.codeline.dao.PredmetDao;
import net.sytes.codeline.dao.PredmetDaoImpl;
import net.sytes.codeline.dao.PredmetKorisnikaDao;
import net.sytes.codeline.dao.PredmetKorisnikaDaoImpl;
import net.sytes.codeline.dao.RolaDao;
import net.sytes.codeline.dao.RolaDaoImpl;
import net.sytes.codeline.dao.TemaDao;
import net.sytes.codeline.dao.TemaDaoImpl;
import net.sytes.codeline.entities.Korisnik;
import net.sytes.codeline.entities.Predmet;
import net.sytes.codeline.entities.PredmetKorisnika;
import net.sytes.codeline.entities.Rola;
import net.sytes.codeline.entities.Tema;

/**
 * @author Dusan Nesic
 * Spring config class
 * Defines database connections, and sessionFactory
 * along with bean definitions
 */
@Configuration
@ComponentScan("net.sytes.codeline")
@EnableTransactionManagement
public class ApplicationContextConfig {

	/**
	 * Method getDataSource
	 * Defines the database, driver usage, and connection credentials
	 * 
	 * @return - DataSource - database info
	 */
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/elearningforum");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.addConnectionProperty("useUnicode", "yes");
		dataSource.addConnectionProperty("characterEncoding", "UTF-8");
		return dataSource;
	}
	
	/**
	 * Method getSessionFactory
	 * Defines SessionFactory, and which entities are used as beans
	 * 
	 * @param dataSource - specifies which database is used
	 * @return - SessionFactory - preset sessionFactory
	 */
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClasses(Korisnik.class, Rola.class, Predmet.class
				, PredmetKorisnika.class, Tema.class);
		sessionBuilder.addProperties(getHibernateProperties());
		
		return sessionBuilder.buildSessionFactory();
	}
	
	/**
	 * Method getHibernateProperties
	 * Returns Properties out of hibernate properties
	 * 
	 * @return - Properties - preset Properties
	 */
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		return properties;
	}
	
	/**
	 * Method getTransactionManager
	 * Setting up the TransactionManager
	 * 
	 * @param sessionFactory - passing the already defined SessionFactory
	 * @return - HibernateTransactionManager - preset component
	 */
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="korisnikDao")
	public KorisnikDao getKorisnikDao(SessionFactory sessionFactory) {
		return new KorisnikDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="rolaDao")
	public RolaDao getRolaDao(SessionFactory sessionFactory) {
		return new RolaDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="predmetDao")
	public PredmetDao getPredmetDao(SessionFactory sessionFactory) {
		return new PredmetDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="predmetKorisnikaDao")
	public PredmetKorisnikaDao getPredmetKorisnikaDao(SessionFactory sessionFactory) {
		return new PredmetKorisnikaDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="temaDao")
	public TemaDao getTemaDao(SessionFactory sessionFactory) {
		return new TemaDaoImpl(sessionFactory);
	}
}
