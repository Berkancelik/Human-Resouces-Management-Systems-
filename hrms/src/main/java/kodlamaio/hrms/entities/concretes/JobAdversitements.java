package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adversitements")
public class JobAdversitements {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id;

	
	@Column(name = "description")
	private String description;
	
	@Column(name = "open_title_count")
	private int openTitleCount;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "is_open")
	private boolean isOpen;
	

	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "salary_max")
	private int salaryMax;
	
	@Column(name = "published_at")
	private LocalDate publishedAt;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	

}
