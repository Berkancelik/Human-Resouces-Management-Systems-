package kodlamaio.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.entities.dtos.ResumeLinkForCandidateDto;

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
	public ResponseEntity<?> add(@Valid @RequestBody ResumeLinkForCandidateDto resumeLinkForCandidateDto) {
		return ResponseEntity.ok(this.resumeLinkService.add(resumeLinkForCandidateDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody ResumeLinkForCandidateDto resumeLinkForCandidateDto) {
		return ResponseEntity.ok(this.resumeLinkService.update(resumeLinkForCandidateDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeLinkService.delete(id));
	}
	
	


}