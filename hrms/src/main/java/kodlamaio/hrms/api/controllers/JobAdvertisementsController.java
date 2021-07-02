package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
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

	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(jobAdvertisementService.getById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(jobAdvertisementService.add(jobAdvertisement));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(int jobAdvertisementId) {
		return ResponseEntity.ok(jobAdvertisementService.delete(jobAdvertisementId));
	}
	
	@GetMapping("/getallsorted")
	public ResponseEntity<?> getAllSorted() {
		return ResponseEntity.ok(this.jobAdvertisementService.getAllSorted());
	}
	
//	@GetMapping("/getjobadvertisementwithemployerdetails")
//	public ResponseEntity<?> getAdvertisementWithEmployerDetails() {
//		return ResponseEntity.ok(this.jobAdvertisementService.getAdvertisementWithEmployerDetails());
//	}
//	
	@GetMapping("/getallbyisactivetrue")
	public ResponseEntity<?> getAllByIsActiveTrue(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllByIsActiveTrue());
	}
	
	@GetMapping("/getbyisactivetrueorderbydeadline")
	public ResponseEntity<?> getByisActiveTrueOrderByDeadline(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueOrderByApplicationDeadline());
	}
	
	@GetMapping("/ getbyisactivetrueandemployerid")
	public ResponseEntity<?> getByisActiveTrueAndEmployer_Id(@RequestParam int employerId){
		return ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueAndEmployer_Id(employerId));
	}
	
	@GetMapping("/getbyisactivetrueandconfirmstatustrue")
	public ResponseEntity<?> getByisActiveTrueAndConfirmStatusTrue(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueAndConfirmStatusTrue());
	}
	
	@GetMapping("/setpassive")
	 public ResponseEntity<?> setPassive(@RequestParam int jobAdvertisementId) {
		Result result=this.jobAdvertisementService.setPassive(jobAdvertisementId);
		if(!result.isSuccess()) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/updateisActive")
	@Transactional
	public Result updateisActive(@RequestParam int jobAdvertisementId, @RequestParam int employerId) {
		return this.jobAdvertisementService.updateisActive(jobAdvertisementId, employerId);
	}
	
	@PostMapping("/updateconfirmStatus")
	@Transactional
	public Result updateconfirmStatus(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.updateconfirmStatus(jobAdvertisementId);
	}
	
	@GetMapping("/getByConfirmStatusFalse")
	public ResponseEntity<?> getByConfirmStatusFalse(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByConfirmStatusFalse());
	}

	@GetMapping("/getByEmployer_Id")
	public ResponseEntity<?> getByEmployer_Id(@RequestParam int employerId){
		return ResponseEntity.ok(this.jobAdvertisementService.getByEmployer_Id(employerId));
	}
	
	@GetMapping("/getByPage")
	public ResponseEntity<?> getbyisactivetrueandconfirmstatustrue( @RequestParam int pageNo,@RequestParam int pageSize){
		return   ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueAndConfirmStatusTrue(pageNo, pageSize));
	}
	
	  @PostMapping("/getbyisactivetrueandconfirmstatustrueandfilter")
	    public Result getByisActiveTrueAndConfirmStatusTrueAndFilter(@RequestParam int pageNo,@RequestParam int pageSize,@RequestBody JobAdvertisementFilter jobAdvertisementFilter){
	        return jobAdvertisementService.getByisActiveTrueAndConfirmStatusTrueAndFilter(pageNo,pageSize,jobAdvertisementFilter);
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
