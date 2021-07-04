package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.dtos.JobExperienceForCandidateDto;

@RestController
@RequestMapping
public class JobExperiencesController {
	private JobExperienceService jobExperienceService;	

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobExperienceForCandidateDto jobExperienceForCandidateDto) {
		return ResponseEntity.ok(this.jobExperienceService.add(jobExperienceForCandidateDto));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobExperienceForCandidateDto jobExperienceForCandidateDto) {
		return ResponseEntity.ok(this.jobExperienceService.update(jobExperienceForCandidateDto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.jobExperienceService.delete(id));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobExperienceService.getAll());
	}

	

	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
}