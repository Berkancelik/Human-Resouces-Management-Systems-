package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.JobExperienceForCandidateDto;

@Service
public class JobExperienceManager implements JobExperienceService {
	JobExperienceDao jobExperienceDao;
	ResumeDao resumeDao;
	JobTitleDao jobTitleDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, CandidateDao candidateDao,ResumeDao resumeDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.resumeDao = resumeDao;
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public Result add(JobExperienceForCandidateDto jobExperienceForCandidateDto) {
		JobExperience jobExperience = new JobExperience();
		jobExperience.setId(0);
		jobExperience.setResumes(
				this.resumeDao.getById(jobExperienceForCandidateDto.getId()));
		jobExperience.setCompnayName(jobExperienceForCandidateDto.getCompanyName());
		jobExperience.setJobTitles(this.jobTitleDao.getById(jobExperienceForCandidateDto.getResumeId()));
		jobExperience.setStartedDate(jobExperienceForCandidateDto.getStartedDate());
		jobExperience.setEndedDate(jobExperienceForCandidateDto.getStartedDate());
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş tecrübesi eklendi");
	}

	@Override
	public Result update(JobExperienceForCandidateDto jobExperienceForCandidateDto) {
		JobExperience jobExperienceUpdate = this.jobExperienceDao
				.getById(jobExperienceForCandidateDto.getId());
		jobExperienceUpdate.setCompnayName(jobExperienceForCandidateDto.getCompanyName());
		jobExperienceUpdate
				.setJobTitles(this.jobTitleDao.getById(jobExperienceForCandidateDto.getResumeId()));
		jobExperienceUpdate.setStartedDate(jobExperienceForCandidateDto.getStartedDate());
		jobExperienceUpdate.setEndedDate(jobExperienceForCandidateDto.getEndedDate());
		this.jobExperienceDao.save(jobExperienceUpdate);
		return new SuccessResult("İş deneyimi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("İş deneyimi silindi");
	}



	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}

	

	@Override
	public DataResult<List<JobExperience>> getAllByCandidateIdOrderByDesc(int id) {
		return new SuccessDataResult<List<JobExperience>>(
				this.jobExperienceDao.getAllByCandidate_idOrderByEndedDateDesc(id));
	}


}
