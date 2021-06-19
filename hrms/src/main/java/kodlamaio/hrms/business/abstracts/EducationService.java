package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import java.util.List;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationForCandidateAddDto;

public interface EducationService {
	public Result add(EducationForCandidateAddDto educationForCandidateAddDto);

	Result update(Education education);

	Result delete(int id);

	DataResult<List<Education>> getAll();

	DataResult<Education> getById(int id);

	DataResult<List<Education>> getAllByJobseekerIdOrderByEndedDateDesc(int id);

	DataResult<List<Education>> getAllByCandidateId(int id);

}
