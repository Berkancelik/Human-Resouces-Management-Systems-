package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LetterOfAcceptanceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LetterOfAcceptanceDao;
import kodlamaio.hrms.entities.concretes.LetterOfAcceptance;
@Service
public class LetterOfAcceptanceManager implements LetterOfAcceptanceService {
	

	private LetterOfAcceptanceDao letterOfAcceptanceDao;
	
	@Autowired
	public LetterOfAcceptanceManager(LetterOfAcceptanceDao letterOfAcceptanceDao) {
		super();
		this.letterOfAcceptanceDao = letterOfAcceptanceDao;
	}

	@Override
	public Result add(LetterOfAcceptance letterOfAcceptance) {
		this.letterOfAcceptanceDao.save(letterOfAcceptance);
		return new SuccessResult("Ön yazı eklendi");
	}

	@Override
	public DataResult<List<LetterOfAcceptance>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<LetterOfAcceptance>>(letterOfAcceptanceDao.getAllByCandidateId(candidateId));
	}

	@Override
	public DataResult<List<LetterOfAcceptance>> getAll() {
		return new SuccessDataResult<List<LetterOfAcceptance>>(letterOfAcceptanceDao.findAll(),"Ön yazı listelendi");
	}

	@Override
	public Result update(LetterOfAcceptance coverLetter) {
	this.letterOfAcceptanceDao.save(coverLetter);
	return new SuccessResult("Ön yazı güncellendi.");
	}




}
