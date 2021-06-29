package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;


@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class ResumeSkillsController {
	private ResumeSkillService resumeSkillService;

	@Autowired
	public ResumeSkillsController(ResumeSkillService resumeSkillService) {
		super();
		this.resumeSkillService = resumeSkillService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ResumeSkillDto resumeSkillDto) {
		return ResponseEntity.ok(this.resumeSkillService.add(resumeSkillDto));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody ResumeSkillDto resumeSkillDto) {
		return ResponseEntity.ok(this.resumeSkillService.update(resumeSkillDto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam(name = "id") int id) {
		return ResponseEntity.ok(this.resumeSkillService.delete(id));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.resumeSkillService.getAll());
	}


	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult<Object>("Doğrulama Hataları");
	}

}
