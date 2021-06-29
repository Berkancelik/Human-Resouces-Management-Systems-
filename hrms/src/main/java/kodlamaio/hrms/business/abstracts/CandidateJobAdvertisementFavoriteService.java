  
package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateJobAdvertisementFavorite;
import kodlamaio.hrms.entities.dtos.CandidateForFavoriteDto;

public interface CandidateJobAdvertisementFavoriteService {
	Result add(CandidateForFavoriteDto candidateForFavoriteDto);

	Result delete(int id);

	DataResult<List<CandidateJobAdvertisementFavorite>> getByCandidateId(int id);

	
}