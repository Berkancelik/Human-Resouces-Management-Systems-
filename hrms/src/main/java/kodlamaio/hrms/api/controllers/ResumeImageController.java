package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.ResumeImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.ResumeImage;

@RestController
@RequestMapping("/api/images")
public class ResumeImageController {
	
	private ResumeImageService resumeImageService;
	private CandidateService candidateService;
	
	@Autowired
	public ResumeImageController(ResumeImageService resumeImageService) {
		super();
		this.resumeImageService = resumeImageService;
		this.candidateService = candidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestParam(value ="id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
		CandidateService candidate = this.candidateService.getJobCantitadeByNationalId().getData();
		ResumeImage resumeImage = new ResumeImage();
		ResumeImage.setCandidate(candidate);
		return this.resumeImageService.add(resumeImage);
		
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody ResumeImage resumeImage){
		return this.resumeImageService.update(resumeImage);
		
	}
	
	@PostMapping("/delete")
	public Result delete(@Valid @RequestParam int  id){
		return this.resumeImageService.delete(id);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeImage>> getAll(){
		return this.resumeImageService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<ResumeImage> getByCandidateId(@RequestParam int id){
		return this.resumeImageService.getByCandidateId(id);
	}
	@GetMapping("/getById")
	public DataResult<ResumeImage> getById(@RequestParam int id){
		return this.resumeImageService.getById(id);
	}

}
