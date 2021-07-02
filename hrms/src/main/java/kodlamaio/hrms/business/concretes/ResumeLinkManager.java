package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLinkDao;
import kodlamaio.hrms.entities.concretes.ResumeLink;
@Service
public class ResumeLinkManager implements ResumeLinkService {
	
	private ResumeLinkDao resumeLinkDao;

	@Autowired
	public ResumeLinkManager(ResumeLinkDao resumeLinkDao) {
		super();
		this.resumeLinkDao = resumeLinkDao;
	}

	@Override
	public Result add(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		return new SuccessResult("Link eklendi");
	}

	@Override
	public DataResult<List<ResumeLink>> getAll() {
		return new SuccessDataResult<List<ResumeLink>>(resumeLinkDao.findAll(),"Yetenekler listelendi");
	}

	@Override
	public Result addAll(List<ResumeLink> resumeLink) {
		this.resumeLinkDao.saveAll(resumeLink);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<ResumeLink>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<ResumeLink>>(resumeLinkDao.getAllByCandidateId(candidateId));
	}

	@Override
	public Result update(ResumeLink resumeLink) {
	this.resumeLinkDao.save(resumeLink);
	return new SuccessResult("Yetenekler güncellendi");
	}
	

}
