package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateJobAdvertisementFavoriteService;
import kodlamaio.hrms.entities.concretes.CandidateJobAdvertisementFavorite;


@RestController
@RequestMapping("api/candidatejobadvertisementfavorites")
@CrossOrigin
public class CandidateJobAdvertisementFavoriteController {
	
	 private CandidateJobAdvertisementFavoriteService candidateJobAdvertisementFavoriteService;

	    @Autowired
	    public CandidateJobAdvertisementFavoriteController(CandidateJobAdvertisementFavoriteService candidateJobAdvertisementFavoriteService) {
	        this.candidateJobAdvertisementFavoriteService = candidateJobAdvertisementFavoriteService;
	    }

	    @PostMapping("/save")
	    private ResponseEntity<?> save(@RequestBody CandidateJobAdvertisementFavorite candidateJobAdvertisementFavorite){
	        return ResponseEntity.ok(this.candidateJobAdvertisementFavoriteService.save(candidateJobAdvertisementFavorite));
	    }

	    @PostMapping("/delete")
	    private ResponseEntity<?> delete(@RequestBody CandidateJobAdvertisementFavorite candidateJobAdvertisementFavorite){
	        return ResponseEntity.ok(this.candidateJobAdvertisementFavoriteService.delete(candidateJobAdvertisementFavorite));
	    }

	    @GetMapping("/getall")
	    private ResponseEntity<?> getAll(){
	        return ResponseEntity.ok(this.candidateJobAdvertisementFavoriteService.getAll());
	    }

	    @GetMapping("/getallbycandidateid")
	    private ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId){
	        return ResponseEntity.ok(this.candidateJobAdvertisementFavoriteService.getAllByCandidateId(candidateId));
	    }

	    @GetMapping("/getbycandidateidandjobadvertşsementid")
	    private ResponseEntity<?> getByCandidateIdAndJobPostingId(@RequestParam int candidateId,int jobAdvertisementId){
	        return ResponseEntity.ok(this.candidateJobAdvertisementFavoriteService.getByCandidateIdAndJobAdvertismentId(candidateId,jobAdvertisementId));
	    }

}
