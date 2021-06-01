package kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeService {
	Result add (Resume resume);
	
	DataResult<List<Resume>> getAll();
	

}
