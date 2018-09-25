package croissant.source.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import croissant.source.entryPoint.CalendarEventEntryPoint;

public class AbstractDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(AbstractDao.class);
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(final Class<T> type) {
		logger.info("getAll");
		return getSession().createCriteria(type).list();
	}
	
	public void saveOrUpdate(Object entity) {
		logger.info("saveOrUpdate");
		getSession().saveOrUpdate(entity);
	}
	
	public void delete(Object entity) {
		logger.info("delete");
		getSession().delete(entity);
	}

}
