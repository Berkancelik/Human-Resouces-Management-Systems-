package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.adapters.RandomGenerateCode;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public void genereatedCode(VerificationCode code, Integer id) {
		VerificationCode codes = code;
		codes.setCode(null);
		codes.setVerified(false);
		if (codes.isVerified() == false) {
			RandomGenerateCode generator = new RandomGenerateCode();
			String code_create = generator.create();
			codes.setCode(code_create);
			

			verificationCodeDao.save(codes);
		}
		return;

	}

	@Override
	public Result verify(String validationCode, Integer id) {
		VerificationCode valid = verificationCodeDao.getOne(id);
		if (valid.getCode().equals(validationCode)) {
			valid.setVerified(true);
			return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.save(valid), "Kayıt başarılı!");
		}
		return new ErrorDataResult<VerificationCode>(null, "Doğrulama kodu geçersiz! Mail adresinizi kontrol ediniz!");
	}

}
