package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceForCandidateDto;

public interface JobExperienceService {
	
	Result add(JobExperienceForCandidateDto jobExperienceForCandidateDto);

	Result update(JobExperienceForCandidateDto jobExperienceForCandidateDto);

	Result delete(int id);

	DataResult<List<JobExperience>> getAll();

	DataResult<List<JobExperience>>  sortByJobEndYear();


	

}
 