package kodlamaio.hrms.entities.concretes;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_educations")
public class Education extends Base {
	

	

	@Column(name = "school_name")
	private String schoolName;
	
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "started_date")
	private Date startedDate;
	
	@Column(name = "ended_date", nullable = true)
	private Date endedDate;
	
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}
