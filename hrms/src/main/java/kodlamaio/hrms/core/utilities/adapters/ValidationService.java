package kodlamaio.hrms.core.utilities.adapters;

public interface ValidationService {
	boolean validateByMernis(String nationalId, String firstname, String lastName, int yearOfBirth);

}
