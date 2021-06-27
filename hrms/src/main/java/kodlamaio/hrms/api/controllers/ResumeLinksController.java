package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.entities.concretes.ResumeLink;

@RestController
@RequestMapping("/api/links")
@CrossOrigin
public class ResumeLinksController {
	private ResumeLinkService resumeLinkService;
	
	@Autowired
	public ResumeLinksController(ResumeLinkService resumeLinkService) {
		super();
		this.resumeLinkService = resumeLinkService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ResumeLink resumeLink) {
		return ResponseEntity.ok(this.resumeLinkService.add(resumeLink));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody ResumeLink resumeLink) {
		return ResponseEntity.ok(this.resumeLinkService.update(resumeLink));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeLinkService.delete(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.resumeLinkService.getAll());
	}
	
	@GetMapping("/getAllByCandidateId")
	public  ResponseEntity<?>  getAllByCandidateId(@RequestParam int id){
		return ResponseEntity.ok(this.resumeLinkService.getAllByCandidateId(id));
	}
	@GetMapping("/getById")
	public ResponseEntity<?>   getById(@RequestParam int id){
		return ResponseEntity.ok(this.resumeLinkService.getById(id));
	}


}
