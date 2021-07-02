package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateJobAdvertisementFavoriteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateJobAdvertisementFavoriteDao;
import kodlamaio.hrms.entities.concretes.CandidateJobAdvertisementFavorite;

@Service
public class CandidateJobAdvertisementFavoriteManager implements CandidateJobAdvertisementFavoriteService {

	private CandidateJobAdvertisementFavoriteDao candidateJobAdvertisementFavoriteDao;

	@Autowired
	public CandidateJobAdvertisementFavoriteManager(CandidateJobAdvertisementFavoriteDao candidateJobAdvertisementFavoriteDao) {
		super();
		this.candidateJobAdvertisementFavoriteDao = candidateJobAdvertisementFavoriteDao;
	}

	@Override
	public Result add(CandidateJobAdvertisementFavorite candidateJobAdvertisementFavorite) {
		this.candidateJobAdvertisementFavoriteDao.save(candidateJobAdvertisementFavorite);
		return new SuccessResult("Facorilere eklendi");
	}

	@Override
	public Result delete(int id) {
		this.candidateJobAdvertisementFavoriteDao.deleteById(id);
		return new SuccessResult("Favorilerden silindi");
	}

	@Override
	public DataResult<List<CandidateJobAdvertisementFavorite>> getByCandidate_Id(int id) {
		return new SuccessDataResult<List<CandidateJobAdvertisementFavorite>>(candidateJobAdvertisementFavoriteDao.getByCandidate_Id(id));
	}



	
	
}