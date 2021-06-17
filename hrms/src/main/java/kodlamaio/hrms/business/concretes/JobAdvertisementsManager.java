package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdversitementsService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertConfirmDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkHourDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementsManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvertisementDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobTitleDao jobTitleDao;
	private WorkTypeDao workTypeDao;
	private WorkHourDao workHourDao;
	private JobAdvertConfirmDao jobAdvertConfirmDao;

	@Autowired
	public JobAdvertisementsManager(JobAdvertisementDao jobAdvertisementDao, CityDao cityDao, EmployerDao employerDao,
			JobTitleDao jobTitleDao, WorkTypeDao workTypeDao, WorkHourDao workHourDao,
			JobAdvertConfirmDao jobAdvertConfirmDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobTitleDao = jobTitleDao;
		this.workTypeDao = workTypeDao;
		this.workHourDao = workHourDao;
		this.jobAdvertConfirmDao = jobAdvertConfirmDao;
	}
	

	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setCity(this.cityDao.getById(jobAdvertisementDto.getCityId()));
		jobAdvertisement.setJobTitle(this.jobTitleDao.getById(jobAdvertisementDto.getJobTitleId()));
		jobAdvertisement.setWorkHour(this.workHourDao.getById(jobAdvertisementDto.getWorkHourId()));
		jobAdvertisement.setWorkType(this.workTypeDao.getById(jobAdvertisementDto.getWorkTypeId()));
		jobAdvertisement.setDescription(jobAdvertisementDto.getDescription());
		jobAdvertisement.setSalaryMax(jobAdvertisementDto.getMaxSalary());
		jobAdvertisement.setSalaryMin(jobAdvertisementDto.getMinSalary());
		jobAdvertisement.setOpenTitleCount(jobAdvertisementDto.getOpenTitleCount());
		jobAdvertisement.setEmployer(this.employerDao.getById(jobAdvertisementDto.getEmployerId()));
		jobAdvertisement.setDeadline(jobAdvertisementDto.getDeadLine());
	
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		//JobAdvertConfirmation jobAdvertConfirmation = new JobAdvertConfirmation();
		return new SuccessResult("başarı ile eklendi");
	
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertByEmployer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result changeIsActiveByEmployee(int jobAdverttisementId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result changeIsOpenByEmployer(int jobAdverttisementId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee_False() {
		// TODO Auto-generated method stub
		return null;
	}





}
