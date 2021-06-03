package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLink;

public interface ResumeLinkService {
	Result add(ResumeLink eesumeLink);
	Result update(ResumeLink eesumeLink);
	Result delete(int id);
	DataResult<ResumeLink> getById(int id);	
	DataResult<List<ResumeLink>> getAllByCandidateId(int id);
	DataResult<List<ResumeLink>> getAll();
	

}
