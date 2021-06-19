package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import kodlamaio.hrms.entities.dtos.ResumeSkillForCandidateDto;

public interface ResumeSkillService {
	Result add(ResumeSkillForCandidateDto resumeSkillForCandidateDto);
	Result update(ResumeSkill resumeSkill);
	Result delete(int id);
	DataResult<ResumeSkill> getById(int id);	
	DataResult<List<ResumeSkill>> getAllByCandidateId(int id);
	DataResult<List<ResumeSkill>> getAll();

}
