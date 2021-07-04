  
package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
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
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkHourDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementFilter;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class JobAdvertisementsManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvertisementDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobTitleDao jobTitleDao;
	private WorkTypeDao workTypeDao;
	private WorkHourDao workHourDao;

	@Autowired
	public JobAdvertisementsManager(JobAdvertisementDao jobAdvertisementDao, CityDao cityDao, EmployerDao employerDao,
			JobTitleDao jobTitleDao, WorkTypeDao workTypeDao, WorkHourDao workHourDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobTitleDao = jobTitleDao;
		this.workTypeDao = workTypeDao;
		this.workHourDao = workHourDao;
	}

	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setId(0);
		jobAdvertisement.setDescription(jobAdvertisementDto.getDescription());
		jobAdvertisement.setSalaryMin(jobAdvertisementDto.getSalaryMin());
		jobAdvertisement.setSalaryMax(jobAdvertisementDto.getSalaryMax());
		jobAdvertisement.setOpenTitleCount(jobAdvertisementDto.getOpenTitleCount());
		jobAdvertisement.setPublishedAt(LocalDate.now());

		jobAdvertisement.setDeadline(jobAdvertisementDto.getDeadline());
		jobAdvertisement.setActive(true);
		jobAdvertisement.setConfirm(false);
		jobAdvertisement.setEmployer(this.employerDao.getById(jobAdvertisementDto.getEmployerId()));
		jobAdvertisement.setJobTitle(this.jobTitleDao.getById(jobAdvertisementDto.getJobTitleId()));
		jobAdvertisement.setCity(this.cityDao.getById(jobAdvertisementDto.getCityId()));
		jobAdvertisement.setWorkType(this.workTypeDao.getById(jobAdvertisementDto.getWorkTypeId()));
		jobAdvertisement.setWorkHour(this.workHourDao.getById(jobAdvertisementDto.getWorkHourId()));
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilani başarı şekilde eklendi");

	}

	@Override
	public DataResult<List<JobAdvertisement>> sortByReleaseDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "releaseDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),
				"Yayın tarihine göre artan olarak listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByEmployer_CompanyName(companyName),
				"Şirket adına göre iş ilanları listelendi");
	}

	@Override
	public Result updateIsActive(boolean isActive, int userId, int id) {
		this.jobAdvertisementDao.updateIsActive(isActive, id);
		return new SuccessResult("İş ilanı aktiflik durumu güncellendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsConfirm(boolean isConfirm) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsConfirm(isConfirm));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, int pageNo,
			int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsConfirmAndIsActive(isConfirm, isActive, pageable).getContent(),
				this.jobAdvertisementDao.getByIsConfirmAndIsActive(isConfirm, isActive, pageable).getTotalPages() + "");
	}
	@Override
	public Result updateIsConfirm(boolean isConfirm, int id) {
		this.jobAdvertisementDao.updateIsConfirm(isConfirm, id);
		return new SuccessResult("İş ilanı onaylandı");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				"İş ilanları listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByFilter(JobAdvertisementFilter jobAdvertisementFilter, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByFilter(jobAdvertisementFilter, pageable).getContent(),
				this.jobAdvertisementDao.getByFilter(jobAdvertisementFilter, pageable).getTotalPages() + "");
	}

}