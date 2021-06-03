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

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {
	private EducationService educationService;
	
	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Education education){
		return this.educationService.add(education);
		
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody Education education){
		return this.educationService.update(education);
		
	}
	
	@PostMapping("/delete")
	Result delete(@Valid @RequestBody @RequestParam  int id){
		return this.educationService.delete(id);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@GetMapping("/getAllByCandidateIdOrderByEndDesc")
	public DataResult<List<Education>> getAllByCandidateIdOrderByEndDesc(@RequestParam int id){
		return this.educationService.getAllByCandidateIdOrderByEndDesc(id);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Education>> getAllByCandidateId(@RequestParam int id){
		return this.educationService.getById(id);
	}
				

}
