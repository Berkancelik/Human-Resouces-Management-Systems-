package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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

public class VerificationCode{
	@Id
	@GeneratedValue()
	@Column(name="id")
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	private int userId;
	
	@Column(name = "created _at", columnDefinition =  "date default current_date")
	private LocalDate createdAt = LocalDate.now();
	
	
	///
	



}
