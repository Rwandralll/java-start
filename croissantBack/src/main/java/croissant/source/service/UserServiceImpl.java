package croissant.source.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import croissant.source.dao.UserDao;
import croissant.source.model.UserModel;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	private static final Logger logger = Logger.getLogger(CalendarEventServiceImpl.class);

	@Override
	public List<UserModel> getAllUser() {
		logger.info("getAllUser");
		return userDao.getAllUser();
	}

}
