package kodlamaio.hrms.core.utilities.imagaUpload;


import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;


@Service
public class CloudinaryManager implements ImageService{

	private Cloudinary cloudinary;
	
	public CloudinaryManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","diq6d5egr",
				"api_key", "657935687453369",
				"api_secret","8OVaOb0SVe_eJjh4cpOJAAslRIk"));
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
