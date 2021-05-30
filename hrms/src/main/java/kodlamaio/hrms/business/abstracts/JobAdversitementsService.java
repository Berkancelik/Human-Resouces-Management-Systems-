package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdversitements;

public interface JobAdversitementsService {
	
	Result add(JobAdversitements jobAdversitements);
	Result update(JobAdversitements jobAdversitements);
	Result delete(int id);
	Result changeOpentoClose(int id);
	DataResult<List<JobAdversitements>> getAll();
	DataResult<List<JobAdversitements>> getAllOpenJobAdvertisementsList();
	DataResult<List<JobAdversitements>> findAllOrderByPublishheadAt();
	DataResult<JobAdversitements> getById(int id);
	DataResult<List<JobAdversitements>> getAllOpenJobAdvertByEmployer(int id);

	

}
