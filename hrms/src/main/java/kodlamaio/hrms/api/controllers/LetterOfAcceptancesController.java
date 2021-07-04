package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
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

import kodlamaio.hrms.business.abstracts.LetterOfAcceptanceService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.LetterOfAcceptance;

@RestController
@RequestMapping("/api/letterofacceptances")
@CrossOrigin
public class LetterOfAcceptancesController {
	
	@Autowired
	private LetterOfAcceptanceService letterOfAcceptanceService;
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody LetterOfAcceptance letterOfAcceptance) {
		return ResponseEntity.ok(this.letterOfAcceptanceService.add(letterOfAcceptance));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?>update(@Valid @RequestBody LetterOfAcceptance letterOfAcceptance){
		return ResponseEntity.ok(this.letterOfAcceptanceService.update(letterOfAcceptance));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.letterOfAcceptanceService.delete(id));
	}

	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.letterOfAcceptanceService.getAll());
	}
	

	@GetMapping("/getById")
	public ResponseEntity<?>getById(@RequestParam int id){
		return ResponseEntity.ok(this.letterOfAcceptanceService.getById(id));
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