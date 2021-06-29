package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CandidateDao candidateDao;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, CandidateDao candidateDao) {
		super();
		this.resumeDao = resumeDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(ResumeDto resumeDto) {
		Resume resume = new Resume();

		resume.setCandidate(this.candidateDao.getById(resumeDto.getCandidateId()));

		this.resumeDao.save(resume);
		return new SuccessResult("CV eklendi");
	}

	@Override
	public DataResult<List<Resume>> getByCandidateId(int id) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByCandidate_Id(id),
				"İş arayana ait CV listelendi");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), "CV'ler listelendi");
	}

	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(
				this.resumeDao.getById(id));
	}

	@Override
	public Result delete(int id) {
		this.resumeDao.deleteById(id);
		return new SuccessResult("Özgeçmiş silindi");
	}
	
}