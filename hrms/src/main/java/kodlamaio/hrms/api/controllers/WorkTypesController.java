package kodlamaio.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.entities.concretes.WorkType;

@RestController
@CrossOrigin
@RequestMapping("/api/workingTypes")

public class WorkTypesController {
	private WorkTypeService workingTypeService;
	
	public WorkTypesController(WorkTypeService workingTypeService) {
		this.workingTypeService = workingTypeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkType workingType){
		return ResponseEntity.ok(this.workingTypeService.add(workingType));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.workingTypeService.getAll());
	}

}
