package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

public interface ResumeSkillService {
	
	Result add(ResumeSkillDto resumeSkillDto);

	Result update(ResumeSkillDto resumeSkillDto);

	Result delete(int id);

	DataResult<List<ResumeSkill>> getAll();


}
