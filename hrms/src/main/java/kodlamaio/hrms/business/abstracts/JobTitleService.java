package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle>getById(int id);	
	Result add(JobTitle jobTitle);
	Result delete(int id);
	Result update(JobTitle jobTitle);
	
	boolean existsJobTitleByJobTitle(String jobTitle);

}
