package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkPlaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkPlace;

@RestController
@CrossOrigin
@RequestMapping("/workPlace")
public class WorkPlacesController {
	private WorkPlaceService workPlaceService;

	public WorkPlacesController(WorkPlaceService workingTypeService) {
		this.workPlaceService = workingTypeService;
	}

	@GetMapping("/getAll")
	public DataResult<List<WorkPlace>> getAll() {
		return this.workPlaceService.getAll();
	}

}
