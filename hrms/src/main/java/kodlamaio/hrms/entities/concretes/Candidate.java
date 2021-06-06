package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

	
	@JsonIgnore
	@Column(name= "created_date", columnDefinition = "Date defult CURRENT_DATE")
	private LocalDate createdDate = LocalDate.now();

	
	@JsonIgnore
	@Column(name= "is_active")
	private boolean isActive = true;

	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;	
	
	@Column(name= "nationality_id")
	private String nationalId;

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
	@OneToOne(mappedBy = "candidate")
	private ResumeImage image;

}
 