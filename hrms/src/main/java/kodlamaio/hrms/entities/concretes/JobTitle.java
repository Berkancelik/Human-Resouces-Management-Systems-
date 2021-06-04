package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_titles")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyIntilazier","handler","jobAdversitements"})

public class JobTitle   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@JsonIgnore
	@Column(name= "created_date", columnDefinition = "Date defult CURRENT_DATE")
	private LocalDate createdDate = LocalDate.now();

	
	@JsonIgnore
	@Column(name= "is_active")
	private boolean isActive = true;


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
