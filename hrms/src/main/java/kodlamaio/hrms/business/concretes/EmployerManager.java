package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;


@Service
public class EmployerManager  implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;
	private VerificationCodeService verificationCodeService;
	
	public  EmployerManager(EmployerDao employerDao, UserService userService, VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
		this.verificationCodeService = verificationCodeService;
		
	}
	

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İşverenler listesi başarıyla getirildi");
	}

	@Override
	public DataResult<Employer> add(Employer employer) {
		
		if(!companyNameCheck(employer)) {
			
			return new ErrorDataResult<Employer>(null,"Şirket ismi boş bırakılamaz!");
			
		}else if(!webAddressCheck(employer)) {
			
			return new ErrorDataResult<Employer>(null,"Şirket web adresi alanı boş bırakılamaz girilmesi zrounludur!");
			
		}else if(!phoneNumberCheck(employer.getPhoneNumber())) {
			
			return new ErrorDataResult<Employer>(null, "Telefon numara alanını eksikisiz ve doğru giriniz!");
			
		}else if(!isEmailFormat(employer.getEmail())) {
			
			return new ErrorDataResult<Employer>(null,"Geçerli bir e-posta adresi giriniz!");
			
		}else if(!employerRegister(employer)) {
			
			return new ErrorDataResult<Employer>(null, "Bu e-posta daha önceden alınmıştır!");
		}else if(!passwordCheck(employer)) {
			return new ErrorDataResult<Employer>(null,"Şifre geçersiz veya alan boş bırakılmış. Tekrar deneyiniz!");
		}
		
		User saveUser = this.userService.add(employer);
		this.verificationCodeService.genereatedCode(new VerificationCode(), saveUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş verenler hesabına kayıt yaptırdınız. Onaylamnması için mail adresinizi kontrol ediniz!");
				
		

	}
	
	private boolean companyNameCheck(Employer employer) {
		
		if(employer.getWebAddress().isBlank()&& employer.getWebAddress()==null) {
			
			return false;
		}
		return true;
	}
	
	private boolean webAddressCheck(Employer employer) {
		if(employer.getWebAddress().isBlank() && employer.getWebAddress()==null) {
			return false;
		}
		return true;
	}
	
	private boolean phoneNumberCheck(String phoneNumber) {
		String patterns ="^(05)([0-9]{2})\s?([0-9]{3})\s?([0-9]{2})\s?([0-9]{2})$";

	  
		
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();

	}
	
	

		  public boolean isEmailFormat(String emailFormat) {

	            String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

	            Pattern pattern = Pattern.compile(regex);
	            Matcher matcher = pattern.matcher(emailFormat);
	            return matcher.matches();
	}
	
	private boolean employerRegister(Employer employer) {
		if(employerDao.getAllByEmail(employer.getEmail()).stream().count() !=0) {
			return false;
		}
		return true;
	}
	
	private boolean passwordCheck(Employer employer) {
		if(employer.getPassword()==null && employer.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}

}
