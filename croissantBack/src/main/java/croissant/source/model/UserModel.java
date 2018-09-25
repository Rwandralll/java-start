package croissant.source.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserModel {
	
	@Id
	@GeneratedValue
	@Column(name = "idUser")
	private Integer userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "username")
	private String username;

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", name=" + name + ", surname="
				+ surname + ", password=" + password + ", username=" + username
				+ "]";
	}

}
