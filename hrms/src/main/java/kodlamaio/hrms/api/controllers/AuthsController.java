package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/verify")
@CrossOrigin
public class AuthsController {
	private AuthService authService;
	
	@Autowired
	public AuthsController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public  ResponseEntity<?> registerEmployer(@RequestBody Employer employer,String confirmPassword) {
		return ResponseEntity.ok(authService.registerEmployer(employer, confirmPassword));
	}
	
	@PostMapping("/registerCandidate")
	public  ResponseEntity<?> registerCandidate(@RequestBody Candidate candidate, String confirmPassword) {
		return ResponseEntity.ok(authService.registerCandidate(candidate, confirmPassword));
	}  
	


}
