package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;


public interface ResumeService {
	Result add(ResumeDto resumeDto);

	Result delete(int id);

	DataResult<List<Resume>> getAll();

	DataResult<List<Resume>> getByCandidateId(int jobseekerId);

	DataResult<Resume> getById(int id);
}