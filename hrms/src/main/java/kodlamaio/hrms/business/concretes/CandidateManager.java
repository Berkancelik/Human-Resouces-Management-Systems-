package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.ResumeImageService;
import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

import kodlamaio.hrms.entities.dtos.CandidateResumeDto;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private EducationService educationService;
	private ResumeImageService resumeImageService;
	private ResumeLinkService resumeLinkService;
	private LanguageService languageService;
	private JobExperienceService jobExperienceService;
	private ResumeSkillService resumeSkillService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,EducationService educationService , ResumeImageService  resumeImageService ,ResumeLinkService  resumeLinkService ,
			ResumeSkillService resumeSkillService,LanguageService languageService, JobExperienceService jobExperienceService) {
		super();
		this.candidateDao = candidateDao;
		this.educationService = educationService;
		this.jobExperienceService = jobExperienceService; 
		this.languageService = languageService;
		this.resumeImageService = resumeImageService;
		this.resumeSkillService = resumeSkillService;
		this.resumeLinkService = resumeLinkService;
		
	}
	
	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş adayı başarılı bir şekilde eklendi!");
	
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
		
	}
	
	
	

	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş adayı başarılı bir şekilde güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.candidateDao.deleteById(id);
		return new SuccessResult("İş adayı başarılı bir şekilde silindi!");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	
	}

	@Override
	public DataResult<Candidate> getCandidateByNationalId(String nationalId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findCandidateByNationalId(nationalId));
	
	}

	@Override
	public DataResult<CandidateResumeDto> getCandidateCVById(int id) {
		CandidateResumeDto resume = new CandidateResumeDto();
		resume.jobExperiences = this.jobExperienceService.getAllByCandidateId(id).getData();
		resume.languages = this.languageService.getAllByCandidateId(id).getData();
		resume.image = this.resumeImageService.getByCandidateId(id).getData();
		resume.resumeLinks = this.resumeLinkService.getAllByCandidateId(id).getData();
		resume.educations = this.educationService.getAllByCandidateId(id).getData();
		resume.resumeSkills = this.resumeSkillService.getAllByCandidateId(id).getData();
		return new SuccessDataResult<CandidateResumeDto>(resume);
		
	}




}
