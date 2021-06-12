package kodlamaio.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertConfirmService;
import kodlamaio.hrms.entities.concretes.JobAdvertConfirm;

@RestController
@RequestMapping("api/jobadvertconfirm")
@CrossOrigin
public class JobAdvertConfirmController {

	private JobAdvertConfirmService jobAdvertConfirmService;
	
	public JobAdvertConfirmController(JobAdvertConfirmService jobAdvertConfirmService) {
		this.jobAdvertConfirmService = jobAdvertConfirmService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobAdvertConfirm jobAdvertConfirm){
		return ResponseEntity.ok(this.jobAdvertConfirmService.add(jobAdvertConfirm));		
	}
	
	@GetMapping("/getbyjobadvertid")
	public ResponseEntity<?> getByJobAdvertId(int jobAdvertId){
		return ResponseEntity.ok(this.jobAdvertConfirmService.getByJobadvertId(jobAdvertId));
	}
	
	@GetMapping("getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobAdvertConfirmService.getAll());
	}

}
