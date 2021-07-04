package kodlamaio.hrms.api.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getall(){
		return ResponseEntity.ok(this.employerService.getAll());
	}
	
	@PostMapping("/add")
	public  ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.add(employer));
	}
	
	@GetMapping("/getByConfirmStatusFalse")
	public ResponseEntity<?> getByConfirmStatusFalse(){
		return ResponseEntity.ok(this.employerService.getByConfirmStatusFalse());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(employerService.getById(id));
	}
	
	@PostMapping("/updateWaiting")
	public ResponseEntity<?> updateWaiting(@RequestBody Employer employer){
		return ResponseEntity.ok(this.employerService.updateWaiting(employer));			
	}
	
	@PostMapping("/updateConfirmStatus")
	public ResponseEntity<?> updateConfirmStatus(@RequestParam int employerId){
		return  ResponseEntity.ok(this.employerService.updateConfirmStatus(employerId));
	}

}
