package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resume_work_experiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "resume_id")
	private Resume resumeId;
	
	@Column(name = "company_name")

	private String companyName;

	@ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "job_title_id", referencedColumnName = "id", nullable = false)
	private JobTitle jobTitle;		
	
	@NotBlank(message = "Boş geçilemez!")
	@Column(name = "started_date")
	private Date startedDate;
	
	@Column(name = "ended_date")
	private Date endedDate;
	
	@Column(name = "created_date")
	private Date createdDate;

}
 