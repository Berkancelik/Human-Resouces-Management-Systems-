package kodlamaio.hrms.business.abstracts;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.LetterOfAcceptance;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Education> educations;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeSkill> resumeSkills;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeLink> links;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;

	@JsonIgnore
	@OneToOne(mappedBy = "resume")
	private LetterOfAcceptance letterOfAcceptance;

	
	
	@JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
	@ManyToOne()
	private Candidate candidate;

	public Resume(int id) {
		super();
		this.id = id;

	}
}