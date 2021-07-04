package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageForCandidateAddDto;

public interface LanguageService {
	Result add(LanguageForCandidateAddDto languageForCandidateAddDto);

	Result update(LanguageForCandidateAddDto languageForCandidateAddDto);

	Result delete(int id);

	DataResult<List<Language>> getAll();

}