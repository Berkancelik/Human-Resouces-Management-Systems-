package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "verification_codes")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")

public class VerificationCode{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "is_verified")
	private boolean isVerified;

	

//	public boolean isVerified() {
//		return this.isVerified;
//	}

	// date eklenmeli :)

}
