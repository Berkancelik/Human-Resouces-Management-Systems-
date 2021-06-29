package kodlamaio.hrms.business.concretes;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageForCandidateAddDto;
@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;
	private ResumeDao resumeDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao, ResumeDao resumeDao) {
		super();
		this.languageDao = languageDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(LanguageForCandidateAddDto languageForCandidateAddDto) {
		Language language = new Language();
		language.setId(0);
		language.setResumes(
				this.resumeDao.getById(languageForCandidateAddDto.getId()));
		language.setLanguageName(languageForCandidateAddDto.getLanguageName());
		language.setLevel(languageForCandidateAddDto.getLevel());

		this.languageDao.save(language);
		return new SuccessResult("Yabancı dil eklendi");
	}

	@Override
	public Result update(LanguageForCandidateAddDto languageForCandidateAddDto) {
		Language languageUpdate = this.languageDao
				.getById(languageForCandidateAddDto.getId());
		languageUpdate.setLanguageName(languageForCandidateAddDto.getLanguageName());
		languageUpdate.setLevel(languageForCandidateAddDto.getLevel());

		this.languageDao.save(languageUpdate);
		return new SuccessResult("Yabancı Dil Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.languageDao.deleteById(id);
		return new SuccessResult("Yabancı Dil Silindi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),
				"Yabancı diller listelendi");
	}

	 

}
