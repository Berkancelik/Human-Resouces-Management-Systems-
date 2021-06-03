package kodlamaio.hrms.entities.concretes;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@NoArgsConstructor


public class User extends Base {
 
	
	@Column(name= "email_address")
	private String email;
	
	@Column(name= "password")
	private String password;
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	


}
