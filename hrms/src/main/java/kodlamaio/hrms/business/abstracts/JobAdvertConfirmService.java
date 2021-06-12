package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertConfirm;

public interface JobAdvertConfirmService {
	Result add(JobAdvertConfirm jobAdvertConfirm);
	DataResult<JobAdvertConfirm> getByJobadvertId(int jobAdvertId);
	DataResult<List<JobAdvertConfirm>> getAll();

}
