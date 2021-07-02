package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {
private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Dil bilgisis başarıyla eklendi!");
		
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}

	@Override
	public DataResult<List<Education>> getByCandidateIdOrderByEndedDateDesc(int candidateId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getByCandidateIdOrderByEndedDateDesc(candidateId));
	}

	@Override
	public Result addAll(List<Education> education) {
		this.educationDao.saveAll(education);
		return new SuccessResult();
	}

	@Override
	public Result update(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("School updated");
	}
	
	
	@Override
	public DataResult<List<Education>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Education>>(educationDao.getAllByCandidateId(candidateId));
	}
	
	




}





