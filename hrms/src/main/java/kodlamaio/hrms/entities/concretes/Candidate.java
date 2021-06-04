package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {

	@NotBlank(message="Boş Geçilemez!")
	@Column(name= "first_name")
	private String firstName;
	
	@NotBlank(message="Boş Geçilemez!")
	@Column(name= "last_name")
	private String lastName;	
	
	@NotBlank(message="Boş Geçilemez!")
	@Column(name= "nationality_id")
	private String nationalId;

	@NotBlank(message="Boş Geçilemez!")
	@Column(name= "date_of_birth")
	private Date dateOfBirth;
	
	
	@Column(name = "is_verified")
	private boolean isVerified = false;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Education> educations;
	
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
	@OneToOne(mappedBy = "candidate",optional = false, fetch = FetchType.LAZY)
	private ResumeImage image;

}
 