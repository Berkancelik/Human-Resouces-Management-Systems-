package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdversitementsService {
	
	Result add(JobAdvertisement jobAdversitements);
	Result update(JobAdvertisement jobAdversitements);
	Result delete(int id);
	Result changeOpentoClose(int id);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllOpenJobAdversitementsList();
	DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAtDesc();
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>> getAllOpenJobAdversitementsByEmployer(int id);

	

}
