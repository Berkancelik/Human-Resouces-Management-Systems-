package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLinkDao;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.dtos.ResumeLinkForCandidateDto;
@Service
public class ResumeLinkManager implements ResumeLinkService {
	
	private ResumeLinkDao resumeLinkDao;
	private ResumeDao resumeDao;

	@Autowired
	public ResumeLinkManager(ResumeDao resumeDao, ResumeLinkDao resumeLinkDao) {
		super();
		this.resumeLinkDao = resumeLinkDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(ResumeLinkForCandidateDto resumeLinkForCandidateDto) {
		ResumeLink resumeLink = new ResumeLink();

		resumeLink.setResumes(this.resumeDao.getById(resumeLinkForCandidateDto.getResumeId()));
		resumeLink.setLinkedin(resumeLinkForCandidateDto.getLinkedin());
		resumeLink.setGithub(resumeLinkForCandidateDto.getGithub());

		this.resumeLinkDao.save(resumeLink);
		return new SuccessResult("Hesaplar Eklendi");
	}

	@Override
	public Result update(ResumeLinkForCandidateDto resumeLinkForCandidateDto) {
		ResumeLink resumeLinkUpdate = this.resumeLinkDao.getById(resumeLinkForCandidateDto.getId());

		resumeLinkUpdate.setLinkedin(resumeLinkForCandidateDto.getLinkedin());
		resumeLinkUpdate.setGithub(resumeLinkForCandidateDto.getGithub());

		this.resumeLinkDao.save(resumeLinkUpdate);
		return new SuccessResult("Hesaplar Güncellendi");
	}

	@Override
	public Result delete(int accountId) {
		this.resumeLinkDao.deleteById(accountId);
		return new SuccessResult("Hesaplar Silindi");
	}

	

}
