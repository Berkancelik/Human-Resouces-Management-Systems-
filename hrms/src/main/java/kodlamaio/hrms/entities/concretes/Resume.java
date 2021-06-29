package kodlamaio.hrms.entities.concretes;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

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

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<CandidateJobAdvertisementFavorite> candidateJobAdvertisementFavorite;
	
	@JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
	@ManyToOne()
	private Candidate candidate;

	
	public Resume(int id) {
		super();
		this.id = id;

	}
}