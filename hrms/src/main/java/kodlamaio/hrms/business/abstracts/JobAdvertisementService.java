package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementFilter;

public interface JobAdvertisementService {	

	Result add(JobAdvertisementDto jobAdvertisementDto);

	Result updateIsConfirm(boolean isConfirm, int id);

	Result updateIsActive(boolean isActive, int userId, int id);
	
	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getByIsConfirm(boolean isConfirm);

	DataResult<List<JobAdvertisement>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, int pageNo,int pageSize);
	DataResult<List<JobAdvertisement>> sortByReleaseDate();

	DataResult<List<JobAdvertisement>> getByCompanyName(String companyName);
	
	DataResult<JobAdvertisement> getById(int id);

	DataResult<List<JobAdvertisement>> getByFilter(JobAdvertisementFilter jobAdvertisementFilter, int pageNo, int pageSize);


	

}
