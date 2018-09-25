package croissant.source.dao;

import java.util.List;

import croissant.source.model.UserModel;

public interface UserDao {
	
	public List<UserModel> getAllUser();
	
	public List<UserModel> getAllUserSQL();

}
