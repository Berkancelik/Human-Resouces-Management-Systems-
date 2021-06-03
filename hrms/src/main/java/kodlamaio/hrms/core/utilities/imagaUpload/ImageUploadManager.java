package kodlamaio.hrms.core.utilities.imagaUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import com.cloudinary.Cloudinary;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService{
	

	private Cloudinary cloudinary;
	
	public ImageUploadManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dwlfg8ogv",
				"api_key", "api_key\", \"41188496826682",
				"pi_secret\",\"WsZxm67EBxiouvUJ0fuicfRQMcA"));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}


}
