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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementFilter;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobAdvertisementService.getAll());
	}

	@GetMapping("/getbyisconfirm")
	public ResponseEntity<?> getByIsActive(@RequestParam boolean isConfirm) {
		return ResponseEntity.ok(this.jobAdvertisementService.getByIsConfirm(isConfirm));
	}

	@GetMapping("/getbyisconfirmandisactive")
	public ResponseEntity<?>  getByIsConfirmAndIsActive(@RequestParam boolean isConfirm,
			@RequestParam boolean isActive, @RequestParam int pageNo, @RequestParam int pageSize) {
		return ResponseEntity.ok(this.jobAdvertisementService.getByIsConfirmAndIsActive(isConfirm, isActive, pageNo, pageSize));
	}
	@GetMapping("/sortbyreleasedate")
	public ResponseEntity<?>  sortByReleaseDate() {
		return ResponseEntity.ok(this.jobAdvertisementService.sortByReleaseDate());
	}

	@GetMapping("/getbycompanyname")
	public ResponseEntity<?>getByCompanyName(@RequestParam String companyName) {
		return ResponseEntity.ok(this.jobAdvertisementService.getByCompanyName(companyName));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisementDto jobAdvertisementDto) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisementDto));
	}

	@PostMapping("/updateisactive")
	public ResponseEntity<?> updateIsActive(@RequestParam boolean isActive, @RequestParam int userId, @RequestParam int id) {
		return ResponseEntity.ok(this.jobAdvertisementService.updateIsActive(isActive, userId, id));
	}

	@PostMapping("/updateisconfirm")
	public ResponseEntity<?>  updateIsConfirm(@RequestParam boolean isConfirm, @RequestParam int id) {
		return ResponseEntity.ok(this.jobAdvertisementService.updateIsConfirm(isConfirm, id));
	}

	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.jobAdvertisementService.getById(id));
	}
	
	
	@PostMapping("/getbyfilter")
	public ResponseEntity<?> getByFilter(@RequestBody JobAdvertisementFilter jobAdvertisementFilter,
			@RequestParam int pageNo, @RequestParam int pageSize) {
		return  ResponseEntity.ok(this.jobAdvertisementService.getByFilter(jobAdvertisementFilter, pageNo, pageSize));
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
