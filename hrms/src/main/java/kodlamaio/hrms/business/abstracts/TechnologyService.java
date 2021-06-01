package kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Technology;

public interface TechnologyService {
	Result add (Technology technology);
	
	DataResult<List<Technology>> getAll();	


}
