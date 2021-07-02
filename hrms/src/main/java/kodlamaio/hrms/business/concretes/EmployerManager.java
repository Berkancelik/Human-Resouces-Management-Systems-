package kodlamaio.hrms.business.concretes;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.ThreadUtils.ThreadIdPredicate;

import kodlamaio.hrms.business.abstracts.EmployerService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private ObjectMapper objectMapper;
	
	@Autowired
	 public EmployerManager(EmployerDao employerDao,ObjectMapper objectMapper) {
		this.employerDao = employerDao;
		this.objectMapper=objectMapper;

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());

	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("işveren başarılı şekilde eklendi!");
	}


	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id).get());
	}

	@Override
	public Result updateWaiting(Employer employer) {
		Employer employerToConfirmUpdate = this.getById(employer.getId()).getData();
		Employer tempEmployer = this.objectMapper.convertValue(employerToConfirmUpdate.getEmployerUpdate(), Employer.class);
		tempEmployer.setEmployerUpdate(null);
		this.employerDao.save(tempEmployer);
		return new SuccessResult("Employer confirmed");
	}

	@Override
	public Result updateConfirmStatus(int employerId) {
		Employer employerToConfirmUpdate = this.getById(employerId).getData();
		Employer tempEmployer = this.objectMapper.convertValue(employerToConfirmUpdate.getEmployerUpdate(), Employer.class);
		tempEmployer.setEmployerUpdate(null);
		this.employerDao.save(tempEmployer);
		return new SuccessResult("Employer confirmed");
	}

	@Override
	public DataResult<List<Employer>> getByConfirmStatusFalse() {
		return new SuccessDataResult<List<Employer>>(employerDao.getByConfirmStatusFalse());

	}


	
	

}
