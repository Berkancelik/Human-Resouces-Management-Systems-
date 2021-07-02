package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.LetterOfAcceptanceService;
import kodlamaio.hrms.business.abstracts.ResumeImageService;
import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.ResumeDto;


@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserDao userDao;
	private EducationService educationService;
	private JobExperienceService jobExperienceService;
	private ResumeImageService resumeImageService;
	private LanguageService languageService;
	private ResumeSkillService resumeSkillService;
	private ResumeLinkService resumeLinkService;
	private LetterOfAcceptanceService letterOfAcceptanceService;

	@Autowired
	CandidateManager(CandidateDao candidateDao, UserDao userDao, EducationService educationService,JobExperienceService jobExperienceService,
			ResumeImageService resumeImageService,LanguageService languageService, ResumeSkillService resumeSkillService,
			ResumeLinkService resumeLinkService, LetterOfAcceptanceService letterOfAcceptanceService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
	
		this.educationService = educationService;
		this.jobExperienceService = jobExperienceService;
		this.resumeImageService = resumeImageService;
		this.languageService = languageService;
		this.resumeLinkService = resumeLinkService;
		this.resumeSkillService = resumeSkillService;
		this.letterOfAcceptanceService=letterOfAcceptanceService;

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
	public DataResult<Candidate> getCandidateByNationalId(String nationalId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findCandidateByNationalId(nationalId));

	}

	

	@Override
	public DataResult<ResumeDto> getCandidateResumeByCandidateId(int candidateId) {
		
		ResumeDto resumeDto=new ResumeDto();
		resumeDto.setCandidate(this.candidateDao.findById(candidateId).get());
		resumeDto.setResumeImage(this.resumeImageService.getAllByCandidateId(candidateId).getData());
		resumeDto.setLanguages(this.languageService.getAllByCandidateId(candidateId).getData());
		resumeDto.setJobExperiences(this.jobExperienceService.getAllByCandidateId(candidateId).getData());
		resumeDto.setEducations(this.educationService.getAllByCandidateId(candidateId).getData());
		resumeDto.setResumeSkills(this.resumeSkillService.getAllByCandidateId(candidateId).getData());
		resumeDto.setResumeLinks(this.resumeLinkService.getAllByCandidateId(candidateId).getData());
		resumeDto.setLetterOfAcceptances(this.letterOfAcceptanceService.getAllByCandidateId(candidateId).getData());
		return new SuccessDataResult<ResumeDto>(resumeDto,"Resume listed.");
	}

}
