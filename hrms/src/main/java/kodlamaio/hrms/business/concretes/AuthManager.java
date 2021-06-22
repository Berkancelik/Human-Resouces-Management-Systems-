package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationCodeService verificationCodeService;
	private ValidationService validationService;
	private VerificationService verificationService;

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, CandidateService candidateService,
			VerificationCodeService verificationCodeService, VerificationService verificationService,
			ValidationService validationService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationCodeService = verificationCodeService;
		this.validationService = validationService;
		this.verificationService = verificationService;

	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("Eksik bilgi girdiniz. lütfen bütün boşlukları doldurunuz!");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {

			return new ErrorResult("Invalid email address!.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + " zaten var!.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Parolalar uyuşmuyor!.");
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeIsGenerated(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Kayıt Başarıyla tammalandı!");

	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {

		if (checkIfRealPerson(candidate.getNationalId(), candidate.getFirstName(), candidate.getLastName(),
				candidate.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("TCKN doğrulanamadı!");
		}

		if (!checkIfNullInfoForCandidate(candidate, confirmPassword)) {

			return new ErrorResult("Eksik bilgi girdiniz. lütfen bütün boşlukları doldurunuz!");
		}

		if (!checkIfExistsTcNo(candidate.getNationalId())) {

			return new ErrorResult(candidate.getNationalId() + " zaten var!");
		}

		if (!checkIfEmailExists(candidate.getEmail())) {

			return new ErrorResult(candidate.getEmail() + " zaten var!");
		}

		candidateService.add(candidate);
		String code = verificationService.sendCode();
		verificationCodeIsGenerated(code, candidate.getId(), candidate.getEmail());
		return new SuccessResult("Kayıt başarıyla tamamlandı!");
	}

	private boolean checkIfNullInfoForEmployer(Employer employer) {
		if (employer.getCompanyName() != null && employer.getWebAddress() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	private boolean checkIfNullInfoForCandidate(Candidate candidate, String confirmPassword) {
				if (candidate.getFirstName() != null && candidate.getLastName() != null && candidate.getNationalId() != null
						&& candidate.getDateOfBirth() != null && candidate.getPassword() != null && candidate.getEmail() != null
						&& confirmPassword != null) {

					return true;

				}

				return false;
			}


	private boolean checkIfExistsTcNo(String nationalId) {
		if (this.candidateService.getCandidateByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(String nationalId, String firstName, String lastName, int yearOfBirth) {

		if (validationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}

	private boolean checkIfEmailExists(String email) {
		if (this.userService.getUserByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	public void verificationCodeIsGenerated(String code, int id, String email) {
		VerificationCode verificationCode = new VerificationCode(id,null, false, code,false, id);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Doğrulama kodu bu email adresine gönderildi : " + " " + email);
	}


}
