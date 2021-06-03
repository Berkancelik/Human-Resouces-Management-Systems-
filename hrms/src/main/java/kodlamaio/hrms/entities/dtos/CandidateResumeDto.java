package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.ResumeImage;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.concretes.ResumeSkill;

public class CandidateResumeDto {
	
	public Candidate candidate;
	public List<Education> educations;
	public List<ResumeSkill> resumeSkills;
	public List<ResumeLink> resumeLinks;
	public List<JobExperience> jobExperiences;
	public List<Language> languages;
	public ResumeImage image;

}
