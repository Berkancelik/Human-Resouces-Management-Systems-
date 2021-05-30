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
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementsDao;
import kodlamaio.hrms.entities.concretes.JobAdversitements;

@Service
public class JobAdvertisementsManager implements JobAdversitementsService {
	private JobAdvertisementsDao jobAdvertisementsDao;

	@Autowired
	public JobAdvertisementsManager(JobAdvertisementsDao jobAdvertisementsDao) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
	}

	@Override
	public Result add(JobAdversitements jobAdversitements) {
		if (!CheckIfNullField(jobAdversitements)) {
			return new ErrorResult("Lütfen boş alanları kontrol ediniz!");
		}
		this.jobAdvertisementsDao.save(jobAdversitements);
		return new SuccessResult("İş ilanı başarılı şekilde eklendi!");
	}

	@Override
	public Result update(JobAdversitements jobAdversitements) {
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
			return new ErrorResult("İş ilanı zaten kapalı!");
		}
		JobAdversitements jobAdversitements = (JobAdversitements) getById(id).getData(); // search
		jobAdversitements.setOpen(false);
		update(jobAdversitements);
		return new SuccessResult("İş ilanı başarılı şekilde kapatıldı");
		
	}

	@Override
	public DataResult<List<JobAdversitements>> getAll() {
		return new SuccessDataResult<List<JobAdversitements>>(this.jobAdvertisementsDao.findAll());
	}

	@Override
	public DataResult<List<JobAdversitements>> getAllOpenJobAdvertisementsList() {
		return new SuccessDataResult<List<JobAdversitements>>(this.jobAdvertisementsDao.getAllOpenJobAdversitementsList());
	}

	@Override
	public DataResult<List<JobAdversitements>> findAllOrderByPublishheadAt() {
		return new SuccessDataResult<List<JobAdversitements>>(this.jobAdvertisementsDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<JobAdversitements>getById(int id) {
		return new SuccessDataResult<JobAdversitements>(this.jobAdvertisementsDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdversitements>> getAllOpenJobAdvertByEmployer(int id) {
		return new SuccessDataResult<List<JobAdversitements>>(this.jobAdvertisementsDao.getAllOpenJobAdversitementsByEmployer(id));
	}

	private boolean CheckIfNullField(JobAdversitements jobAdversitements) {
		if (jobAdversitements.getJobTitle() != null && jobAdversitements.getDescription() != null && jobAdversitements.getCity() != null && jobAdversitements.getOpenTitleCount() != 0) {
			return true;
		}
		return false;
	}

}
