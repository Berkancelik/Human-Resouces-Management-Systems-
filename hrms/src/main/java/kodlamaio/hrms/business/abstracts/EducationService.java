package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import java.util.List;
import kodlamaio.hrms.entities.concretes.Education;

public interface EducationService {
	Result add(Education education);
	
	Result update(Education education);
	
	DataResult<List<Education>> getAll();
	
	Result addAll(List<Education> education);
	
	DataResult<List<Education>> getAllByCandidateId(int candidateId);
	
	DataResult<List<Education>> getByCandidateIdOrderByEndedDateDesc(int candidateId);




}
