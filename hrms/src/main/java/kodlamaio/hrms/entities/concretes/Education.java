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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_educations")
public class Education {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")	
	private int id;
	
	@JsonIgnore
	@Column(name= "created_date")
	private LocalDate createdDate = LocalDate.now();
	
	@JsonIgnore
	@Column(name= "is_active")
	private boolean isActive = true;
	

	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "started_date")
	private LocalDate startedDate;
	
	@Column(name = "ended_date", nullable = true)
	private LocalDate endedDate;

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}
