package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_titles")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyIntilazier","handler","jobAdversitements"})
public class JobTitle extends Base {


	@Column(name = "title")
	private String jobTitle;
	


	@OneToMany(mappedBy = "jobTitle")
	private List<JobAdversitements> jobAdversitements;
	
	public JobTitle(String title, List<JobAdversitements> jobAdversitements) {
		super();
		this.jobTitle = title;
		this.jobAdversitements = jobAdversitements;
	} 
	
	


}
