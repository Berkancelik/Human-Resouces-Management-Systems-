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
	DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementList();
	DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAt();
	DataResult<List<JobAdvertisement>> getAllOpenJobAdvertisementByEmployer(int id);	
	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
	Result changeIsActiveByEmployee(int jobAdverttisementId);	
	Result changeIsOpenByEmployer(int jobAdverttisementId);	
	DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee_False();
	DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee();
	

	

}
