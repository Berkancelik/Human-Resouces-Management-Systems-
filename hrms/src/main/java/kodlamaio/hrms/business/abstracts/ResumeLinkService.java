package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLink;

public interface ResumeLinkService {
	Result add(ResumeLink resumeLink);
	Result update(ResumeLink resumeLink);
	DataResult<List<ResumeLink>> getAll();
	Result addAll(List<ResumeLink> resumeLink);
    DataResult<List<ResumeLink>> getAllByCandidateId(int candidateId);
}
