package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdversitementsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementsManager implements JobAdversitementsService {
	private JobAdvertisementDao jobAdvertisementsDao;

	@Autowired
	public JobAdvertisementsManager(JobAdvertisementDao jobAdvertisementsDao) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdversitements) {
		if (!CheckIfNullField(jobAdversitements)) {
			return new ErrorResult("Lütfen boş alanları kontrol ediniz!");
		}
		this.jobAdvertisementsDao.save(jobAdversitements);
		return new SuccessResult("İş ilanı başarılı şekilde eklendi!");
	}

	@Override
	public Result update(JobAdvertisement jobAdversitements) {
		this.jobAdvertisementsDao.save(jobAdversitements);
		return new SuccessResult("İş ilanı başarılı şekilde güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementsDao.deleteById(id);
		return new SuccessResult("İş ilanı başarılı şekilde silindi");
	}
	
	@Override
	public Result changeOpentoClose(int id) {
		if(getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı yok!");
		}
		if (getById(id).getData().isOpen() == false) {
			return new SuccessResult("İş ilani zaten kapalı!");
		
		}
		JobAdvertisement jobAdversitements = getById(id).getData();
		jobAdversitements.setOpen(false);
		update(jobAdversitements);
		return new SuccessResult("İş ilanı başarılı şekilde kapatıldı!");
			
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdversitementsList() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getAllOpenJobAdversitementsList());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByOrderByPublishedAtDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<JobAdvertisement>getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementsDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllOpenJobAdversitementsByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getAllOpenJobAdversitementsByEmployer(id));
	}

	private boolean CheckIfNullField(JobAdvertisement jobAdversitements) {
		if (jobAdversitements.getJobTitle() != null && jobAdversitements.getDescription() != null && jobAdversitements.getCity() != null && jobAdversitements.getOpenTitleCount() != 0) {
			return true;
		}
		return false;
	}
	
	  @Override
	    public DataResult<List<JobAdvertisement>> getAllByIsConfirmed(boolean isConfirmed) {
	        return new SuccessDataResult<>(this.jobAdvertisementsDao.getAllByJobAdvertConfirm_IsConfirmed(isConfirmed));
	    }
	



}
