package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	Result add(JobExperience jobExperience);
	Result update(JobExperience jobExperience);
	Result delete(int id);
	DataResult<JobExperience>getById(int id);
	DataResult<List<JobExperience>>  getAll();
	DataResult<List<JobExperience>>  getAllByCandidateId(int id);
	DataResult<List<JobExperience>>  getAllByCandidateIdOrderByDesc(int id);

	

}
 