package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		jobAdvertisement.setSalaryMin(jobAdvertisementDto.getMinSalary());
		jobAdvertisement.setOpenTitleCount(jobAdvertisementDto.getOpenTitleCount());
		jobAdvertisement.setEmployer(this.employerDao.getById(jobAdvertisementDto.getEmployerId()));
		jobAdvertisement.setDeadline(jobAdvertisementDto.getDeadLine());
		jobAdvertisement.setWorkHour(this.workHourDao.getById(jobAdvertisementDto.getWorkHourId()));
		jobAdvertisement.setWorkType(this.workTypeDao.getById(jobAdvertisementDto.getWorkTypeId()));
		jobAdvertisement.setDescription(jobAdvertisementDto.getDescription());
		jobAdvertisement.setSalaryMax(jobAdvertisementDto.getMaxSalary());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("başarı şekilde eklendi");

	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı başarılı şekilde güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("İş ilanı başarılı şekilde silindi");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getOne(id));

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllOpenJobAdvertisementList());

	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAt() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByOrderByPublishedAtDesc());

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllOpenJobAdvertisementByEmployer(id));

	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsActiveByEmployee()); 
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByEmployerId(employerId),
				"İşveren id ile getirildi");
	}

	@Override
	public Result changeIsActiveByEmployee(int jobAdverttisementId) {
		JobAdvertisement jobAdvertisementIsActiveEmployee= this.jobAdvertisementDao.getById(jobAdverttisementId);
		jobAdvertisementIsActiveEmployee.setActive(!jobAdvertisementIsActiveEmployee.isActive());
		this.jobAdvertisementDao.save(jobAdvertisementIsActiveEmployee);
		return new SuccessResult("İş ilanının admin tarafından aktifliği değiştirildi");
	}

	@Override
	public Result changeIsOpenByEmployer(int jobAdverttisementId) {
		JobAdvertisement jobAdvertToChangeIsOpen =this.jobAdvertisementDao.getById(jobAdverttisementId);
		jobAdvertToChangeIsOpen.setOpen(!jobAdvertToChangeIsOpen.isOpen());
		this.jobAdvertisementDao.save(jobAdvertToChangeIsOpen);
		return new SuccessResult("İş ilanı iş veren taraqfından aktif edildi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee_False() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsActiveByEmployee_False()) ;
	}

}
