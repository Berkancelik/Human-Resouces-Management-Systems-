package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeLinkForCandidateDto;

public interface ResumeLinkService {
	Result add(ResumeLinkForCandidateDto resumeLinkForCandidateDto);

	Result update(ResumeLinkForCandidateDto resumeLinkForCandidateDto);

	Result delete(int accountId);
}