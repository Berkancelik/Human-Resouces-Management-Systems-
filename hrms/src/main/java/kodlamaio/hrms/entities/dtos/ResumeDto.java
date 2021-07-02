package kodlamaio.hrms.entities.dtos;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.LetterOfAcceptance;
import kodlamaio.hrms.entities.concretes.ResumeImage;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
	@JsonIgnore()
	private Candidate candidate;
	private List<@Valid Education> educations;
	private List<@Valid Language> languages;
	private List<@Valid JobExperience> jobExperiences;
	private List<@Valid ResumeLink> resumeLinks;
	private List<@Valid ResumeSkill> resumeSkills;
	private List<@Valid ResumeImage> resumeImage;
	private List<LetterOfAcceptance> letterOfAcceptances;
}