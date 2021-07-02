package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeSkill;

public interface ResumeSkillService {
	
	Result add(ResumeSkill resumeSkill);
	Result update(ResumeSkill resumeSkill);
	DataResult<List<ResumeSkill>> getAll();
	Result addAll(List<ResumeSkill> resumeSkill);
    DataResult<List<ResumeSkill>> getAllByCandidateId(int candidateId);


}
