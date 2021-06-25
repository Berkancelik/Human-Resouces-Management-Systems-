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
public class CandidateJobAdvertisementManager implements CandidateJobAdvertisementFavoriteService {

	private CandidateJobAdvertisementFavoriteDao candidateJobAdvertisementFavoriteDao;

	@Autowired
	public CandidateJobAdvertisementManager(CandidateJobAdvertisementFavoriteDao candidateJobAdvertisementFavoriteDao) {
		this.candidateJobAdvertisementFavoriteDao = candidateJobAdvertisementFavoriteDao;
	}

	@Override
	public Result save(CandidateJobAdvertisementFavorite candidateJobAdvertisementFavorite) {
		this.candidateJobAdvertisementFavoriteDao.save(candidateJobAdvertisementFavorite);
		return new SuccessResult();
	}

	@Override
	public Result delete(CandidateJobAdvertisementFavorite candidateJobPostingFavorite) {
		this.candidateJobAdvertisementFavoriteDao.delete(candidateJobPostingFavorite);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateJobAdvertisementFavorite>> getAll() {
		return new SuccessDataResult<>(this.candidateJobAdvertisementFavoriteDao.findAll());
	}

	@Override
	public DataResult<List<CandidateJobAdvertisementFavorite>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<>(this.candidateJobAdvertisementFavoriteDao.getAllByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<CandidateJobAdvertisementFavorite> getByCandidateIdAndJobAdvertismentId(int candidateId,
			int jobAdverisementId) {
		return new SuccessDataResult<>(this.candidateJobAdvertisementFavoriteDao
				.getByCandidate_IdAndJobAdvertisement_Id(candidateId, jobAdverisementId));
	}

}
