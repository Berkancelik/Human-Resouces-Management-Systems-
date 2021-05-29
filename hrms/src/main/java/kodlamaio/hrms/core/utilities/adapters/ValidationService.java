package kodlamaio.hrms.core.utilities.adapters;

public interface ValidationService {
	boolean validateByMernis(long nationalId, String firstname, String lastName, int yearOfBirth);

}
