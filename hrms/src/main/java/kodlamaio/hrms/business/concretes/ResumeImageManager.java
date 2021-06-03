package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeImageService;
import kodlamaio.hrms.core.utilities.imagaUpload.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeImageDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.ResumeImage;
@Service
public class ResumeImageManager implements ResumeImageService {
	
	private ResumeImageDao resumeImageDao;
	private ResumeImageService resumeImageService;
	
	@Autowired
	public ResumeImageManager(ResumeImageDao resumeImageDao,ResumeImageService resumeImageService) {
		super();
		this.resumeImageDao = resumeImageDao;
		this.resumeImageService = resumeImageService;
	}

	
	@Override
	public Result  add(ResumeImage resumeImage,MultipartFile file) {
		Map<String,String> uploadImage = this.imageUpload(imageFile).getData();
		resumeImage.setUrlAddress(uploadImage.get("url"));
		this.resumeImageDao.save(resumeImage);
		return new SuccessResult("Fotoğraf eklendi!");
	}

	@Override
	public Result update(ResumeImage resumeImage) {
		this.resumeImageDao.save(resumeImage);
		return new SuccessResult("Fotoğraf güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.resumeImageDao.deleteById(id);
		return new SuccessResult("Fotoğraf eklendi!");
	}

	@Override
	public DataResult<ResumeImage> getById(int id) {
		return new SuccessDataResult<ResumeImage>(this.resumeImageDao.getById(id));
		
	}

	@Override
	public DataResult<List<ResumeImage>> getAll() {
		return new SuccessDataResult<List<ResumeImage>>(this.resumeImageDao.findAll());		
	}

	@Override
	public DataResult<ResumeImage>getByCandidateId(int id) {
		return new SuccessDataResult<ResumeImage>(this.resumeImageDao.getByCandidateId(id));
		
	}



	

}
