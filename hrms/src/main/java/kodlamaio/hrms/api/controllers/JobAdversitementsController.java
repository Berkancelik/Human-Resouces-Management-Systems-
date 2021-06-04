package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdversitementsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdversitements;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdversitementsController {
	private JobAdversitementsService jobAdversitementsService;
	
	@Autowired
	public JobAdversitementsController(JobAdversitementsService jobAdversitementsService) {
		super();
		this.jobAdversitementsService = jobAdversitementsService;
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdversitements jobAdversitements) {
		return this.jobAdversitementsService.add(jobAdversitements);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdversitements>> getAll(){
		return this.jobAdversitementsService.getAll();
	}
	

	
	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobAdversitements>> findAllByOrderByPublishedAtDesc(){
		return this.jobAdversitementsService.findAllByOrderByPublishedAtDesc();
	}
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdversitements>> getAllOpenJobAdversitementsByEmployer(int id){
		return this.jobAdversitementsService.getAllOpenJobAdversitementsByEmployer(id);
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id){
		return this.jobAdversitementsService.changeOpentoClose(id);
	}
	
	@GetMapping("/getAllOpenJobAdvertsitementsList")
	public DataResult<List<JobAdversitements>> getAllOpenJobAdvertsitementsList(){
		return this.jobAdversitementsService.getAllOpenJobAdversitementsList();
	}
}
