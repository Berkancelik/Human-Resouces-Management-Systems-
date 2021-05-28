package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result verify(String validationCode,Integer id);
	void genereatedCode(VerificationCode code, Integer id);

}
