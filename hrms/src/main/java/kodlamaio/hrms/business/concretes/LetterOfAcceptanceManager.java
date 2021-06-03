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
import kodlamaio.hrms.entities.concretes.ResumeLink;
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
		return new SuccessResult("Kapak mektubu eklendi!.");
	}

	@Override
	public Result update(LetterOfAcceptance letterOfAcceptance) {
		this.letterOfAcceptanceDao.save(letterOfAcceptance);
		return new SuccessResult("Kapak mektubu güncellendi!.");
	}

	@Override
	public Result delete(int id) {
		this.letterOfAcceptanceDao.deleteById(id);
		return new SuccessResult("Kapak mektubu silindi!.");
	}

	@Override
	public DataResult<LetterOfAcceptance> getById(int id) {
		return new SuccessDataResult<LetterOfAcceptance>(this.letterOfAcceptanceDao.findById(id).get());
		
	}

	@Override
	public DataResult<List<LetterOfAcceptance>> getAll() {
		return new SuccessDataResult<List<LetterOfAcceptance>>(this.letterOfAcceptanceDao.findAll());
		
	}




}
