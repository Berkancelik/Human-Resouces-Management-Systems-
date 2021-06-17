package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisementDto JobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(int id);
	
	DataResult<JobAdvertisement> getById(int id);	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllOpenJobAdvertList();
	DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAt();
	DataResult<List<JobAdvertisement>> getAllOpenJobAdvertByEmployer(int id);
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee();
	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
	Result changeIsActiveByEmployee(int jobAdverttisementId);
	
	Result changeIsOpenByEmployer(int jobAdverttisementId);
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee_False();
	

	

}
