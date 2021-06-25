package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateJobAdvertisementFavorite;

public interface CandidateJobAdvertisementFavoriteService {
	Result save(CandidateJobAdvertisementFavorite candidateJobAdvertisementFavorite);
    Result delete(CandidateJobAdvertisementFavorite candidateJobAdvertisementFavorite);
    DataResult<List<CandidateJobAdvertisementFavorite>> getAll();
    DataResult<List<CandidateJobAdvertisementFavorite>> getAllByCandidateId(int candidateId);
    DataResult<CandidateJobAdvertisementFavorite> getByCandidateIdAndJobAdvertismentId(int candidateId,int jobAdverisementId);

}
