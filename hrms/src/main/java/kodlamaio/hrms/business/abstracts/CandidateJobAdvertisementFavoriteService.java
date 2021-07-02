  
package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateJobAdvertisementFavorite;

public interface CandidateJobAdvertisementFavoriteService {
	Result add(CandidateJobAdvertisementFavorite candidateJobAdvertisementFavorite);

	Result delete(int id);

	DataResult<List<CandidateJobAdvertisementFavorite>> getByCandidate_Id(int id);

	
}