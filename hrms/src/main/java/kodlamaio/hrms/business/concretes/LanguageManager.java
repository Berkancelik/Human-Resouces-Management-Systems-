package kodlamaio.hrms.business.concretes;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageForCandidateAddDto;
@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;
	private CandidateDao candidateDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao, CandidateDao candidateDao) {
		super();
		this.languageDao = languageDao;
		this.candidateDao = candidateDao;
	}

	  @Override
	    public Result add(LanguageForCandidateAddDto languageCandidateAddDto) {

	        if(!this.candidateDao.existsById(languageCandidateAddDto.getCandidteId())){
	            return new ErrorResult("Böyle bir kullanıcı yok!");
	        }else if(languageCandidateAddDto.getLanguageName().length()<=2){
	            return new ErrorResult("Dil ismi 2 karakterden uzun olmalıdır!");
	        }else if(Integer.parseInt(languageCandidateAddDto.getLevel()) <=0 || Integer.parseInt(languageCandidateAddDto.getLevel()) >=6){
	            return new ErrorResult("Dil seviyesi 1-5 arası bir değer olmalıdır!");
	        }

	        Language language=new Language();
	        language.setCandidate(this.candidateDao.getById(languageCandidateAddDto.getCandidteId()));
	        language.setLanguageName(languageCandidateAddDto.getLanguageName());
	        language.setLevel(languageCandidateAddDto.getLevel());

	        this.languageDao.save(language);
	        return new SuccessResult("Dil kaydedildi!");
	    }

	@Override
	public Result update(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Yabancı dil güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.languageDao.deleteById(id);
		return new SuccessResult("Yabancı dil silindi");
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(this.languageDao.getById(id));
		
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());		
	}

	@Override
	public DataResult<List<Language>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getAllByCandidate_id(id));
		
	}


}
