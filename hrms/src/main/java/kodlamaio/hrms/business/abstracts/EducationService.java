package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import java.util.List;


import kodlamaio.hrms.entities.concretes.Education;

public interface EducationService {
	Result add (Education education);
	
	DataResult<List<Education>> getAll();
	

}
