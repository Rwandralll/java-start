package croissant.source.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import croissant.source.model.UserModel;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {
	
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public List<UserModel> getAllUser() {
		logger.info("getAllUser");
		return this.getAll(UserModel.class);
	}
	
	@Override
	public List<UserModel> getAllUserSQL() {
		logger.info("getAllUserSQL");
		return this.getSession().createSQLQuery("SELECT * FROM User").list();
	}


}
