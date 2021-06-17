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

import kodlamaio.hrms.business.abstracts.JobAdversitementsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	private JobAdversitementsService jobAdversitementsService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdversitementsService) {
		super();
		this.jobAdversitementsService = jobAdversitementsService;
	}

	
	@PostMapping("/add")
	
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisementDto jobAdvert){
		return ResponseEntity.ok(this.jobAdversitementsService.add(jobAdvert));
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdversitementsService.update(jobAdvertisement));
	}
	
	@PostMapping("/delete")
	public Result delete(@PathVariable("id") int id){
		return this.jobAdversitementsService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvertisement> getById(@PathVariable("id") int id){
		return this.jobAdversitementsService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){		
		return this.jobAdversitementsService.getAll();
	}
	
	@GetMapping("/getAllActiveAndOpenJobAdverts")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee(){
		return this.jobAdversitementsService.getAllByIsActiveByEmployee();
	}
	
	@GetMapping("/getAllOpenJobAdvertsAndIsActiveFalse")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveByEmployee_False(){
		return this.jobAdversitementsService.getAllByIsActiveByEmployee_False();
	}
	
	@GetMapping("/getAllByEmployerId")
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(@RequestParam int id){
		return this.jobAdversitementsService.getAllByEmployerId(id);
	}
	

	@PostMapping("/changeactivestatus")
	public Result changeIsActiveByEmployee(@RequestParam int id) {
		return this.jobAdversitementsService.changeIsActiveByEmployee(id);
	}

	@PostMapping("/changeopenstatus")
	public Result changeIsOpenByEmployer(@RequestParam int id) {
		return this.jobAdversitementsService.changeIsOpenByEmployer(id);
	}
	

}
