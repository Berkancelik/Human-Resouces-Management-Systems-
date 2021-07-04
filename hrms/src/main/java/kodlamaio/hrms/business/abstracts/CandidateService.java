package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateService {
	Result add(Candidate candidate);
	Result update(Candidate candidate);
	Result delete(int id);
	DataResult<Candidate> getById(int id);	
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getCandidateByNationalId(String nationalId);

	
}