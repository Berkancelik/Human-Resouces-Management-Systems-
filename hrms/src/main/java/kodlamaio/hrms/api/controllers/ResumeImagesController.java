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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.ResumeImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.ResumeImage;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ResumeImagesController {
	
	private ResumeImageService resumeImageService;
	private CandidateService candidateService;
	
	@Autowired
	public ResumeImagesController(ResumeImageService resumeImageService,CandidateService candidateService) {
		super();
		this.resumeImageService = resumeImageService;
		this.candidateService = candidateService;
	}

	@PostMapping(value = "/add")
	public  ResponseEntity<?>  add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
		Candidate candidate = this.candidateService.getById(id).getData();
		ResumeImage resumeImage = new ResumeImage();
		resumeImage.setCandidate(candidate);
		return ResponseEntity.ok(this.resumeImageService.add(resumeImage, imageFile));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody ResumeImage resumeImage) {
		return ResponseEntity.ok(this.resumeImageService.update(resumeImage));
	}
	
	@DeleteMapping("/delete")
	public  ResponseEntity<?> delete( @RequestParam int  id){
		return ResponseEntity.ok(this.resumeImageService.delete(id));
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(this.resumeImageService.getAll());
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?>getByCandidateId(@RequestParam int id){
		return ResponseEntity.ok(this.resumeImageService.getByCandidateId(id));
	}
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(this.resumeImageService.getById(id));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult<Object>("Validation Errors", validationErrors);
	}

}
