package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeSkillDao;
import kodlamaio.hrms.entities.concretes.ResumeSkill;


@Service
public class ResumeSkillManager implements ResumeSkillService {
	private ResumeSkillDao resumeSkillDao;

	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao) {
		super();
		this.resumeSkillDao = resumeSkillDao;
	}

	@Override
	public Result add(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("Technology added");
	}

	@Override
	public DataResult<List<ResumeSkill>> getAll() {
		return new SuccessDataResult<List<ResumeSkill>>(resumeSkillDao.findAll(),"Yetenekler listelendi");
	}

	@Override
	public Result addAll(List<ResumeSkill> resumeSkill) {
		this.resumeSkillDao.saveAll(resumeSkill);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<ResumeSkill>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<ResumeSkill>>(resumeSkillDao.getAllByCandidateId(candidateId),"Yetenekler listelendi");
	}

	@Override
	public Result update(ResumeSkill resumeSkill) {
	this.resumeSkillDao.save(resumeSkill);
	return new SuccessResult("Yetenekler güncellendi");
	}
	
}