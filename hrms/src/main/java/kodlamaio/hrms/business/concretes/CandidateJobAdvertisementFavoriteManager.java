package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateJobAdvertisementFavoriteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateJobAdvertisementFavoriteDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.CandidateJobAdvertisementFavorite;
import kodlamaio.hrms.entities.dtos.CandidateForFavoriteDto;

@Service
public class CandidateJobAdvertisementFavoriteManager implements CandidateJobAdvertisementFavoriteService {

	private CandidateJobAdvertisementFavoriteDao candidateJobAdvertisementFavoriteDao;
	private JobAdvertisementDao jobAdvertisementDao;
	private CandidateDao candidateDao;

	@Autowired
	public CandidateJobAdvertisementFavoriteManager(CandidateJobAdvertisementFavoriteDao candidateJobAdvertisementFavoriteDao, CandidateDao candidateDao, JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.candidateJobAdvertisementFavoriteDao = candidateJobAdvertisementFavoriteDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(CandidateForFavoriteDto candidateForFavoriteDto) {
		CandidateJobAdvertisementFavorite candidateJobAdvertisementFavorite = new CandidateJobAdvertisementFavorite();

		candidateJobAdvertisementFavorite.setCandidate(this.candidateDao.getById(candidateForFavoriteDto.getCandidateId()));
		candidateJobAdvertisementFavorite.setJobAdvertisement(this.jobAdvertisementDao.getById(candidateForFavoriteDto.getJobAdvertisementId()));
		this.candidateJobAdvertisementFavoriteDao.save(candidateJobAdvertisementFavorite);
		return new SuccessResult("Favori Eklendi");
	
	}



	@Override
	public Result delete(int id) {
		this.candidateJobAdvertisementFavoriteDao.deleteById(id);
		return new SuccessResult("Favorilerdeden çıkarıldı");
	}

	@Override
	public DataResult<List<CandidateJobAdvertisementFavorite>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateJobAdvertisementFavorite>>(this.candidateJobAdvertisementFavoriteDao.getAllByCandidate_Id(id));

	}

	
}