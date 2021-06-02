package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resume_experiences")
public class JobExperience {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")	
	private int id;
	
	@JsonIgnore
	@Column(name= "created_at")
	private LocalDate createdAt = LocalDate.now();
	
	@JsonIgnore
	@Column(name= "is_active")
	private boolean isActive = true;
	
	@JsonIgnore
	@Column(name= "is_deleted")
	private boolean isDeleted = false;
	
	@Column(name= "ended_date")
	private LocalDate endedDate;
	
	@Column(name= "started_date")
	private LocalDate startedDate;
	
	@Column(name= "company_name")
	private String compnayName;
	
	@Column(name= "position")
	private String position;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
}
 