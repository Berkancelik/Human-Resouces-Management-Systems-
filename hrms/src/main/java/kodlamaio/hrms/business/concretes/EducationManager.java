package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationForCandidateAddDto;

@Service
public class EducationManager implements EducationService {
	private EducationDao educationDao;
	private ResumeDao resumeDao;

	@Autowired
	public EducationManager(EducationDao educationDao, ResumeDao resumeDao) {
		super();
		this.educationDao = educationDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(EducationForCandidateAddDto educationForCandidateAddDto) {
		Education education = new Education();
		education.setId(0);
		education.setResume(
				this.resumeDao.getById(educationForCandidateAddDto.getResumeId()));
		education.setSchoolName(educationForCandidateAddDto.getSchoolName());
		education.setDepartment(educationForCandidateAddDto.getDepartment());
		education.setStartedDate(educationForCandidateAddDto.getStartedDate());
		education.setEndedDate(educationForCandidateAddDto.getEndedDate());

		this.educationDao.save(education);
		return new SuccessResult("Eğitim durumu eklendi");
	}

	@Override
	public Result update(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Okul bilgisi başarıyla güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.educationDao.deleteById(id);
		return new SuccessResult("Okul bilgisi başarıyla silindi!");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());

	}

	@Override
	public DataResult<Education> getById(int id) {
		return new SuccessDataResult<Education>(this.educationDao.getById(id));

	}


	@Override
	public DataResult<List<Education>> sortByEndYearOfEducation() {
		Sort sort = Sort.by(Sort.Direction.DESC, "endYearOfEducation");
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(sort));
	}





}
