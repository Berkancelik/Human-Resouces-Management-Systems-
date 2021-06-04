package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resume_languages")
@NoArgsConstructor
@AllArgsConstructor
public class Language  extends Base  {

	
	@NotBlank(message="Boş Geçilemez!")
	@Min(value = 1 )
	@Max(value = 5)	
	@Column(name="level")
	private int level;
	
	@NotBlank(message="Boş Geçilemez!")
	@Column(name="language_name")
	private String languageName;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}
