package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {	

	Result add(JobAdvertisementDto jobAdvertisementDto);

	Result updateIsConfirm(boolean isConfirm, int id);

	Result updateIsActive(boolean isActive, int userId, int id);
	
	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getByIsConfirm(boolean isConfirm);

	DataResult<List<JobAdvertisement>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);

	DataResult<List<JobAdvertisement>> sortByReleaseDate();

	DataResult<List<JobAdvertisement>> getByCompanyName(String companyName);
	
	DataResult<JobAdvertisement> getByJobAdvertisementId(int id);


	

}
