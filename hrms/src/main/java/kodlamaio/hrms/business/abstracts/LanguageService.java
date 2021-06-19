package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageCandidateAddDto;

public interface LanguageService {
	Result add(LanguageCandidateAddDto languageCandidateAddDto);
	Result update(Language Language);
	Result delete(int id);
	DataResult<Language>getById(int id);
	DataResult<List<Language>>  getAll();
	DataResult<List<Language>>  getAllByCandidateId(int id);

}
 