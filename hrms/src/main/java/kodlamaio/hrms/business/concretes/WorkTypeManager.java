package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService {
	private WorkTypeDao workingTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public Result add(WorkType workingType) {
		this.workingTypeDao.save(workingType);
		return new SuccessResult();
		
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(this.workingTypeDao.findAll());
		
	}

}
