package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageForCandidateAddDto;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	@Autowired
	private LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody LanguageForCandidateAddDto languageCandidateAddDto){
		return this.languageService.add(languageCandidateAddDto);
		
	}
	
	@PostMapping("/update")
	public Result update( @RequestBody Language language){
		return this.languageService.update(language);
		
	}
	
	@PostMapping("/delete")
	public Result delete( @RequestParam int  id){
		return this.languageService.delete(id);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Language>> getAllByCandidateId(@RequestParam int id){
		return this.languageService.getAllByCandidateId(id);
	}
	@GetMapping("/getById")
	public DataResult<Language> getById(@RequestParam int id){
		return this.languageService.getById(id);
	}

	

}
