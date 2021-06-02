package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message="TC Kimlik Numarası Alanı Boş Olamaz!") 
	@Size(min = 11, max=11, message = "TC Kimlik No 11 hane olmalıdır!")
	@Column(name = "nationality_id")
	private String nationalId;
	
	@NotBlank(message="Doğum yılı bpş bırakılamaz") 
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "is_verified")
	private boolean isVerified = false;

}
 