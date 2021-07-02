package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LetterOfAcceptance;

public interface LetterOfAcceptanceService {
	Result add(LetterOfAcceptance letterOfAcceptance);
	
	Result update(LetterOfAcceptance letterOfAcceptance);

	DataResult<List<LetterOfAcceptance>> getAll();
	
	DataResult<List<LetterOfAcceptance>> getAllByCandidateId(int candidateId);

}
