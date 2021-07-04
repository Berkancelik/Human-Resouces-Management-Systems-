package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeSkillDao;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;


@Service
public class ResumeSkillManager implements ResumeSkillService {
	private ResumeDao resumeDao;
	private ResumeSkillDao resumeSkillDao;

	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao, ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
		this.resumeSkillDao = resumeSkillDao;
	}

	@Override
	public Result add(ResumeSkillDto resumeSkillDto) {
		ResumeSkill resumeSkill = new ResumeSkill();
		resumeSkill.setResume(
				this.resumeDao.getById(resumeSkillDto.getResumeId()));
		resumeSkill.setSkillName(resumeSkillDto.getSkillName());
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("Teknoloji eklendi");
	}

	@Override
	public Result update(ResumeSkillDto resumeSkillDto) {
		ResumeSkill resumeSkillUpdate = this.resumeSkillDao.getById(resumeSkillDto.getId());
		resumeSkillUpdate.setSkillName(resumeSkillDto.getSkillName());

		this.resumeSkillDao.save(resumeSkillUpdate);
		return new SuccessResult("Yetenekler Güncellendi");
	}

	@Override
	public Result delete(int technologyId) {
		this.resumeSkillDao.deleteById(technologyId);
		return new SuccessResult("Yetenekler Silindi");
	}

	@Override
	public DataResult<List<ResumeSkill>> getAll() {
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.findAll(), "Yetenekler listelendi");
	}
	
}