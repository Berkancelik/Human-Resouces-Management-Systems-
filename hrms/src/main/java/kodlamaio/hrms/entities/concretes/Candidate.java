package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate extends User {



	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	
	
	@Column(name= "national_id")
	private String nationalId;
	
	@Column(name= "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Education> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ResumeSkill> programingSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<ResumeLink> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<LetterOfAcceptance> coverLetters;	

	@JsonIgnore
	@OneToOne(mappedBy = "candidate", optional=false, fetch=FetchType.LAZY)
	private ResumeImage image;

}
 