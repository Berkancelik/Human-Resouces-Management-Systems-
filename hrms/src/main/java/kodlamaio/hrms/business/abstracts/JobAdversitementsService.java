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
	DataResult<List<JobAdversitements>> getAllOpenJobAdversitementsList();
	DataResult<List<JobAdversitements>> findAllByOrderByPublishedAtDesc();
	DataResult<JobAdversitements> getById(int id);
	DataResult<List<JobAdversitements>> getAllOpenJobAdversitementsByEmployer(int id);

	

}
