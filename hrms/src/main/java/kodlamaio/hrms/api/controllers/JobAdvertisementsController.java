package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

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

	
	@PostMapping("/add")
	
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisementDto jobAdvert){
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvert));
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.update(jobAdvertisement));
	}
	
	@PostMapping("/delete")
	public Result delete(@PathVariable("id") int id){
		return this.jobAdvertisementService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvertisement> getById(@PathVariable("id") int id){
		return this.jobAdvertisementService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){		
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllActiveAndOpenJobAdverts")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee(){
		return this.jobAdvertisementService.getAllByIsActiveByEmployee();
	}
	
	@GetMapping("/getAllOpenJobAdvertsAndIsActiveFalse")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee_False(){
		return this.jobAdvertisementService.getAllByIsActiveByEmployee_False();
	}
	
	@GetMapping("/getAllByEmployerId")
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(@RequestParam int id){
		return this.jobAdvertisementService.getAllByEmployerId(id);
	}
	

	@PostMapping("/changeactivestatus")
	public Result changeIsActiveByEmployee(@RequestParam int id) {
		return this.jobAdvertisementService.changeIsActiveByEmployee(id);
	}

	@PostMapping("/changeopenstatus")
	public Result changeIsOpenByEmployer(@RequestParam int id) {
		return this.jobAdvertisementService.changeIsOpenByEmployer(id);
	}
	

}
