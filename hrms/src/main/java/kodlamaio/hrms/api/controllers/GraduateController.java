package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Graduate;
@RestController
@RequestMapping("/api/graduates")
public class GraduateController {
	private GraduateController graudateService;
	@Autowired
	public GraduateController(GraduateController graduateController) {
		super();
		this.graudateService = graudateService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Graduate>>getAll(){
		return this.graudateService.getAll();
	}
	
	@GetMapping("/add")
	public Result add(@Valid @RequestBody Graduate graduate){
		return this.graudateService.add(graduate);
	}



}
