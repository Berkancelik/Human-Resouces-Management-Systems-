package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeSkillDao;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import kodlamaio.hrms.entities.dtos.ResumeSkillForCandidateDto;
@Service
public class ResumeSkillManager implements ResumeSkillService {
	private ResumeSkillDao resumeSkillDao;
	private CandidateDao candidateDao;
	
	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao, CandidateDao candidateDao) {
		super();
		this.resumeSkillDao = resumeSkillDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(ResumeSkillForCandidateDto resumeSkillForCandidateDto) {
		 if(!this.candidateDao.existsById(resumeSkillForCandidateDto.getCandidateId())){
	            return new ErrorResult("Böyle bir kullanıcı yok");
	        }else if(resumeSkillForCandidateDto.getSkillName().length()<=2){
	            return new ErrorResult("Yetenek adı 2 karekterden kısa olamaz");
	        }

	        ResumeSkill resumeSkill=new ResumeSkill();
	        resumeSkill.setCandidate(this.candidateDao.getById(resumeSkillForCandidateDto.getCandidateId()));
	        resumeSkill.setSkillName(resumeSkillForCandidateDto.getSkillName());

	        this.resumeSkillDao.save(resumeSkill);
	        return new SuccessResult("Eklendi");
	    }
	@Override
	public Result update(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("Yetenek güncellendi!");
	}

	@Override
	public Result delete(int id) {
	     if(!this.resumeSkillDao.existsById(id)){
	            return new ErrorResult("Böyle bir yetenek yok");
	        }
	        this.resumeSkillDao.deleteById(id);
	        return new SuccessResult("Silindi");
	    }

	@Override
	public DataResult<ResumeSkill> getById(int id) {
		return new SuccessDataResult<ResumeSkill>(this.resumeSkillDao.getById(id));
		
	}

	@Override
	public DataResult<List<ResumeSkill>> getAll() {
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.findAll());

	}

	@Override
	public DataResult<List<ResumeSkill>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.getAllByCandidate_id(id));
		
	}

}
