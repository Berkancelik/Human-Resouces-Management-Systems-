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
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.JobExperienceForCandidateDto;

@Service
public class JobExperienceManager implements JobExperienceService {
	JobExperienceDao jobExperienceDao;
	CandidateDao candidateDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, CandidateDao candidateDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.candidateDao = candidateDao;
	}

	@Override
	  public Result add(JobExperienceForCandidateDto jobExperienceForCandidateDto) {

        if(!this.candidateDao.existsById(jobExperienceForCandidateDto.getCandidateId())){
            return new ErrorResult("Böyle bir cv yok");
        }else if(jobExperienceForCandidateDto.getCompanyName().length()<=2){
            return new ErrorResult("Şirket adı 2 karakterden uzun olmalıdır");
        }else if(jobExperienceForCandidateDto.getPosition().length()<=2){
            return new ErrorResult("Pozisyon adı 2 karakterden uzun olmalıdır");
        }else if(jobExperienceForCandidateDto.getStartedDate() == null){
            return new ErrorResult("Başlangıç tarihi boş bırakılamaz");
        }

        JobExperience jobExperience=new JobExperience();
        jobExperience.setCandidate(this.candidateDao.getById(jobExperienceForCandidateDto.getCandidateId()));
        jobExperience.setCompnayName(jobExperienceForCandidateDto.getCompanyName());
        jobExperience.setPosition(jobExperienceForCandidateDto.getPosition());
        jobExperience.setStartedDate(jobExperienceForCandidateDto.getStartedDate());
        jobExperience.setEndedDate(jobExperienceForCandidateDto.getEndedDate());
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Kaydedildi");
    }
	@Override
	public Result update(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş deneyimi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("İş deneyimi silindi");
	}

	@Override
	public DataResult<JobExperience> getById(int id) {
		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.getById(id));

	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<JobExperience>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllByCandidate_id(id));

	}

	@Override
	public DataResult<List<JobExperience>> getAllByCandidateIdOrderByDesc(int id) {
		return new SuccessDataResult<List<JobExperience>>(
				this.jobExperienceDao.getAllByCandidate_idOrderByEndedDateDesc(id));
	}

}
