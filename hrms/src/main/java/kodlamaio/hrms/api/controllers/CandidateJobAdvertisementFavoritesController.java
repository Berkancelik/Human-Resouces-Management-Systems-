package kodlamaio.hrms.api.controllers;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateJobAdvertisementFavoriteService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.CandidateJobAdvertisementFavorite;
import kodlamaio.hrms.entities.dtos.CandidateForFavoriteDto;


@RestController
@RequestMapping("api/candidatejobadvertisementfavorites")
@CrossOrigin
public class CandidateJobAdvertisementFavoritesController {
	
	 private CandidateJobAdvertisementFavoriteService candidateJobAdvertisementFavoriteService;

	    @Autowired
	    public CandidateJobAdvertisementFavoritesController(CandidateJobAdvertisementFavoriteService candidateJobAdvertisementFavoriteService) {
	        this.candidateJobAdvertisementFavoriteService = candidateJobAdvertisementFavoriteService;
	    }

	    @PostMapping("/add")
	    private ResponseEntity<?> save(@RequestBody CandidateForFavoriteDto candidateForFavoriteDto){
	        return ResponseEntity.ok(this.candidateJobAdvertisementFavoriteService.add(candidateForFavoriteDto));
	    }

	    @DeleteMapping("/delete")
	    private ResponseEntity<?> delete(@RequestParam int id  ){
	        return ResponseEntity.ok(this.candidateJobAdvertisementFavoriteService.delete(id));
	    }

	    @GetMapping("/getbycandidateid")
	    private ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
	        return ResponseEntity.ok(this.candidateJobAdvertisementFavoriteService.getByCandidateId(candidateId));
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