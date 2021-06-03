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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="educations")
public class Education {
	

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
	

	@Column(name = "name")
	private String schoolName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "started_date")
	private LocalDate startAt;
	
	@Column(name = "ended_date", nullable = true)
	private LocalDate endAt;

	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private Candidate candidate;

}
