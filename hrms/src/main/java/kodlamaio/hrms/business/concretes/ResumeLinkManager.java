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
		return new SuccessResult("Link eklendi!");

	}

	@Override
	public Result update(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		return new SuccessResult("Link güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.resumeLinkDao.deleteById(id);
		return new SuccessResult("Limk silindi!");
	}

	@Override
	public DataResult<ResumeLink> getById(int id) {
		return new SuccessDataResult<ResumeLink>(this.resumeLinkDao.getById(id));
		
	}

	@Override
	public DataResult<List<ResumeLink>> getAll() {
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.findAll());		
	}

	@Override
	public DataResult<List<ResumeLink>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.getAllByCandidate_id(id));

	}

	

}
