package kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	Result add (JobExperience jobExperience);
	
	DataResult<List<JobExperience>> getAll();
	

}
