package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationForCandidateAddDto;

@Service
public class EducationManager implements EducationService {
	private EducationDao educationDao;
	private CandidateDao candidateDao;

	@Autowired
	public EducationManager(EducationDao educationDao, CandidateDao candidateDao) {
		super();
		this.educationDao = educationDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(EducationForCandidateAddDto educationForCandidateAddDto) {

		if (!this.candidateDao.existsById(educationForCandidateAddDto.getCandidateId())) {
			return new ErrorResult("Böyle bir kullanıcı  yok");
		} else if (educationForCandidateAddDto.getSchoolName().length() <= 2) {
			return new ErrorResult("Okul adı 2 karakterden uzun olmalıdır");
		} else if (educationForCandidateAddDto.getDepartment().length() <= 2) {
			return new ErrorResult("Bölüm adı 2 karakterden uzun olmalıdır");
		} else if (educationForCandidateAddDto.getStartedDate() == null) {
			return new ErrorResult("Başlangıç tarihi boş birakılamaz");
		}

		Education education = new Education();
		education.setCandidate(this.candidateDao.getById(educationForCandidateAddDto.getCandidateId()));
		education.setSchoolName(educationForCandidateAddDto.getSchoolName());
		education.setDepartment(educationForCandidateAddDto.getDepartment());
		education.setStartedDate(educationForCandidateAddDto.getStartedDate());
		education.setEndedDate(educationForCandidateAddDto.getEndedDate());

		this.educationDao.save(education);
		return new SuccessResult("Okul eklendi");
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
	public DataResult<List<Education>> getAllByJobseekerIdOrderByEndedDateDesc(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getAllByCandidate_idOrderByEndedDateDesc(id));

	}

	@Override
	public DataResult<List<Education>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getAllByCandidate_id(id));

	}

}
