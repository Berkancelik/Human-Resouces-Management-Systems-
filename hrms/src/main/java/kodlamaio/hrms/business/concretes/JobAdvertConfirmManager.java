package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdversitementsService;
import kodlamaio.hrms.business.abstracts.JobAdvertConfirmService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertConfirmDao;
import kodlamaio.hrms.entities.concretes.JobAdvertConfirm;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobAdvertConfirmManager implements JobAdvertConfirmService{
	
	private JobAdvertConfirmDao jobAdvertConfirmDao;
	
	@Autowired
	public JobAdvertConfirmManager(JobAdvertConfirmDao jobAdvertConfirmDao) {
		super();
		this.jobAdvertConfirmDao = jobAdvertConfirmDao;
	}

	@Override
	public Result add(JobAdvertConfirm jobAdvertConfirm) {
		this.jobAdvertConfirmDao.save(jobAdvertConfirm);
		return new SuccessResult();
		
	}

	@Override
	public DataResult<JobAdvertConfirm> getByJobadvertId(int jobAdvertId) {
		return new SuccessDataResult<JobAdvertConfirm>
		(this.jobAdvertConfirmDao.getByJobAdvertId(jobAdvertId));		
	}

	@Override
	public DataResult<List<JobAdvertConfirm>> getAll() {
		return new SuccessDataResult<List<JobAdvertConfirm>>(this.jobAdvertConfirmDao.findAll());
	
	}



}
