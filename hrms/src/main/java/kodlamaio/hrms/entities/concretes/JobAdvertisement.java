package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "created_date")
	private LocalDateTime createdDate=LocalDateTime.now();

	@Column(name = "is_active",columnDefinition="boolean default true")
	private boolean isActive=true;
	
	@Column(name = "description")
	private String description;

	@Column(name = "open_title_count")
	private int openTitleCount;

	@Column(name = "deadline")
	private LocalDate deadline;

	@Column(name = "confirm_status",columnDefinition="boolean default false")
	private boolean confirmStatus=false;
	

	@Column(name = "salary_min")
	private int salaryMin;

	@Column(name = "salary_max")
	private int salaryMax;

	@Column(name = "published_at")
	private LocalDate publishedAt;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;

	@ManyToOne
	@JoinColumn(name = "work_hour_id")
	private WorkHour workHour;

	@ManyToOne()
	@JoinColumn(name = "job_work_type_id")
	private WorkType workType;
	
	@OneToMany(mappedBy = "candidate")
	private List<CandidateJobAdvertisementFavorite> CandidateJobAdvertisementFavorites;
	
	

}